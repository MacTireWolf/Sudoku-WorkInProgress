import Sudoku.SudokuSolver;
import java.util.Scanner;

public class ProgrammeInstance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SudokuSolver.printBoard();
        SudokuSolver.getUserInput(scanner);
        System.out.println("Board after user edits:");
        SudokuSolver.printBoard();

        if (SudokuSolver.solveSudoku()) {
            System.out.println("Sudoku solved successfully:");
            SudokuSolver.printBoard();
        } else {
            System.out.println("Sudoku solved unsuccessfully.");
        }
        scanner.close();
    }
}
