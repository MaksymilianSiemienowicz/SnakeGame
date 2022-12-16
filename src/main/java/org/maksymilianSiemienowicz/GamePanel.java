package org.maksymilianSiemienowicz;

import model.Apple;
import model.Snake;
import service.Collision;
import service.EatenApple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {


    private final Apple apple = new Apple();
    private final Snake snake = new Snake();
    Collision collision = new Collision(snake);
    EatenApple eatenApple = new EatenApple(apple, snake);
    private final int gamePanelWidth = 800;
    private final int gamePanelHeight = 800;
    private final int unitSize = 25;
    private final int delay = 100;
    Timer timer;

    public GamePanel() {
        settingUpGamePanel();
        startGame();
    }

    //FUNCTIONS
    private void settingUpGamePanel() {
        this.setSize(gamePanelWidth, gamePanelHeight);
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.setPreferredSize(new Dimension(800, 800));

    }

    private void startGame() {
        apple.setAppleXY();
        snake.setSnakeRunning(true);
        timer = new Timer(delay, this);
        timer.start();
    }

    //PAINTER
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawMatrix(g);
        drawTopLine(g);
        apple.drawApple(g);
        snake.drawSnake(g);
        if (!snake.getSnakeRunning()) {
            timer.stop();
            collision.gameOver(g);
        }
    }

    private void drawTopLine(Graphics g){
        g.setColor(Color.GRAY);
        g.drawLine(0,0,800,0);
    }

    private void drawMatrix(Graphics g) {
        for (int i = 0; i < gamePanelHeight; i++) {
            g.setColor(Color.white);
            g.drawLine(i * unitSize, 0, i * unitSize, gamePanelHeight);
        }

        for (int i = 0; i < gamePanelWidth; i++) {
            g.setColor(Color.white);
            g.drawLine(0, i * unitSize, gamePanelWidth, i * unitSize);
        }
    }

    //ACTION LISTENER
    @Override
    public void actionPerformed(ActionEvent e) {
        if (snake.getSnakeRunning()) {
            snake.snakeMove();
        }
        collision.checkCollision();
        eatenApple.checkEatApple();
        repaint();
    }


    //KEY-ADAPTER
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    if (snake.getSnakeDirection() != 'R') {
                        snake.setSnakeDirection('L');
                        System.out.println(snake.getSnakeDirection());
                    }
                    break;

                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    if (snake.getSnakeDirection() != 'L') {
                        snake.setSnakeDirection('R');
                        System.out.println(snake.getSnakeDirection());
                    }
                    break;

                case KeyEvent.VK_W:
                case KeyEvent.VK_UP:
                    if (snake.getSnakeDirection() != 'D') {
                        snake.setSnakeDirection('U');
                        System.out.println(snake.getSnakeDirection());
                    }
                    break;

                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    if (snake.getSnakeDirection() != 'U') {
                        snake.setSnakeDirection('D');
                        System.out.println(snake.getSnakeDirection());
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if(!snake.getSnakeRunning()){
                        ScorePanel.getInstance().setScorePoints(0);
                        snake.setSnakeElements(3);
                        snake.setSnakeYonI(0,0);
                        snake.setSnakeXonI(0,0);
                        snake.setSnakeDirection('R');
                        startGame();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}