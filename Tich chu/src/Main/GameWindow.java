package Main;

import java.awt.*;

/**
 * Created by Mr Hung on 3/13/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Graphics seconds;
    Image image;

    public GameWindow(){

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
