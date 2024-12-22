package string;

import javax.swing.*;
import java.awt.*;

public class StringGame extends JPanel {

    private int x;
    private int y;
    private String message;
    Font font;

    public StringGame(int x, int y, int fontSize) {
        super(true);
        this.x = x;
        this.y = y;
        this.message = "Счёт";
        font = new Font("Arial", Font.BOLD, fontSize);
        this.setOpaque(false);
    }

    public void drawString(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics();

        g.drawString(message, x, y);
    }

}
