package day12;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day12Part2 {

	private List<Character> gardenInput = Arrays.asList('#', '.', '.', '#', '#', '#', '#', '.', '#', '#', '.', '.', '#', '.', '#', '#', '.', '#', '.', '.', '#', '.', '.', '.', '.', '.', '#', '#', '.', '.', '#', '.', '#', '#', '#', '.', '#', '.', '.', '#', '#', '#', '.', '.', '.', '.', '#', '#', '.', '#', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#', '#', '.', '#', '#', '#', '#', '.', '#', '.', '.', '#', '#', '.', '#', '#', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.');

	private List<String> combinationList = Arrays.asList(
			"##...", ".",
			"##.##", ".",
			".#.#.", "#",
			"#..#.", ".",
			"#.###", "#",
			".###.", ".",
			"#.#..", ".",
			"##..#", ".",
			".....", ".",
			"...#.", ".",
			".#..#", ".",
			"####.", "#",
			"...##", "#",
			"..###", "#",
			"#.#.#", "#",
			"###.#", "#",
			"#...#", "#",
			"..#.#", ".",
			".##..", "#",
			".#...", "#",
			".##.#", "#",
			".####", ".",
			".#.##", ".",
			"..##.", ".",
			"##.#.", ".",
			"#.##.", ".",
			"#..##", ".",
			"###..", ".",
			"....#", ".",
			"#####", "#",
			"#....", ".",
			"..#..", "#");

	private Long leftAdded = 0L;

	public Long execute() {
		Map<String, Character> combinationMap = initializeCombinationMap(combinationList);

		List<Character> garden = new ArrayList<>();
		garden.addAll(gardenInput);

		Long previousValue = countGardenPlants(garden);

		for(long i = 0; i <= 125; i++) {
			addOrRemoveEmptyElements(garden);
			garden = passYear(garden, combinationMap);

			//System.out.println(i + " --> " + (countGardenPlants(garden) - previousValue));
			//previousValue = countGardenPlants(garden);
		}

		return countGardenPlants(garden) + ((50000000000L-126L)*36L);
	}

	private Map<String, Character> initializeCombinationMap(List<String> combinationList) {
		Map<String, Character> combinations = new HashMap<>();
		for(int i = 0; i < combinationList.size()-1; i = i+2) {
			String formula = combinationList.get(i);
			Character produce = combinationList.get(i+1).charAt(0);
			combinations.put(formula, produce);
		}
		return combinations;
	}

	private void addOrRemoveEmptyElements(List<Character> garden) {
		if(garden.get(0).equals('#')) {
			garden.add(0, '.');
			garden.add(0, '.');
			leftAdded+=2;
		}
		else if(garden.get(1).equals('#')) {
			garden.add(0, '.');
			leftAdded++;
		}
		else
			while(garden.get(2).equals('.')) {
				garden.remove(0);
				leftAdded--;
			}

		if(garden.get(garden.size()-1).equals('#')) {
			garden.add('.');
			garden.add('.');
		}
		else if(garden.get(garden.size()-2).equals('#')) {
			garden.add('.');
		}
		else
			while(garden.get(garden.size()-3).equals('.')) {
				garden.remove(garden.size()-1);
			}
	}

	private List<Character> passYear(List<Character> garden, Map<String, Character> combinationMap) {

		List<Character> newGarden = new ArrayList<>();

		for(int i = 0; i < garden.size(); i++) {

			List<Character> stateList = new ArrayList<>();
			if(i == 0) {
				stateList.add('.');
				stateList.add('.');
				stateList.addAll(garden.subList(i, i+3));
			}
			else if (i == 1) {
				stateList.add('.');
				stateList.addAll(garden.subList(i-1, i+3));
			}
			else if (i == garden.size()-1) {
				stateList.addAll(garden.subList(i-2, i+1));
				stateList.add('.');
				stateList.add('.');
			}
			else if (i == garden.size()-2) {
				stateList.addAll(garden.subList(i-2, i+2));
				stateList.add('.');
			}
			else {
				stateList = garden.subList(i-2, i+3);
			}

			StringBuilder builder = new StringBuilder();
			for(Character value : stateList)
				builder.append(value);

			if(combinationMap.containsKey(builder.toString())) {
				newGarden.add(combinationMap.get(builder.toString()));
			}
			else {
				newGarden.add('.');
			}
		}
		return newGarden;
	}

	private Long countGardenPlants(List<Character> garden) {
		Long value = 0L;
		for(int i = 0; i < garden.size(); i++) {
			if(garden.get(i).equals('#'))
				value+=i-leftAdded;
		}
		return value;
	}

}
