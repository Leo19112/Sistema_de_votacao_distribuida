package dev.application.core;

import java.awt.Dimension;

public class ApplicationConfig {

    private Dimension windowSize;
    private String windowTitle;

    public ApplicationConfig() {
        this.windowSize = new Dimension(800, 600);
        this.windowTitle = "Project Application";

        // Parâmetros de animação podem ser adicionados futuramente
        // int animationSpeed = 5;
        // Color backgroundColor = Color.BLACK;
    }

    public Dimension getWindowSize() {
        return windowSize;
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    // Futuramente, getters e setters para outros parâmetros podem ser adicionados
    // Ex: public int getAnimationSpeed() { return animationSpeed; }
}