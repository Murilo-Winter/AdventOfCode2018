package day8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day8Part2 {

	private List<Integer> sampleInputList = Arrays.asList(2, 3, 0, 3, 10, 11, 12, 1, 1, 0, 1, 99, 2, 1, 1, 2);

	private List<Integer> inputList;

	private Map<Integer, ArrayList<Integer>> nodeMetaValue = new HashMap<>();

	private Integer result = 0;

	public Integer execute() throws FileNotFoundException {
		inputList = readInput("resources/day8/input.txt");
		//inputList = sampleInputList;

		calculateMeta(0,0);
		return result;
	}

	private ArrayList<Integer> readInput(String path) throws FileNotFoundException {
		ArrayList<Integer> inputList = new ArrayList<>();
		try (Scanner s = new Scanner(new FileReader(path))) {
			while (s.hasNext()) {
				inputList.add(s.nextInt());
			}
			return inputList;
		}
	}

	private Integer calculateMeta(Integer index, Integer parent) {
		Integer currentElement = index;

		Integer childrenNumber = inputList.get(index);
		Integer metadataNumber = inputList.get(index + 1);
		index = index + 2;

		for (int i = 0; i < childrenNumber; i++) {
			index = calculateMeta(index, currentElement);
		}

		Integer meta = 0;
		if (childrenNumber == 0) {
			for (int i = 0; i < metadataNumber; i++) {
				meta += inputList.get(index);
				index++;
			}
		}
	    else {
			for (int i = 0; i < metadataNumber; i++) {
				Integer requiredChild = inputList.get(index)-1;
				if(nodeMetaValue.containsKey(currentElement))
					if (nodeMetaValue.get(currentElement).size() > requiredChild)
						meta+= nodeMetaValue.get(currentElement).get(requiredChild);
				index++;
			}
		}

		if(currentElement.equals(parent))
			result = meta;
		else
			updateNoteMetaValue(parent, meta);
		return index;
	}

	private void updateNoteMetaValue(Integer parent, Integer meta) {
		if(nodeMetaValue.containsKey(parent)) {
			nodeMetaValue.get(parent).add(meta);
		}
		else {
			ArrayList<Integer> newList = new ArrayList<>();
			newList.add(meta);
			nodeMetaValue.put(parent, newList);
		}
	}

	class Node{
		public Integer element;
		public Integer parent;
	}

}



