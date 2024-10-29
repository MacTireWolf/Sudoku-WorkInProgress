package Sudoku;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class InterfaceGUI extends JPanel {
    private static final Integer size = 9;
    private static final Integer cellSize = 50;
    private static final Integer boardSize = cellSize * size;
    private JTextField[][] cells = new JTextField[size][size];

    public InterfaceGUI() {
        setLayout(new GridLayout(size, size));
        initializeBoard();
    }

    public void initializeBoard() {
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
                add(cell);
            }
        }
    }

    public Boolean updateBoardFromInput() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String text = cells[row][col].getText();
                if (text.isEmpty()) {
                    SudokuSolver.sudokuBoard[row][col] = 0;
                } else {
                    Integer value = Integer.parseInt(text);
                    if(value < 1 || value > 9){
                        return false;
                    }
                    SudokuSolver.sudokuBoard[row][col] = value;
                }
            }
        }
        return true;
    }

    public void updateInputFromBoard(){
        for (int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                Integer value = SudokuSolver.sudokuBoard[row][col];
                if(value != 0){
                    cells[row][col].setText(value.toString());
                    cells[row][col].setEditable(false);
                    cells[row][col].setBackground(Color.WHITE);
                } else{
                    cells[row][col].setText("");
                    cells[row][col].setEditable(true);
                }
            }
        }
    }

}
