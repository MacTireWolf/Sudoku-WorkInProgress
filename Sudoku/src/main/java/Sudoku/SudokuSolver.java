package Sudoku;

import java.util.Scanner;

public class SudokuSolver {

    private static Integer[][] sudokuBoard = {
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

    public static void getUserInput(Scanner scanner) {
        System.out.println("Edit the cells that are empty (0). Enter an integer between 1 and 9, or 0 to leave it empty.");

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuBoard[row][col] == 0) {
                    Integer input = -1;
                    while (true) {
                        System.out.printf("Enter value for cell (%d, %d): ", row + 1, col + 1);
                        input = scanner.nextInt();
                        if (input < 0 || input > 9) {
                            System.out.println("Invalid input. Please enter a number between 0 and 9.");
                        } else if (input != 0 && !isValid(row, col, input)) {
                            System.out.println("Invalid move. The number " + input + " cannot be placed in cell (" + (row + 1) + ", " + (col + 1) + "). Please try again.");
                        } else {
                            sudokuBoard[row][col] = input;
                            break;
                        }
                    }
                }
            }
        }
    }

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
