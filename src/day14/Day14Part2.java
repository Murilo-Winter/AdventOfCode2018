package day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day14Part2 {

	private List<Integer> input = Arrays.asList(5, 0, 5, 9, 6, 1);
	private Integer inputMatch = 0;
	private Integer lastRecipeChecked = 0;
	private Integer extra = 0;

	public int execute() {
		List<Integer> recipeList = new ArrayList<>();
		recipeList.add(3);
		recipeList.add(7);

		List<Integer> elfPositionList = Arrays.asList(0, 1);

		while(true) {
			cookNewRecipes(recipeList, elfPositionList);
			findNewPosition(recipeList, elfPositionList);
			if (findPattern(recipeList))
				return recipeList.size() - input.size()-extra;;
		}
	}

	private Boolean findPattern(List<Integer> recipeList) {

		for(int i = lastRecipeChecked+1; i < recipeList.size(); i++) {
			if(input.get(inputMatch).equals(recipeList.get(i))) {
					inputMatch++;
					if (inputMatch.equals(input.size())) {
						extra = recipeList.size()-1 - i;
						break;
					}
			}
			else  {
				inputMatch = 0;
			}
		}

		lastRecipeChecked = recipeList.size()-1;
		return inputMatch.equals(input.size());
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