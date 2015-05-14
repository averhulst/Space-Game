package game.entity.unit.enemy;

import game.entity.Entity;

public class EnemyFactory {
    public Entity buildEnemy(String type){
        Entity enemy;
        switch (type) {
            case "fighter":
                enemy = new EnemyFighter();

                break;
            case "bomber":
                enemy = new EnemyBomber();
                break;
            default:
                throw new RuntimeException("unable to build enemy of type: " + type);
        }

        return enemy;
    }
}
