package com.example.snake.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JPanel {

    private  final JButton startButton;
    private  final JButton exitButton;

    public MainMenuView() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        startButton = new JButton("Start");
        exitButton = new JButton("Exit");

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(startButton);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(exitButton);
    }

    public void start(ActionListener actionListener) {
        startButton.addActionListener(actionListener);
    }

    public void exit(ActionListener actionListener) {
        exitButton.addActionListener(actionListener);
    }
}
