package Entities.Enemy;

/**
 * Created by chtnnnmtgkyp on 3/16/2016.
 */
public class EnemyManager {
    private BeeBrown beeBrown;
    private static EnemyManager sharePointer;

    private EnemyManager(){
        beeBrown = new BeeBrown(200,200);
    }
    public static EnemyManager getInstance(){
        if(sharePointer == null){
            sharePointer = new EnemyManager();
        }
        return sharePointer;
    }

    public BeeBrown getBeeBrown() {
        return beeBrown;
    }

}
