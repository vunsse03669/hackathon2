/*
* DaiTQ.
* Minion di chuyen tu phai qua trai theo hinh Sin.
* Yeu cau dat lai vi tri va thoi gian xuat hien minion cho phu hop.
* */


package Entities.Enemy;

import Entities.Animation;
import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Quang Đại on 16/3/2016.
 */
public class Enemy2 extends EnemyAbstract {
    Animation anim, anim1;
    int speedX = 1;
    int speedY = 0;
    int e = 0;

    public Enemy2() {
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
        //Di chuyen tu phai qua trai.
        e++;
        this.positionY += 2 * Math.sin(e * Math.PI/96);
        this.positionX -= speedX;
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
