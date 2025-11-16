package com.example.snake.controller;


import com.example.snake.model.Apple;
import com.example.snake.model.Direction;
import com.example.snake.model.GameState;
import com.example.snake.model.Snake;
import com.example.snake.view.GameView;
import com.example.snake.view.MainMenuView;

import javax.swing.*;

public class GameController {

    private final JFrame frame;
    private final MainMenuView mainMenuView;

    private GameView gameView;

    private Snake snake;
    private Apple apple;

    private final int gridWidth = 20;
    private final int gridHeight = 20;

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
        mainMenuView.getExitButton().addActionListener(e -> System.exit(0));

        frame.revalidate();
        frame.repaint();
    }

    private void startGame() {
        snake = new Snake(gridWidth / 2, gridHeight / 2);
        apple = new Apple(gridWidth, gridHeight);
        state = GameState.RUNNING;

        gameView = new GameView(this, gridWidth, gridHeight, snake, apple);

        frame.setContentPane(gameView);
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

        checkAppleCollision();
        checkWallCollision();
        checkSnakeCollision();

        gameView.repaint();
    }

    private void checkAppleCollision() {
        if (snake.getHead().x == apple.getX()
                && snake.getHead().y == apple.getY()) {

            snake.grow();
            apple.relocate(gridWidth, gridHeight);
        }
    }

    private void checkWallCollision() {
        int x = snake.getHead().x;
        int y = snake.getHead().y;

        if (x < 0 || x >= gridWidth || y < 0 || y >= gridHeight) {
            state = GameState.GAME_OVER;
            gameTimer.stop();
        }
    }

    private void checkSnakeCollision() {
        var head = snake.getHead();

        for (int i = 1; i < snake.getBody().size(); i++) {
            if (head.equals(snake.getBody().get(i))) {
                state = GameState.GAME_OVER;
                gameTimer.stop();
                break;
            }
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
