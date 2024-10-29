package Sudoku;

import java.util.Scanner;

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

    public static void getUserInput(Scanner scanner) {
        System.out.println("Edit the cells that are empty (0). Enter an integer between 1 and 9, or 0 to leave it empty.");

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudokuBoard[row][col] == 0) {
                    Integer input = -1;
                    while (input < 0 || input > 9) {
                        System.out.printf("Enter value for cell (%d, %d): ", row + 1, col + 1);
                        input = scanner.nextInt();
                        if (input < 0 || input > 9) {
                            System.out.println("Invalid input. Please enter a number between 0 and 9.");
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
        System.out.println("Current Sudoku Board:");
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(sudokuBoard[row][col] + " ");
            }
            System.out.println();
        }
    }
}
