package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day13Part1 {

	public String execute() throws FileNotFoundException {
		ArrayList<String> listMap = readInput("resources/day13/input.txt");
		char[][] map = initializeMap(listMap);

		return "";
	}

	private char[][] initializeMap(ArrayList<String> listMap) {
		char[][] map = new char[150][150];

		Integer currentLine = 0;
		Integer currentRow = 0;

		for(String line: listMap) {
			for (int i = 0; i < line.length(); i++) {
				map[currentLine][currentRow] = line.charAt(i);
				currentRow++;
			}
			currentRow = 0;
			currentLine++;
		}
		return map;
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

}