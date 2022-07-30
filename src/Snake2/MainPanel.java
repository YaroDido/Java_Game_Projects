package Snake2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {

    private Snake snake = new Snake();
    private Apple apple = new Apple();
    private boolean gameOver = false;

    public MainPanel() {
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
        MainTimer timer = new MainTimer();
        timer.start();

        MainFrame.score.setText("Score: " + snake.getSize());

        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
    }

    protected void paintComponent(Graphics g) {
        Board.draw(g);
        snake.draw(g);
        apple.draw(g);
    }

    private class MainTimer extends Timer {
        public static final int DELAY = 100;

        public MainTimer() {
            super(DELAY, e -> {
                if (!gameOver) {
                    snake.move();

                    if (snake.eatApple(apple)) {
                        apple = new Apple();
                    }
                    if (snake.isCollision()) {
                        gameOver = true;
                        MainFrame.score.setText("Game Over - Score: " + snake.getSize());
                    }
                    repaint();
                }
            });
        }
    }

    private class MyKeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (snake.getDirection() != Direction.R) {
                        snake.setDirection(Direction.L);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (snake.getDirection() != Direction.L) {
                        snake.setDirection(Direction.R);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (snake.getDirection() != Direction.U) {
                        snake.setDirection(Direction.D);
                    }
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (snake.getDirection() != Direction.D) {
                        snake.setDirection(Direction.U);
                    }
                    break;
            }
        }
    }
}
