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
        vectorEnemy.add(new Dragon(3000,200));
        vectorEnemy.add(new Dragon(3500,800));
        vectorEnemy.add(new Dragon(4000,500));

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                vectorEnemy.add(new Enemy3(500 +j*100,100 + i*100));
                vectorEnemy.add(new Enemy2(2000+j*100,100 + i*100));
                vectorEnemy.add(new Enemy1(5500+j*100,100 + i*100));
            }
        }


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
