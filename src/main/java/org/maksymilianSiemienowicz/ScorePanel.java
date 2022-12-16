package org.maksymilianSiemienowicz;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int points = 0;

    private static ScorePanel scorePanel;

   private ScorePanel(){
    }

    public static ScorePanel getInstance(){
       if (scorePanel == null){
           scorePanel = new ScorePanel();
           return scorePanel;
       }
       return scorePanel;
    }


     public JLabel scorePoints = new JLabel();

    void settingUpScorePanel(){
        this.setSize(800,200);
        this.setBackground(Color.black);

        scorePoints.setText("Score: "+ points);
        scorePoints.setForeground(Color.GREEN);
        scorePoints.setFont(new Font("Verdant", Font.BOLD, 100));
        scorePoints.setLayout(new BorderLayout());
        this.add(scorePoints,BorderLayout.CENTER);
    }

    public void setScorePoints(int z){
        points = z;
        scorePoints.setText("Score: "+ points);
    }

    public int getScorePoints(){
        return points;
    }
}
