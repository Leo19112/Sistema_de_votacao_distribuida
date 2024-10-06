package dev.application.file.interfaces;

import javax.swing.JTextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

public interface IFileHandler {
    public File getFile();
    public boolean isSettedFile();
    public void loadFile(File file);
}