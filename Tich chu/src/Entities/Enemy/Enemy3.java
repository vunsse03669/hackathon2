/*
* DaiTQ.
* Minion di chuyen tu tren xuong duoi
* Yeu cau dat lai vi tri va thoi gian xuat hien minion cho phu hop.
* */

package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;
import GameState.Help;

import java.awt.*;


/**
 * Created by Quang Đại on 16/3/2016.
 */
public class Enemy3 extends EnemyAbstract {
    Animation anim, anim1;
    int speedX = 1;
    int speedY = 2;

    public Enemy3() {
        anim = new Animation(Helper.ENEMY2, 57, 36, 50);
        //66, 51, 50 with Enemy1
        //55, 36, 50 with Enemy2
        //88, 58, 50 with Enemy3
        //108, 62, 50 with Enemy4
        //Yeu cau sua lai vi tri va thoi gian xuat hien.
        setPositionX(500);
        setPositionY(100);
    }

    public void move() {
        //Di chuyen tu tren xuong duoi
        this.positionY += speedY;
    }

    @Override
    public void update() {
        this.move();

    }

    @Override
    public void draw(Graphics g) {
        anim.draw(g, (int) this.positionX, (int) this.positionY);
    }
}
