package GameState;

import GameHelper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public class MenuState extends GameState {
    private String [] options = {"START","HELP","ABOUT","EXIT"};
    private int currentSelection = 0;
    private BufferedImage sprite;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        try {
            sprite = ImageIO.read(new File("Resources/Image/background.jpg"));
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
        for(int i = 0; i < options.length;i++){
            if(i == currentSelection){
                g.setColor(Color.RED);
            }else{
                g.setColor(Color.green.WHITE);
            }

            g.setFont(new Font("Arial",Font.PLAIN,50));
            g.drawString(options[i], Helper.WIDTH/2-100, Helper.HEIGHT/2 - 100 + i*100);

        }
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_DOWN){
            currentSelection++;
            if(currentSelection > options.length-1){
                currentSelection = 0;
            }
        }else if(k == KeyEvent.VK_UP){
            currentSelection--;
            if(currentSelection < 0){
                currentSelection = options.length-1;
            }
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}
