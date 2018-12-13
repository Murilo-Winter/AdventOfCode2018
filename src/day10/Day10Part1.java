package day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Day10Part1 {

	List<Integer> sampleInputList = Arrays
			.asList(9, 1, 0, 2, 7, 0, -1, 0, 3, -2, -1, 1, 6, 10, -2, -1, 2, -4, 2, 2, -6, 10, 2, -2, 1, 8, 1, -1, 1, 7,
					1, 0, -3, 11, 1, -2, 7, 6, -1, -1, -2, 3, 1, 0, -4, 3, 2, 0, 10, -3, -1, 1, 5, 11, 1, -2, 4, 7, 0,
					-1, 8, -2, 0, 1, 15, 0, -2, 0, 1, 6, 1, 0, 8, 9, 0, -1, 3, 3, -1, 1, 0, 5, 0, -1, -2, 2, 2, 0, 5,
					-2, 1, 2, 1, 4, 2, 1, -2, 7, 2, -2, 3, 6, -1, -1, 5, 0, 1, 0, -6, 0, 2, 0, 5, 9, 1, -2, 14, 7, -2,
					0, -3, 6, 2, -1);

	List<Integer> inputList = Arrays.asList(-10810,  43870, 1, -4,
			-21745, -10795, 2,  1,
			54771, -54515,-5,  5,
			54792, -32660,-5,  3,
			21972,  54799,-2, -5,
			-43565, -43583, 4,  4,
			54775,  43864,-5, -4,
			54819, -54516,-5,  5,
			21981,  32941,-2, -3,
			-32642,  43871, 3, -4,
			-43614, -54516, 4,  5,
			-21758, -43590, 2,  4,
			-43589, -54520, 4,  5,
			-10818,  43864, 1, -4,
			-32646, -43584, 3,  4,
			54814, -54523,-5,  5,
			43877, -43592,-4,  4,
			54766,  32933,-5, -3,
			-21749,  22006, 2, -2,
			-32658, -43588, 3,  4,
			-54544, -54524, 5,  5,
			-43590, -21725, 4,  2,
			-32638,  11076, 3, -1,
			43861,  32941,-4, -3,
			-21699, -32656, 2,  3,
			11089,  11068,-1, -1,
			-10805,  22000, 1, -2,
			-43598,  54797, 4, -5,
			11065, -21728,-1,  2,
			54768,  54799,-5, -5,
			-10810,  43871, 1, -4,
			54803,  22001,-5, -2,
			11081, -32651,-1,  3,
			-10782, -10792, 1,  1,
			-10824, -21722, 1,  2,
			-54529, -21728, 5,  2,
			32918, -10796,-3,  1,
			-10773,  32938, 1, -3,
			-21706, -21723, 2,  2,
			-32664,  43864, 3, -4,
			-43578,  54802, 4, -5,
			11082,  22007,-1, -2,
			43838, -10795,-4,  1,
			54766,  43871,-5, -4,
			22007, -54522,-2,  5,
			-43601, -21726, 4,  2,
			-10825, -10791, 1,  1,
			32950, -43584,-3,  4,
			-32669,  32939, 3, -3,
			-43564, -54524, 4,  5,
			22014,  32934,-2, -3,
			-10797, -43584, 1,  4,
			-10826, -32655, 1,  3,
			-32690, -10791, 3,  1,
			11059, -43588,-1,  4,
			-43598,  43869, 4, -4,
			32931,  43871,-3, -4,
			32927,  32941,-3, -3,
			-10798,  11068, 1, -1,
			32938, -54524,-3,  5,
			-32686, -32659, 3,  3,
			-43601, -54522, 4,  5,
			-32633,  11074, 3, -1,
			54766,  11068,-5, -1,
			11054, -10794,-1,  1,
			-10805, -10791, 1,  1,
			-54533,  43872, 5, -4,
			-43590,  11076, 4, -1,
			32954, -54524,-3,  5,
			43877, -54524,-4,  5,
			21982, -43589,-2,  4,
			-10824, -54518, 1,  5,
			-32666, -54521, 3,  5,
			-10789, -54523, 1,  5,
			32936, -10796,-3,  1,
			43850,  22008,-4, -2,
			43870, -21722,-4,  2,
			11059, -10792,-1,  1,
			43875, -32651,-4,  3,
			54769, -32653,-5,  3,
			-32633, -43586, 3,  4,
			11046,  22007,-1, -2,
			-10794, -54515, 1,  5,
			-43598, -21725, 4,  2,
			11083, -32660,-1,  3,
			-54504, -21728, 5,  2,
			43842, -32651,-4,  3,
			-54533, -10794, 5,  1,
			-43566,  22008, 4, -2,
			54817,  43873,-5, -4,
			-21742, -21725, 2,  2,
			43836, -10793,-4,  1,
			-32634, -21719, 3,  2,
			32918,  54800,-3, -5,
			32923,  22000,-3, -2,
			54774, -32651,-5,  3,
			11091, -32651,-1,  3,
			32902, -32654,-3,  3,
			-21714, -54521, 2,  5,
			-21755, -21726, 2,  2,
			-21707,  22009, 2, -2,
			11099, -54522,-1,  5,
			54766,  11071,-5, -1,
			54803, -54521,-5,  5,
			11086, -54523,-1,  5,
			-32641,  11068, 3, -1,
			-10816, -54519, 1,  5,
			21991, -54516,-2,  5,
			-10810,  22009, 1, -2,
			-21729,  32933, 2, -3,
			-21734, -10793, 2,  1,
			-32674, -10790, 3,  1,
			21970, -21722,-2,  2,
			54802, -10792,-5,  1,
			-43564,  43864, 4, -4,
			43878, -21720,-4,  2,
			32912,  54801,-3, -5,
			-32674, -10788, 3,  1,
			-43611, -32656, 4,  3,
			-43572,  43873, 4, -4,
			-21726,  32932, 2, -3,
			32926, -43590,-3,  4,
			54814, -10789,-5,  1,
			43834,  54796,-4, -5,
			-43578, -32652, 4,  3,
			-43590, -54523, 4,  5,
			-21721,  22009, 2, -2,
			11043,  22000,-1, -2,
			-32678,  54796, 3, -5,
			-54496,  22005, 5, -2,
			-32669, -54516, 3,  5,
			-54525,  32933, 5, -3,
			22023, -32659,-2,  3,
			43866,  43869,-4, -4,
			22031, -54523,-2,  5,
			11067,  22006,-1, -2,
			-43606,  43865, 4, -4,
			-21737,  11075, 2, -1,
			-54510, -43590, 5,  4,
			32918,  54801,-3, -5,
			-10823, -10789, 1,  1,
			22027,  54805,-2, -5,
			-21721, -43589, 2,  4,
			11054,  11069,-1, -1,
			-32656, -32656, 3,  3,
			54766,  11077,-5, -1,
			22029, -32660,-2,  3,
			32942, -10789,-3,  1,
			-43570, -32655, 4,  3,
			32926,  43871,-3, -4,
			-43590, -21722, 4,  2,
			32926, -54522,-3,  5,
			-21714, -43587, 2,  4,
			-21710, -54520, 2,  5,
			32952,  43864,-3, -4,
			-54536,  22004, 5, -2,
			32913,  11068,-3, -1,
			11098,  22009,-1, -2,
			-10817,  11068, 1, -1,
			-54493,  43866, 5, -4,
			43876, -32651,-4,  3,
			-43589,  32932, 4, -3,
			32955, -32652,-3,  3,
			21999, -10787,-2,  1,
			21982,  32941,-2, -3,
			43883, -54524,-4,  5,
			-54533, -32651, 5,  3,
			32953,  43869,-3, -4,
			-21750,  54804, 2, -5,
			-54554, -54520, 5,  5,
			-21723,  22000, 2, -2,
			32918, -10789,-3,  1,
			-10801, -21728, 1,  2,
			-43561,  54805, 4, -5,
			-10802,  22004, 1, -2,
			22002,  32938,-2, -3,
			11097, -32651,-1,  3,
			-21724,  22000, 2, -2,
			-54543, -43592, 5,  4,
			54775,  54796,-5, -5,
			11066,  54796,-1, -5,
			54814,  54798,-5, -5,
			32927, -43592,-3,  4,
			54803,  43872,-5, -4,
			-43569, -54516, 4,  5,
			-54498,  54796, 5, -5,
			54786,  43868,-5, -4,
			43850,  43873,-4, -4,
			-43569,  11074, 4, -1,
			-21714,  22000, 2, -2,
			54809,  32941,-5, -3,
			-43590, -32653, 4,  3,
			-54535,  54800, 5, -5,
			43863,  22007,-4, -2,
			43871, -54516,-4,  5,
			-10810, -10789, 1,  1,
			-43605,  43868, 4, -4,
			32942,  22008,-3, -2,
			-21701, -54524, 2,  5,
			-21722, -21721, 2,  2,
			-32666, -43590, 3,  4,
			32926, -10792,-3,  1,
			22011, -10787,-2,  1,
			43846,  32935,-4, -3,
			22026, -10788,-2,  1,
			-32682, -54515, 3,  5,
			-32666, -10792, 3,  1,
			11071,  22004,-1, -2,
			-10790, -43585, 1,  4,
			32934, -43590,-3,  4,
			-32662, -21723, 3,  2,
			54790, -10790,-5,  1,
			11082,  22002,-1, -2,
			54766,  54801,-5, -5,
			54794, -43584,-5,  4,
			-10789,  54805, 1, -5,
			-43622, -21719, 4,  2,
			-32682,  54796, 3, -5,
			43847,  22009,-4, -2,
			43890,  22007,-4, -2,
			-21742,  43867, 2, -4,
			22023,  43869,-2, -4,
			43858,  43872,-4, -4,
			-21697, -43583, 2,  4,
			43871,  32933,-4, -3,
			21980,  11077,-2, -1,
			43871,  32935,-4, -3,
			-32669, -21727, 3,  2,
			-10774,  11073, 1, -1,
			-43594, -32655, 4,  3,
			-21742,  32940, 2, -3,
			-43595,  11077, 4, -1,
			-54510,  22005, 5, -2,
			32912,  32932,-3, -3,
			-54493,  32932, 5, -3,
			-54497, -10796, 5,  1,
			32923,  43868,-3, -4,
			-10815, -43588, 1,  4,
			32915, -21728,-3,  2,
			32931,  54805,-3, -5,
			32906,  22001,-3, -2,
			21986, -10796,-2,  1,
			-54526, -43592, 5,  4,
			54822,  22000,-5, -2,
			32926, -43585,-3,  4,
			32931, -10791,-3,  1,
			-54496,  43869, 5, -4,
			22005,  11073,-2, -1,
			-54525,  54805, 5, -5,
			-21710,  43867, 2, -4,
			54814, -43586,-5,  4,
			22002,  11074,-2, -1,
			-43606, -10787, 4,  1,
			32913, -54524,-3,  5,
			32928, -43583,-3,  4,
			-10826,  32939, 1, -3,
			-10769, -10787, 1,  1,
			-43574,  43870, 4, -4,
			-32632, -54515, 3,  5,
			-43613,  32941, 4, -3,
			11086, -43590,-1,  4,
			-10773, -54517, 1,  5,
			-54527, -43587, 5,  4,
			22014, -21727,-2,  2,
			32923,  22005,-3, -2,
			-54493,  43865, 5, -4,
			-54541,  43866, 5, -4,
			22019,  32941,-2, -3,
			11067, -54516,-1,  5,
			32912, -21723,-3,  2,
			-10826,  32939, 1, -3,
			-32637, -32659, 3,  3,
			-43574,  11075, 4, -1,
			43834, -54521,-4,  5,
			-43563, -32660, 4,  3,
			-43601, -21725, 4,  2,
			-32647,  54796, 3, -5,
			-21758, -43592, 2,  4,
			54766,  32938,-5, -3,
			32946, -54524,-3,  5,
			-21734,  11074, 2, -1,
			43892, -10787,-4,  1,
			11047, -10790,-1,  1,
			-10794, -43590, 1,  4,
			54793,  11077,-5, -1,
			-32633,  22000, 3, -2,
			-10770, -54516, 1,  5,
			-21749,  54802, 2, -5,
			54782,  11073,-5, -1,
			-43564, -32651, 4,  3,
			-54530, -21721, 5,  2,
			11096, -32655,-1,  3,
			-54525,  54803, 5, -5,
			43863, -21720,-4,  2,
			-32673, -54520, 3,  5,
			-43562,  11071, 4, -1,
			32923,  43870,-3, -4,
			54791,  43873,-5, -4,
			54815, -10787,-5,  1,
			-32634, -32653, 3,  3,
			-54506, -54521, 5,  5,
			-10821,  54796, 1, -5,
			-32653,  32941, 3, -3,
			32950,  43869,-3, -4,
			43895,  54805,-4, -5,
			-54506,  54804, 5, -5,
			-43618, -10788, 4,  1,
			22013,  11077,-2, -1,
			-21746, -32651, 2,  3,
			-43619, -54522, 4,  5,
			22021,  54801,-2, -5,
			43858,  54804,-4, -5,
			43887,  11074,-4, -1,
			-43602, -43588, 4,  4,
			43835,  32936,-4, -3,
			-10823, -54517, 1,  5,
			43834, -43584,-4,  4,
			43883,  11068,-4, -1,
			-43561, -10794, 4,  1,
			11070, -10788,-1,  1,
			11098,  22000,-1, -2,
			-10767,  22000, 1, -2,
			54787, -54517,-5,  5,
			22002,  54804,-2, -5,
			-54543,  22009, 5, -2,
			43869, -10792,-4,  1,
			-10797, -43591, 1,  4,
			54806,  11075,-5, -1,
			43834, -32652,-4,  3,
			54766,  54799,-5, -5,
			54790, -10790,-5,  1,
			32955,  43871,-3, -4);

	public void execute() {
		List<Point> pointList = initializeList(inputList);

		while(true) {
			draw(pointList);
			pointList.forEach(Point::move);
		}

	}

	private List<Point> initializeList(List<Integer> inputList) {
		List<Point> pointList = new ArrayList<>();
		for (int i = 0; i < inputList.size(); i = i + 4) {
			Point point = new Point(inputList.get(i), inputList.get(i + 1), inputList.get(i + 2), inputList.get(i + 3));
			pointList.add(point);
		}
		return pointList;
	}

	private void draw(List<Point> pointList) {

		Integer minX = getMinX(pointList);
		Integer maxX = getMaxX(pointList);
		Integer minY = getMinY(pointList);
		Integer maxY = getMaxY(pointList);

		if(maxX - minX <= 100 && maxY - minY <= 100) {
			for (int y = minY; y <= maxY; y++) {
				StringBuilder stringBuilder = new StringBuilder();
				for (int x = minX; x <= maxX; x++) {
					stringBuilder.append(pointList.contains(new Point(x, y)) ? "X" : ".");
				}
				System.out.println(stringBuilder.toString());

			}
			StringBuilder separator = new StringBuilder();
			for (int x = minX; x <= maxX; x++) {
				separator.append("-");
			}
			System.out.println(separator);
		}

	}

	private Integer getMaxX(List<Point> pointList) {
		return pointList.stream().max(Comparator.comparing(Point::getX)).get().getX();
	}

	private Integer getMinX(List<Point> pointList) {
		return pointList.stream().min(Comparator.comparing(Point::getX)).get().getX();
	}

	private Integer getMaxY(List<Point> pointList) {
		return pointList.stream().max(Comparator.comparing(Point::getY)).get().getY();
	}

	private Integer getMinY(List<Point> pointList) {
		return pointList.stream().min(Comparator.comparing(Point::getY)).get().getY();
	}

	private class Point {
		private Integer x;

		private Integer y;

		private Integer vx;

		private Integer vy;

		public Point(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}

		public Point(Integer x, Integer y, Integer vx, Integer vy) {
			this.x = x;
			this.y = y;
			this.vx = vx;
			this.vy = vy;
		}

		public Integer getX() {
			return x;
		}

		public Integer getY() {
			return y;
		}

		public void move() {
			x += vx;
			y += vy;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Point point = (Point) o;
			return Objects.equals(x, point.x) && Objects.equals(y, point.y);
		}

		@Override
		public int hashCode() {

			return Objects.hash(x, y);
		}
	}

}