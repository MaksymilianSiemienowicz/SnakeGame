package model;

import org.maksymilianSiemienowicz.GamePanel;

import java.awt.*;
import java.util.Random;

public class Apple {
    private Random rand = new Random();
    private int appleX;
    private int appleY;
    public Apple(){

    }
    public void setAppleXY(){
        appleX = rand.nextInt((800/25))*25;
        appleY = rand.nextInt(800/25)*25;
    }
    public int getAppleX(){
        return appleX;
    }
    public int getAppleY(){
        return appleY;
    }

    public void drawApple(Graphics g) {
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, 25, 25);
    }
}
