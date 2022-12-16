package service;

import model.Apple;
import model.Snake;
import org.maksymilianSiemienowicz.ScorePanel;

public class EatenApple {
    Snake snake;
    Apple apple;

    ScorePanel scorePanel;

    public EatenApple(Apple apple, Snake snake) {
        this.snake = snake;
        this.apple = apple;
    }

    public void checkEatApple() {
        if (snake.getSnakeXonI(0) == apple.getAppleX() && snake.getSnakeYonI(0) == apple.getAppleY()) {
            apple.setAppleXY();
            snake.setSnakeElements(snake.getSnakeElements() + 1);
            ScorePanel.getInstance().setScorePoints(ScorePanel.getInstance().getScorePoints() + 1);
            System.out.println(ScorePanel.getInstance().getScorePoints());
            //ADD POINTS METHOD
        }
    }
}
