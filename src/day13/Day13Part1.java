package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Day13Part1 {

	private List<Cart> cartList = new ArrayList<>();

	private char[][] map;

	public String execute() throws FileNotFoundException {
		ArrayList<String> listMap = readInput("resources/day13/input.txt");
		map = initializeMap(listMap);

		while(true) {
			Collections.sort(cartList);
			cartList.forEach(this::move);
			return "";
		}

	}

	private void move(Cart cart) {

		Integer nextX = cart.x;
		Integer nextY = cart.y;

		if(map[cart.x][cart.y] == '+') {

//			switch (cart.direction) {
//			case '<':
//				cart.direction = 'v';
//				break;
//			case '>':
//				cart.direction = '^';
//				break;
//			case 'v':
//				cart.direction = '<';
//				break;
//			case '^':
//				cart.direction = '>';
//				break;
//			}

			cart.changeNextDirectionOnIntersection();
		}
		else if(map[cart.x][cart.y] == '/') {

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
		if(map[cart.x][cart.y] == '\\') {

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

		Integer currentLine = 0;
		Integer currentRow = 0;

		for(String line: listMap) {
			for (int i = 0; i < line.length(); i++) {
				Character element = line.charAt(i);
				if(Arrays.asList('<', '>', '^', 'v').contains(element)) {
					cartList.add(new Cart(currentLine, currentRow, element));
					if(Arrays.asList('<', '>').contains(element))
						map[currentLine][currentRow] = '-';
					else
						map[currentLine][currentRow] = '|';
				}
				else {
					map[currentLine][currentRow] = element;
				}
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

	class Cart implements Comparable{
		Character nextDirection = 'L';

		Integer x;

		Integer y;

		Character direction;

		public Cart(Integer x, Integer y, Character direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public void changeNextDirectionOnIntersection() {
			if(nextDirection.equals('L'))
				nextDirection = 'S';
			else if (nextDirection.equals('S'))
				nextDirection = 'R';
			else
				nextDirection = 'L';
		}

		@Override
		public int compareTo(Object o) {
			Cart cart = (Cart) o;
			if(Objects.equals(this.x, cart.x))
				return Integer.compare(this.y, cart.y);
			else
				return Integer.compare(this.x, cart.x);
		}
	}

}
