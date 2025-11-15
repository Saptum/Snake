//import com.example.snake.model.Apple;
//import com.example.snake.model.Snake;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//
//public class SnakeMain extends JPanel implements ActionListener  {
//
//    // Объявление переменных
//    public static JFrame jFrame;
//    public static final int SCALE = 32;
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 20;
//    public static int speed = 10;
//
//    // Создание экземпляра змеи и яблока, а также таймера для обновления игры
//    Snake s = new Snake(5, 6, 5, 5);
//    Apple apple = new Apple(Math.abs((int) (Math.random() * SnakeMain.WIDTH - 1)), Math.abs((int) (Math.random() * SnakeMain.HEIGHT - 1)));
//    Timer timer = new Timer(1000 / speed, this);
//
//    // Конструктор класса
//    public SnakeMain() {
//        timer.start();
//        addKeyListener(new KeyBoard());
//        setFocusable(true);
//    }
//
//    // Метод для отрисовки элементов игры
//    public void paint(Graphics g) {
//        // Отрисовка фона
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
//
//        // Отрисовка сетки
//        for (int x = 0; x < WIDTH * SCALE; x = x + SCALE) {
//            g.setColor(Color.WHITE);
//            g.drawLine(x, 0, x, HEIGHT * SCALE);
//        }
//        for (int y = 0; y < HEIGHT * SCALE; y = y + SCALE) {
//            g.setColor(Color.WHITE);
//            g.drawLine(0, y, WIDTH * SCALE, y);
//        }
//
//        // Отрисовка яблока
//        g.setColor(Color.RED);
//        g.fillOval(apple.posX * SCALE + 4, apple.posY * SCALE + 4, SCALE - 8, SCALE - 8);
//
//        // Отрисовка змеи
//        for (int l = 0; l < s.length; l++) {
//            g.setColor(Color.GREEN);
//            g.fillRect(s.snakeX[l] * SCALE + 3, s.snakeY[l] * SCALE + 1, SCALE - 6, SCALE - 6);
//
//            // Отрисовка головы змеи
//            g.setColor(Color.WHITE);
//            g.fillRect(s.snakeX[0] * SCALE + 3, s.snakeY[0] * SCALE + 1, SCALE - 6, SCALE - 6);
//        }
//    }
//
//    // Метод для запуска игры
//    public static void main(String[] args) {
//
//        jFrame = new JFrame("SnakeFX");
//        jFrame.setSize(WIDTH * SCALE + 7, HEIGHT * SCALE + 29);
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setResizable(false);
//        jFrame.setLocationRelativeTo(null);
//        jFrame.add(new SnakeMain());
//        jFrame.setVisible(true);
//    }
//
//    // Метод, вызываемый таймером при обновлении игры
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // Движение змеи
//        s.move();
//        // Обработка съедания яблока
//        if ((s.snakeX[0] == apple.posX) && (s.snakeY[0] == apple.posY)) {
//            apple.setDandomPosition();
//            s.length++;
//        }
//
//        // Обработка столкновения со своим телом
//        for (int l = 1; l < s.length; l++) {
//            if ((s.snakeX[l] == apple.posX) && (s.snakeY[l] == apple.posY)) {
//                apple.setDandomPosition();
//            }
//            //случай когда игра заканчивается
//            if ((s.snakeX[0] == s.snakeX[l]) && (s.snakeY[0] == s.snakeY[l])) {
//                timer.stop();
//                JOptionPane.showMessageDialog(null, "Вы проиграли, зачать заново?");
//                jFrame.setVisible(false);
//                s.length = 2;
//                s.direction = 0;
//                apple.setDandomPosition();
//                jFrame.setVisible(true);
//                timer.start();
//            }
//        }
//        // Перерисовка игрового поля
//        repaint();
//    }
//
//    // Внутренний класс для обработки событий клавиатуры
//    public class KeyBoard extends KeyAdapter {
//        public void keyPressed(KeyEvent event) {
//
//            int key = event.getKeyCode();
//
//            if ((key == KeyEvent.VK_UP) && (s.direction != 2)) s.direction = 0;
//            if ((key == KeyEvent.VK_DOWN) && (s.direction != 0)) s.direction = 2;
//            if ((key == KeyEvent.VK_LEFT) && (s.direction != 1)) s.direction = 3;
//            if ((key == KeyEvent.VK_RIGHT) && (s.direction != 3)) s.direction = 1;
//        }
//    }
//}
