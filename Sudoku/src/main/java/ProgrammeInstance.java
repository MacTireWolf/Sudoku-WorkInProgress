import Sudoku.InterfaceGUI;
import Sudoku.SudokuSolver;

import javax.swing.*;
import java.awt.*;

public class ProgrammeInstance {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InterfaceGUI sudokuPanel = new InterfaceGUI();
        frame.setLayout(new BorderLayout());
        frame.add(sudokuPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        sudokuPanel.updateInputFromBoard();
    }
}
