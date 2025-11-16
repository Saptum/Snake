package com.example.snake.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JPanel {

    private  final JButton startButton;
    private  final JButton exitButton;

    public MainMenuView() {

        setPreferredSize(new Dimension(600, 600));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton = new JButton("Start Game");
        exitButton = new JButton("Exit");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(200));
        add(startButton);
        add(Box.createVerticalStrut(20));
        add(exitButton);
    }

//    public void start(ActionListener actionListener) {
//        startButton.addActionListener(actionListener);
//    }
//
//    public void exit(ActionListener actionListener) {
//        exitButton.addActionListener(actionListener);
//    }


    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getStartButton() {
        return startButton;
    }
}
