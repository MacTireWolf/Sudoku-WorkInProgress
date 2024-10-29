import Sudoku.SudokuSolver;

import static Sudoku.SudokuSolver.printBoard;
import static Sudoku.SudokuSolver.solveSudoku;

public class ProgrammeInstance {
    SudokuSolver sudokuSolver = new SudokuSolver();

    public static void main(String[] args) {
        if (solveSudoku()) {
            System.out.println("Sudoku solved successfully:");
            printBoard();
        } else {
            System.out.println("No solution exists for the given Sudoku puzzle.");
        }
    }
}
