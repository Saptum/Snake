public class Snake {
    public int length = 2;
    // Направление змеи (0: вверх, 1: вниз, 2: вправо, 3: влево)
    public int direction = 2;

    // Массивы для хранения координат X и Y сегментов змеи
    public int[] snakeX = new int[300];
    public int[] snakeY = new int[300];
}
