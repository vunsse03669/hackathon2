package Entities.Weapon;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public class BulletPlayer extends BulletAbstract {

    public BulletPlayer(double positionX, double positionY) {
        super(positionX, positionY);
        this.damage = 5;
        try {
            this.sprite = ImageIO.read(new File("Resources/Image/player_bullet"));
        }catch(Exception e){}
    }

    @Override
    public void move() {

    }
}
