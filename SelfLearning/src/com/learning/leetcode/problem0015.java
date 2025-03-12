/**
*/

package com.learning.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class problem0015 {

	public static void main(String[] args) {
		int[] set = {1,2,3};
		ArrayList<HashSet<Integer>> listOfSubsets = subsetsOfGivenSet(set);
		System.out.print("{");
		for (HashSet<Integer> subset : listOfSubsets) {
			System.out.print("{");
			if (!subset.isEmpty()) {
				for (Integer integer : subset) {
					System.out.print(integer.toString() + ",");
				}
			}
			System.out.print("},");
		}
		System.out.print("}");
	}
	
	public static ArrayList<HashSet<Integer>> subsetsOfGivenSet(int[] set) {
		
		int setSize = set.length;
		
		int totalPossibleSubsets = (int) Math.pow(2, setSize);
		
		ArrayList<HashSet<Integer>> listOfSubsets = new ArrayList<>();
		
		for (int i=0; i<totalPossibleSubsets; i++ ) {
			String binaryIndex = Integer.toBinaryString(i);
			System.out.println(i + " -> " + binaryIndex);
			HashSet<Integer> subSet = new HashSet<>();
			for (int j=0; j<binaryIndex.length(); j++) {
				if (binaryIndex.charAt(binaryIndex.length()-1-j) == '1') {
					subSet.add(set[setSize-1-j]);
				} 
			}
			listOfSubsets.add(subSet);
		}
		return listOfSubsets;
	}
}
