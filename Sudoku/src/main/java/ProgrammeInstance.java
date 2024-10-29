import Sudoku.SudokuSolver;

import java.util.Scanner;

public class ProgrammeInstance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SudokuSolver.printBoard();
        SudokuSolver.getUserInput(scanner);

        if (SudokuSolver.solveSudoku()) {
            System.out.println("Sudoku solved successfully:");
            SudokuSolver.printBoard();
        }
        scanner.close();
    }
}
