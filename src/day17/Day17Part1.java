package day17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Day17Part1 {

	private Position waterSource = new Position(500, 2);
	public Integer execute() throws FileNotFoundException {

		char[][] map = initializeMap(readInput("resources/day17/input.txt"));;
		map[waterSource.y][waterSource.x] = '+';

		//Correct is 28246
		//28248 is wrong
		//draw(map);
		while(map[waterSource.y+1][waterSource.x] != '|') {
			dropWater(map, waterSource);
		}
		draw(map);
		return countWater(map);
	}

	private void dropWater(char[][] map, Position waterSource) {

		Water water = new Water(new Position(waterSource.x, waterSource.y), '.' );
		Integer minY = map.length;

		while(true) {
			//Clean old position
			//map[water.position.y][water.position.x] = '.';

			//End of map reached
			if (water.position.y+1 == minY) {
				break;
			}

			//Falling down regularly
			else if(map[water.position.y+1][water.position.x] == '.') {
				water.shape = '|';
				water.position.y++;
				water.lateralDirection = ' ';
			}

			//Reached clay or resting water
			else if( map[water.position.y+1][water.position.x] == '#' || map[water.position.y+1][water.position.x] == '~' ) {

				//Determine nearest pit
				Integer pitToLeftDistance = 0;
				for (int i = water.position.x - 1; i > -1; i--) {
					if (map[water.position.y][i] == '#' || map[water.position.y][i] == '|') {
						pitToLeftDistance = Integer.MAX_VALUE;
						break;
					}
					else if (map[water.position.y + 1][i] == '.') {
						pitToLeftDistance = water.position.x - i;
						break;
					}
				}
				Integer pitToRightDistance = 0;
				for(int i = water.position.x+1; i < map[0].length; i++ ) {
					if(map[water.position.y][i] == '#' || map[water.position.y][i] == '|') {
						pitToRightDistance = Integer.MAX_VALUE;
						break;
					}
					else if(map[water.position.y + 1][i] == '.') {
						pitToRightDistance = i - water.position.x;
						break;
					}
				}

				//Move horizontally based on nearest pit
				if(pitToLeftDistance < pitToRightDistance) {
					//Check if there's room to the left (and ground below)
					if (map[water.position.y][water.position.x - 1] == '.' && water.lateralDirection != 'R' && map[water.position.y + 1][water.position.x] != '.') {
						water.position.x--;
						water.lateralDirection = 'L';
					}
					//Check if there's room to the right (and ground below)
					else if (map[water.position.y][water.position.x + 1] == '.' && water.lateralDirection != 'L' && map[water.position.y + 1][water.position.x] != '.') {
						water.position.x++;
						water.lateralDirection = 'R';
					}
					else {
						//Check if there's moving water in the next position (then this is moving water as well), or check if there's nothing blocking that dropping water to be considered moving water as well
						if ((water.lateralDirection == 'L' && map[water.position.y][water.position.x - 1] == '|')
								|| (water.lateralDirection == 'R' && map[water.position.y][water.position.x + 1] == '|')
								|| (map[water.position.y][water.position.x - 1] == '.' && map[water.position.y][water.position.x + 1] == '.')
								|| determineSameLevelMovingWater(map, water) == true)
							water.shape = '|';
						else
							water.shape = '~';
						break;
					}
				}
				else {
					//Check if there's room to the right (and ground below)
					if (map[water.position.y][water.position.x + 1] == '.' && water.lateralDirection != 'L' && map[water.position.y + 1][water.position.x] != '.') {
						water.position.x++;
						water.lateralDirection = 'R';
					}
					//Check if there's room to the left (and ground below)
					else if (map[water.position.y][water.position.x - 1] == '.' && water.lateralDirection != 'R' && map[water.position.y + 1][water.position.x] != '.') {
						water.position.x--;
						water.lateralDirection = 'L';
					}
					else {
						//Check if there's moving water in the next position (then this is moving water as well), or check if there's nothing blocking that dropping water to be considered moving water as well
						if ((water.lateralDirection == 'L' && map[water.position.y][water.position.x - 1] == '|')
								|| (water.lateralDirection == 'R' && map[water.position.y][water.position.x + 1] == '|')
								|| (map[water.position.y][water.position.x - 1] == '.' && map[water.position.y][water.position.x + 1] == '.')
								|| determineSameLevelMovingWater(map, water) == true)
							water.shape = '|';
						else
							water.shape = '~';
						break;
					}
				}


			}
			//Found water in movement
			else if (map[water.position.y+1][water.position.x] == '|') {
				break;
			}

			//Update position
			//map[water.position.y][water.position.x] = water.shape;
		}
		map[water.position.y][water.position.x] = water.shape;
	}

	//Check if there's moving water on the same X level before the next wall or pit
	private Boolean determineSameLevelMovingWater(char[][] map, Water water) {

		Boolean movingWater = false;
		for(int i = water.position.x-1; i > -1; i-- ) {
			if(map[water.position.y][i] == '|') {
				movingWater = true;
				break;
			}
			else if(map[water.position.y][i] == '#' || map[water.position.y+1][i] == '.') {
				movingWater = false;
				break;
			}
		}
		if (movingWater) return movingWater;

		for(int i = water.position.x+1; i < map[0].length; i++ ) {
			if(map[water.position.y][i] == '|') {
				movingWater = true;
				break;
			}
			else if(map[water.position.y][i] == '#' || map[water.position.y+1][i] == '.') {
				movingWater = false;
				break;
			}
		}
		return movingWater;
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

	private char[][] initializeMap(ArrayList<String> inputList) {

		List<Range> rangeList = new ArrayList<>();
		for (String line : inputList) {
				String[] lineArray = line.split(",");

				String axis1 = lineArray[0];
				Integer axis1Value = Integer.valueOf(lineArray[1]);
				Integer axis2ValueBegin = Integer.valueOf(lineArray[3]);
				Integer axis2ValueEnd = Integer.valueOf(lineArray[4]);

				Range range;
				if(axis1.equals("x"))
					range = new Range(axis1Value, axis2ValueBegin, axis1Value, axis2ValueEnd);
				else
					range = new Range(axis2ValueBegin, axis1Value, axis2ValueEnd, axis1Value);
				rangeList.add(range);
		}

		Integer minX = rangeList.stream().map(r -> r.begin).collect(Collectors.toList()).stream().map(p -> p.x).min(Integer::compareTo).get();
		Integer maxX = rangeList.stream().map(r -> r.end).collect(Collectors.toList()).stream().map(p -> p.x).max(Integer::compareTo).get();
		Integer maxY = rangeList.stream().map(r -> r.end).collect(Collectors.toList()).stream().map(p -> p.y).max(Integer::compareTo).get();

		//Initialize Matrix (2 for offset + 1 because the last element of the range counts)
		char[][] map = new char[maxY+1][maxX-minX+3];

		//Fill with empty lines
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j < map[0].length; j++)
				map[i][j] = '.';

		//Normalize ranges based on X min and Max (and add 1 offset for first line)
		Integer factor = minX-1;
		rangeList.forEach(r -> { r.begin.x-=factor; r.end.x-=factor;});
		waterSource.x-= factor;

		//Input range into map
		for( Range range : rangeList) {

			//Draw in the Y axis
			if (range.begin.x.equals(range.end.x)) {
				for(int i = range.begin.y; i <= range.end.y; i++)
					map[i][range.begin.x] = '#';
			}
			//Draw in the X axis
			else {
				for(int i = range.begin.x; i <= range.end.x; i++)
					map[range.begin.y][i] = '#';
			}
		}
		return map;
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

	private Integer countWater(char[][] map) {
		Integer waterCount = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if (map[i][j] == '~' || map[i][j] == '|')
					waterCount++;
			}
		}
		return waterCount;
	}

	private class Position {
		public Integer x;

		public Integer y;

		public Position(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}

	}

	private class Range {
		public Position begin;
		public Position end;
		public Range(Integer x1, Integer y1, Integer x2, Integer y2) {
			this.begin = new Position(x1, y1);
			this.end = new Position(x2, y2);
		}
	}

	private class Water {

		public Position position;

		public Character shape;

		public Character lateralDirection = ' ';

		public Water(Position position, Character shape) {
			this.position = position;
			this.shape = shape;
		}
	}

}


