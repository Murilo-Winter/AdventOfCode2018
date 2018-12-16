package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Day13Part2 {

	private List<Cart> cartList = new ArrayList<>();

	private char[][] map;

	public String execute() throws FileNotFoundException {
		ArrayList<String> listMap = readInput("resources/day13/input.txt");
		map = initializeMap(listMap);

		while(cartList.size() > 1) {
			Collections.sort(cartList);
			for(Cart cart : cartList) {
				if(!cart.collided) {
					move(cart);
					flagCollisions(cartList);
				}
			}
			cartList.removeIf(c -> c.collided);
		}
		return cartList.get(0).x + "," + cartList.get(0).y;
	}

	private void move(Cart cart) {

		Integer nextX = cart.x;

		Integer nextY = cart.y;

		if (map[cart.x][cart.y] == '+') {

			switch (cart.direction) {
			case '<':
				switch (cart.nextDirection) {
				case 'L':
					cart.direction = 'v';
					break;
				case 'S':
					cart.direction = '<';
					break;
				case 'R':
					cart.direction = '^';
					break;
				}
				break;

			case '>':
				switch (cart.nextDirection) {
				case 'L':
					cart.direction = '^';
					break;
				case 'S':
					cart.direction = '>';
					break;
				case 'R':
					cart.direction = 'v';
					break;
				}
				break;

			case 'v':
				switch (cart.nextDirection) {
				case 'L':
					cart.direction = '>';
					break;
				case 'S':
					cart.direction = 'v';
					break;
				case 'R':
					cart.direction = '<';
					break;
				}
				break;

			case '^':
				switch (cart.nextDirection) {
				case 'L':
					cart.direction = '<';
					break;
				case 'S':
					cart.direction = '^';
					break;
				case 'R':
					cart.direction = '>';
					break;
				}
				break;
			}

			cart.changeNextDirectionOnIntersection();
		}
		else if (map[cart.x][cart.y] == '/') {

			switch (cart.direction) {
			case '<':
				cart.direction = 'v';
				break;
			case '>':
				cart.direction = '^';
				break;
			case 'v':
				cart.direction = '<';
				break;
			case '^':
				cart.direction = '>';
				break;
			}

		}
		else if (map[cart.x][cart.y] == '\\') {

			switch (cart.direction) {
			case '<':
				cart.direction = '^';
				break;
			case '>':
				cart.direction = 'v';
				break;
			case 'v':
				cart.direction = '>';
				break;
			case '^':
				cart.direction = '<';
				break;
			}

		}

		switch (cart.direction) {
		case '<':
			nextX--;
			break;
		case '>':
			nextX++;
			break;
		case 'v':
			nextY++;
			break;
		case '^':
			nextY--;
			break;
		}
		cart.x = nextX;
		cart.y = nextY;
	}

	private char[][] initializeMap(ArrayList<String> listMap) {
		char[][] map = new char[150][150];

		Integer currentColumn = 0;
		Integer currentRow = 0;

		for (String line : listMap) {
			for (int i = 0; i < line.length(); i++) {
				Character element = line.charAt(i);
				if (Arrays.asList('<', '>', '^', 'v').contains(element)) {
					cartList.add(new Cart(currentRow, currentColumn, element));
					if (Arrays.asList('<', '>').contains(element))
						map[currentRow][currentColumn] = '-';
					else
						map[currentRow][currentColumn] = '|';
				}
				else {
					map[currentRow][currentColumn] = element;
				}
				currentRow++;
			}
			currentRow = 0;
			currentColumn++;
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

	private void flagCollisions(List<Cart> cartList) {
		cartList.stream()
				.filter(c -> !c.collided)
				.filter(c -> Collections.frequency(cartList, c) > 1)
				.forEach(c -> c.collided = true);
	}

	class Cart implements Comparable {
		Character nextDirection = 'L';

		Integer x;

		Integer y;

		Character direction;

		public Boolean collided = false;

		public Cart(Integer x, Integer y, Character direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public void changeNextDirectionOnIntersection() {
			if (nextDirection.equals('L'))
				nextDirection = 'S';
			else if (nextDirection.equals('S'))
				nextDirection = 'R';
			else
				nextDirection = 'L';
		}

		@Override
		public int compareTo(Object o) {
			Cart cart = (Cart) o;
			if (Objects.equals(this.y, cart.y))
				return Integer.compare(this.x, cart.x);
			else
				return Integer.compare(this.y, cart.y);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Cart cart = (Cart) o;
			return Objects.equals(x, cart.x) && Objects.equals(y, cart.y);
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

}
