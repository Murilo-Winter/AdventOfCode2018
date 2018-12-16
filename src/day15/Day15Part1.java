package day15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Day15Part1 {

	private List<Player> playerList = new ArrayList<>();

	private char[][] map;

	public Integer execute() throws FileNotFoundException {
		initializeMap(readInput("resources/day15/input.txt"));

		Integer round = 0;
		while (true) {
			Collections.sort(playerList);
			System.out.println("Round: " + round);
			drawMap(map);
			Boolean finished = takeTurn(playerList, map);
			if (finished)
				break;
			round++;
		}
		drawMap(map);
		cleanBodies(playerList);
		return round * playerList.stream().mapToInt(p -> p.health).sum();
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

	private void initializeMap(ArrayList<String> inputList) {
		char[][] map = new char[inputList.size()][inputList.get(0).length()];

		Integer currentColumn = 0;
		Integer currentLine = 0;

		for (String line : inputList) {
			for (int i = 0; i < line.length(); i++) {
				Character element = line.charAt(i);
				if (Arrays.asList('G', 'E').contains(element)) {
					playerList.add(new Player(new Position(currentColumn, currentLine), element));
				}
				map[currentLine][currentColumn] = element;
				currentColumn++;
			}
			currentColumn = 0;
			currentLine++;
		}
		this.map = map;
	}

	private void drawMap(char[][] map) {

		for(int line = 0; line < map.length; line++) {
			StringBuilder currentLine = new StringBuilder();
			for(int column = 0; column < map[0].length; column++) {
				currentLine.append(map[line][column]);
			}
			System.out.println(currentLine.toString());
		}

	}

	private Boolean takeTurn(List<Player> playerList, char[][] map) {

		for (Player player : playerList) {
			if (player.health < 0)
				continue;

			//Check for no opponents remaining
			if (playerList.stream().noneMatch(p -> p.race != player.race && p.health > 0))
				return true;

			if (returnAdjacentTargets(player, playerList).isEmpty()) {
				System.out.println("Player " + player.race + " at " + player.position.x + "," + player.position.y + " is moving!");
				Set<Position> desiredDestinationSet = findInRangePositions(player, playerList, map);

				Position nextDirection = findNextDirection(player, desiredDestinationSet, map);

				if (nextDirection != null) {
					processMovement(player, nextDirection, map);
				}

			}
			processAttackPhase(player, playerList, map);
		}
		cleanBodies(playerList);
		return false;
	}

	private List<Player> returnAdjacentTargets(Player player, List<Player> playerList) {
		List<Position> directions = new ArrayList<>(Arrays.asList(
				new Position(player.position.x, player.position.y-1),
				new Position(player.position.x-1, player.position.y),
				new Position(player.position.x+1, player.position.y),
				new Position(player.position.x, player.position.y+1)));

		return playerList.stream()
				.filter(p -> p.race != player.race)
				.filter(p -> directions.contains(p.position))
				.filter(p -> p.health > 0)
				.collect(Collectors.toList());
	}

	private Set<Position> findInRangePositions(Player player, List<Player> playerList, char[][] map) {

		List<Position> validTargets = playerList.stream()
				.filter(p -> p.race != player.race)
				.filter(p -> p.health > 0)
				.map(p -> p.position)
				.collect(Collectors.toList());

		Set<Position> validTargetPositions = new LinkedHashSet<>();
		for (Position target : validTargets) {
			if (map[target.y-1][target.x] == '.')
				validTargetPositions.add(new Position(target.x, target.y-1));
			if (map[target.y][target.x-1] == '.')
				validTargetPositions.add(new Position(target.x-1, target.y));
			if (map[target.y][target.x+1] == '.')
				validTargetPositions.add(new Position(target.x+1, target.y));
			if (map[target.y+1][target.x] == '.')
				validTargetPositions.add(new Position(target.x, target.y+1));
		}
		return validTargetPositions;
	}

	private Position findNextDirection(Player player, Set<Position> desiredDestinationSet, char[][] map) {

		List<Position> directions = new ArrayList<>(Arrays.asList(new Position(0, -1), new Position(-1, 0), new Position(1, 0), new Position(0, 1)));
		Position chosenDirection = null;

		StepsToTarget lesserStepsToTarget = new StepsToTarget(Integer.MAX_VALUE, new Position(Integer.MAX_VALUE, Integer.MAX_VALUE));
		for(Position direction : directions) {

			StepsToTarget stepsToTarget = new StepsToTarget(Integer.MAX_VALUE-1, new Position(Integer.MAX_VALUE, Integer.MAX_VALUE));
			Integer maxSteps = 1;
			while(stepsToTarget.steps == Integer.MAX_VALUE-1) { //Indicates off limits
				stepsToTarget = findNextPath(player.position, direction, desiredDestinationSet, map, new HashMap<>(), 0, maxSteps);
				maxSteps*=2;
			}
			if (stepsToTarget.compareTo(lesserStepsToTarget) < 0) {
				lesserStepsToTarget = stepsToTarget;
				chosenDirection = direction;
			}
		}
		return chosenDirection;
	}

	private void processMovement(Player player, Position nextDirection, char[][] map) {
		map[player.position.y][player.position.x] = '.';
		map[player.position.y+nextDirection.y][player.position.x+nextDirection.x] = player.race;
		player.position.x+=nextDirection.x;
		player.position.y+=nextDirection.y;
	}

	private void processAttackPhase(Player player, List<Player> playerList, char[][] map) {
		List<Player> adjacentTargets = returnAdjacentTargets(player, playerList);
		if(!adjacentTargets.isEmpty()) {
			Optional<Player> target = adjacentTargets.stream().min(Comparator.comparing(Player::getHealth).thenComparing(Player::getPosition));
			target.get().sufferDamage(3);

			if(target.get().health < 0)
				map[target.get().position.y][target.get().position.x] = '.';
		}
	}

	private void cleanBodies(List<Player> playerList) {
		playerList.removeIf(player -> player.health < 0);
	}

	//Current Position, next move, all desired destinations, map, list of paths so far, Index of current path, search area
	private StepsToTarget findNextPath(Position currPos, Position direction, Set<Position> desiredDestinationSet, char[][] map, HashMap<Position, Integer> takenPaths, Integer stepsTaken, Integer maxSteps) {
		Position newPosition = new Position(currPos.x + direction.x, currPos.y + direction.y);
		stepsTaken++;

		//If you exceed the search area, return a value to indicate that
		if (stepsTaken >= maxSteps)
			return new StepsToTarget(Integer.MAX_VALUE-1, new Position(Integer.MAX_VALUE, Integer.MAX_VALUE));

		//Check if path is not blocked, or if it has not already been taken with less steps
		if (map[newPosition.y][newPosition.x] != '.' || (takenPaths.containsKey(newPosition) && stepsTaken >= takenPaths.get(newPosition))) {
			return new StepsToTarget(Integer.MAX_VALUE, new Position(Integer.MAX_VALUE, Integer.MAX_VALUE));
		}

		//Add the path
		takenPaths.put(newPosition, stepsTaken);

		//Check if you reached your destination;
		if (desiredDestinationSet.contains(newPosition)) {
			return new StepsToTarget(stepsTaken, newPosition);
		}
		else {
			List<Position> validDirections = getNonOpposingDirections(direction);

			StepsToTarget fewerStepsToTarget = new StepsToTarget(Integer.MAX_VALUE, new Position(Integer.MAX_VALUE, Integer.MAX_VALUE));
			for(Position nextDirection : validDirections) {
				StepsToTarget stepsToTarget = findNextPath(newPosition, nextDirection, desiredDestinationSet, map, takenPaths, stepsTaken, maxSteps);
				fewerStepsToTarget = findShortestPath(stepsToTarget, fewerStepsToTarget);
			}
			return fewerStepsToTarget;
		}
	}

	private List<Position> getNonOpposingDirections(Position direction) {
		List<Position> directions = new ArrayList<>(Arrays.asList(new Position(0, -1), new Position(-1, 0), new Position(1, 0), new Position(0, 1)));
		directions.remove(new Position(direction.x*-1, direction.y*-1));
		return directions;
	}

	private StepsToTarget findShortestPath(StepsToTarget stepsToTarget, StepsToTarget fewerStepsToTarget) {
		List<StepsToTarget> stepsToTargetlist = new ArrayList<>(Arrays.asList(stepsToTarget, fewerStepsToTarget));
		Collections.sort(stepsToTargetlist);
		return stepsToTargetlist.get(0);
	}

	private class Position implements Comparable {
		public Integer x;

		public Integer y;

		public Position(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Position position = (Position) o;
			return Objects.equals(x, position.x) && Objects.equals(y, position.y);
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public int compareTo(Object o) {
			Position other = (Position) o;
			if (Objects.equals(this.y, other.y))
				return Integer.compare(this.x, other.x);
			else
				return Integer.compare(this.y, other.y);
		}

	}

	private class Player implements Comparable {

		public Position position;

		public Character race;

		public Integer health = 200;

		public Player(Position position, Character race) {
			this.position = position;
			this.race = race;
		}

		public void sufferDamage(Integer damage) {
			health -= damage;
		}

		@Override
		public int compareTo(Object o) {
			Player other = (Player) o;
			return this.position.compareTo(other.position);
		}

		public Position getPosition() {
			return position;
		}

		public void setPosition(Position position) {
			this.position = position;
		}

		public Character getRace() {
			return race;
		}

		public void setRace(Character race) {
			this.race = race;
		}

		public Integer getHealth() {
			return health;
		}

		public void setHealth(Integer health) {
			this.health = health;
		}
	}

	private class StepsToTarget implements Comparable {

		public Integer steps;

		public Position target;

		public StepsToTarget(Integer steps, Position target) {
			this.steps = steps;
			this.target = target;
		}

		@Override
		public int compareTo(Object o) {
			StepsToTarget other = (StepsToTarget) o;
			if (this.steps < other.steps)
				return -1;
			else if (this.steps.equals(other.steps))
				return this.target.compareTo(other.target);
			else
				return 1;
		}

	}

}


