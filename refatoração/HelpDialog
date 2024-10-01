package projeto1;

import javax.swing.*;
import java.awt.*;

public class HelpDialog {

    private JDialog helpDialog;

    public HelpDialog(JFrame parentFrame) {
        helpDialog = new JDialog(parentFrame, "Help - Project POO", true);
        helpDialog.setSize(400, 300);
        helpDialog.setLayout(new BorderLayout());

        JTextArea helpText = new JTextArea();
        helpText.setText("Welcome to the Project of the Discipline SI400.\n\n" +
                "This project is a Java application with a graphical interface that allows you to:\n" +
                "- Open and view text files\n" +
                "- Modify graphical patterns in the background\n" +
                "- Adjust colors and speeds\n" +
                "- Customize the interface with different configuration options.\n\n" +
                "Use the menus to explore the features.\n" +
                "Thank you for using our application!");
        helpText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(helpText);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\leona\\Downloads\\Logotipo_UNICAMP.jpg");
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(imageIcon);

        JPanel buttonPanel = new JPanel();
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> helpDialog.dispose());
        buttonPanel.add(closeButton);

        helpDialog.add(imageLabel, BorderLayout.NORTH);
        helpDialog.add(scrollPane, BorderLayout.CENTER);
        helpDialog.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void showDialog() {
        helpDialog.setLocationRelativeTo(null);
        helpDialog.setVisible(true);
    }
}
