package Game;

import Entity.Player;
import string.StringLogGame;

import javax.swing.*;

public class GameField extends JFrame {

    private final int width = 500;
    private final int height = 600;

    public GameField() {

        // Настройка окна игрового поля
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Добавляем игровую панель
        PanelGame panelGame = new PanelGame();
        this.add(panelGame);



        this.setVisible(true);
    }
}
