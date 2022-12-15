package service;

import model.Snake;

import java.awt.*;

public class Colision {

    Snake snake;
    public Colision(Snake mainSnake){
        snake = mainSnake;
    }

    public void checkColision(){
        for(int i = snake.getSnakeElements(); i > 0; i--){
            if(snake.getSnakeXonI(0) == snake.getSnakeXonI(i) && snake.getSnakeYonI(0) == snake.getSnakeYonI(i)){
                snake.running = false;
            }
        }

        if(snake.getSnakeXonI(0) < 0){
            snake.running = false;
        }
        if(snake.getSnakeXonI(0) > 800){
            snake.running = false;
        }
        if (snake.getSnakeYonI(0) > 800){
            snake.running = false;
        }
        if(snake.getSnakeYonI(0) < 0){
            snake.running = false;
        }

    }
    public void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 150);

        g.setColor(Color.red);
        g.setFont(small);
        g.drawString(msg, 0 , 400);
    }
}
