package dev.application.file;

import dev.application.file.interfaces.IFileHandler;
import dev.application.file.interfaces.ITextFileHandler;

import java.io.*;

public class TextFilePanel implements ITextFileHandler {

    private File file;
    private boolean settedFile;

    public TextFilePanel() {
        settedFile = false;
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public boolean isSettedFile() {
        return this.settedFile;
    }

    private void setSettedFile(boolean bool) {
        this.settedFile = bool;
    }

    @Override
    public void loadFile(File file) {
        // Validate if file is a text type file (this validation may become another function)
        this.file = file;
        setSettedFile(true);
    }

    @Override
    public BufferedReader loadTextFromFile() throws FileNotFoundException {
        return new BufferedReader(new FileReader(getFile()));
    }
}