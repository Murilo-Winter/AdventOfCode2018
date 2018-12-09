package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day7Part2 {

	private List<Character> inputList = Arrays
			.asList('G', 'X', 'X', 'B', 'A', 'I', 'D', 'H', 'O', 'T', 'H', 'C', 'S', 'E', 'U', 'M', 'M', 'Z', 'R', 'N',
					'C', 'Q', 'T', 'P', 'I', 'W', 'W', 'N', 'P', 'J', 'N', 'F', 'Y', 'J', 'J', 'L', 'L', 'E', 'E', 'B',
					'Q', 'B', 'F', 'K', 'V', 'K', 'Z', 'B', 'B', 'K', 'G', 'U', 'E', 'V', 'A', 'Z', 'C', 'V', 'R', 'B',
					'Q', 'Z', 'R', 'K', 'T', 'B', 'L', 'B', 'M', 'K', 'T', 'Z', 'W', 'B', 'I', 'E', 'A', 'M', 'V', 'Z',
					'Y', 'B', 'Q', 'F', 'W', 'Y', 'U', 'K', 'D', 'F', 'P', 'F', 'N', 'L', 'H', 'T', 'H', 'L', 'C', 'T',
					'H', 'I', 'Z', 'K', 'L', 'Z', 'Y', 'K', 'I', 'V', 'P', 'K', 'P', 'N', 'G', 'D', 'I', 'J', 'H', 'K',
					'L', 'Q', 'D', 'M', 'O', 'V', 'R', 'L', 'D', 'W', 'M', 'J', 'O', 'R', 'N', 'Z', 'Y', 'V', 'W', 'L',
					'U', 'Y', 'S', 'V', 'M', 'P', 'X', 'A', 'A', 'E', 'A', 'L', 'A', 'R', 'V', 'B', 'P', 'B', 'E', 'F',
					'T', 'V', 'S', 'R', 'T', 'F', 'P', 'Y', 'A', 'C', 'J', 'F', 'H', 'B', 'C', 'E', 'P', 'E', 'D', 'I',
					'X', 'F', 'T', 'Q', 'J', 'B', 'C', 'B', 'P', 'Q', 'H', 'R', 'F', 'B', 'T', 'J', 'A', 'W', 'N', 'K',
					'T', 'E');

	private List<Character> sampleInputList = Arrays
			.asList('C', 'A', 'C', 'F', 'A', 'B', 'A', 'D', 'B', 'E', 'D', 'E', 'F', 'E');

	private Integer availableWorkers = 5;

	private Integer additionalTime = 60;

	public Integer execute() {

		List<Element> elementList = convertInputList(inputList);

		Integer time = 0;

		Boolean keepGoing = true;
		while (keepGoing) {
			for (Character letter = 'A'; letter <= 'Z'; letter++) {

				if(availableWorkers == 0) {
					letter = 'Z';
					continue;
				}

				//Find element that matches letter, is not yet built, has no worker
				Character finalLetter = letter;
				Element element = elementList.stream()
						.filter(e -> e.value.equals(finalLetter))
						.filter(e -> !e.built)
						.filter(e -> !e.hasWorker)
						.findFirst().orElse(null);

				//If such element is found, has all pre-requisites,
				// put it under construction (if there's available workers)
				if (element != null  && element.previous.stream().allMatch(p -> p.built)) {
					element.hasWorker = true;
					availableWorkers--;
					letter = (char) 64;
				}
			}

			//Update time for each element under construction
			elementList.stream()
					.filter(e -> e.hasWorker )
					.forEach(e -> e.timeSpent++);

			//Process finished elements
			elementList.stream()
					.filter(e -> !e.built)
					.filter(Element::isFinished)
					.forEach(e -> {e.built = true; e.hasWorker = false; availableWorkers++;});

			//Increase time
			time++;

			//Check if everything is built
			if (elementList.stream().allMatch(e -> e.built))
				keepGoing = false;
		}
		return time;
	}

	private List<Element> convertInputList(List<Character> inputList) {

		List<Element> elementList = new ArrayList<>();

		for (int i = 0; i < inputList.size(); i = i + 2) {
			Element element = new Element();
			element.value = inputList.get(i + 1);

			Element previous = new Element();
			previous.value = inputList.get(i);

			addElement(elementList, element, previous);
			addElement(elementList, previous, null);
		}
		return elementList;
	}

	private void addElement(List<Element> elementList, Element element, Element previous) {
		if (elementList.contains(element)) {
			element = elementList.get(elementList.indexOf(element));
		}
		else {
			elementList.add(element);
		}

		if (previous != null) {

			if (elementList.contains(previous)) {
				previous = elementList.get(elementList.indexOf(previous));
			}
			else {
				elementList.add(previous);
			}
			element.addPrevious(previous);
		}
	}

	private class Element {

		public Character value;

		public List<Element> previous = new ArrayList<>();

		public Boolean built = false;

		public Integer timeSpent = 0;

		public Boolean hasWorker = false;

		public void addPrevious(Element element) {
			previous.add(element);
		}

		public Boolean isFinished() {
			if (timeSpent.equals(Integer.valueOf(value) - 64 + additionalTime))
				return true;
			else
				return false;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Element element = (Element) o;
			return Objects.equals(value, element.value);
		}

		@Override
		public int hashCode() {

			return Objects.hash(value);
		}
	}

}