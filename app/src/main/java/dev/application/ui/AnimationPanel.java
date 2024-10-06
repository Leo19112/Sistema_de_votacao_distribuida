package dev.application.ui;

import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {

    private int x = 0;
    private int y = 0;
    private Color color = Color.BLUE;
    private int pattern = 0;
    private int speed = 5;

    public AnimationPanel() {
        // Configura o painel para ser transparente
        setOpaque(false);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPattern(int pattern) {
        this.pattern = pattern;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void updateAnimation() {
        // Atualiza a posição ou estado da animação com base no padrão
        switch (pattern) {
            case 0:
                // Movimento diagonal
                x += speed;
                y += speed;
                break;
            case 1:
                // Movimento horizontal
                x += speed;
                break;
            case 2:
                // Movimento vertical
                y += speed;
                break;
            default:
                x += speed;
                y += speed;
                break;
        }

        // Reseta posições para manter a animação dentro dos limites
        if (x > getWidth()) x = 0;
        if (y > getHeight()) y = 0;

        // Repaint para atualizar a animação
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha uma elipse móvel como exemplo de animação
        g.setColor(color);
        g.fillOval(x, y, 50, 50);
    }
}
