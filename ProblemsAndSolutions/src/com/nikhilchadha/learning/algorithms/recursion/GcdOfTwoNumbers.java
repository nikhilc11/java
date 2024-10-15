package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find the GCD (Greatest Common Divisor) of Two Numbers using recursion.
 */
public class GcdOfTwoNumbers {
	
	public static void main(String[] args) {
		
		gcdOfTwoNumbers(3,-10);
		gcdOfTwoNumbers(0,10);
		gcdOfTwoNumbers(1,2);
		gcdOfTwoNumbers(2,1);
		gcdOfTwoNumbers(10,2);
		gcdOfTwoNumbers(10,200);
		gcdOfTwoNumbers(120,200);
	}
	
	public static void gcdOfTwoNumbers(int num1, int num2) {
		
		if (num1 <= 0 || num2 <= 0) {
			System.out.println("Please enter Two Positive Non Zero Numbers.");
		}
		else if (num1 > num2) {
			System.out.println("Input_Number_1: " + num1 + " Input_Number_2: " + num2 + " Output_GCD: " + findGcdOfTwoNumbers(num1, num2));
		}
		else {
			System.out.println("Input_Number_1: " + num1 + " Input_Number_2: " + num2 + " Output_GCD: " + findGcdOfTwoNumbers(num2, num1));
		}
		
	}
	
	private static int findGcdOfTwoNumbers(int number1, int number2) {
		
		int remainder = number1 % number2;
		if (remainder == 0) {
			return number2;
		}
		return findGcdOfTwoNumbers(number2, remainder);
	}

}
