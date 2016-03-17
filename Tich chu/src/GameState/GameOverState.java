package GameState;

import GameHelper.Helper;

import java.awt.*;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public class GameOverState extends GameState {
    public GameOverState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.setFont(new Font("Arial Black",Font.PLAIN,50));
        g.drawString("Game Over", Helper.WIDTH/2-100, Helper.HEIGHT/2 - 100 );
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void keyTyped(int k) {

    }
}
