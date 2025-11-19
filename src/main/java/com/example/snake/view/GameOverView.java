package com.example.snake.view;

import com.example.snake.utils.StyleConstants;

import javax.swing.*;
import java.awt.*;

public class GameOverView extends JPanel {

    private final JButton restartButton;
    private final JButton menuButton;
    private final JButton exitButton;

    public GameOverView() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setOpaque(false); // Прозрачный фон для наложения на игровое поле
        
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(StyleConstants.TITLE_FONT);
        gameOverLabel.setForeground(StyleConstants.ACCENT_COLOR);
        gameOverLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        restartButton = createStyledButton("Play Again", StyleConstants.PRIMARY_COLOR);
        menuButton = createStyledButton("Main Menu", StyleConstants.PRIMARY_COLOR);
        exitButton = createStyledButton("Exit", StyleConstants.ACCENT_COLOR);
        
        add(Box.createVerticalStrut(100));
        add(gameOverLabel);
        add(Box.createVerticalStrut(80));
        add(restartButton);
        add(Box.createVerticalStrut(StyleConstants.VERTICAL_SPACING));
        add(menuButton);
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
