

public class Apple {

    public int posY;
    public int posX;

    public void setDandomPosition() {
        posX = Math.abs((int) (Math.random() * SnakeMain.WIDTH - 1));
        posY = Math.abs((int) (Math.random() * SnakeMain.HEIGHT - 1));
    }
}
