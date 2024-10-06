package dev.application.ui.dialog;

import dev.application.ui.dialog.interfaces.IDialog;

import javax.swing.*;
import java.awt.*;

public class HelpDialogBuilder extends DialogBuilder {

    public HelpDialogBuilder(JFrame parentFrame) {
        super(parentFrame);
    }

    @Override
    public IDialog build() {
        // Criação do JDialog
        JDialog dialog = new JDialog(parentFrame, this.title, true);
        dialog.setSize(this.width, this.height);
        dialog.setLocationRelativeTo(parentFrame);

        dialog.setLayout(new BorderLayout());

        // Criação do conteúdo do dialog
        JTextArea helpText = new JTextArea();
        helpText.setText(this.content);
        helpText.setEditable(false);
        JScrollPane helpTextScrollPane = new JScrollPane(helpText);

        JPanel buttonPanel = new JPanel();
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.dispose());
        buttonPanel.add(closeButton);

        dialog.add(helpTextScrollPane, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Retorna uma nova instância de HelpDialog passando o JDialog
        return new HelpDialog(dialog);
    }
}
