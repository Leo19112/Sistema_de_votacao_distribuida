package projeto1;

import javax.swing.*;
import java.io.*;

public class FileOperations {

    private JFrame parentFrame;

    public FileOperations(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void openFile(JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(parentFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.read(reader, null);
                reader.close();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(parentFrame, "File not found: " + file.getName());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(parentFrame, "Error reading file: " + e.getMessage());
            }
        }
    }
}
