package com.example.snake.view;


import com.example.snake.utils.StyleConstants;

import javax.swing.*;
import java.awt.*;


public class MainMenuView extends JPanel {

    private final JButton startButton;
    private final JButton exitButton;


    public MainMenuView() {

        setPreferredSize(new Dimension(500, 500));
        setBackground(StyleConstants.BACKGROUND_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("SNAKE GAME");
        titleLabel.setFont(StyleConstants.TITLE_FONT);
        titleLabel.setForeground(StyleConstants.PRIMARY_COLOR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton = createStyledButton("Start Game", StyleConstants.PRIMARY_COLOR);
        exitButton = createStyledButton("Exit", StyleConstants.ACCENT_COLOR);

        add(Box.createVerticalStrut(80));
        add(titleLabel);
        add(Box.createVerticalStrut(100));
        add(startButton);
        add(Box.createVerticalStrut(StyleConstants.VERTICAL_SPACING));
        add(exitButton);

    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(StyleConstants.BUTTON_FONT);
        button.setPreferredSize(StyleConstants.BUTTON_SIZE);
        button.setMaximumSize(StyleConstants.BUTTON_SIZE);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setBackground(color);
        button.setForeground(StyleConstants.TEXT_COLOR);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color.darker(), 2),
                BorderFactory.createEmptyBorder(10, 25, 10, 25)
        ));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });

        return button;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

}
