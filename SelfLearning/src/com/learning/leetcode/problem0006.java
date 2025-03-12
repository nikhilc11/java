/**
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.


Example 1:
Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".


Example 2:
Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are: 
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
Clearly the destination city is "A".


Example 3:
Input: paths = [["A","Z"]]
Output: "Z"
 

Constraints:
1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.

*/

package com.learning.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class problem0006 {
	
	public static void main(String[] args) {
		
		String[][] inputArray = {{"Lima","Sao Paulo"},{"London","New York"},{"New York","Lima"}};

		int m = inputArray.length;
		int n = inputArray[0].length;

		List<List<String>> paths = new ArrayList<List<String>>();
		
		for (int i = 0; i < m; i++) {
			List<String> stringList = new ArrayList<String>();
			for (int j = 0; j < n; j++) {
				stringList.add(inputArray[i][j]);
			}
			paths.add(stringList);
		}

		System.out.println(destCity(paths));
	}

	public static String destCity(List<List<String>> paths) {
		
		String destination = "";
		
		HashSet<String> sourceCitySet = new HashSet<String>();
		
		for (List<String> entry : paths) {
			sourceCitySet.add(entry.get(0));
		}
		
		for (List<String> entry : paths) {
			if (!sourceCitySet.contains(entry.get(1))) {
				destination = entry.get(1);
			}
		}
		
    	return destination;
    	
    }

	public static String destCityV1(List<List<String>> paths) {
		
		String destination = "";
		
		Map<String, Integer> cityMap = new HashMap<String, Integer>();
		
		for (List<String> entry : paths) {
			int index = 0;
			for (String city : entry) {
				if (cityMap.containsKey(city)) {
					cityMap.remove(city);
				}
				else {
					cityMap.put(city, index);
				}
				index++;
			}
		}
		
		for (String city : cityMap.keySet()) {
			if (cityMap.get(city) > 0) {
				destination = city;
			}
		}
		
    	return destination;
    	
    }
}
