package com.example.snake.model;

import java.util.Random;

public class Apple {

    private int x;
    private int y;

    public Apple(int gridWidth, int girdHeight) {
        relocate(gridWidth,girdHeight);
    }

    public void relocate(int gridWidth, int girdHeight) {
        Random random = new Random();
        this.x = random.nextInt(gridWidth);
        this.y = random.nextInt(girdHeight);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
