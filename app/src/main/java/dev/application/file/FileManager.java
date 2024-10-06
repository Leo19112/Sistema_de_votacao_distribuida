package dev.application.file;

import dev.application.file.interfaces.IFileHandler;
import dev.application.file.interfaces.ITextFileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

public class FileManager {
    private JFrame parentFrame;
    private IFileHandler fileHandler;

    public FileManager(JFrame parentFrame, IFileHandler fileHandler) {
        this.parentFrame = parentFrame;
        this.fileHandler = fileHandler;
    }

    public void setFilePanel(IFileHandler filePanel) {
        this.fileHandler = filePanel;
    }

    private void setPanelFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(parentFrame);

        if(option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            this.fileHandler.loadFile(file);
        }
    }

    public void readFile(JTextArea outputTextArea) {
        setPanelFile();
        if(this.fileHandler.isSettedFile()) {
            try {
                if(fileHandler instanceof ITextFileHandler) {
                    BufferedReader reader = ((ITextFileHandler)this.fileHandler).loadTextFromFile();
                    outputTextArea.read(reader, null);
                    reader.close();
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(parentFrame, "File not found: " + fileHandler.getFile().getName());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(parentFrame, "Error reading file: " + e.getMessage());
            }
        }
    }
}
