package Sudoku;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGUI extends JPanel {
    private static final Integer size = 9;
    private JTextField[][] cells = new JTextField[size][size];

    public InterfaceGUI() {
        setLayout(new BorderLayout());
        initializeBoard();

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkUserInput();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    public void initializeBoard() {
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(size, size));

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setBorder(new LineBorder(Color.BLACK, 1));

                Integer cellValue = SudokuSolver.sudokuBoard[row][col];
                if (cellValue != 0) {
                    cell.setText(cellValue.toString());
                    cell.setEditable(false);
                    cell.setBackground(Color.WHITE);
                } else {
                    cell.setText("");
                    cell.setEditable(true);
                    cell.setBackground(Color.WHITE);
                }

                cell.setDocument(new JTextFieldLimit(1));
                cells[row][col] = cell;
                boardPanel.add(cell);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
    }

    public void checkUserInput() {
        SudokuSolver.copySolvedSudokuBoard();
        Integer[][] solvedCopy = SudokuSolver.solvedSudoku;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String text = cells[row][col].getText();
                Integer userInput = text.isEmpty() ? 0 : Integer.parseInt(text);

                if (!cells[row][col].isEditable()) {
                    continue;
                }

                if (userInput != 0) {
                    if (solvedCopy[row][col].equals(userInput)) {
                        cells[row][col].setBackground(Color.green);
                    } else {
                        cells[row][col].setBackground(Color.red);
                    }
                }
            }
        }
    }

    public void updateInputFromBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Integer value = SudokuSolver.sudokuBoard[row][col];
                if (value != 0) {
                    cells[row][col].setText(value.toString());
                    cells[row][col].setEditable(false);
                    cells[row][col].setBackground(Color.WHITE);
                } else {
                    cells[row][col].setText("");
                    cells[row][col].setEditable(true);
                }
            }
        }
    }
}
