/**
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.

Example 1:
Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6

Example 2:
Input: arr = [1,1]
Output: 1
 

Constraints:
1 <= arr.length <= 104
0 <= arr[i] <= 105

*/

package com.learning.leetcode;

public class problem0002 {
	
	public static void main(String[] args) {
		
		int[] inputArray = {1,2,2,3,3,3,4,4,4,4,4,4};
		
		System.out.println(findSpecialInteger(inputArray));
	}

	public static int findSpecialInteger(int[] arr) {

		int size = arr.length;
		int requiredCount = size/4;

		for (int index = 0; index < size; index++) {
			if (arr[index] == arr[index + requiredCount]) {
				return arr[index];
			}
		} 
		
//		int count= 0;
//		int previousNumber = -1;
//
//		for (int number : arr)  {
//			if (number > previousNumber) {
//				previousNumber = number;
//				count = 1;
//			}
//			else {
//				count++;
//			}
//			if (count > requiredCount) {
//				return number;
//			}
//		}
		
    	return -1;
    	
    }
}
