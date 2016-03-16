package GameState;

import Entities.Player.PlayerFly;
import Entities.Player.PlayerManager;
import GameHelper.Helper;
import Main.GameManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Mr Hung on 3/15/2016.
 */
public class Level2State extends GameState {

    private BufferedImage background;
    private PlayerFly player;


    public Level2State(GameStateManager gsm) {
        super(gsm);
        player = PlayerManager.getInstance().getPlayerFly();
        try{
            this.background = ImageIO.read(new File("Resources/TilesMap/lv1.png"));

        }catch(Exception e){}
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        player.update();
        int loX = GameManager.getInstance().getLocationX();
        GameManager.getInstance().setLocationX(loX - Helper.PLAYER_SPEED);
        if(player.getPositionY() <= 0){
            player.setPositionY(player.getPositionY() + 10);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.background, GameManager.getInstance().getLocationX(),GameManager.getInstance().getLocationY(),null);
        player.draw(g);
    }

    @Override
    public void keyPressed(int k) {
        player.keyPressed(k);
    }

    @Override
    public void keyReleased(int k) {
        player.keyRelased(k);
    }

    @Override
    public void keyTyped(int k) {
        player.keyTyped(k);
    }
}
