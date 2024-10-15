package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find the sum of digits of a positive integer number using recursion and continue reducing the sum until single digit.
 */
public class RecursiveSumOfDigitsUntilSingleDigit {
	
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
	
	public static void recursiveSumOfDigits(int num) {
		
		System.out.println("Input(Number): " + num + " Output(TOTAL SUM): " + findSumOfDigits(num) + " Output(REDUCED SUM): " + reduceSumToSingleDigit(num));
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
	
	private static int reduceSumToSingleDigit(int number) {
		
		int sum = findSumOfDigits(number);
		
		if (sum < 10) {
			return sum;
		}
		return reduceSumToSingleDigit(sum);
	}

}
