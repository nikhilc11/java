package com.nikhilchadha.learning.datastructures.arrays;

import java.util.Arrays;

public class OneDimArray {

	/**
	 * Main Function for the Class
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(getIntArrayWithSize(10)));
	}
	
	/**
	 * Function to create an integer array with iven size
	 * @param size
	 * @return
	 */
	public static int[] getIntArrayWithSize(int size) {
		
		// Declare an Array
		int[] intArray;
		
		// Instantiate an Array
		intArray = new int[size];
		
		// Initialize an Array to Default Values as Min_Value for Integer
		for (int i=0; i<intArray.length; i++) {
			intArray[i] = Integer.MIN_VALUE;
		}
		
		return intArray;
	}
}
