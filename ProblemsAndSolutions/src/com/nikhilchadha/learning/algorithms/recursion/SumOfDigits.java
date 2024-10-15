package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find the sum of digits of a positive integer number using recursion.
 */
public class SumOfDigits {
	
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
	
	public static void sumOfDigits(int num) {
		
		System.out.println("Input(Number): " + num + " Output(Sum): " + findSumOfDigits(num));
	}
	
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
