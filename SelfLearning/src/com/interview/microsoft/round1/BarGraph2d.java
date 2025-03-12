package com.interview.microsoft.round1;

public class BarGraph2d {

	public static void main(String[] args) {

		// Initializations
		int[] integerArray = new int[] {1,3,5,0,1,1};
		
		char[][] charMatrix = new char[integerArray.length][];
		
		int maxValue = 0;
		
		// First Iteration of the input array
		for (int index = 0; index < integerArray.length; index++) {
			
			if (maxValue < integerArray[index]) {
				
				maxValue = integerArray[index];
			}
			
			if (integerArray[index] > 0)  {
				
				charMatrix[index] = new char[integerArray[index]];
				
				for (int index2 = 0 ; index2 < integerArray[index]; index2++) {
					charMatrix[index][index2] = '*';
				}
			}
			else {
				
				charMatrix[index] = new char[1];
				charMatrix[index][0] = '-';
			}
		}
		
		// Printing the Resultant Array
		
		for (int printValue = maxValue; printValue > 0; printValue--) {
			
			System.out.println("");
			
			for (char[] firstLevelArray : charMatrix) {
				
				if(printValue > firstLevelArray.length) {
					
					System.out.print("  ");
				}
				else {
					System.out.print(" " + firstLevelArray[printValue-1]);
				}
			}
		}
	}
}
