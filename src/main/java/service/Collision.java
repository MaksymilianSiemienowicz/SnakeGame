package service;

import model.Snake;

import java.awt.*;

public class Collision {

    Snake snake;
    public Collision(Snake mainSnake){
        snake = mainSnake;
    }

    public void checkCollision(){
        for(int i = snake.getSnakeElements(); i > 0; i--){
            if(snake.getSnakeXonI(0) == snake.getSnakeXonI(i) && snake.getSnakeYonI(0) == snake.getSnakeYonI(i)){
                snake.setSnakeRunning(false);
            }
        }

        if(snake.getSnakeXonI(0) < 0){
            snake.setSnakeRunning(false);
        }
        if(snake.getSnakeXonI(0) > 800){
            snake.setSnakeRunning(false);
        }
        if (snake.getSnakeYonI(0) > 800){
            snake.setSnakeRunning(false);
        }
        if(snake.getSnakeYonI(0) < 0){
            snake.setSnakeRunning(false);
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
