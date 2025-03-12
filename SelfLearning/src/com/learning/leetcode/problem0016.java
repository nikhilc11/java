/**
*/

package com.learning.leetcode;

public class problem0016 {

	public static void main(String[] args) {
		int[][] boxSet = {{4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32}};
		stackBoxes(boxSet);
	}
	
	public static void stackBoxes(int[][] boxSet) {
		
	}
}



//Algorithm complexity - "Great answer, can we do better?" is something every good interviewer will ask - even if you can't actually do better than your solution. You need to be able to analyze your solutions with Big-Oh notation for both space and time complexity. Your hashtable get() method is of constant time? Great, why? Your divide and conqour algorithm is O(log(n))? Can you explain why?

//Sorting - Know the main sorting algorithms, their complexity, implementations, and when to use them. Almost every company I've ever interviewed at has asked some question that at it's heart is a derivative of a sorting algorithm.

//Hash Tables - From my brief career so far I've come to the conclusion that much of what Software Engineers do at Internet companies is a glorified hashtable. It's a core concept and you should know how to at least do a nieve implementation.

//Trees - I had a candidate ask me once, "Do you really use trees regularly at work?" YES! They're everywhere! I worked on a the payments team for a few years where the main thing we did was process orders which are modeled as trees and traverse them in pre/post order for fulfillment. Know how to implement a binary tree, an n-ary tree, and how to implement algorithms to traverse, add to, and delete from them. It's amazing how many problems can be modeled as a tree traversal. Definitely know when recursion is and isn’t appropriate.

//Graphs - Tree's are really just a special case of a graph, but be sure to know your graph algorithms as well. Know at least one algorithm for finding the shortest path on different types of graphs.
