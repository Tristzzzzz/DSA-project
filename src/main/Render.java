package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Render {

    private GameScreen gameScreen;
    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;

    public Render(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        random = new Random();
        ImportImg();
        loadSprites();

    }

    public void render(Graphics g) {

        switch(GameStates.gameState){
            case MENU:
                for (int x = 0; x < 20; x++) {
                    for (int y = 0; y < 20; y++) {
                        g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);

                    }
                }
                break;
            case PLAYING:
                break;
            case SETTINGS:
                break;
        }
    }
    private void ImportImg() {
        InputStream is = getClass().getResourceAsStream("/res/spriteatlas.png");
        try {
            if (is != null) {
                img = ImageIO.read(is);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void loadSprites() {
        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 10; x++){
                sprites.add(img.getSubimage(x , y , 32, 32));
            }
        }
    }
    private int getRndInt(){
        return random.nextInt(100);
    }

}
