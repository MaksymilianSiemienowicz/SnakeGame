package org.maksymilianSiemienowicz;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    GameFrame(){
        settingUpFrame();
    }

    private void settingUpFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("SnakeGame");
        this.add(new ScorePanel(), BorderLayout.NORTH);
        this.add(new GamePanel());
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
}
