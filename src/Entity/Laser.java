package Entity;

import javax.swing.*;
import java.awt.*;

public class Laser {

    private final int x;
    private final int y;
    private boolean flag = false;


    public Laser(int x, int y) {
        this.x = x;
        this.y = y;

    }



    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x,
                y,
                50,
                400
        );
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
