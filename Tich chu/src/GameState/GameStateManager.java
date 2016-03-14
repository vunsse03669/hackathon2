package GameState;

import java.awt.*;
import java.util.Stack;

/**
 * Created by Mr Hung on 3/14/2016.
 */
public class GameStateManager {
    private Stack<GameState> states;

    public GameStateManager(){
        states = new Stack<GameState>();
        states.push(new MenuState(this));
    }

    public void draw(Graphics g){
        states.peek().draw(g);
    }

    public void tick(){
        states.peek().tick();
    }

    public void keyPressed(int k){
        states.peek().keyPressed(k);
    }

    public void keyRelased(int k){
        states.peek().keyReleased(k);
    }
}
