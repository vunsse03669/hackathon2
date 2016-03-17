package Entities.Weapon;

import Entities.Enemy.EnemyAbstract;
import Entities.Enemy.EnemyManager;
import Entities.GameObject;
import Entities.Player.Player;
import Entities.Player.PlayerAbstract;
import Entities.Player.PlayerManager;


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


    public boolean collisionEnemy(){

        boolean isCollision = false;
        Rectangle rectBullet = new Rectangle((int)this.positionX,(int)this.positionY,(int)this.getWidth(),(int)this.getHeight());
        for(EnemyAbstract enemy : EnemyManager.getInstance().getVectorEnemy()){
            Rectangle rectEnemy = new Rectangle((int)enemy.getPositionX(),(int)enemy.getPositionY(),
                    (int)enemy.getImageWidth(),(int)enemy.getImageHeight());
            if(rectBullet.intersects(rectEnemy)){
                enemy.setHp(enemy.getHp()- this.damage);
                if(enemy.getHp() <= 0){
                    EnemyManager.getInstance().getVectorEnemy().remove(enemy);
                }
                PlayerManager.getInstance().getPlayerFly().setScore( PlayerManager.getInstance().getPlayerFly().getScore()+10);
                isCollision = true;
                break;
            }
        }
        return isCollision;
    }

}
