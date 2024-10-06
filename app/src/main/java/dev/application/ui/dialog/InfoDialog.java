package dev.application.ui;

import dev.application.ui.interfaces.IDialog;

import javax.swing.*;

public class InfoDialog implements IDialog {

    private JFrame parentFrame;
    private JDialog dialog;

    public InfoDialog(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.dialog = new JDialog(parentFrame, "Info - Project OOP");


    }

    @Override
    public void showDialog() {
        if(this.dialog.isDisplayable()) {
            this.dialog.setLocationRelativeTo(null);
            this.dialog.setVisible(true);
        }
    }

    @Override
    public void disposeDialog() {

    }
}
