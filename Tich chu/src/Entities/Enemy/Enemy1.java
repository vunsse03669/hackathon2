//65, 51, 50 with Enemy1
//57, 36, 50 with Enemy2
//88, 58, 50 with Enemy3
//108, 62, 50 with Enemy4
//144, 78, 30 with Enemy5       
//90, 111, 70 with Enemy6
//166, 118, 70 with Enemy7

package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/17/2016.
 */
public class Enemy1 extends EnemyAbstract {
    Animation anim;

    public Enemy1(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY1, 65, 51, 100);
        imageWidth = 65;
        imageHeight = 51;
        hp = 2;
    }

    public void move() {
        //Di chuyen tu phai qua trai.
        this.positionX -= Helper.ENEMY1_SPEED;
    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}

