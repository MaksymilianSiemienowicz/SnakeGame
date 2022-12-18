package service;

import model.Snake;

import java.awt.*;

public class Collision {

    Snake snake;
    public Collision(Snake mainSnake){
        this.snake = mainSnake;
    }

    public void checkCollision(){
        for(int i = snake.getSnakeElements(); i > 0; i--){
            if(snake.getSnakeXonI(0) == snake.getSnakeXonI(i) && snake.getSnakeYonI(0) == snake.getSnakeYonI(i)){
                snake.setSnakeRunning(false);
            }
        }

        if(snake.getSnakeXonI(0) < 0){
            snake.setSnakeXonI(0,800);
        }
        else if(snake.getSnakeXonI(0) >= 800){
            snake.setSnakeXonI(0,0);
        }
        else if (snake.getSnakeYonI(0) >= 800){
            snake.setSnakeYonI(0,0);
        }
        else if(snake.getSnakeYonI(0) < 0){
            snake.setSnakeYonI(0,800);
        }

    }


    public void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 150);

        g.setColor(Color.red);
        g.setFont(small);
        g.drawString(msg, 0 , 400);
        String tryAgain ="Press enter to try again...";
        g.setColor(Color.red);
        Font tryAgainFont = new Font("Helvetica", Font.BOLD, 50);
        g.setFont(tryAgainFont);
        g.drawString(tryAgain,100,600);
    }
}