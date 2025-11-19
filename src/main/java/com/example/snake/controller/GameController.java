package com.example.snake.controller;


import com.example.snake.model.Apple;
import com.example.snake.model.Direction;
import com.example.snake.model.GameState;
import com.example.snake.model.Snake;
import com.example.snake.view.GameView;
import com.example.snake.view.MainMenuView;

import javax.swing.*;
import java.awt.*;

public class GameController {

    private final JFrame frame;
    private final MainMenuView mainMenuView;

    private GameView gameView;

    private Snake snake;
    private Apple apple;

    private final int gridWidth = 20;
    private final int gridHeight = 20;
    private final int cellSize = 25;

    public int getGridWidth() { return gridWidth; }
    public int getGridHeight() { return gridHeight; }
    public int getCellSize() { return cellSize; }

    public Dimension getPreferredSize() {
        return new Dimension(gridWidth * cellSize, gridHeight * cellSize);
    }

    private GameState state = GameState.RUNNING;

    private Timer gameTimer;
    private final int delayMs = 150; // скорость движения

    public GameController(JFrame frame, MainMenuView mainMenuView) {
        this.frame = frame;
        this.mainMenuView = mainMenuView;
        initMenu();
    }

    private void initMenu() {
        frame.setContentPane(mainMenuView);

        mainMenuView.getStartButton().addActionListener(e -> startGame());
        mainMenuView.getRestartButton().addActionListener(e -> startGame());
        mainMenuView.getExitButton().addActionListener(e -> System.exit(0));

        frame.revalidate();
        frame.repaint();
    }

    private void startGame() {
        snake = new Snake(gridWidth / 2, gridHeight / 2);
        apple = new Apple(gridWidth, gridHeight);

        state = GameState.RUNNING;

        gameView = new GameView(this, snake, apple);

        frame.setContentPane(gameView);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.revalidate();
        frame.repaint();

        gameView.requestFocusInWindow();

        startGameLoop();
    }

    private void startGameLoop() {
        gameTimer = new Timer(delayMs, e -> update());
        gameTimer.start();
    }

    private void update() {
        if (state != GameState.RUNNING) return;

        snake.move();

        checkWallCollision();
        if (state == GameState.GAME_OVER) return;
        checkSnakeCollision();
        if (state == GameState.GAME_OVER) return;
        checkAppleCollision();

        gameView.repaint();
    }

    private void checkAppleCollision() {
        if (snake.getHead().x == apple.getX()&& snake.getHead().y == apple.getY()) {

            do {
                apple.relocate(gridWidth, gridHeight);
            } while (isAppleOnSnake());

            snake.grow();

        }
    }

    private boolean isAppleOnSnake() {
        for (Point segment : snake.getBody()) {
            if (segment.x == apple.getX() && segment.y == apple.getY()) {
                return true;
            }
        }
        return false;
    }

    private void checkWallCollision() {
        int x = snake.getHead().x;
        int y = snake.getHead().y;

        if (x < 0 || x >= gridWidth || y < 0 || y >= gridHeight) {

            state = GameState.GAME_OVER;
            gameTimer.stop();

            if (gameView != null) {
                gameView.repaint();
            }
        }
    }

    private void checkSnakeCollision() {
        var head = snake.getHead();
        var body = snake.getBody();

        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                state = GameState.GAME_OVER;
                gameTimer.stop();
                if (gameView != null) {
                    gameView.repaint();
                }
                return;
            }
        }
    }

    public void setPause() {
        if (state == GameState.RUNNING) {
            state = GameState.PAUSED;
        }else if (state == GameState.PAUSED) {
            state = GameState.RUNNING;
        }
    }

    public void setDirection(Direction direction) {
        snake.setDirection(direction);
    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }


    public GameState getState() {
        return state;
    }
}
