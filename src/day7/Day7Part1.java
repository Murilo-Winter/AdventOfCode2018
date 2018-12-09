package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day7Part1 {

	List<Character> inputList = Arrays
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

	List<Character> sampleInputList = Arrays
			.asList('C', 'A', 'C', 'F', 'A', 'B', 'A', 'D', 'B', 'E', 'D', 'E', 'F', 'E');

	public String execute() {

		List<Element> elementList = convertInputList(inputList);

		Boolean keepGoing = true;
		StringBuilder order = new StringBuilder();
		while (keepGoing) {
			for (Character letter = 'A'; letter <= 'Z'; letter++) {

				Character finalLetter = letter;
				Element element = elementList.stream().filter(e -> !e.visited).filter(e -> e.value.equals(finalLetter))
						.findFirst().orElse(null);

				if (element != null && element.previous.stream().allMatch(p -> p.visited)) {
					element.visited = true;
					order.append(element.value);
					letter = 'Z';
				}
			}

			if (elementList.stream().allMatch(e -> e.visited))
				keepGoing = false;
		}
		return order.toString();

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

		public Boolean visited = false;

		public void addPrevious(Element element) {
			previous.add(element);
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