package GameState;

import Entities.Enemy.Dragon;
import Entities.Enemy.EnemyAbstract;
import Entities.Enemy.EnemyManager;
import Entities.Player.PlayerFly;
import Entities.Player.PlayerManager;
import GameHelper.Helper;
import Main.GameManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

/**
 * Created by Mr Hung on 3/15/2016.
 */
public class Level2State extends GameState {

    private BufferedImage background;
    private PlayerFly player;
    Vector<EnemyAbstract> vectorEnemy;

    public Level2State(GameStateManager gsm) {
        super(gsm);
        player = PlayerManager.getInstance().getPlayerFly();
        vectorEnemy = EnemyManager.getInstance().getVectorEnemy();
        try{
            this.background = ImageIO.read(new File(Helper.BACKGROUND_LV1));

        }catch(Exception e){}
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        player.update();
        int loX = GameManager.getInstance().getLocationX();
        if(GameManager.getInstance().getLocationX() >= -background.getWidth()+Helper.WIDTH){
            GameManager.getInstance().setLocationX(loX - Helper.PLAYER_SPEED);
        }
        //check va cham tren
        if(player.getPositionY() <= 0){
            player.setPositionY(player.getPositionY() + 10);
        }
        // gamve over
        if(player.getPositionY() + player.getSprite().getHeight() >= Helper.HEIGHT || player.getHp() <= 0){
            gsm.states.pop();
            gsm.states.push(new GameOverState(gsm));
        }
        for(EnemyAbstract enemy : vectorEnemy){
            enemy.update();
            if(enemy.getPositionX() <= 0){
                vectorEnemy.remove(enemy);
                return;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.background, GameManager.getInstance().getLocationX(),GameManager.getInstance().getLocationY(),null);
        player.draw(g);
        for(EnemyAbstract enemy : vectorEnemy){
            enemy.draw(g);
        }
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
