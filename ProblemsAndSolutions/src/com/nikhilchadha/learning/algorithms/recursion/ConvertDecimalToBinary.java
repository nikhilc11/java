package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Convert a Decimal Number to its corresponding Binary Number using recursion.
 */
public class ConvertDecimalToBinary {
	
	public static void main(String[] args) {
		
		convertDecimalToBinary(100);
	}
	
	public static void convertDecimalToBinary(int num) {
		
		System.out.println("Input_Decimal_Number: " + num + " Output_Binary_Number: " + findBinaryOfDecimal(num));
	}
	
	private static int findBinaryOfDecimal(int number) {
		
		// TODO - Generate Both Positive and Negative Test Cases
		return 0;
	}

}
