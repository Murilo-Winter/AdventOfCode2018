package day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Day6Part2 {

	private List<String> sampleInputList = Arrays.asList("1", "1", "1", "6", "8", "3", "3", "4", "5", "5", "8", "9");

	private List<String> inputList = Arrays.asList("195", "221",
			"132", "132",
			"333", "192",
			"75", "354",
			"162", "227",
			"150", "108",
			"46", "40",
			"209", "92",
			"153", "341",
			"83", "128",
			"256", "295",
			"311", "114",
			"310", "237",
			"99", "240",
			"180", "337",
			"332", "176",
			"212", "183",
			"84", "61",
			"275", "341",
			"155", "89",
			"169", "208",
			"105", "78",
			"151", "318",
			"92", "74",
			"146", "303",
			"184", "224",
			"285", "348",
			"138", "163",
			"216", "61",
			"277", "270",
			"130", "155",
			"297", "102",
			"197", "217",
			"72", "276",
			"299", "89",
			"357", "234",
			"136", "342",
			"346", "221",
			"110", "188",
			"82", "183",
			"271", "210",
			"46", "198",
			"240", "286",
			"128", "95",
			"111", "309",
			"108", "54",
			"258", "305",
			"241", "157",
			"117", "162",
			"96", "301");

	public Integer execute() {
		List<Vertex> vertexList = initializeCoordinatesList(inputList);

		Integer minX = getMinX(vertexList);
		Integer maxX = getMaxX(vertexList);
		Integer minY = getMinY(vertexList);
		Integer maxY = getMaxY(vertexList);

		Integer safeRegions = 0;
		for (int x = minX-1; x <= maxX+1; x++)
			for (int y = minY-1; y <= maxY+1; y++) {
				Integer distance = calculateDistances(vertexList, x, y);
				if (distance < 10000)
					safeRegions++;
			}
		return safeRegions;
	}

	private Integer calculateDistances(List<Vertex> vertexList, int x, int y) {
		Integer distance = 0;
		for (Vertex vertex : vertexList) {
			distance += calculateDistance(vertex, new Vertex(x, y));
		}
		return distance;
	}

	private Integer calculateDistance(Vertex vertexA, Vertex vertexB) {
		return Math.abs(vertexA.getX() - vertexB.getX()) + Math.abs(vertexA.getY() - vertexB.getY());
	}

	private Integer getMaxY(List<Vertex> vertexList) {
		return vertexList.stream().max(Comparator.comparing(Vertex::getY)).get().getY();
	}

	private Integer getMinY(List<Vertex> vertexList) {
		return vertexList.stream().min(Comparator.comparing(Vertex::getY)).get().getY();
	}

	private Integer getMaxX(List<Vertex> vertexList) {
		return vertexList.stream().max(Comparator.comparing(Vertex::getX)).get().getX();
	}

	private Integer getMinX(List<Vertex> vertexList) {
		return vertexList.stream().min(Comparator.comparing(Vertex::getX)).get().getX();
	}

	private List<Vertex> initializeCoordinatesList(List<String> inputList) {
		List<Vertex> vertexList = new ArrayList<>();

		Boolean isX = true;
		Integer x = 0;
		for (String element : inputList) {

			if (isX)
				x = Integer.valueOf(element);
			else {
				Vertex vertex = new Vertex(x, Integer.valueOf(element));
				vertexList.add(vertex);
			}
			isX = !isX;
		}
		return vertexList;
	}

	class Vertex {

		private Integer X;

		private Integer Y;

		public Vertex(Integer x, Integer y) {
			X = x;
			Y = y;
		}

		public Integer getX() {
			return X;
		}

		public Integer getY() {
			return Y;

		}
	}

}