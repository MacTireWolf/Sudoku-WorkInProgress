package Sudoku;

public class SudokuSolver {

    private static Integer[][] sudokuBoard = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public static Boolean solveSudoku() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuBoard[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isValid(row, col, number)) {
                            sudokuBoard[row][col] = number;

                            if (solveSudoku()) {
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

    public static void printBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(sudokuBoard[row][col] + " ");
            }
            System.out.println();
        }
    }
}
