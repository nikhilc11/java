package com.nikhilchadha.learning.algorithms.recursion;

import java.util.Arrays;

/**
 * @author Nikhil Chadha
 * 
 * Find first N Fibonacci numbers using recursion.
 */
public class FibonacciNumbersFirstN {
	
	/**
	 * Main Function for the Class
	 * @param args
	 */
	public static void main(String[] args) {
		
		fibonacciNumbersFirstN(-1);
		fibonacciNumbersFirstN(0);
		fibonacciNumbersFirstN(1);
		fibonacciNumbersFirstN(2);
		fibonacciNumbersFirstN(3);
		fibonacciNumbersFirstN(4);
		fibonacciNumbersFirstN(5);
		fibonacciNumbersFirstN(6);
		fibonacciNumbersFirstN(7);
		fibonacciNumbersFirstN(8);
		fibonacciNumbersFirstN(9);
		fibonacciNumbersFirstN(10);
		fibonacciNumbersFirstN(20);
		fibonacciNumbersFirstN(47);
	}

	/**
	 * Wrapper Function to perform Input Validation before calling the Recursive Function
	 * @param number
	 */
	public static void fibonacciNumbersFirstN(int number) {
		if (number <= 0) {
			System.out.println("Please provide a Positive Integer for Series Generation.");
		}
		else {
			int[] arr = new int[number];
			System.out.println("\nFibonacci Series upto " + number + " positions.");
			findFibonacciNumbersFirstN(number, arr);
			System.out.println(Arrays.toString(arr));
		}
//		else {
//			System.out.println("\nInput Number: "+ number +":");
//			findFibonacciNumber(number-1);
//		}
	}
	
	/**
	 * Function to calculate the Fibonacci Series in Order
	 * @param number
	 * @param seriesArray
	 * @return true
	 * @time_complexity_O(n)
	 * @space_complexity_O(n)
	 */
	private static void findFibonacciNumbersFirstN(int number, int[] seriesArray) {
		
		if (number == 1) {
			seriesArray[0] = 0;
			return;
		}
		else if (number == 2) {
			findFibonacciNumbersFirstN(1, seriesArray);
			seriesArray[1] = 1;
			return;
		}
		else {
			findFibonacciNumbersFirstN(number-1, seriesArray);
			seriesArray[number-1] = seriesArray[number -2] + seriesArray[number -3];
			return;
		}
	}

	/**
	 * @deprecated
	 * Function to find the Fibonacci Series Number in the provided position
	 * @param position
	 * @return Fibonacci Series Number at Position
	 * @time_complexity_O(2^n)
	 * @space_complexity_O(n)
	 */
	private static int findFibonacciNumber(int position) {
		
		if (position <= 1) {
			return position;
		}
		int fibonacciNumber = findFibonacciNumber(position-2) + findFibonacciNumber(position-1);
		System.out.print(fibonacciNumber + " ");
		return fibonacciNumber;
	}
}
