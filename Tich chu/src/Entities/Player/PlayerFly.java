package Entities.Player;


import Entities.Sound.AudioPlayer;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Mr Hung on 3/15/2016.
 */
public class PlayerFly extends PlayerAbstract {
    private HashMap<String,AudioPlayer> sound;
    private boolean isFly;
    private int count = 0;
    private int speedY;
    private int speedX;
    public PlayerFly(double positionX, double positionY) {
        super(positionX, positionY);
        speedX = 0;
        speedY = 6;
        sound = new HashMap<String,AudioPlayer>();
        sound.put("jump",new AudioPlayer("Resources/Music/level1.mp3"));
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
                sound.get("jump").play();
            }
        }
        else{
            isFly = false;
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
