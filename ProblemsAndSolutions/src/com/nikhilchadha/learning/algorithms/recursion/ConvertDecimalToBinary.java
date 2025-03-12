package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Convert a Decimal Number to its corresponding Binary Number using recursion.
 */
public class ConvertDecimalToBinary {
	
	/**
	 * Main Function for the Class
	 * @param args
	 */
	public static void main(String[] args) {
		
		convertDecimalToBinary(100);
	}
	
	/**
	 * Wrapper Function to perform Input Validation before calling the Recursive Function
	 * @param number
	 */
	public static void convertDecimalToBinary(int number) {
		
		System.out.println("Input_Decimal_Number: " + number + " Output_Binary_Number: " + findBinaryOfDecimal(number));
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 * @time_complexity_O()
	 * @space_complexity_O()
	 */
	private static int findBinaryOfDecimal(int number) {
		
		// TODO - Generate Both Positive and Negative Integers
		return 0;
	}

}
