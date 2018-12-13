package day11;

public class Day11Part1 {

	private Integer input = 4172;

	private Integer xSize = 300;

	private Integer ySize = 300;

	public String execute() {

		Integer powerLevel[][] = new Integer[xSize][ySize];

		powerLevel = calculatePowerLevel(powerLevel);

		return calculateHighestSquare(powerLevel);

	}

	private Integer[][] calculatePowerLevel(Integer[][] powerLevel) {

		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				String powerString = String.valueOf(((((x + 1) + 10) * (y + 1)) + input) * ((x + 1) + 10));
				Integer power;
				if (powerString.length() < 3)
					power = 0;
				else
					power = Character.getNumericValue(powerString.charAt(powerString.length() - 3));
				powerLevel[x][y] = power - 5;
			}
		}
		return powerLevel;
	}

	private String calculateHighestSquare(Integer[][] powerLevel) {
		Integer highest = Integer.MIN_VALUE;
		Integer highX = 0;
		Integer highY = 0;

		for (int x = 0; x < xSize - 3; x++) {
			for (int y = 0; y < ySize - 3; y++) {

				Integer value = powerLevel[x][y] + powerLevel[x + 1][y] + powerLevel[x + 2][y] +
						powerLevel[x][y + 1] + powerLevel[x + 1][y + 1] + powerLevel[x + 2][y + 1] +
						powerLevel[x][y + 2] + powerLevel[x + 1][y + 2] + powerLevel[x + 2][y + 2];

				if (value > highest) {
					highest = value;
					highX = x + 1;
					highY = y + 1;
				}
			}

		}
		return highX + "," + highY;
	}
}
