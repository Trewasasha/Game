package view;

import button.RoundedButtonStart;

import javax.swing.*;

public class Display extends JFrame {

    private final int width = 500;
    private final int height = 600;

    public Display() {
        // Настройка окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLayout(null); // Отключаем менеджер компоновки
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Кнопка Start
        RoundedButtonStart roundedButtonStart = new RoundedButtonStart("Start", 60, this);
        roundedButtonStart.setBounds(150, 250, 200, 100); // Устанавливаем положение кнопки
        this.add(roundedButtonStart);

        // Панель с фоном
        Panel mainMenuPanel = new Panel();
        mainMenuPanel.setBounds(0, 0, width, height); // Устанавливаем размер панели
        this.add(mainMenuPanel);




        this.setVisible(true);
    }


}
