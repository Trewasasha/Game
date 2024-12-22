package Entity;

import javax.swing.*;
import java.awt.*;

public class Laser {

    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Laser(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}
