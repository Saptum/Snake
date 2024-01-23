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
}
