package dev.application.ui.dialog;

import dev.application.ui.dialog.interfaces.IDialog;

import javax.swing.*;
import java.awt.*;

public class InfoDialogBuilder extends DialogBuilder {

    public InfoDialogBuilder(JFrame parentFrame) {
        super(parentFrame);
    }

    @Override
    public IDialog build() {
        // Criação do JDialog
        JDialog dialog = new JDialog(parentFrame, title, true);
        dialog.setSize(width, height);
        dialog.setLocationRelativeTo(parentFrame);

        dialog.setLayout(new BorderLayout());

        JTextArea infoText = new JTextArea();
        infoText.setText(this.content);
        infoText.setEditable(false);

        JScrollPane infoTextScrollPane = new JScrollPane(infoText);


        JPanel buttonPanel = new JPanel();
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.dispose());
        buttonPanel.add(closeButton);

        dialog.add(infoTextScrollPane, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        // Retorna uma nova instância de InfoDialog passando o JDialog
        return new InfoDialog(dialog);
    }
}