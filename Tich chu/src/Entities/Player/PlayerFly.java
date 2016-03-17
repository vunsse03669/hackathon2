package Entities.Player;


import Entities.Animation;
import Entities.Sound.AudioPlayer;
import Entities.Weapon.BulletAbstract;
import Entities.Weapon.BulletManager;
import Entities.Weapon.BulletPlayerLv1;
import GameHelper.Helper;
import GameState.Help;
import Main.GameManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Mr Hung on 3/15/2016.
 */
public class PlayerFly extends PlayerAbstract {
  //  private HashMap<String,AudioPlayer> sound;
    private boolean isFly;
    private int count = 0;
    private int speedY;
    private int speedX;
    Animation animation;
    public PlayerFly(double positionX, double positionY) {
        super(positionX, positionY);
        speedX = 0;
        speedY = 6;
        animation = new Animation(Helper.PLAYER_FLY,216,200,100);
       // sound = new HashMap<String,AudioPlayer>();
      //  sound.put("jump",new AudioPlayer("Resources/Music/level1.mp3"));
    }

    @Override
    public void move(){

        positionX+=speedX;

        if(isFly){
            positionY -= speedY;
        }else{
            positionY += this.speedY-2;
        }
    }

    @Override
    public void keyPressed(int k) {
        count++;
        if(count <= 5){
            if(k == KeyEvent.VK_SPACE){
                isFly = true;
               // sound.get("jump").play();
            }
        }
        else{
            isFly = false;
        }

        if(k == KeyEvent.VK_Z){
            if(count <= 5){
                this.shot();}
        }
    }

    public void draw(Graphics g){
        animation.draw(g,(int)positionX ,(int)positionY );
        for(int i = 0; i < this.hp; i++){
            g.drawImage(this.heart,20 + i*32,50,null);
        }
        for(BulletAbstract bullet : BulletManager.getInstance().getVectorBulelt()){
            bullet.draw(g);
        }
        g.setFont(new Font("Arial Black",Font.PLAIN,20));
        g.drawString("Score: "+this.score, Helper.WIDTH - 200, 100);
    }

    @Override
    public void keyRelased(int k) {
        isFly = false;
        count = 0;
    }

    @Override
    public void keyTyped(int k) {}

    @Override
    public void shot() {
        BulletManager.getInstance().getVectorBulelt().add(new BulletPlayerLv1(this.positionX+getWidth()+20,this.positionY +getHeight()/2+20));
    }
}
