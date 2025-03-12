package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find the power of a number to mentioned positive exponent using recursion.
 */
public class PowerOfNumber {
	
	/**
	 * Main Function for the Class
	 * @param args
	 */
	public static void main(String[] args) {
		
		powerOfNumber(2,-1);
		powerOfNumber(2,0);
		powerOfNumber(2,1);
		powerOfNumber(2,2);
		powerOfNumber(2,3);
		powerOfNumber(2,4);
		powerOfNumber(2,5);
		powerOfNumber(2,6);
		powerOfNumber(2,7);
		powerOfNumber(2,8);
		powerOfNumber(2,9);
		powerOfNumber(2,10);
	}
	
	/**
	 * Wrapper Function to perform Input Validation before calling the Recursive Function
	 * @param number
	 * @param power
	 */
	public static void powerOfNumber(int number, int power) {
		if (power < 0) {
			System.out.println("Pleae provide a positive number in Power.");
		}
		else {
			System.out.println(findPowerOfNumber(number, power));
		}
	}
	
	/**
	 * Recursive Function written to identify the Result of Number 1 to the power of Number 2
	 * @param number
	 * @param power
	 * @return number ^ power
	 * @time_complexity_O(n)
	 * @space_complexity_O(n)
	 */
	private static int findPowerOfNumber(int number, int power) {
		
		if (power == 0) {
			return 1;
		}
		else {
			return findPowerOfNumber(number, power - 1) * number;
		}
	}

}
