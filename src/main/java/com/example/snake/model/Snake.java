package com.example.snake.model;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Snake {

    private LinkedList<Point> body = new LinkedList<>();
    private Direction direction = Direction.RIGHT;

    public Snake(int startX, int startY) {
        body.add(new Point(startX, startY));
    }

    public void move() {
        // Получаем текущую голову
        Point head = new Point(body.getFirst());

        // На основе направления создаётся новая точка-голова
        switch (direction) {
            case UP -> head.y--;
            case DOWN -> head.y++;
            case LEFT -> head.x--;
            case RIGHT -> head.x++;
        }

        // Добавляем её как новую голову
        body.addFirst(head);
        body.removeLast();
    }

    public void grow(){
        Point tail = body.getLast();
        body.add(new Point(tail));
    }

    public void setDirection(Direction newDirection) {
        if (!isOpposite(newDirection)){
            this.direction = newDirection;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Point> getBody() {
        return body;
    }

    public Point getHead() {
        return body.getFirst();
    }

    private boolean isOpposite(Direction newDirection) {
        return  (direction == Direction.UP && newDirection == Direction.DOWN) ||
                (direction == Direction.DOWN && newDirection == Direction.UP) ||
                (direction == Direction.LEFT && newDirection == Direction.RIGHT) ||
                (direction == Direction.RIGHT && newDirection == Direction.LEFT);
    }

}
