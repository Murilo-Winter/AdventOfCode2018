package day1.part2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

	private static List<Long> inputList = Arrays
			.asList(13L, -12L, -14L, 19L, -13L, 16L, 12L, 19L, 8L, -10L, -9L, -2L, 1L, -13L, 10L, -7L, -11L, -10L, 1L,
					-14L, -15L, 16L, 6L, 17L, -19L, -13L, 5L, -19L, -12L, -10L, -12L, 13L, 14L, 3L, -13L, 3L, 17L, 10L,
					-16L, 19L, 1L, 11L, -16L, 3L, -16L, -12L, -7L, -11L, -6L, -19L, 6L, 12L, 15L, -7L, -18L, 13L, -4L,
					-14L, -7L, -18L, 17L, 9L, -12L, -3L, -13L, -16L, 14L, -4L, -12L, -10L, -3L, 8L, -10L, -4L, -10L,
					-11L, -14L, 11L, -7L, 17L, 19L, 2L, -13L, 17L, -10L, -6L, 15L, 7L, 15L, -3L, -7L, -6L, -1L, -13L,
					-5L, -6L, -6L, -12L, -18L, -7L, -19L, -5L, -15L, -7L, 4L, -18L, 5L, 17L, -2L, -12L, -1L, 3L, -11L,
					10L, -13L, 10L, 17L, 15L, 16L, 16L, -7L, -17L, -11L, 10L, -15L, -13L, 2L, -6L, 3L, 9L, 2L, 20L,
					-14L, 22L, 6L, 14L, -3L, -15L, -7L, -16L, -2L, -20L, 3L, -21L, -13L, -14L, 3L, 17L, -18L, -14L, 13L,
					-11L, 14L, 18L, -16L, -17L, -5L, -3L, 10L, 2L, -14L, 18L, -3L, -8L, -14L, -10L, -5L, 11L, -15L, -3L,
					1L, -17L, 7L, 17L, -15L, -17L, 19L, -15L, 12L, -10L, -16L, -13L, -5L, -6L, 4L, -3L, 11L, -15L, -16L,
					3L, 14L, 9L, 6L, 14L, -5L, 1L, 16L, -3L, 9L, -14L, 6L, -17L, -12L, -13L, -2L, -4L, -19L, -9L, 17L,
					-18L, 9L, -5L, -14L, -14L, 18L, 19L, -16L, -13L, -3L, -1L, 6L, 6L, -10L, -3L, -4L, 21L, 10L, 6L, 4L,
					23L, 17L, -13L, 15L, -3L, 13L, 4L, 11L, 17L, 8L, -1L, 10L, -15L, -8L, 1L, 14L, 13L, -7L, -11L, 9L,
					17L, -11L, 7L, 18L, 17L, 3L, 5L, -13L, 4L, -13L, -4L, -22L, 14L, -24L, 3L, 26L, 19L, 20L, 4L, -12L,
					11L, 2L, -12L, -6L, -20L, 9L, 2L, 10L, -4L, -10L, -20L, -5L, -5L, 8L, -7L, -27L, -16L, 6L, -12L,
					-16L, 6L, -20L, -14L, -8L, -12L, -18L, -19L, 3L, -16L, 3L, 1L, -16L, 11L, -1L, -4L, -16L, 4L, -6L,
					-7L, -12L, -9L, 15L, -3L, -4L, -10L, 15L, 10L, -7L, 9L, 6L, -4L, 2L, 20L, -14L, 18L, 11L, -6L, 1L,
					1L, 1L, -13L, -7L, 3L, -12L, 11L, -17L, -9L, -12L, -1L, -8L, -16L, -1L, -14L, -6L, 18L, 16L, -4L,
					-15L, 9L, -10L, -18L, 11L, 2L, -10L, -1L, 10L, 20L, 7L, 13L, -1L, 14L, 18L, 16L, -7L, 22L, 11L, 13L,
					6L, -9L, -8L, 14L, -20L, 18L, -15L, -16L, -1L, 12L, 12L, 12L, -20L, 38L, -10L, 17L, -4L, 21L, 12L,
					-19L, -12L, 4L, 20L, 16L, 14L, 12L, 16L, -9L, -17L, -13L, -7L, -16L, -24L, -9L, 2L, 1L, 7L, -13L,
					-48L, -15L, -3L, 6L, -21L, -10L, 8L, -20L, -16L, -4L, 13L, 15L, -11L, 19L, -43L, 10L, -34L, -15L,
					-17L, 16L, 10L, 1L, -3L, -9L, -19L, 1L, -18L, 9L, -14L, -13L, -17L, 19L, 1L, -12L, -18L, -11L, 2L,
					-18L, 8L, 1L, 6L, 7L, -17L, 5L, 23L, -8L, -18L, 17L, 5L, 1L, 10L, 10L, 9L, 12L, -18L, -12L, -15L,
					-3L, -11L, -18L, 12L, -16L, -21L, 6L, 6L, 4L, -7L, -21L, 14L, -5L, 4L, -7L, -17L, -17L, 14L, -2L,
					15L, -7L, -14L, -7L, -7L, -2L, -6L, 10L, -9L, -20L, 15L, 17L, 8L, 16L, -2L, -4L, 10L, 8L, 3L, -27L,
					14L, -20L, 4L, -24L, -14L, -2L, 22L, 21L, -17L, -21L, 6L, -8L, -25L, -12L, 19L, -14L, -4L, -9L, -7L,
					-40L, -30L, 37L, 51L, -84L, -56L, -14L, 35L, 12L, -123L, -18L, 14L, -71L, -35L, -18L, 1L, -11L, 15L,
					-13L, -12L, -19L, -16L, 14L, 6L, -17L, -11L, -18L, 92L, -24L, 10L, -22L, 16L, -22L, 3L, -21L, 2L,
					30L, 31L, 8L, -2L, 1L, 19L, -23L, 7L, -112L, -15L, -16L, 10L, -15L, -49L, 43L, 7L, 250L, -39L, -80L,
					1324L, 76538L, 17L, -3L, 4L, 76L, 35L, 12L, -33L, 52L, 37L, -33L, 26L, 60L, -5L, 12L, 25L, -18L,
					17L, 9L, 19L, -7L, 3L, -4L, -8L, 11L, -9L, 20L, 18L, 6L, -15L, 2L, 17L, 4L, 5L, -7L, -14L, -10L,
					-2L, -7L, 6L, 22L, -18L, 15L, -10L, 5L, -3L, -18L, 24L, 1L, 18L, 14L, 21L, -11L, -20L, 6L, -16L, 9L,
					-11L, -29L, -21L, -17L, 13L, 14L, -9L, 45L, 61L, 9L, 5L, -11L, 13L, 17L, 3L, 17L, -6L, -8L, -19L,
					2L, -16L, -1L, -1L, -17L, 9L, 15L, -22L, -4L, 5L, 17L, -9L, 19L, 21L, -6L, 5L, 17L, -4L, -7L, 8L,
					-23L, -18L, -18L, 10L, 19L, 9L, -17L, -18L, -25L, 4L, 8L, 6L, -30L, 67L, -17L, 38L, 23L, 1L, -10L,
					14L, 6L, 9L, 10L, -18L, 4L, 12L, 14L, 2L, 3L, 20L, -15L, 16L, 4L, -19L, 6L, 11L, 15L, 17L, 9L, 16L,
					-12L, -6L, 16L, 18L, 5L, 5L, -1L, -12L, 2L, 15L, 14L, 5L, -3L, 12L, 4L, 12L, -6L, 8L, 17L, 9L, -5L,
					14L, -7L, 4L, 6L, 6L, 8L, 11L, -7L, 1L, -17L, -13L, 6L, 12L, -9L, 15L, -1L, 9L, -16L, -2L, 8L, 17L,
					-2L, 9L, 15L, -7L, 11L, -5L, -10L, 16L, -11L, -13L, 14L, 12L, 17L, 10L, -11L, -17L, -18L, 10L, 13L,
					10L, 15L, -6L, 18L, -13L, -13L, 9L, -11L, 18L, 1L, 1L, -14L, 7L, 13L, 7L, 15L, 5L, 11L, 17L, 11L,
					-13L, -9L, -8L, -10L, -5L, 2L, 19L, 12L, -11L, 9L, -11L, 15L, -5L, 14L, 18L, 7L, 21L, 9L, 14L, -7L,
					9L, -7L, -21L, -16L, -22L, -12L, 19L, -2L, 12L, 14L, 15L, 23L, 2L, 6L, -9L, -16L, 27L, -17L, 10L,
					19L, -15L, 8L, 15L, -2L, -4L, 8L, 17L, 1L, 12L, -4L, -3L, -12L, -31L, -1L, -13L, -4L, -15L, 5L, 20L,
					10L, -5L, -22L, -9L, -22L, -15L, -6L, 23L, -30L, -17L, -10L, -20L, -2L, -4L, -13L, 12L, -3L, 5L,
					-9L, -11L, 1L, -5L, -19L, -17L, 7L, 19L, 5L, 12L, -15L, 14L, 2L, -17L, -13L, 2L, -15L, 14L, -20L,
					-24L, 8L, 10L, -20L, -12L, -17L, -5L, -2L, -18L, -14L, -18L, 2L, 19L, 12L, -18L, 4L, 19L, 15L, -2L,
					-7L, -8L, -12L, 16L, -15L, -13L, -7L, -19L, 2L, -14L, 11L, -15L, -17L, 18L, -2L, -8L, -20L, -4L, 5L,
					16L, 4L, 14L, 19L, -2L, -13L, 23L, -9L, 13L, 4L, -7L, -13L, -4L, -8L, 4L, -8L, 17L, -2L, -18L, -12L,
					-12L, 11L, -3L, -11L, 4L, 5L, -23L, 20L, 6L, -13L, -5L, -16L, -7L, 6L, 10L, -15L, 7L, 6L, -12L, 17L,
					-9L, -23L, 6L, 11L, -6L, -9L, 20L, -19L, 2L, -1L, 21L, 5L, -18L, 23L, 17L, 8L, 3L, 15L, 3L,
					-76719L);

	public static void main(String[] args) {
		Long frequency = 0L;
		Map<Long, Integer> reachedFrequencies = new HashMap<>();

		int i = 0;
		while (true) {
			Long entry = inputList.get(i);
			frequency += entry;

			if (reachedFrequencies.containsKey(frequency)) {
				System.out.println(frequency);
				break;
			}
			else {
				reachedFrequencies.put(frequency, 1);
				if (i + 1 == inputList.size())
					i = 0;
				else
					i++;
			}
		}
	}

}
