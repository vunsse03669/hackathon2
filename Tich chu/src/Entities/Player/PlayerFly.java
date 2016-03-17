package Entities.Player;


import Entities.Animation;
import Entities.Sound.AudioPlayer;
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
        animation = new Animation("Resources/Image/player.png",216,200,100);
       // sound = new HashMap<String,AudioPlayer>();
      //  sound.put("jump",new AudioPlayer("Resources/Music/level1.mp3"));
    }

    @Override
    public void move(){

        positionX+=speedX;

        if(isFly){
            positionY -= speedY;
            //positionX += this.speedX;
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

    }

    public void draw(Graphics g){
        animation.draw(g,(int)positionX ,(int)positionY );
        for(int i = 0; i < this.hp; i++){
            g.drawImage(this.heart,20 + i*32,50,null);
        }
    }

    @Override
    public void keyRelased(int k) {
        isFly = false;
        count = 0;
    }

    @Override
    public void keyTyped(int k) {
        if(k == KeyEvent.VK_A)
            System.out.println("xxx");
    }
}
