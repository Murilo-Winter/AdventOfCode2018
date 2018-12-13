package day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day12Part1 {

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

	private List<Character> sampleGarden = Arrays.asList('#', '.', '.', '#', '.', '#', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '#', '#', '#', '.', '.', '.', '#', '#', '#');

	private List<String> sampleCombinationList = Arrays.asList(
			"...##", "#",
			"..#..", "#",
			".#...", "#",
			".#.#.", "#",
			".#.##", "#",
			".##..", "#",
			".####", "#",
			"#.#.#", "#",
			"#.###", "#",
			"##.#.", "#",
			"##.##", "#",
			"###..", "#",
			"###.#", "#",
			"####.", "#");

		private Integer leftAdded = 0;

	public Integer execute() {
		Map<String, Character> combinationMap = initializeCombinationMap(combinationList);

		List<Character> garden = new ArrayList<>();
		garden.addAll(gardenInput);

		garden.add(0, '.');
		garden.add(0, '.');
		garden.add('.');
		garden.add('.');
		leftAdded = 2;

		for(Integer i = 0; i < 20; i++) {
			garden = passYear(garden, combinationMap);

			if(garden.get(0).equals('#')) {
				garden.add(0, '.');
				garden.add(0, '.');
				leftAdded+=2;
			}
			else if(garden.get(1).equals('#')) {
				garden.add(0, '.');
				leftAdded++;
			}

			if(garden.get(garden.size()-1).equals('#')) {
				garden.add('.');
				garden.add('.');
			}
			else if(garden.get(garden.size()-2).equals('#')) {
				garden.add('.');
			}
			System.out.println(countGardenPlants(garden));
		}

		return countGardenPlants(garden);
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

	private Integer countGardenPlants(List<Character> garden) {
		Integer value = 0;
		for(int i = 0; i < garden.size(); i++) {
			if(garden.get(i).equals('#'))
				value+=i-leftAdded;
		}
		return value;
	}

}
