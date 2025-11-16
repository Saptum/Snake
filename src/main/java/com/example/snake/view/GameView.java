package com.example.snake.view;


import com.example.snake.controller.GameController;
import com.example.snake.model.Apple;
import com.example.snake.model.Direction;
import com.example.snake.model.GameState;
import com.example.snake.model.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameView extends JPanel {

    private final GameController controller;
    private final int cellSize = 25;

    private final int gridWidth;
    private final int gridHeight;

    public GameView(GameController controller,
                    int gridWidth,
                    int gridHeight,
                    Snake snake,
                    Apple apple) {

        this.controller = controller;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;

        setPreferredSize(new Dimension(gridWidth * cellSize, gridHeight * cellSize));
        setBackground(Color.BLACK);

        setFocusable(true);
        setupKeyboard();
    }



    private void setupKeyboard() {
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> controller.setDirection(Direction.UP);
                    case KeyEvent.VK_DOWN -> controller.setDirection(Direction.DOWN);
                    case KeyEvent.VK_LEFT -> controller.setDirection(Direction.LEFT);
                    case KeyEvent.VK_RIGHT -> controller.setDirection(Direction.RIGHT);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawApple(g);
        drawSnake(g);

        if (controller.getState() == GameState.GAME_OVER) {
            drawGameOver(g);
        }
    }

    private void drawSnake(Graphics g) {
        Snake snake = controller.getSnake();

        g.setColor(Color.GREEN);

        snake.getBody().forEach(p ->
                g.fillRect(p.x * cellSize, p.y * cellSize, cellSize, cellSize)
        );

        g.setColor(Color.YELLOW);
        g.fillRect(
                snake.getHead().x * cellSize,
                snake.getHead().y * cellSize,
                cellSize,
                cellSize
        );
    }

    private void drawApple(Graphics g) {
        Apple apple = controller.getApple();

        g.setColor(Color.RED);
        g.fillOval(
                apple.getX() * cellSize,
                apple.getY() * cellSize,
                cellSize,
                cellSize
        );
    }

    private void drawGameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));

        String text = "Game Over";
        int textWidth = g.getFontMetrics().stringWidth(text);

        g.drawString(text,
                (getWidth() - textWidth) / 2,
                getHeight() / 2);
    }
}
