package day8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day8Part1 {

	private List<Integer> sampleInputList = Arrays.asList(2, 3, 0, 3, 10, 11, 12, 1, 1, 0, 1, 99, 2, 1, 1, 2);

	private List<Integer> inputList;

	private Integer meta = 0;

	public Integer execute() throws FileNotFoundException {
		inputList = readInput("resources/day8/input.txt");
		calculateMeta(inputList.get(0), inputList.get(1), 2);
		return meta;
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

	private Integer calculateMeta(Integer childrenNumber, Integer metadataNumber, Integer index) {

		for(int i = 0; i < childrenNumber; i++) {
			index = calculateMeta(inputList.get(index), inputList.get(index+1), index+2);
		}

		for(int i = 0; i < metadataNumber; i++) {
			meta+=inputList.get(index);
			index++;
		}
		return index;
	}

}


