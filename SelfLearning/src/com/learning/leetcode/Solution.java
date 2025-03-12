package com.learning.leetcode;
//Problem Statement

//You are given a 2-D matrix surface of size n*m. Each cell of the surface is either 1 (land) or 0 (water).
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//Assume all four edges of the surface are all surrounded by water.

//1. Find the number of islands on the surface.
//2. Find the smallest island's size on the surface.
//3. Find the largest island's size on the surface.

class Solution {
	public static void main(String[] args) {

		int[][] matrix = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 1, 0 } };

		System.out.println("Number of islands is: " + countIslands(matrix));
		System.out.println("Smallest Island Size: " + smallestIslandSize(matrix));
		System.out.println("Largest Island Size: " + largestIslandSize(matrix));
	}

	// Create Initiating Function
	public static int smallestIslandSize(int[][] matrix) {

		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int cols = matrix[0].length;

		// Create Visited Matrix
		boolean[][] visited = new boolean[rows][cols];

		// Create Counter
		int currentArea = 999999;

		// Loop all Values in Matrix for execution
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {

				// Validate Logic for Proceeding (If Any)
				if (matrix[i][j] == 1 && !visited[i][j]) {

					// Call for Graph Next Node Validation with Recursion
					int area = getArea(rows, cols, matrix, i, j, visited);
					// Increment Counter
					if (currentArea > area)
						currentArea = area;
				}
			}
		}
		return currentArea;
	}

	// Create Initiating Function
	public static int largestIslandSize(int[][] matrix) {

		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int cols = matrix[0].length;

		// Create Visited Matrix
		boolean[][] visited = new boolean[rows][cols];

		// Create Counter
		int currentArea = 0;

		// Loop all Values in Matrix/Array for execution
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				// Validate Logic for Proceeding (If Any)
				if (matrix[i][j] == 1 && !visited[i][j]) {
					// Call for Graph Next Node Validation with Recursion
					int area = getArea(rows, cols, matrix, i, j, visited);
					// Increment Counter
					if (currentArea < area)
						currentArea = area;
				}
			}
		}
		return currentArea;
	}

	// Function with Recursion for calculation
	public static int getArea(int rows, int cols, int[][] matrix, int row, int col, boolean[][] visited) {

		// Update Visited
		visited[row][col] = true;
		int area = 1;

		// Define Sub Search group
		int[][] searchGroup = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		// Iterate Search Group
		for (int[] set : searchGroup) {
			// Validate Logic for Proceeding (If Any) and Position not visited
			if (withinMatrixBoundaryAndNotVisited(rows, cols, matrix, row - set[0], col - set[1], visited)) {
				// Make Recusive Call for Graph Next Node Validation with Recursion
				// Increment Counter
				area += getArea(rows, cols, matrix, row - set[0], col - set[1], visited);
			}
		}
		return area;
	}

	// Create Initiating Function
	public static int countIslands(int[][] matrix) {

		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int cols = matrix[0].length;

		// Create Visited Matrix
		boolean[][] visited = new boolean[rows][cols];

		// Create Counter
		int count = 0;

		// Loop all Values in Matrix/Array for execution
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				// Validate Logic for Proceeding (If Any)
				if (matrix[i][j] == 1 && !visited[i][j]) {
					// Call for Graph Next Node Validation with Recursion
					markVisited(rows, cols, matrix, i, j, visited);
					// Increment Counter
					count++;
				}
			}
		}
		return count;
	}

	// Function with Recursion for calculation
	public static void markVisited(int rows, int cols, int matrix[][], int row, int col, boolean visited[][]) {
		// Update Visited
		visited[row][col] = true;

		// Define Sub Search group
		int[][] searchGroup = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		// Iterate Search Group
		for (int[] set : searchGroup) {
			// Validate Logic for Proceeding (If Any) and Position not visited
			if (withinMatrixBoundaryAndNotVisited(rows, cols, matrix, row - set[0], col - set[1], visited))
				// Make Recusive Call for Graph Next Node Validation with Recursion
				markVisited(rows, cols, matrix, row - set[0], col - set[1], visited);
		}
	}

	// Function to Validate Logic for Proceeding (If Any) and Position not visited
	public static boolean withinMatrixBoundaryAndNotVisited(int rows, int cols, int[][] matrix, int row, int col,
			boolean[][] visited) {
		return (row >= 0) && (row < rows) && (col >= 0) && (col < cols) && (matrix[row][col] == 1)
				&& (!visited[row][col]);
	}
}
