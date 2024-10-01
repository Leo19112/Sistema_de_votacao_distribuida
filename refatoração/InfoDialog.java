package projeto1;

import javax.swing.*;

public class InfoDialog {

    private JFrame parentFrame;

    public InfoDialog(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void showDialog() {
        JOptionPane.showMessageDialog(
                parentFrame,
                "Project POO\n Version 1.0\nAuthors: Leonardo Basset, Emily Tomadon, Gabriel Mendes, Pedro Evandro e Lucas Hernandez\n\n" +
                        "This software was developed as part of an academic project for the discipline.",
                "About - Project",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
