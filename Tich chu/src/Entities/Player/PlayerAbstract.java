package Entities.Player;

import Entities.Animation;
import Entities.GameObject;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public abstract class PlayerAbstract extends GameObject {
    protected int speed;
    protected int hp;
    protected BufferedImage heart;

    public PlayerAbstract(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        hp = Helper.PLAYER_HP;
        speed = Helper.PLAYER_SPEED;
        try{
            this.sprite = ImageIO.read(new File("Resources/Image/TT1.png"));
            this.heart = ImageIO.read(new File("Resources/Image/heart.png"));
        }catch(Exception e){}
    }
    @Override
    public void update() {
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }

    public abstract void move();
    public abstract void keyPressed(int k);
    public abstract void keyRelased(int k);
    public abstract void keyTyped(int k);

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
