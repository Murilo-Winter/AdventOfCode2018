package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day14Part1 {

	Integer input = 505961;

	public String execute() {
		List<Integer> recipeList = new ArrayList<>();
		recipeList.add(3);
		recipeList.add(7);

		List<Integer> elfPositionList = Arrays.asList(0, 1);

		while(recipeList.size() < input + 10) {
			cookNewRecipes(recipeList, elfPositionList);
			findNewPosition(recipeList, elfPositionList);
		}
		return recipeList.subList(recipeList.size()-10, recipeList.size()).toString();
	}

	private void cookNewRecipes(List<Integer> recipeList, List<Integer> elfPositionList) {
		Integer sum = 0;
		for(Integer position : elfPositionList) {
			sum+= recipeList.get(position);
		}

		String digits = String.valueOf(sum);
		for (int i = 0; i < digits.length(); i++) {
			recipeList.add(Character.getNumericValue(digits.charAt(i)));
		}
	}

	private void findNewPosition(List<Integer> recipeList, List<Integer> elfPositionList) {

		for(int i = 0; i < elfPositionList.size(); i++) {
			Integer elfPosition = elfPositionList.get(i);

			Integer newPosition = elfPosition + recipeList.get(elfPosition) + 1;
			while(newPosition >= recipeList.size())
				newPosition-=recipeList.size();

			elfPositionList.set(i, newPosition);
		}
	}

}