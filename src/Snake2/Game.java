package Snake2;

import java.awt.*;

public class Game {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
           MainFrame mainFrame = new MainFrame();
           mainFrame.setVisible(true);
        });
    }
}

