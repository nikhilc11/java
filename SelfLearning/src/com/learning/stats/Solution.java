package com.learning.stats;

import java.util.Arrays;

//Problem Statement
//Given a value of V Rs and an infinite supply of each of the denominations {1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, 
//The task is to find the minimum number of coins and/or notes needed to make the change?

class Solution {
	public static void main(String[] args) {

		int[] denominations = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

		int amount = 1688;

		System.out.println(getTotalCoinCount(denominations, amount));

	}

	public static int getTotalCoinCount(int[] denominations, int amount) {

		int coinCount = 0;

		Arrays.sort(denominations);

		for (int i = denominations.length; i > 0; i--) {
			while (amount >= denominations[i - 1]) {
				coinCount++;
				amount -= denominations[i - 1];
			}
		}

		return coinCount;
	}
}
