package com.example.snake.view;


import javax.swing.*;
import java.awt.*;


public class MainMenuView extends JPanel {

    private  final JButton startButton;
    private  final JButton exitButton;
    private  final JButton restartButton;


    public MainMenuView() {

        setPreferredSize(new Dimension(500, 500));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton = new JButton("Start Game");
        exitButton = new JButton("Exit");
        restartButton = new JButton("Restart");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(200));
        add(startButton);
        add(Box.createVerticalStrut(20));
        add(restartButton);
        add(Box.createVerticalStrut(20));
        add(exitButton);
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getRestartButton() {
        return restartButton;
    }
}
