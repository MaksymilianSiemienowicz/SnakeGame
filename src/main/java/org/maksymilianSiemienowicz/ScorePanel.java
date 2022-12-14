package org.maksymilianSiemienowicz;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int Points = 0;
    ScorePanel(){
        settingUpScorePanel();
    }

    private void settingUpScorePanel(){
        this.setSize(800,200);
        this.setBackground(Color.GREEN);

        JLabel scorePoints = new JLabel();
        scorePoints.setText("Score: "+Points);
        scorePoints.setForeground(Color.MAGENTA);
        scorePoints.setFont(new Font("Verdant", Font.BOLD, 100));
        scorePoints.setLayout(new BorderLayout());
        this.add(scorePoints,BorderLayout.CENTER);
    }

    public void setScorePoints(int z){
        Points = z;
    }

    public int getScorePoints(){
        return Points;
    }
}
