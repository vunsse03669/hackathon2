package Entities.Enemy;

import Entities.Animation;

import java.awt.*;

/**
 * Created by chtnnnmtgkyp on 3/17/2016.
 */
public class Fly extends EnemyAbstract{
    private int angle = 0;
    Animation animation;

    public Fly(double positionX, double positionY) {
        super(positionX, positionY);

        animation = new Animation("Resources/Image/Ruoi.png",178,149,50);
    }


    @Override
    public void move() {
        angle++;
        this.positionX += (double) (5 * Math.sin(angle * 0.09));
        this.positionY += (double) (5 * Math.cos(angle * 0.09));

    }
    public void draw(Graphics g){
        animation.draw(g,(int)positionX , (int)positionY );
    }
}
