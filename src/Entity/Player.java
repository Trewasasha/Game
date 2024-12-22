package Entity;

import javax.swing.*;
import java.awt.*;

public class Player {

    private int x; // Позиция игрока
    private int y;
    private final int size; // Размер игрока
    private final Image playerImage;

    public Player(int startX, int startY, int size) {
        this.x = startX;
        this.y = startY;
        this.size = size;
        playerImage = new ImageIcon(getClass().getResource("/resources/player.png")).getImage();
    }

    public void draw(Graphics g) {
        if (playerImage != null) {
            g.drawImage(playerImage, x - size / 2, y - size / 2, size, size, null);
        } else {
            System.out.println("Изображение не загрузилось!!!");
        }
    }

    public void moveTo(int mouseX, int panelWidth) {
        // Обновляем позицию игрока
        x = Math.max(size / 2, Math.min(mouseX, panelWidth - size / 2) - 15);
        y = 500; // Фиксированное значение по вертикали
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Player{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }

    public int getY() {
        return y;
    }
}
