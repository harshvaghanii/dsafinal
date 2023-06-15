package Backtracking;

public class SudokuSolver {

    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {

        // Base Case
        if (row == 9)
            return true;

        // Calculating the next row and columns

        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow++;
            nextCol = 0;
        }

        // Going to the next recursive work if the value is not Zero

        if (sudoku[row][col] != 0)
            return sudokuSolver(sudoku, nextRow, nextCol);

        // Recursive Work

        for (int i = 1; i <= 9; i++) {
            if (isSafe(sudoku, row, col, i)) {
                sudoku[row][col] = i;
                if (sudokuSolver(sudoku, nextRow, nextCol))
                    return true;
                sudoku[row][col] = 0;
            }
        }

        return false;

    }

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {

        // Checking in the row

        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit)
                return false;
        }

        // Checking in the column

        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit)
                return false;
        }

        // Checking in the 3x3 Grid

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        int endRow = startRow + 3;
        int endCol = startCol + 3;

        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (sudoku[i][j] == digit)
                    return false;
            }
        }

        return true;

    }

    public static void print(int[][] sudoku) {
        for (int[] arr : sudoku) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };
        if (sudokuSolver(sudoku, 0, 0)) {
            print(sudoku);
        } else {
            System.out.println("The solution does not exist");
        }
    }
}
