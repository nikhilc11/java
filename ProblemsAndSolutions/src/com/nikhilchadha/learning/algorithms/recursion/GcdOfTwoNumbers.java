package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find the GCD (Greatest Common Divisor) of Two Numbers using recursion.
 */
public class GcdOfTwoNumbers {
	
	/**
	 * Main Function for the Class
	 * @param args
	 */
	public static void main(String[] args) {
		
		gcdOfTwoNumbers(3,-10);
		gcdOfTwoNumbers(0,10);
		gcdOfTwoNumbers(1,2);
		gcdOfTwoNumbers(2,1);
		gcdOfTwoNumbers(10,2);
		gcdOfTwoNumbers(10,200);
		gcdOfTwoNumbers(120,200);
	}
	
	/**
	 * Wrapper Function to perform Input Validation and Input Selection before calling the Recursive Function
	 * @param number1
	 * @param number2
	 */
	public static void gcdOfTwoNumbers(int number1, int number2) {
		
		if (number1 <= 0 || number2 <= 0) {
			System.out.println("Please enter Two Positive Non Zero Numbers.");
		}
		else if (number1 > number2) {
			System.out.println("Input_Number_1: " + number1 + " Input_Number_2: " + number2 + " Output_GCD: " + findGcdOfTwoNumbers(number1, number2));
		}
		else {
			System.out.println("Input_Number_1: " + number1 + " Input_Number_2: " + number2 + " Output_GCD: " + findGcdOfTwoNumbers(number2, number1));
		}
		
	}
	
	/**
	 * Recursive Function written to identify the GCD of given two number
	 * @param number1
	 * @param number2
	 * @return GCD of the provided numbers
	 * @time_complexity_O(logN)
	 * @space_complexity_O(logN)
	 */
	private static int findGcdOfTwoNumbers(int number1, int number2) {
		
		int remainder = number1 % number2;
		if (remainder == 0) {
			return number2;
		}
		return findGcdOfTwoNumbers(number2, remainder);
	}

}
