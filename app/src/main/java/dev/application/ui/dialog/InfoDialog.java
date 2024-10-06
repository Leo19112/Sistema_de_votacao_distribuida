package dev.application.ui.dialog;

import dev.application.ui.dialog.interfaces.IDialog;

import javax.swing.*;

public class InfoDialog implements IDialog {

    private JDialog dialog;

    public InfoDialog(JDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void showDialog() {
        if (dialog != null && !dialog.isDisplayable()) {
            dialog.setVisible(true);
        }
    }

    @Override
    public void disposeDialog() {
        if (dialog != null) {
            dialog.dispose();
        }
    }
}