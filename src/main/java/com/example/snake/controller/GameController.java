package com.example.snake.controller;


import com.example.snake.model.*;
import javafx.animation.AnimationTimer;

public class GameController {

    private final int gridWidth = 20;
    private final int gridHeight = 20;

    private final long moveDelayNs = 150_000_000;

    private final Snake snake;
    private final Apple apple;

    private GameState state = GameState.RUNNING;

    private AnimationTimer timer;

    public GameController() {
        this.snake = new Snake(gridWidth/2, gridHeight/2);
        this.apple = new Apple(gridWidth, gridHeight);
    }

    public void startGameLoop(Runnable onUpdate){
        timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate > moveDelayNs) {
                    update();
                }
            }
        };
    }

    private void update() {
        if (state != GameState.RUNNING) return;
         snake.move();
         checkAppleCollision();
         checkWallCollision();
         checkSnakeCollision();
    }

     private void checkAppleCollision() {
        if (snake.getHead().x == apple.getX() &&
            snake.getHead().y == apple.getY()){

            snake.grow();
            apple.relocate(gridWidth, gridHeight);
        }
     }

     private void checkWallCollision() {
        int x = snake.getHead().x;
        int y = snake.getHead().y;
        if (x < 0 || x >= gridWidth || y < 0 || y >= gridHeight){
            state = GameState.GAME_OVER;
            timer.stop();
        }
     }

   private void checkSnakeCollision() {
        var head = snake.getHead();
         for (int i = 0; i < snake.getBody().size(); i++){
             if (head.equals(snake.getBody().get(i))){
                 state = GameState.GAME_OVER;
                 timer.stop();
                 break;
             }
         }
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

    public void setDirection(Direction direction) {
        snake.setDirection(direction);
    }

}
