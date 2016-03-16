package Entities.Weapon;

import Entities.GameObject;

import java.awt.*;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public abstract class BulletAbstract extends WeaponAbstract {
    protected int speed;
    public BulletAbstract(double positionX, double positionY) {
        super(positionX, positionY);
    }
    public void update(){
        this.move();
    }
    public abstract void move();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
