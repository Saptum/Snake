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

//    public int posY;
//    public int posX;
//
//    public Apple(int x, int y) {
//        posX = x;
//        posY = y;
//    }
//
//    public void setDandomPosition() {
//        posX = Math.abs((int) (Math.random() * SnakeMain.WIDTH - 1));
//        posY = Math.abs((int) (Math.random() * SnakeMain.HEIGHT - 1));
//    }
}
