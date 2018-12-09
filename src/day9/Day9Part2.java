package day9;

import java.util.HashMap;
import java.util.Map;

import it.unimi.dsi.fastutil.BigList;
import it.unimi.dsi.fastutil.longs.LongBigArrayBigList;

public class Day9Part2 {

	private Integer players = 493;

	private Integer marbles = 7186300;

	private Map<Integer, Long> scoreMap = new HashMap<>();

	public Long execute() {
		Integer currentMarble = 0;
		Long marblePosition = 0L;
		Integer currentPlayer = 0;

		BigList marbleList = new LongBigArrayBigList();
		marbleList.add(0L);

		while (marbles > 0) {
			currentMarble++;
			if (currentPlayer.equals(players))
				currentPlayer = 1;
			else
				currentPlayer++;

			long newPosition;
			if (currentMarble % 23 == 0) {
				newPosition = returnRemovalPosition(marblePosition, marbleList);
				Long score = currentMarble + (Long) marbleList.get(newPosition);
				marbleList.remove(newPosition);
				updateScore(score, currentPlayer);
			}
			else {
				newPosition = calculateNewPosition(marblePosition, marbleList);
				marbleList.add(newPosition, Long.valueOf(currentMarble));
			}

			marblePosition = newPosition;
			marbles--;
		}
		return scoreMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
	}

	private void updateScore(Long score, Integer player) {
		if (scoreMap.containsKey(player)) {
			scoreMap.put(player, scoreMap.get(player) + score);
		}
		else {
			scoreMap.put(player, score);
		}
	}

	private Long calculateNewPosition(Long marblePosition, BigList marbleList) {
		Long newPosition = marblePosition + 2L;
		if (newPosition > marbleList.size())
			newPosition -= marbleList.size();
		return newPosition;
	}

	private Long returnRemovalPosition(Long marblePosition, BigList marbleList) {
		Long removalPosition = marblePosition - 7L;

		if (removalPosition <= 0)
			removalPosition += marbleList.size();

		return removalPosition;
	}

}