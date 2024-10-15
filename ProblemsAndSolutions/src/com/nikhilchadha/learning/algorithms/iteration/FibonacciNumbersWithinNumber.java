package com.nikhilchadha.learning.algorithms.iteration;

/**
 * @author Nikhil Chadha
 * 
 * Find all Fibonacci numbers within a positive integer.
 */
public class FibonacciNumbersWithinNumber {
	
	public static void main(String[] args) {

		fibonacciNumbersWithinNumber(-1);
		fibonacciNumbersWithinNumber(0);
		fibonacciNumbersWithinNumber(1);
		fibonacciNumbersWithinNumber(2);
		fibonacciNumbersWithinNumber(3);
		fibonacciNumbersWithinNumber(4);
		fibonacciNumbersWithinNumber(5);
		fibonacciNumbersWithinNumber(6);
		fibonacciNumbersWithinNumber(7);
		fibonacciNumbersWithinNumber(8);
		fibonacciNumbersWithinNumber(9);
		fibonacciNumbersWithinNumber(10);
		fibonacciNumbersWithinNumber(20);
		fibonacciNumbersWithinNumber(30);
		fibonacciNumbersWithinNumber(40);
		fibonacciNumbersWithinNumber(50);
		fibonacciNumbersWithinNumber(60);
		fibonacciNumbersWithinNumber(70);
		fibonacciNumbersWithinNumber(80);
		fibonacciNumbersWithinNumber(90);
		fibonacciNumbersWithinNumber(100);
		fibonacciNumbersWithinNumber(200);
		fibonacciNumbersWithinNumber(300);
		fibonacciNumbersWithinNumber(400);
		fibonacciNumbersWithinNumber(500);
		fibonacciNumbersWithinNumber(600);
		fibonacciNumbersWithinNumber(700);
		fibonacciNumbersWithinNumber(800);
		fibonacciNumbersWithinNumber(900);
		fibonacciNumbersWithinNumber(1000);
		fibonacciNumbersWithinNumber(2000);
		fibonacciNumbersWithinNumber(3000);
		fibonacciNumbersWithinNumber(4000);
		fibonacciNumbersWithinNumber(5000);
		fibonacciNumbersWithinNumber(6000);
		fibonacciNumbersWithinNumber(7000);
		fibonacciNumbersWithinNumber(8000);
		fibonacciNumbersWithinNumber(9000);
		fibonacciNumbersWithinNumber(10000);
		fibonacciNumbersWithinNumber(20000);
		fibonacciNumbersWithinNumber(30000);
		fibonacciNumbersWithinNumber(40000);
		fibonacciNumbersWithinNumber(50000);
		fibonacciNumbersWithinNumber(60000);
		fibonacciNumbersWithinNumber(70000);
		fibonacciNumbersWithinNumber(80000);
		fibonacciNumbersWithinNumber(90000);
		fibonacciNumbersWithinNumber(100000);
		fibonacciNumbersWithinNumber(200000);
		fibonacciNumbersWithinNumber(300000);
		fibonacciNumbersWithinNumber(400000);
		fibonacciNumbersWithinNumber(500000);
		fibonacciNumbersWithinNumber(600000);
		fibonacciNumbersWithinNumber(700000);
		fibonacciNumbersWithinNumber(800000);
		fibonacciNumbersWithinNumber(900000);
		fibonacciNumbersWithinNumber(1000000);
	}

	public static void fibonacciNumbersWithinNumber(int num) {
		if (num <= 0) {
			System.out.println("Please provide a Positive Integer for Series Generation.");
		}
		else {
			System.out.println("\nInput: "+ num);
			findfibonacciNumbersWithinNumber(num);
		}
	}
	
	private static void findfibonacciNumbersWithinNumber(int number) {
		
		int num1 = 0;
		int num2 = 1;
		System.out.print(num1 + " " + num2 + " ");

		while (num1 + num2 <= number) {
			int num3 = num1 + num2;
			System.out.print(num3 + " ");
			num1 = num2;
			num2 = num3;
		}
	}
}
