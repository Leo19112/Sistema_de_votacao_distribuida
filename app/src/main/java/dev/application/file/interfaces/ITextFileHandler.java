package dev.application.file.interfaces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public interface ITextFileHandler extends IFileHandler {
    public BufferedReader loadTextFromFile() throws FileNotFoundException;
}