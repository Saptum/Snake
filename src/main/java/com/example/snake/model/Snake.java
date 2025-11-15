package com.example.snake.model;

public class Snake {
    public int length = 2;
    // Направление змеи (0: вверх, 1: вниз, 2: вправо, 3: влево)
    public int direction = 2;

    // Массивы для хранения координат X и Y сегментов змеи
    public int[] snakeX = new int[300];
    public int[] snakeY = new int[300];

    // Конструктор для инициализации змеи начальными координатами (x1, y1) и (x2, y2)
    public Snake(int x1, int y1, int x2, int y2) {
        snakeX[0] = x1;
        snakeX[1] = x2;
        snakeY[0] = y1;
        snakeY[1] = y2;
    }

    public void move() {
        // Перемещение сегментов хвоста после головы
        for (int l = length; l > 0; l--) {
            snakeX[l] = snakeX[l - 1];
            snakeY[l] = snakeY[l - 1];
        }

        // Перемещение головы змеи в зависимости от текущего направления
        // up
        if (direction == 0) snakeY[0]--;
        // right
        if (direction == 2) snakeY[0]++;
        // down
        if (direction == 1) snakeX[0]++;
        // left
        if (direction == 3) snakeX[0]--;

        // Зацикливание змеи вокруг экрана, если она выходит за границы
        if (snakeY[0] > SnakeMain.HEIGHT - 1) snakeY[0] = 0;
        if (snakeY[0] < 0) snakeY[0] = SnakeMain.HEIGHT - 1;

        if (snakeX[0] > SnakeMain.WIDTH - 1) snakeX[0] = 0;
        if (snakeX[0] < 0) snakeX[0] = SnakeMain.WIDTH - 1;

    }
}
