/**

You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.

 

Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

 

Constraints:

n == score.length
1 <= n <= 104
0 <= score[i] <= 106
All the values in score are unique.
*/

package com.learning.leetcode;

import java.util.Arrays;

public class problem0001 {
	
	public static void main(String[] args) {
		
		int[] inputArray = {5,4,3,2,1};
		
		String[] resultArray = findRelativeRanks(inputArray);
		
		for (String entry: resultArray) {
			System.out.println(entry);
		}
	}
	
	public static String[] findRelativeRanks(int[] score) {

        String[] result = new String[score.length];
        
        int arrayLength = score.length;

        int[][] sortedPairs = new int[arrayLength][2];

        for (int index = 0; index < arrayLength ; index++) {
            sortedPairs[index] = new int[]{score[index],index};
        }
        
        Arrays.sort(sortedPairs, (a, b) -> b[0] - a[0]);

        for (int index = 0; index < arrayLength; index++) {
        	if (index == 0) {
	    		result[sortedPairs[index][1]] = "Gold Medal";
	    	}
	    	else if (index == 1) {
	    	    result[sortedPairs[index][1]] = "Silver Medal";
	    	}
	    	else if (index == 2) {
	    	    result[sortedPairs[index][1]] = "Bronze Medal";
	    	}
	    	else {
	    	    result[sortedPairs[index][1]] = Integer.toString(index+1);
	    	}
        }

        return result;
    }
}
