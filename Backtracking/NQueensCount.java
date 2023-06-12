package Backtracking;

public class NQueensCount {
    public static int counter = 0;

    public static void countWays(char[][] board, int row) {
        if (row == board.length) {
            counter++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                countWays(board, row + 1);
                board[row][i] = '.';
            }
        }

    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // Checking on Top

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Checking diagonally left

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Checking diagonally right

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        countWays(board, 0);
        System.out.println("The total number of ways are : " + counter);
    }

}
