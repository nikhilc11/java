package com.nikhilchadha.learning.algorithms.recursion;

/**
 * @author Nikhil Chadha
 * 
 * Find the power of a number to mentioned positive exponent using recursion.
 */
public class PowerOfNumber {
	
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
	
	public static void powerOfNumber(int num, int pow) {
		if (pow < 0) {
			System.out.println("Pleae provide a positive number in Power.");
		}
		else {
			System.out.println(findPowerOfNumber(num, pow));
		}
	}
	
	private static int findPowerOfNumber(int number, int power) {
		
		if (power == 0) {
			return 1;
		}
		else {
			return findPowerOfNumber(number, power - 1) * number;
		}
	}

}
