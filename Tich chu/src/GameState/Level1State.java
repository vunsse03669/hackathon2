package GameState;

import GameHelper.Helper;
import TileMap.TileMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public class Level1State extends GameState {
    private TileMap tileMap;
    public Level1State(GameStateManager gsm) {
        super(gsm);

    }

    @Override
    public void init() {
        tileMap = new TileMap(32);
        tileMap.loadTiles("Resources/TilesMap/grasstileset.gif");
        tileMap.loadMap("Resources/Map/level1-1.map");
        tileMap.setPosition(0,0);
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0, Helper.WIDTH,Helper.HEIGHT);
        tileMap.draw(g);
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
