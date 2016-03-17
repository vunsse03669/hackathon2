package Entities.Enemy;

import java.util.Vector;

/**
 * Created by Mr Hung on 3/16/2016.
 */
public class EnemyManager {
    private Vector<EnemyAbstract> vectorEnemy;
    private static EnemyManager sharePointer;

    private EnemyManager(){
        vectorEnemy = new Vector<>();
        vectorEnemy.add(new Dragon(1200,100));
        vectorEnemy.add(new Dragon(1100,300));
        vectorEnemy.add(new Dragon(1200,500));
        vectorEnemy.add(new Dragon(1400,600));
        vectorEnemy.add(new Dragon(1500,700));

    }

    public static EnemyManager getInstance(){
        if(sharePointer == null){
            sharePointer = new EnemyManager();
        }
        return sharePointer;
    }

    public Vector<EnemyAbstract> getVectorEnemy() {
        return vectorEnemy;
    }
}
