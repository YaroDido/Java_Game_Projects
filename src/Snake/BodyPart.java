package Snake;

import java.awt.*;

public class BodyPart {

    private int xCoor, yCoor, WIDTH, HEIGHT;

    public BodyPart(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        WIDTH = tileSize;
        HEIGHT = tileSize;
    }

    public void tick(){
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xCoor * HEIGHT, yCoor *  HEIGHT, WIDTH, HEIGHT);
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
}
