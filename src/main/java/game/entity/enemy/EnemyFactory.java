package game.entity.enemy;

import game.Vector;
import game.entity.Entity;
import game.entity.unit.Unit;

public class EnemyFactory {
    public static Unit buildEnemy(String type, Vector origin){
        Unit enemy;
        switch (type) {
            case "fighter":
                enemy = new EnemyFighter(origin);

                break;
            case "bomber":
                enemy = new EnemyBomber(origin);
                break;
            default:
                throw new RuntimeException("unable to build enemy of type: " + type);
        }

        return enemy;
    }
}
