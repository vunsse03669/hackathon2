package Entities.Enemy;

import Entities.GameObject;
import Entities.Player.Player;
import Entities.Player.PlayerManager;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public abstract class EnemyAbstract extends GameObject {
    protected int speed;
    protected double imageWidth;
    protected double imageHeight;
    protected int hp;
    public EnemyAbstract(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        speed = Helper.ENEMY_SPEED;

    }
    @Override
    public void update() {
        this.move();
        if(collisionPlayer()){
            int hp = PlayerManager.getInstance().getPlayerFly().getHp();
            double dx = PlayerManager.getInstance().getPlayerFly().getPositionX();
            PlayerManager.getInstance().getPlayerFly().setHp(hp-1);
            PlayerManager.getInstance().getPlayerFly().setPositionX(dx-50);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }

    public abstract void move();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getImageWidth() {
        return imageWidth;
    }

    public double getImageHeight() {
        return imageHeight;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean collisionPlayer(){

        Rectangle rectPlayer = new Rectangle((int) PlayerManager.getInstance().getPlayerFly().getPositionX(),
                (int)PlayerManager.getInstance().getPlayerFly().getPositionY(),
                (int)PlayerManager.getInstance().getPlayerFly().getWidth(),
                (int)PlayerManager.getInstance().getPlayerFly().getHeight());
        Rectangle rectEnemy = new Rectangle((int)this.positionX,(int)this.positionY,(int)imageWidth,(int)imageHeight);

        return rectEnemy.intersects(rectPlayer);
    }
}