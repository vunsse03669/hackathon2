package GameState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public class Help extends GameState {
    BufferedImage sprite;
    public Help(GameStateManager gsm) {
        super(gsm);
        try {
            sprite = ImageIO.read(new File("Resources/Image/help.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite,0,0,null);
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_B){
            gsm.states.pop();
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}
