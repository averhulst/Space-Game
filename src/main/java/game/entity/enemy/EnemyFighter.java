package game.entity.enemy;

import game.Vector;
import game.entity.unit.Unit;

public class EnemyFighter extends Unit {
    public EnemyFighter(Vector position) {
        this.hitPoints = 60;
        this.position = position;
        setImage("src/main/resources/enemies/enemy_fighter.png");
    }
    public void shoot(){

    }
}
