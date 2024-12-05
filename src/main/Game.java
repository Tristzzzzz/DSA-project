package main;

import inputs.KeyBoradListener;
import inputs.MyMouseListener;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;
    private Thread gameThread;

    private int updates;
    private long lastTimeUPS;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    private MyMouseListener myMouseListener;
    private KeyListener keyboardListener;

    public Game(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// frame in the middle of the screen

        gameScreen = new GameScreen(this);

        add(gameScreen);
        pack(); //set size for the window to make sure nothing is hiding

        setVisible(true);
    }

    private void initinput(){
        myMouseListener = new MyMouseListener();
        keyboardListener = new KeyBoradListener();

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);

        requestFocus();// focus on this particular component
    }


    private void start(){
        gameThread = new Thread(this){};

        gameThread.start();
}

    private void callUPS() {
        if (System.currentTimeMillis() - lastTimeUPS >= 1000){
            System.out.println("UPS:" + updates);
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
        }
    }

    private void updateGame() {
        updates++;

//        System.out.println("Game updated");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.initinput();
        game.start();

    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;
        long now;

        while(true) {

            now = System.nanoTime();
            //render
            if (now - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }
            //update
            if (now - lastUpdate >= timePerUpdate) {
                updateGame();
                lastUpdate = now;
                updates++;
            }

            if (System.currentTimeMillis() - lastTimeCheck >= 1000){
                System.out.println("FPS:" + frames + "|Updates:" + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
}
