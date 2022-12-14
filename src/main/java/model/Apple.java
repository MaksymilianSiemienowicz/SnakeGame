package model;

import org.maksymilianSiemienowicz.GamePanel;

import java.util.Random;

public class Apple extends GamePanel {
    private Random rand = new Random();
    private int appleX;
    private int appleY;
    Apple(){

    }
    public boolean shouldAppleExist(){
        int i = rand.nextInt(2);
        return i == 0;
    }
    private void setAppleXY(){
        appleX = rand.nextInt(getGamePanelWidth());
        appleY = rand.nextInt(getGamePanelHeight());
    }
    public int getAppleX(){
        return appleX;
    }
    public int getAppleY(){
        return appleY;
    }
}
