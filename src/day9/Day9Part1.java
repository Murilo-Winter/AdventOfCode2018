package day9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day9Part1 {

	private Integer players = 493;

	private Integer marbles = 71863;

	private Map<Integer, Integer> scoreMap = new HashMap<>();

	public Integer execute() {

		Integer currentMarble = 0;
		Integer marblePosition = 0;
		Integer currentPlayer = 0;

		List<Integer> marbleList = new ArrayList<>();
		marbleList.add(0);

		while (marbles > 0) {
			currentMarble++;
			if (currentPlayer.equals(players))
				currentPlayer = 1;
			else
				currentPlayer++;

			int newPosition;
			if (currentMarble % 23 == 0) {
				newPosition = returnRemovalPosition(marblePosition, marbleList);
				Integer score = currentMarble + marbleList.get(newPosition);
				marbleList.remove(newPosition);
				updateScore(score, currentPlayer);
			}
			else {
				newPosition = calculateNewPosition(marblePosition, marbleList);
				marbleList.add(newPosition, currentMarble);
			}

			marblePosition = newPosition;
			marbles--;
		}
		return scoreMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
	}

	private void updateScore(Integer score, Integer player) {
		if (scoreMap.containsKey(player)) {
			scoreMap.put(player, scoreMap.get(player) + score);
		}
		else {
			scoreMap.put(player, score);

		}
	}

	private Integer calculateNewPosition(Integer marblePosition, List<Integer> marbleList) {
		Integer newPosition = marblePosition + 2;
		if (newPosition > marbleList.size())
			newPosition -= marbleList.size();
		return newPosition;
	}

	private Integer returnRemovalPosition(Integer marblePosition, List<Integer> marbleList) {
		Integer removalPosition = marblePosition - 7;

		if (removalPosition <= 0)
			removalPosition += marbleList.size();

		return removalPosition;
	}

}