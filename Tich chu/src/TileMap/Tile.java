package TileMap;

import java.awt.image.BufferedImage;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public class Tile {
    private BufferedImage image;
    private int type;

    public Tile(BufferedImage image, int type) {
        this.image = image;
        this.type = type;
    }

    // tile type
    public static final int NORMAL = 0;
    public static final int BLOCKED = 1;

    public BufferedImage getImage() {
        return image;
    }

    public int getType() {
        return type;
    }
}
