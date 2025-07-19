import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Auto Moving Button");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(null); // manual layout

            JButton movingBtn = new JButton("I'm Alive!");
            movingBtn.setBounds(120, 100, 150, 50);
            movingBtn.setBackground(new Color(200, 200, 255));
            movingBtn.setFocusPainted(false);
            movingBtn.setFont(new Font("Arial", Font.BOLD, 16));

            frame.add(movingBtn);

            // Auto movement timer
            Timer timer = new Timer(50, null);
            timer.addActionListener(new ActionListener() {
                int direction = 1; // 1 for right, -1 for left
                int step = 5;
                int minX = 50, maxX = 200;

                public void actionPerformed(ActionEvent e) {
                    Point pos = movingBtn.getLocation();
                    int newX = pos.x + (direction * step);

                    if (newX > maxX || newX < minX) {
                        direction *= -1; // reverse direction
                    }

                    movingBtn.setLocation(newX, pos.y);
                }
            });

            timer.start(); // Start the automatic animation

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
