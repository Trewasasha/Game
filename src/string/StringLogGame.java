package string;

import javax.swing.*;
import java.awt.*;

public class StringLogGame extends JPanel {

    private final int x;
    private final int y;

    private int check;
    Font font;

    public StringLogGame(int x, int y, int fontSize) {
        super(true);

        this.x = x;
        this.y = y;
        this.check = 100;

        font = new Font("Arial", Font.BOLD, fontSize);
        this.setOpaque(false);
    }

    public void draw(Graphics g) {
        String checkString = String.valueOf(check);

        g.setColor(Color.BLACK);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics();


        g.drawString(checkString, x, y);
    }



}
