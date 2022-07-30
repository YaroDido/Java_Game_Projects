package Snake2;

import java.awt.*;
import java.util.Random;

public class Apple extends Point {
    private static Random random = new Random();

    public Apple() {
        super(random.nextInt(Board.FIELD_X), random.nextInt(Board.FIELD_Y));
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x*Board.SIZE, y* Board.SIZE, Board.SIZE, Board.SIZE);
    }
}
