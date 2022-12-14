package model;

import org.maksymilianSiemienowicz.GamePanel;

public class Snake extends GamePanel {
    private int snakeElements = 3;
    private int snakeXs[] = new int[getGamePanelWidth()/getUnitSize()];
    private int snakeYs[] = new int[getGamePanelHeight()/getUnitSize()];


    ////GETTERS////
    public int getSnakeElements(){
        return snakeElements;
    }
    public int getSnakeYonI(int i){
        return snakeYs[i];
    }
    public int getSnakeXonI(int i){
        return snakeXs[i];
    }

    ////SETTERS////
    public void setSnakeElements(int i){
        snakeElements = i;
    }
    public void setSnakeYonI(int i, int y){
            snakeYs[i] = y;
    }
    public void setSnakeXonI(int i, int x){
        snakeXs[i] = x;
    }

}
