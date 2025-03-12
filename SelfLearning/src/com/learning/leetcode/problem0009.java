/**
*/

package com.learning.leetcode;

import java.util.Arrays;

public class problem0009 {

	public static void main(String[] args) {

		int[] arr = {2,3,4,5};
		
		System.out.println(maximumHappinessSum(arr,2));
	}

    public static long maximumHappinessSum(int[] happiness, int k) {
        
    	Arrays.sort(happiness);
    	
    	long totalHappiness = 0;
    	int stepIndex = 0;
    	
    	for (int index = happiness.length-1; index >= 0; index--) {
    		if (stepIndex == k) {
    			break;
    		}
    		else if (happiness[index] - stepIndex > 0) {
    			totalHappiness += (happiness[index] - stepIndex);
    		}
    		stepIndex++;
    	}
    	
    	return totalHappiness;
    }
}