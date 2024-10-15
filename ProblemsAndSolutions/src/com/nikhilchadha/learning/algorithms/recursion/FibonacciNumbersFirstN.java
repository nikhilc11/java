package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find first N Fibonacci numbers using recursion.
 */
public class FibonacciNumbersFirstN {
	
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

	public static void fibonacciNumbersFirstN(int num) {
		if (num <= 0) {
			System.out.println("Please provide a Positive Integer for Series Generation.");
		}
		else {
			int[] arr = new int[num];
			System.out.println("\n"+findFibonacciNumbersFirstN(num, arr));
			printArray(arr);
		}
	}
	
	private static boolean findFibonacciNumbersFirstN(int number, int[] seriesArray) {
		
		if (number == 1) {
			seriesArray[0] = 0;
			return false;
		}
		else if (number == 2) {
			findFibonacciNumbersFirstN(1, seriesArray);
			seriesArray[1] = 1;
			return true;
		}
		else {
			findFibonacciNumbersFirstN(number-1, seriesArray);
			seriesArray[number-1] = seriesArray[number -2] + seriesArray[number -3];
			return true;
		}
	}

	private static void printArray(int[] array) {
		for (int element : array) {
			System.out.print(element + " ");
		}
	}
}
