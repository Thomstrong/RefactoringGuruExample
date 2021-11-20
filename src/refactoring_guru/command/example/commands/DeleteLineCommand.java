package refactoring_guru.command.example.commands;

import refactoring_guru.command.example.editor.Editor;

import javax.swing.*;
import javax.swing.text.BadLocationException;

public class DeleteLineCommand extends Command {
    public DeleteLineCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        this.backup();
        JTextArea textField = editor.textField;
        int currentOffset = textField.getCaretPosition();
        try {
            int currentLine = textField.getLineOfOffset(currentOffset);
            int lineEndOffset = textField.getLineEndOffset(currentLine);
            if (lineEndOffset == 0) {
                // no text in text field
                return true;
            }
            int lineStartOffset = textField.getLineStartOffset(currentLine);
            textField.replaceRange("", lineStartOffset, lineEndOffset);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return true;
    }
}
