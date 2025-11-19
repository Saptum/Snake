package com.example.snake.model;

import java.util.Random;

public class Apple {

    private int x;
    private int y;

    public Apple(int gridWidth, int gridHeight) {
        relocate(gridWidth, gridHeight);
    }

    public void relocate(int gridWidth, int gridHeight) {
        Random random = new Random();
        this.x = random.nextInt(gridWidth);
        this.y = random.nextInt(gridHeight);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
