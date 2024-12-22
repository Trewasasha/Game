package Controller;

import Entity.Blasters;
import Entity.Laser;
import Entity.Player;

import javax.swing.*;
import java.util.List;

public class TimerBlast {
    private final Timer blasterTimer;
    private Timer laserTimer;
    private boolean flag = false;

    public TimerBlast(Player player, List<Blasters> blasters, List<Laser> lasers, Runnable repaintCallback) {
        // Таймер для появления бластера через 2 секунды
        blasterTimer = new Timer(2000, e -> {
            SwingUtilities.invokeLater(() -> {
                int playerX = player.getX();
                int playerY = player.getY();
                Blasters newBlaster = new Blasters(playerX, playerY - 315);
                blasters.add(newBlaster);
                repaintCallback.run(); // Callback для обновления UI

                // Таймер для появления лазера через 1 секунду рядом с бластером
                laserTimer.setInitialDelay(500); // Установка задержки для лазера
                laserTimer.start();
            });
        });
        blasterTimer.setRepeats(false);

        // Инициализация таймера для лазера
        laserTimer = new Timer(0, e -> {
            SwingUtilities.invokeLater(() -> {
                if (!blasters.isEmpty()) {
                    Blasters lastBlaster = blasters.get(blasters.size() - 1); // Получаем последний бластер
                    int blasterX = lastBlaster.getX();
                    int blasterY = lastBlaster.getY();
                    Laser newLaser = new Laser(blasterX - 25, blasterY + 50);
                    lasers.add(newLaser); // Лазер рядом с бластером
                    flag = true;
                    repaintCallback.run();
                }
            });
        });
        laserTimer.setRepeats(false);
    }
    public boolean getFlag() {
        return flag;
    }

    public void start() {
        blasterTimer.start();
    }
}
