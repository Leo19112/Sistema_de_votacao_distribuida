package dev.application.ui.dialog;

import javax.swing.*;

public class DialogManager {
    private JFrame parentFrame;

    public DialogManager(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void showHelpDialog() {
        String dialogText =
                "Welcome to the Project of the Discipline SI400.\n\n" +
                "This project is a Java application with a graphical interface that allows you to:\n" +
                "- Open and view text files\n" +
                "- Modify graphical patterns in the background\n" +
                "- Adjust colors and speeds\n" +
                "- Customize the interface with different configuration options.\n\n" +
                "Use the menus to explore the features.\n" +
                "Thank you for using our application!";

        HelpDialogBuilder builder = new HelpDialogBuilder(parentFrame);
        builder.setTitle("Help")
                .setContent(dialogText)
                .setSize(400, 300);

        HelpDialog helpDialog = (HelpDialog) builder.build();
        helpDialog.showDialog();
    }

    public void showInfoDialog() {
        String dialogText =
                "Project POO\n" +
                "Version 1.0\n" +
                "Authors: Leonardo Basset, Emily Tomadon, Gabriel Mendes, Pedro Evandro e Lucas Hernandez\n\n" +
                "This software was developed as part of an academic project for the discipline.";

        InfoDialogBuilder builder = new InfoDialogBuilder(parentFrame);
        builder.setTitle("Information")
                .setContent(dialogText)
                .setSize(400, 300);

        InfoDialog infoDialog = (InfoDialog) builder.build();
        infoDialog.showDialog();
    }
}