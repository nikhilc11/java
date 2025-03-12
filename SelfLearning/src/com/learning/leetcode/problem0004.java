/**

Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

 

Example 1:


Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
Example 2:


Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1.
*/

package com.learning.leetcode;

public class problem0004 {
	
	public static void main(String[] args) {
		
		int[][] inputArray = {{1,0,0},{0,1,0},{0,0,1}};
		
		System.out.println(numSpecial(inputArray));
	}

	public static int numSpecial(int[][] mat) {
		
		int numberOfSpecialPositions = 0;
		
		int m = mat.length;
		int n = mat[0].length;
		
		int[] sumRows = new int[m];
		int[] sumCols = new int[n];
		
		for (int index = 0; index < m; index++) {
			sumRows[index] = 0;
		}
		
		for (int index = 0; index < n; index++) {
			sumCols[index] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sumRows[i] += mat[i][j];
				sumCols[j] += mat[i][j];
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == sumRows[i] && mat[i][j] == sumCols[j]) {
					numberOfSpecialPositions++;
				}
			}
		}
		
    	return numberOfSpecialPositions;
    	
    }
}
