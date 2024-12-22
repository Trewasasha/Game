package button;

import Game.GameField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RoundedButtonStart extends JButton implements ActionListener, MouseListener {
    private final int cornerRadius;
    private boolean isPressed = false; // Флаг для отслеживания состояния нажатия
    private final Font font;
    private final JFrame parentFrame; // Ссылка на главное окно

    public RoundedButtonStart(String text, int cornerRadius, JFrame parentFrame) {
        super(text);

        this.parentFrame = parentFrame; // Сохраняем ссылку на главное окно

        font = new Font("Arial", Font.BOLD, 30);

        this.cornerRadius = cornerRadius;
        setContentAreaFilled(false);  // Отключить стандартное заполнение кнопки
        setFocusPainted(true);        // Отключить обводку при фокусе
        setBorderPainted(false);      // Отключить рамку
        setForeground(Color.WHITE);   // Цвет текста
        setBackground(Color.decode("#00CC00")); // Цвет фона кнопки
        setFont(font);

        // Привязываем слушатель событий
        addActionListener(this);
        addMouseListener(this); // Для обработки нажатия мышью
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Меняем цвет при нажатии
        if (isPressed) {
            g2.setColor(getBackground().darker()); // Затемнённый цвет
        } else {
            g2.setColor(getBackground());
        }

        // Отрисовка кнопки с закруглёнными углами
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        // Рисуем текст
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();
        g2.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 4);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Отключаем стандартную рамку
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Открытие игрового поля
        System.out.println("Start game");
        new GameField();
        parentFrame.dispose(); // Закрываем главное окно
    }

    // Реализация MouseListener
    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
        repaint(); // Перерисовываем кнопку
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
        repaint(); // Перерисовываем кнопку
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Не используется
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Не используется
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isPressed = false;
        repaint(); // Сбрасываем состояние при выходе курсора
    }
}
