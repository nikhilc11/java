package com.learning.leetcode;

import java.util.Arrays;

public class problem0014 {

	public static void main(String[] args) {
//		int[][] input = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
//		int result = matrixScore(input);
//		System.out.println(result);
//		stringFinder();
		System.out.println(factorial(3));
		nQueens(4);
	}
	
	public static void stringFinder() {
		String text = "0123hello9012hello8901hello7890";
		String word = "hello";

		System.out.println(text.indexOf(word)); // prints "4"
		System.out.println(text.lastIndexOf(word)); // prints "22"
	}
	
    public static int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxOnes = n+m;
        int totalOnes = 0;
        int[] rowOnesCount = new int[m];
        int[] colOnesCount = new int[n];
        
        totalOnes = calculateOnes(rowOnesCount, colOnesCount, m, n, grid);

        for (int i=0; i<m; i++) {
            if (totalOnes == maxOnes) break;
            if ((rowOnesCount[i] < n-rowOnesCount[i])) {
                toggleRow(grid, i, n);
                totalOnes = calculateOnes(rowOnesCount, colOnesCount, m, n, grid);
            }
        }
        for (int j=0; j<n; j++) {
            if (totalOnes == maxOnes) break;
            if ((colOnesCount[j] < m-colOnesCount[j])) {
                toggleCol(grid, j, m);
                totalOnes = calculateOnes(rowOnesCount, colOnesCount, m, n, grid);
            }
        }
        // return calculateOnes(rowOnesCount, colOnesCount, m, n, grid);
        return calculateScore(grid, m, n);
    }

    public static int calculateOnes(int[] rowOnesCount, int[] colOnesCount, int m, int n, int[][] grid) {
        int onesCount = 0;
        Arrays.fill(rowOnesCount, 0);
        Arrays.fill(colOnesCount, 0);
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                onesCount += grid[i][j];
                rowOnesCount[i] += grid[i][j];
                colOnesCount[j] += grid[i][j];
            }
        }
        return onesCount;
    }

    public static int calculateScore(int[][] grid, int m, int n) {
        int score = 0;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                score += (grid[i][j]*(2^(j+1)));
            }
        }
        return score;
    }

    public static void toggleRow(int[][] grid, int rowIndex, int colCount) {
        for (int i=0; i<colCount; i++) {
            if (grid[rowIndex][i] == 0) {
                grid[rowIndex][i] = 1;
            }
            else {
                grid[rowIndex][i] = 0;
            }
        }
    }
    public static void toggleCol(int[][] grid, int colIndex, int rowCount) {
        for (int i=0; i<rowCount; i++) {
            if (grid[i][colIndex] == 0) {
                grid[i][colIndex] = 1;
            }
            else {
                grid[i][colIndex] = 0;
            }
        }
    }
    
    public static int factorial(int n) {
    	if (n==0) { 
    		return 1;
    	}
    	else {
    		return n*factorial(n-1);
    	}
    }

    /**
     * N-Queens Problem Solution
     * @param n = Total Rows, Total Columns, Total Number of Queens to be places
     * @return
     */
    
    /*
     * 00 01 02 03 04 05 06 07
     * 10 11 12 13 14 15 16 17
     * 20 21 22 23 24 25 26 27
     * 30 31 32 33 34 35 36 37
     * 40 41 42 43 44 45 46 47
     * 50 51 52 53 54 55 56 57
     * 60 61 62 63 64 65 66 67
     * 70 71 72 73 74 75 76 77
     */

    /*
     * 00 01 02 03
     * 10 11 12 13
     * 20 21 22 23
     * 30 31 32 33
     * 
     * 0 1 2 3
     * 1 2 3 4
     * 2 3 4 5
     * 3 4 5 6
     * 
     * 4 3 2 1
     * 5 4 3 2
     * 6 5 4 3
     * 7 6 5 4
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */

    public static int nQueens(int n) {
    	
    	int [][] board = new int[n][n];
    	
    	for(int i=0; i<n; i++) {
    		Arrays.fill(board[i], 0);
    	}
    	
    	print2dArray(board);
    	
    	int possibleSolutionsCount = 0;
    	
    	
    	
    	return possibleSolutionsCount;
    }
    
    public static int placeAllNQueens(int [][] board, int n, int row, int col) {
    	
    	int queensPlacedCount = 0;
    	
    	while(queensPlacedCount < n) {
    		if (isSafe(board, row, col)) {
    			queensPlacedCount += placeQueen(board, row, col);
    			
    		}
    	}
    	
//    	if () {
//    		
//    	}
    	
    	return 0;
    }
    
    public static void print2dArray(int[][] arr) {
		System.out.println("");
    	for (int i=0; i<arr.length; i++) {
    		System.out.println("");
    		for (int j=0; j<arr[0].length; j++) {
        		System.out.print(arr[i][j] + " ");
    		}
    	}
    }
    
    public static boolean isSafe(int[][] board, int row, int col) {
    	
    	int m = board.length;
    	int n = board[0].length;
    	
    	for (int i=0; i<m; i++) {
        	for (int j=0; j<n; j++) {
        		if (i == row && board[i][j] == 1) return false;
        		if (j == col && board[i][j] == 1) return false;
        		if (row-i == col-j && board[i][j] == 1) return false;
        		if (row-i == j-col && board[i][j] == 1) return false;
        	}
    	}
    	return true;
    }

    public static int placeQueen(int[][] board, int row, int col) {
    	board[row][col] = 1;
    	return 1;
    }




























}

