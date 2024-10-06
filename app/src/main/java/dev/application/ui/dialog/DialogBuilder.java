package dev.application.ui.dialog;

import dev.application.ui.dialog.interfaces.IDialogBuilder;

import javax.swing.*;

public abstract class DialogBuilder implements IDialogBuilder {
    protected JFrame parentFrame;
    protected String title;
    protected String content;
    protected int width;
    protected int height;

    public DialogBuilder(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public DialogBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public DialogBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public DialogBuilder setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }
}
