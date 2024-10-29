package Sudoku;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
    private final Integer limit;

    public JTextFieldLimit(Integer limit){
        super();
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= limit && str.matches("[1-9]?")) {
            super.insertString(offset, str, attr);
        }
    }
}
