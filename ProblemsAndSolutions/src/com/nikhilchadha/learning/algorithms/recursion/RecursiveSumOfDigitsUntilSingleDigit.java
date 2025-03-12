package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find the sum of digits of a positive integer number using recursion and continue reducing the sum until single digit.
 */
public class RecursiveSumOfDigitsUntilSingleDigit {
	
	/**
	 * Main Function for the Class
	 * @param args
	 */
	public static void main(String[] args) {
		
		recursiveSumOfDigits(0);
		recursiveSumOfDigits(1);
		recursiveSumOfDigits(9);
		recursiveSumOfDigits(10);
		recursiveSumOfDigits(11);
		recursiveSumOfDigits(19);
		recursiveSumOfDigits(29);
		recursiveSumOfDigits(-1);
		recursiveSumOfDigits(-11111987);
		recursiveSumOfDigits(11111987);
	}
	
	/**
	 * Wrapper Function to perform Input Validation before calling the Recursive Function
	 * @param number
	 */
	public static void recursiveSumOfDigits(int number) {
		
		System.out.println("Input(Number): " + number + " Output(TOTAL SUM): " + findSumOfDigits(number) + " Output(REDUCED SUM): " + reduceSumToSingleDigit(number));
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
	
	/**
	 * Recursive Function written to identify the Sum of digits of a given Number recursively until the sum does not reach a single digit.
	 * @param number
	 * @return recursive sum of all digits of the given number into a single digit
	 * @time_complexity_O(NLogN)
	 * @space_complexity_O(NLogN)
	 */
	private static int reduceSumToSingleDigit(int number) {
		
		int sum = findSumOfDigits(number);
		
		if (sum < 10) {
			return sum;
		}
		return reduceSumToSingleDigit(sum);
	}
}
