package org.maksymilianSiemienowicz;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final int gamePanelWidth = 800;
    private final int gamePanelHeight = 800;
    private final int unitSize = 50;


    public GamePanel(){
        settingUpGamePanel();
    }
    public int getGamePanelWidth(){
        return gamePanelWidth;
    }
    public int getGamePanelHeight(){
        return gamePanelHeight;
    }
    public int getUnitSize(){
        return unitSize;
    }

    private void settingUpGamePanel(){
        this.setSize(gamePanelWidth,gamePanelHeight);
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMatrix(g);
    }

    private void drawMatrix(Graphics g){
        for(int i = 0; i < gamePanelHeight; i++){
            g.setColor(Color.white);
            g.drawLine(i*unitSize,0,i*unitSize,gamePanelHeight);
        }

        for(int i = 0; i < gamePanelWidth; i++){
            g.setColor(Color.white);
            g.drawLine(0,i*unitSize,gamePanelWidth,i*unitSize);
        }
    }

}
