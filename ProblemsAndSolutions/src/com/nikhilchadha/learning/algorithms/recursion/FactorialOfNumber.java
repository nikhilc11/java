package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find the factorial of a positive integer number using recursion.
 */
public class FactorialOfNumber {
	
	/**
	 * Main Function for the Class
	 * @param args
	 */
	public static void main(String[] args) {
		
		factorialOfNumber(-1);
		factorialOfNumber(0);
		factorialOfNumber(1);
		factorialOfNumber(2);
		factorialOfNumber(3);
		factorialOfNumber(4);
		factorialOfNumber(5);
		factorialOfNumber(6);
		factorialOfNumber(7);
		factorialOfNumber(8);
		factorialOfNumber(9);
		factorialOfNumber(10);
	}
	
	/**
	 * Wrapper Function to perform Input Validation before calling the Recursive Function
	 * @param number
	 */
	public static void factorialOfNumber(int number) {
		if (number < 0) {
			System.out.println("Please provide a Positive Integer for Calculation.");
		}
		else {
			System.out.println(findFactorialOfNumber(number));
		}
	}
	
	/**
	 * Recursive Function written to identify Factorial of a given number
	 * @param number
	 * @return factorial of the provided number
	 * @time_complexity_O(n)
	 * @space_complexity_O(n)
	 */
	private static int findFactorialOfNumber(int number) {
		
		if (number == 0) {
			return 1;
		}
		return findFactorialOfNumber(number-1) * number;
	}

}
