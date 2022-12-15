package model;

import java.awt.*;

public class Snake {
    private int snakeElements = 3;
    private int snakeXs[] = new int[64];
    private int snakeYs[] = new int[64];
    public char direction = 'R';
    public boolean running = false;
    public Snake(){

    }


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
    public char getSnakeDirection(){
        return direction;
    }
    ////SETTERS////
    public void setSnakeElements(int i){
        snakeElements = i;
    }
    public void setSnakeDirection(char a){
        direction = a;
    }
    public void setSnakeDirectionL() {
        direction = 'L';
    }
    public void snakeMove(){
        for(int i = snakeElements; i > 0; i--){
            snakeXs[i] = snakeXs[i-1];
            snakeYs[i] = snakeYs[i-1];
        }
        switch (direction){
            case 'U':
                snakeYs[0] -= 25;
                break;
            case 'D':
                snakeYs[0] += 25;
                break;
            case 'L':
                snakeXs[0] -= 25;
                break;
            case 'R':
                snakeXs[0] += 25;
                break;
        }
    }
    public void drawSnake(Graphics g){
        for(int i = 0; i < snakeElements; i++){
            if(i == 0){
                g.setColor(new Color(108, 238, 126));
                g.fillRect(snakeXs[i],snakeYs[i],25,25);
            }
            else{
                g.setColor(new Color(32, 255, 0));
                g.fillRect(snakeXs[i],snakeYs[i],25,25);
            }
        }
    }

}
