package dev.application.ui;

import javax.swing.*;
import java.awt.Color;

public class AnimationManager implements Runnable {

    private AnimationPanel animationPanel;
    private Thread animationThread;
    private boolean running = false;
    private int delay = 50; // Em milissegundos

    public AnimationManager(AnimationPanel panel) {
        this.animationPanel = panel;
    }

    public void startAnimation() {
        if (animationThread == null || !running) {
            running = true;
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    public void stopAnimation() {
        running = false;
    }

    public void setSpeed(int speed) {
        // Ajusta o delay com base na velocidade (quanto maior a velocidade, menor o delay)
        delay = 1000 / speed;
        animationPanel.setSpeed(speed);
    }

    public void setColor(Color color) {
        animationPanel.setColor(color);
    }

    public void setPattern(int pattern) {
        animationPanel.setPattern(pattern);
    }

    @Override
    public void run() {
        while (running) {
            // Atualiza a animação na Event Dispatch Thread
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    animationPanel.updateAnimation();
                }
            });

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
