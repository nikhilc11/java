/**
Design a food rating system that can do the following:

Modify the rating of a food item listed in the system.
Return the highest-rated food item for a type of cuisine in the system.
Implement the FoodRatings class:

FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
foods[i] is the name of the ith food,
cuisines[i] is the type of cuisine of the ith food, and
ratings[i] is the initial rating of the ith food.
void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.

 

Example 1:
Input
["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
[[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
Output
[null, "kimchi", "ramen", null, "sushi", null, "ramen"]

Explanation
FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
foodRatings.highestRated("korean"); // return "kimchi"
                                    // "kimchi" is the highest rated korean food with a rating of 9.
foodRatings.highestRated("japanese"); // return "ramen"
                                      // "ramen" is the highest rated japanese food with a rating of 14.
foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
foodRatings.highestRated("japanese"); // return "sushi"
                                      // "sushi" is the highest rated japanese food with a rating of 16.
foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
foodRatings.highestRated("japanese"); // return "ramen"
                                      // Both "sushi" and "ramen" have a rating of 16.
                                      // However, "ramen" is lexicographically smaller than "sushi".
 

Constraints:
1 <= n <= 2 * 104
n == foods.length == cuisines.length == ratings.length
1 <= foods[i].length, cuisines[i].length <= 10
foods[i], cuisines[i] consist of lowercase English letters.
1 <= ratings[i] <= 108
All the strings in foods are distinct.
food will be the name of a food item in the system across all calls to changeRating.
cuisine will be a type of cuisine of at least one food item in the system across all calls to highestRated.
At most 2 * 104 calls in total will be made to changeRating and highestRated.
*/

package com.learning.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class problem0008 {

	public static void main(String[] args) {

		String[] foods = { "Manchurian", "Fried Rice", "Pizza", "Noodles"};
		String[] cuisines = { "Chinese", "Chinese", "Italian", "Chinese" };
		int[] ratings = { 5, 4, 3, 5 };

		FoodRatings obj = new FoodRatings(foods, cuisines, ratings);

		String food = "Manchurian";
		int newRating = 2;
		String cuisine = "Chinese";
		System.out.println(obj.highestRated(cuisine));
		obj.changeRating(food, newRating);
		System.out.println(obj.highestRated(cuisine));

	}
}


class Food {
	String name;
	Integer rating;
	String cuisineName;
	public Food(String name, int rating, String cuisineName) {
		this.name = name;
		this.rating = rating;
		this.cuisineName = cuisineName;
	}
	public void changeFoodRating(int rating) {
		this.rating = rating;
	}
}

class Cuisine {
	String name;
	TreeMap<String, Food> foodMap;
	Food highestRatedFood;
	public Cuisine(String name) {
		this.name = name;
	}

	public void addFood(Food food) {
		if (this.foodMap == null) {
			this.foodMap = new TreeMap<String, Food>();
		}
		this.foodMap.put(food.name, food);
	}

	public void calculateHighestRating() {
		
		for (String foodName: foodMap.keySet()) {
			Food food = foodMap.get(foodName);
			
			if (highestRatedFood == null) {
				highestRatedFood = food;
			}
			else if (food.rating > highestRatedFood.rating) {
				highestRatedFood = food;
			}
			else if (food.rating == highestRatedFood.rating) {
				if (food.name.compareTo(highestRatedFood.name) < 1) {
					highestRatedFood = food;
				}
			}
		} 
	}
}


class FoodRatings {
	
	Map<String, Cuisine> cuisineMap;
	Map<String, Food> foodMap;
	
	public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

		cuisineMap = new HashMap<String, Cuisine>();
		foodMap = new HashMap<String, Food>();
		
		for (int index = 0; index < foods.length; index++) {
			
			Food food = new Food(foods[index], ratings[index], cuisines[index]);
			Cuisine cuisine = new Cuisine(cuisines[index]);
			
			foodMap.put(foods[index], food);

			if (!cuisineMap.containsKey(cuisines[index])) {
				cuisineMap.put(cuisines[index], cuisine);
			}
			
			cuisineMap.get(cuisine.name).addFood(food);
			cuisineMap.get(cuisine.name).calculateHighestRating();
		}
	}

	public void changeRating(String food, int newRating) {
		foodMap.get(food).rating = newRating;
		String cuisineName = foodMap.get(food).cuisineName;
		cuisineMap.get(cuisineName).calculateHighestRating();
	}

	public String highestRated(String cuisine) {
		
		return cuisineMap.get(cuisine).highestRatedFood.name;
	}
}

class FoodRatingsV1 {

	Map<String, Set<String>> cuisineToFoodsSetMap;
	Map<String, Integer> foodToRatingMap;
	
	public FoodRatingsV1(String[] foods, String[] cuisines, int[] ratings) {

		cuisineToFoodsSetMap = new HashMap<String, Set<String>>();
		foodToRatingMap = new HashMap<String, Integer>();
		
		for (int index = 0; index < foods.length; index++) {

			foodToRatingMap.put(foods[index], ratings[index]);

			if (!cuisineToFoodsSetMap.containsKey(cuisines[index])) {
				cuisineToFoodsSetMap.put(cuisines[index], new TreeSet<String>());
			}
			cuisineToFoodsSetMap.get(cuisines[index]).add(foods[index]);
		}
	}

	public void changeRating(String food, int newRating) {
		foodToRatingMap.put(food, newRating);
	}

	public String highestRated(String cuisine) {
		Set<String> foodSet = cuisineToFoodsSetMap.get(cuisine);
		
		String finalFood = "";
		int finalRating = 0;
		
		for (String food: foodSet) {
			int rating = foodToRatingMap.get(food);
			if (rating > finalRating) {
				finalFood = food;
				finalRating = rating;
			}
			else if (rating == finalRating) {
				if (food.compareTo(finalFood) < 1) {
					finalFood = food;
				}
			}
		} 
		return finalFood;
	}
}