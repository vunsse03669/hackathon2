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
public class Enemy2  extends EnemyAbstract {
    Animation anim, anim1;
    int speedX = 3;
    int speedY = 0;
    int e = 0;

    public Enemy2(double positionX, double positionY) {
        super(positionX, positionY);
        anim = new Animation(Helper.ENEMY2, 57, 36, 50);
        imageWidth = 57;
        imageHeight = 36;
        hp = 1;
    }

    public void move() {
        //Di chuyen tu phai qua trai.
        e++;
        this.positionY += 2 * Math.sin(e * Math.PI/96);
        this.positionX -= speedX;
    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}
