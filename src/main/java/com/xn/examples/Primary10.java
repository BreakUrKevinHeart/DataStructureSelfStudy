package com.xn.examples;

public class Primary10 {

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[10][10];
        int[][] col = new int[10][10];
        int[][] square = new int[10][10];
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                count++;
                if (board[i][j] == '.') {
                    continue;
                }
                row[i][Character.getNumericValue(board[i][j])]++;
                col[j][Character.getNumericValue(board[i][j])]++;
                int k = i / 3 * 3 + j / 3;
                square[k][Character.getNumericValue(board[i][j])]++;
                if (row[i][Character.getNumericValue(board[i][j])] > 1 | col[j][Character.getNumericValue(board[i][j])] > 1
                        | square[k][Character.getNumericValue(board[i][j])] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
