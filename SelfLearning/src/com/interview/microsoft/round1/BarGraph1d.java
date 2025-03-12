package com.interview.microsoft.round1;

public class BarGraph1d {

	public static void main(String[] args) {

		// Initializations
		int[] integerArray = new int[] {1,3,5,0,1,1};
		int maxValue = 0;
		
		// First Iteration of the input array
		for (int integerValue : integerArray) {
			
			if (maxValue < integerValue) {
				maxValue = integerValue;
			}
		}
		
		// Printing the Resultant Array
		for (int printValue = maxValue; printValue > 0; printValue--) {
			
			System.out.println("");
			
			for (int integerValue : integerArray) {
				
				if(integerValue > 0 && printValue > integerValue) {
					
					System.out.print("  ");
				}
				else if (integerValue > 0 && printValue <= integerValue) {
					System.out.print(" *");
				}
			
				else if (printValue == 1 && integerValue == 0) {
					System.out.print(" -");
				}
			}
		}
	}
}
