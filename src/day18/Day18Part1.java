package day18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day18Part1 {

	public Integer execute() throws FileNotFoundException {
		char[][] map = initializeMap(readInput("resources/day18/input.txt"));

		draw(map);
		for(int i = 0; i < 10; i++) {
			map = updateMap(map);
			draw(map);
		}
		return countElements(map);
	}


	private void draw(char[][] map) {
		for(int line = 0; line < map.length; line++) {
			StringBuilder currentLine = new StringBuilder();
			for(int column = 0; column < map[0].length; column++) {
				currentLine.append(map[line][column]);
			}
			System.out.println(currentLine.toString());
		}
		System.out.println('\n');
	}

	private Integer countElements(char[][] map) {
		Integer woodAcre = 0;
		Integer lumberyards = 0;
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[0].length; x++) {
				if (map[y][x] == '|')
					woodAcre++;
				else if (map[y][x] == '#')
					lumberyards++;
			}
		}
		return woodAcre * lumberyards;
	}

	private char[][] updateMap(char[][] map) {
		char[][] updatedMap = cloneMap(map);

		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[0].length; x++) {
				List<Character> adjacentCharacters = checkAll(x, y, map);

				if(map[y][x] == '.') {
					if(adjacentCharacters.stream().filter(c -> c.equals('|')).count() >= 3)
						updatedMap[y][x] = '|';
					else
						updatedMap[y][x] = '.';
				}
				else if (map[y][x] == '|') {
					if(adjacentCharacters.stream().filter(c -> c.equals('#')).count() >= 3)
						updatedMap[y][x] = '#';
					else
						updatedMap[y][x] = '|';
				}
				else {
					if(adjacentCharacters.stream().filter(c -> c.equals('#')).count() >= 1 &&
							adjacentCharacters.stream().filter(c -> c.equals('|')).count() >= 1)
						updatedMap[y][x] = '#';
					else
						updatedMap[y][x] = '.';
				}
			}
		}
		return updatedMap;
	}

	private char[][] cloneMap(char[][] map) {
		char[][] newMap = new char[map.length][map[0].length];
		for(int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[0].length; x++) {
				newMap[y][x] = map[y][x];
			}
		}
		return newMap;
	}

	private List<Character> checkAll(Integer x, Integer y, char[][] map) {
		List<Character> adjacentCharacters = new ArrayList<>();
		adjacentCharacters.add(checkUp(x,y,map));
		adjacentCharacters.add(checkDown(x,y,map));
		adjacentCharacters.add(checkLeft(x,y,map));
		adjacentCharacters.add(checkRight(x,y,map));
		adjacentCharacters.add(checkUpLeft(x,y,map));
		adjacentCharacters.add(checkUpRight(x,y,map));
		adjacentCharacters.add(checkDownLeft(x,y,map));
		adjacentCharacters.add(checkDownRight(x,y,map));
		adjacentCharacters.removeIf(c -> c.equals(' '));
		return adjacentCharacters;
	}

	private Character checkUp(Integer x, Integer y, char[][] map) {
		if(y-1 >= 0)
			return map[y-1][x];
		else
			return ' ';
	}

	private Character checkDown(Integer x, Integer y, char[][] map) {
		if(y+1 < map.length)
			return map[y+1][x];
		else
			return ' ';
	}

	private Character checkLeft(Integer x, Integer y, char[][] map) {
		if(x-1 >= 0)
			return map[y][x-1];
		else
			return ' ';
	}

	private Character checkRight(Integer x, Integer y, char[][] map) {
		if(x+1 < map[0].length)
			return map[y][x+1];
		else
			return ' ';
	}

	private Character checkUpLeft(Integer x, Integer y, char[][] map) {
		if(y-1 >= 0 && x-1 >= 0)
			return map[y-1][x-1];
		else
			return ' ';
	}

	private Character checkUpRight(Integer x, Integer y, char[][] map) {
		if(y-1 >= 0 && x+1 < map[0].length)
			return map[y-1][x+1];
		else
			return ' ';
	}

	private Character checkDownLeft(Integer x, Integer y, char[][] map) {
		if(y+1 < map.length && x-1 >= 0)
			return map[y+1][x-1];
		else
			return ' ';
	}

	private Character checkDownRight(Integer x, Integer y, char[][] map) {
		if(y+1 < map.length && x+1 < map[0].length)
			return map[y+1][x+1];
		else
			return ' ';
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


