/**
*/

package com.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class problem0013 {

	public static void main(String[] args) {

		System.out.println(numDecodings("11106"));
		arrayFunctionsTest();
	}

    public static int numDecodings(String s) {
        
    	return 0;

    }
    
    public static void arrayFunctionsTest() {
    	
    	int[] intArray1 = new int[10];
    	
    	Arrays.fill(intArray1, 99);

    	System.out.println(Arrays.toString(intArray1));
    	
    	int[] intArray2 = {6,5,4,3,2,1};
    	
    	Arrays.sort(intArray2);

    	System.out.println(Arrays.toString(intArray2));
    	
    	Collections.reverseOrder();
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	pq.add(2);
    	pq.add(1);
    	pq.add(5);
    	pq.add(3);
    	pq.add(7);
    	pq.add(6);

    	while (!pq.isEmpty()) {
        	System.out.println(pq.poll());
    	}
    	
    	
    	int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
    	
    	int arrLen = arr.length;
    	int arrMax = 0;
    	int arrMin = 999999999;
    	
    	int result = -1;
    	
    	int[] arrLeftMax = new int[arrLen];
    	int[] arrRightMin = new int[arrLen];
    	
    	for (int i = 0; i<arrLen; i++) {
    		if (i > 0 && arr[i-1] > arrMax) arrMax = arr[i-1];
    		if (i > 0 && arr[arrLen-i] < arrMin) arrMin = arr[arrLen-i];
    		arrLeftMax[i] = arrMax;
    		arrRightMin[arrLen-i-1] = arrMin;
    	}
    	
    	for (int i = 0; i < arrLen; i++) {
    		if (arr[i] > arrLeftMax[i] && arr[i] < arrRightMin[i]) {
    			result = i;
    		}
    	}
    	
    	System.out.println(result);
    	
    }
    
}