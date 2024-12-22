package Game;

import Entity.Blasters;
import Entity.Laser;
import Entity.Player;
import string.StringGame;
import string.StringLogGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelGame extends JPanel implements MouseMotionListener {

    private final int width = 500;
    private final int height = 600;

    private final StringGame stringGame;
    private final Player player;
    private final StringLogGame stringLogGame;
    private List<Blasters> blasters;
    //private final List<Laser> lasers;



    public PanelGame() {
        this.setPreferredSize(new Dimension(width, height));
        this.addMouseMotionListener(this);

        stringGame = new StringGame(200, 40, 40);
        stringLogGame = new StringLogGame(215, 90, 40);
        player = new Player(250, 500, 100);

        blasters = new ArrayList<>();
        //lasers = new ArrayList<>();

        // Таймер для появления бластера через 2 секунды
        Timer firstTimer = new Timer(2000, e -> {
            SwingUtilities.invokeLater(() -> {
                int playerX = player.getX();
                int playerY = player.getY();
                blasters.add(new Blasters(playerX, playerY - 315));
                repaint();
            });

        });
        firstTimer.setRepeats(false);
        firstTimer.start();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Фон
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.decode("#FF7C00"));
        g2D.fillRect(0, 0, width, height);


        stringGame.drawString(g);
        stringLogGame.draw(g);
        player.draw(g);
//        blasters.draw(g);
        for(Blasters blasters : blasters) {
            blasters.draw(g);
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        // Обновляем позицию игрока
        player.moveTo(e.getX(), getWidth());
        repaint(); // Перерисовываем панель
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}


