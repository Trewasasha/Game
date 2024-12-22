package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

public class Panel extends JPanel {

    public Panel() {
        this.setPreferredSize(new Dimension(getWidth(), getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Игровой фон
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.decode("#FF0000"));
        g2D.fillRect(0, 0, getWidth(), getHeight());

    }
}
