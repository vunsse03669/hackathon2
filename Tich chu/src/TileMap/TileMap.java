package TileMap;

import GameHelper.Helper;
import GameState.Help;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public class TileMap {
    private double positionX;
    private double positionY;
    //bound
    private int xmin;
    private int ymin;
    private int xmax;
    private int ymax;

    private double tween;
    //map
    private int [][] map;
    private int tileSize;
    private int numRow;
    private int numCol;
    private int width;
    private int height;

    // tileset
    private BufferedImage tileset;
    private int numTilesAcross;
    private Tile[][] tiles;

    // drawing
    private int colOffset;
    private int rowOffset;
    private int numRowsToDraw;
    private int numColsToDraw;

    public TileMap(int tileSize){
        this.tileSize = tileSize;
        numRowsToDraw = Helper.HEIGHT/tileSize + 2;
        numColsToDraw = Helper.WIDTH/tileSize + 2;
        tween = 0.07;
    }

    public void loadTiles(String s){
        try{
            tileset = ImageIO.read(getClass().getResourceAsStream(s));
            numTilesAcross = tileset.getWidth()/tileSize;
            tiles = new Tile[2][numTilesAcross];

            BufferedImage subImage;
            for(int col = 0; col < numTilesAcross; col++){
                subImage = tileset.getSubimage(col*tileSize,0,tileSize,tileSize);
                tiles[0][col] = new Tile(subImage,Tile.NORMAL);
                subImage = tileset.getSubimage(col*tileSize,tileSize,tileSize,tileSize);
                tiles[1][col] = new Tile(subImage,Tile.BLOCKED);
            }
        }catch(Exception e){}

    }

    public void loadMap(String s){
        try{
            InputStream in = getClass().getResourceAsStream(s);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            numCol = Integer.parseInt(br.readLine());
            numRow = Integer.parseInt(br.readLine());
            map = new int[numRow][numCol];
            width = numCol*tileSize;
            height = numRow*tileSize;

            String delims = "\\s+";
            for(int row = 0; row < numRow; row++){
                String line = br.readLine();
                String[] token = line.split(delims);
                for(int col = 0; col < numCol; col++){
                    map[row][col] = Integer.parseInt(token[col]);
                }
            }

        }catch(Exception e){}
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getX(){
        return (int) this.positionX;
    }
    public int getY(){
        return (int)this.positionY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getType(int row, int col){
        int rc = map[row][col];
        int r = rc/numTilesAcross;
        int c = rc%numTilesAcross;

        return tiles[r][c].getType();
    }

    public void setPosition(int x, int y){
        this.positionX += (x - this.positionX)*tween;
        this.positionX += (y - this.positionY)*tween;
        this.fixBound();

        colOffset = (int) -this.positionX/tileSize;
        rowOffset = (int) -this.positionY/tileSize;
    }

    private void fixBound(){
        if(this.positionX < xmin) positionX = xmin;
        if(this.positionY < ymin) positionX = xmin;
        if(this.positionX > xmax) positionX = xmax;
        if(this.positionY >ymax)  positionY = ymax;
    }

    public void draw(Graphics g){
        for(int row = rowOffset; row < rowOffset+numRowsToDraw;row++){
            if(row >= numRow) break;
            for(int col = colOffset; col < colOffset+numColsToDraw;col++){
                if(col >= numCol) break;
                if(map[row][col] == 0) continue;

                int rc =    map[row][col];
                int r = rc/numTilesAcross;
                int c = rc%numTilesAcross;

                g.drawImage(tiles[r][c].getImage(),(int)positionX + col*tileSize,
                        (int)positionY + row*tileSize ,null);

            }
        }
    }
}
