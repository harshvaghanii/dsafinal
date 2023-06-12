package Backtracking;

public class NQueensPrint {
    public static void countWaysAndPrint(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                countWaysAndPrint(board, row + 1);
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

    public static void printBoard(char[][] board) {
        for (char[] c : board) {
            for (char ch : c) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        countWaysAndPrint(board, 0);
    }

}
