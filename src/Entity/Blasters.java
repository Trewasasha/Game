package Entity;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Blasters extends JPanel {

    private final int x;
    private final int y;
    Image blasterImage;


    public Blasters(int x, int y) {

        this.x = x;
        this.y = y;
        this.setOpaque(false);

        blasterImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/blasters.png"))).getImage();

    }

    public void draw(Graphics g) {
        g.drawImage(blasterImage,
                x - 83,
                y - 83,
                166,
                166,
                this);
    }


}
