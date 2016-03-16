package Entities.Player;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public class PlayerManager {
    private PlayerFly playerFly;
    private Player player;
    private static PlayerManager sharePointer;

    private PlayerManager(){
        playerFly = new PlayerFly(100,200);
        player = new Player(100,200);
    }

    public static PlayerManager getInstance(){
        if(sharePointer == null){
            sharePointer = new PlayerManager();
        }
        return sharePointer;
    }

    public PlayerFly getPlayerFly() {
        return playerFly;
    }

    public Player getPlayer() {
        return player;
    }
}
