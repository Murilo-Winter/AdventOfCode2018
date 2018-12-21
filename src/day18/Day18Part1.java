package day18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import day13.Day13Part1;

public class Day18Part1 {

	public Integer execute() throws FileNotFoundException {
		char[][] map = initializeMap(readInput("resources/day18/input.txt"));
		return 0;
	}

	private ArrayList<String> readInput(String path) throws FileNotFoundException {
		ArrayList<String> inputList = new ArrayList<>();
		try (Scanner s = new Scanner(new FileReader(path))) {
			while (s.hasNext()) {
				inputList.add(s.nextLine());
			}
			return inputList;
		}
	}

	private char[][] initializeMap(ArrayList<String> listMap) {
		char[][] map = new char[listMap.size()][listMap.size()];

		for(int i = 0; i < listMap.size(); i++) {
			String line = listMap.get(i);
			for (int j = 0; j < listMap.size(); j++) {
				Character element = line.charAt(j);
				map[i][j] = element;
			}
		}
		return map;
	}

}


