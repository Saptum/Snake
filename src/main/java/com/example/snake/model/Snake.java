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
        Point head = new Point(body.getFirst());

        switch (direction) {
            case UP: head = new Point(head.x, head.y - 1); break;
            case DOWN: head = new Point(head.x, head.y + 1); break;
            case LEFT: head = new Point(head.x - 1, head.y); break;
            case RIGHT: head = new Point(head.x + 1, head.y); break;
        }

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
