package Main;

import GameHelper.Helper;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Graphics seconds;
    Image image;

    public GameWindow(){
        this.setGame();
        this.init();
    }

    public void setGame(){
        this.setTitle("Tich Chu saves her grandmother");
        this.setSize(Helper.WIDTH,Helper.HEIGHT);
        this.setVisible(true);
        this.setLocation(200,100);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    public void init(){

    }

    @Override
    public void run() {

    }

    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds= image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
}
