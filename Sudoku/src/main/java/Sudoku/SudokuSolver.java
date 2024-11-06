package Sudoku;

public class SudokuSolver {

    public static Integer[][] sudokuBoard = {
            {5, 3, 4, 6, 7, 0, 9, 1, 2},
            {6, 0, 2, 1, 9, 5, 0, 4, 8},
            {1, 9, 8, 0, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 0, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    public static Integer[][] solvedSudoku = new Integer[9][9];

    public static void copySolvedSudokuBoard() {
        solve();
        for (int index = 0; index < 9; index++) {
            System.arraycopy(sudokuBoard[index], 0, solvedSudoku[index], 0, 9);
        }
    }

    public static Boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuBoard[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isValid(row, col, number)) {
                            sudokuBoard[row][col] = number;

                            if (solve()) {
                                return true;
                            }

                            sudokuBoard[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean isValid(Integer row, Integer col, Integer number) {
        for (int index = 0; index < 9; index++) {
            if (sudokuBoard[row][index].equals(number) || sudokuBoard[index][col].equals(number)) {
                return false;
            }
        }

        Integer startingRowForSubGrid = row - (row % 3);
        Integer startingColForSubGrid = col - (col % 3);

        for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
            for (int colIndex = 0; colIndex < 3; colIndex++) {
                if (sudokuBoard[startingRowForSubGrid + rowIndex][startingColForSubGrid + colIndex].equals(number)) {
                    return false;
                }
            }
        }
        return true;
    }
}
