package org.maksymilianSiemienowicz;

import model.Apple;
import model.Snake;
import service.Colision;
import service.EatenApple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {


    private Apple apple = new Apple();
    private Snake snake = new Snake();
     Colision colision= new Colision(snake);
     EatenApple eatenApple = new EatenApple(apple, snake);
    private final int gamePanelWidth = 800;
    private final int gamePanelHeight = 800;
    private final int unitSize = 25;
    private final int delay = 75;
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
        this.setPreferredSize(new Dimension(800,800));

    }

    private void startGame() {
        apple.setAppleXY();
        snake.running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    //PAINTER
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       //drawMatrix(g);
        apple.drawApple(g);
        snake.drawSnake(g);
        if(!snake.running){
           colision.gameOver(g);
        }
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
        if (snake.running) {
            snake.snakeMove();
        }
        colision.checkColision();
        eatenApple.checkEatApple();
        repaint();
    }


    //KEY-ADAPTER
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    if (snake.getSnakeDirection() != 'R') {
                        snake.setSnakeDirection('L');
                        System.out.println(snake.getSnakeDirection());
                    }

                case KeyEvent.VK_D:
                    if (snake.getSnakeDirection() != 'L') {
                        snake.setSnakeDirection('R');
                        System.out.println(snake.getSnakeDirection());
                    }

                case KeyEvent.VK_W:
                    if (snake.getSnakeDirection() != 'D') {
                        snake.setSnakeDirection('U');
                        System.out.println(snake.getSnakeDirection());
                    }

                case KeyEvent.VK_S:
                    if (snake.getSnakeDirection() != 'U') {
                        snake.setSnakeDirection('D');
                        System.out.println(snake.getSnakeDirection());
                    }
                default:
                    break;
                }
            }
        }
    }