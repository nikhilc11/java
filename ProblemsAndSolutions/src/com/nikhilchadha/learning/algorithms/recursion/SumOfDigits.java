package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find the sum of digits of a positive integer number using recursion.
 */
public class SumOfDigits {
	
	/**
	 * Main Function for the Class
	 * @param args
	 */
	public static void main(String[] args) {
		
		sumOfDigits(0);
		sumOfDigits(1);
		sumOfDigits(9);
		sumOfDigits(10);
		sumOfDigits(11);
		sumOfDigits(19);
		sumOfDigits(29);
		sumOfDigits(-1);
		sumOfDigits(-11111987);
		sumOfDigits(11111987);
	}
	
	/**
	 * Wrapper Function to perform Input Validation before calling the Recursive Function
	 * @param number
	 */
	public static void sumOfDigits(int number) {
		
		System.out.println("Input(Number): " + number + " Output(Sum): " + findSumOfDigits(number));
	}
	
	/**
	 * Recursive Function written to identify the Sum of digits of a given Number.
	 * @param number
	 * @return sum of all digits of the given number
	 * @time_complexity_O(n)
	 * @space_complexity_O(n)
	 */
	private static int findSumOfDigits(int number) {
		
		if (number < 0) {
			return findSumOfDigits(-1 * number);
		}
		else if (number < 10) {
			return number;
		}
		else {
			return findSumOfDigits((int) number / 10) + number % 10;
		}
	}

}
