
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
public class Enemy3 extends EnemyAbstract {
    Animation anim, anim1;
    public Enemy3(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY3, 88, 58, 100);
        imageWidth = 88;
        imageHeight = 58;
        hp = 2;
    }

    @Override
    public void move() {
        this.positionY += 2;
        this.positionX -= 2;
    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}
