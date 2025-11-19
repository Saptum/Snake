package com.example.snake.view;

import javax.swing.*;
import java.awt.*;

public class GameOverView extends JPanel {

    private  final JButton restartButton;
    private  final JButton menuButton;
    private  final JButton exitButton;

    public GameOverView() {

        setLayout(new BorderLayout());
        setOpaque(false);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 48));
        gameOverLabel.setForeground(Color.RED);
        gameOverLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        textPanel.add(Box.createVerticalGlue());
        textPanel.add(gameOverLabel);
        textPanel.add(Box.createVerticalStrut(50));

        add(textPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout());

        restartButton = new JButton("Restart");
        menuButton = new JButton("Menu");
        exitButton = new JButton("Exit");

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        restartButton.setFont(buttonFont);
        menuButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        restartButton.setPreferredSize(new Dimension(150, 40));
        menuButton.setPreferredSize(new Dimension(150, 40));
        exitButton.setPreferredSize(new Dimension(150, 40));

        buttonPanel.add(restartButton);
        buttonPanel.add(menuButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JButton getRestartButton() {
        return restartButton;
    }
    public JButton getMenuButton() {
        return menuButton;
    }
    public JButton getExitButton() {
        return exitButton;
    }
}
