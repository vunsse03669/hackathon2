package Entities.Enemy;

import Entities.GameObject;
import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public abstract class EnemyAbstract extends GameObject {
    protected int speed;

    public EnemyAbstract(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        speed = Helper.ENEMY_SPEED;
        try{
            this.sprite = ImageIO.read(new File("Resources/Image/DragonFly.png"));
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
