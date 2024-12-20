package managers;

import helpz.LoadSave;
import objects.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager {

    public Tile GRASS,WATER,ROAD;
    public BufferedImage atlas;
    public ArrayList<Tile> titles = new ArrayList<>();

    public TileManager() {

        loadAtlas();
        creatTiles();
    }

    private void creatTiles() {

        titles.add(GRASS = new Tile(getSprite(9,0)));
//        titles.add(WATER = new Tile(getSprite(0,0)));
//        titles.add(ROAD = new Tile(getSprite(8,0)));
    }

    private void loadAtlas() {
        atlas = LoadSave.getSpriteAtlas();
    }

    public BufferedImage getSprite(int id) {
        return titles.get(id).getSprite();
    }

    private BufferedImage getSprite(int xCord, int yCord) {
        return atlas.getSubimage(xCord * 32,yCord * 32,32,32);
    }
}
