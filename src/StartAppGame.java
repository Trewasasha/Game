import view.Display;

import javax.swing.*;

public class StartAppGame {
    public static void main(String[] args) {
        // Запускаем приложение в потоке диспетчера событий для безопасности Swing
        SwingUtilities.invokeLater(() -> new Display());
    }
}
