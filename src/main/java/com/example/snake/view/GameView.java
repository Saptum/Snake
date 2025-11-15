package com.example.snake.view;

import com.example.snake.controller.GameController;
import com.example.snake.model.Apple;
import com.example.snake.model.Direction;
import com.example.snake.model.Snake;
import com.example.snake.model.GameState;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GameView extends StackPane {

    private final GameController controller;
    private final Canvas canvas;

    private final int cellSize = 25;

    public GameView() {
        this.controller = new GameController();

        int width = 20 * cellSize;
        int height = 20 * cellSize;

        this.canvas = new Canvas(width, height);
        getChildren().add(canvas);

        setupKeyboard();
        controller.startGameLoop(this::draw);

    }

    private void setupKeyboard() {
        setFocusTraversable(true);
        setOnKeyPressed(event -> {
            KeyCode code = event.getCode();

            switch (code) {
                case UP -> controller.setDirection(Direction.UP);
                case DOWN -> controller.setDirection(Direction.DOWN);
                case LEFT -> controller.setDirection(Direction.LEFT);
                case RIGHT -> controller.setDirection(Direction.RIGHT);
            }
        });
    }

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        drawApple(gc);
        drawSnake(gc);

        if (controller.getState() == GameState.GAME_OVER) {
            drawGameOver(gc);
        }
    }

    private void drawSnake(GraphicsContext gc) {
        Snake snake = controller.getSnake();

        gc.setFill(Color.LIGHTGREEN);

        snake.getBody().forEach(apple -> {
            gc.fillRect(apple.x * cellSize, apple.y * cellSize, cellSize, cellSize);
        });

        gc.setFill(Color.GREEN);
        gc.fillRect(
                snake.getHead().x * cellSize,
                snake.getHead().y * cellSize,
                cellSize,
                cellSize
        );
    }

    private void drawApple(GraphicsContext gc) {
        Apple apple = controller.getApple();

        gc.setFill(Color.RED);
        gc.fillOval(
                apple.getX() * cellSize,
                apple.getY() * cellSize,
                cellSize,
                cellSize
        );
    }

    private void drawGameOver(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.setFont(javafx.scene.text.Font.font(40));
        gc.fillText(
                "Game Over",
                canvas.getWidth() / 2 -120,
                canvas.getHeight() / 2
        );
    }
}
