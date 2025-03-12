/**
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/

package com.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

public class problem0007 {
	
	public static void main(String[] args) {
		
		System.out.println(isAnagram("anagram","nagaram"));
	}

	public static boolean isAnagram(String s, String t) {
		
		char[] sCharArray = new char[s.length()];
		s.getChars(0, s.length(), sCharArray, 0);
		
		char[] tCharArray = new char[t.length()];
		t.getChars(0, t.length(), tCharArray, 0);
		
		Map<Character, Integer> sourceCharactersArray = new HashMap<Character, Integer>();
		
		for (char character : sCharArray) {
			if (!sourceCharactersArray.containsKey(character)) {
				sourceCharactersArray.put(character, 0);
			}
			sourceCharactersArray.put(character, sourceCharactersArray.get(character)+1);
		}
		
		for (char character : tCharArray) {
			if (sourceCharactersArray.containsKey(character) && sourceCharactersArray.get(character) > 1) {
				sourceCharactersArray.put(character, sourceCharactersArray.get(character)-1);
			}
			else if (sourceCharactersArray.containsKey(character) && sourceCharactersArray.get(character) == 1) {
				sourceCharactersArray.remove(character);
			}
			else if (!sourceCharactersArray.containsKey(character)) {
				return false;
			}
		}
		
		if (sourceCharactersArray.size() == 0) {
			return true;
		}
		return false;
    }




	public static boolean isAnagramV1(String s, String t) {
		
		String[] charactersS = s.split("");

		Map<String, Integer> sourceCharactersArray = new HashMap<String, Integer>();
		
		for (String character : charactersS) {
			if (!sourceCharactersArray.containsKey(character)) {
				sourceCharactersArray.put(character, 0);
			}
			sourceCharactersArray.put(character, sourceCharactersArray.get(character)+1);
		}
		
		String[] charactersT = t.split("");
		
		for (String character : charactersT) {
			if (sourceCharactersArray.containsKey(character) && sourceCharactersArray.get(character) > 1) {
				sourceCharactersArray.put(character, sourceCharactersArray.get(character)-1);
			}
			else if (sourceCharactersArray.containsKey(character) && sourceCharactersArray.get(character) == 1) {
				sourceCharactersArray.remove(character);
			}
			else if (!sourceCharactersArray.containsKey(character)) {
				return false;
			}
		}
		
		if (sourceCharactersArray.size() == 0) {
			return true;
		}
		return false;
    }
}
