package com.example.snake;

import com.example.snake.controller.GameController;
import com.example.snake.view.MainMenuView;

import javax.swing.*;

public class SnakeMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            JFrame frame = new JFrame("Snake");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MainMenuView mainMenuView = new MainMenuView();
            new GameController(frame,mainMenuView);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
