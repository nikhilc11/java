/**
*/

package com.learning.leetcode;

public class problem0010 {

	public static void main(String[] args) {

		System.out.println(reversePrefix("nikhilchadha",'h'));
	}

    public static String reversePrefix(String word, char ch) {
        
        if (!word.contains(Character.toString(ch))) return word;

        StringBuffer result = new StringBuffer("");
        
        int splitIndex = word.indexOf(ch)+1;
        
        for (int index = splitIndex-1; index >= 0; index-- ) {
        	result.append(word.charAt(index));
        }
        
        result.append(word.substring(splitIndex, word.length()));
        
        return result.toString();

    }




    public static String reversePrefixV1(String word, char ch) {
        
        if (!word.contains(Character.toString(ch))) return word;

        StringBuffer result = new StringBuffer("");
        
        int splitIndex = word.indexOf(ch)+1;
        
        char[] stringToBeReversed = new char[splitIndex];
        
        word.getChars(0, splitIndex, stringToBeReversed, 0);
        
        for (int index = splitIndex-1; index >= 0; index-- ) {
        	result.append(stringToBeReversed[index]);
        }
        
        result.append(word.substring(splitIndex, word.length()));
        
        return result.toString();

    }
}