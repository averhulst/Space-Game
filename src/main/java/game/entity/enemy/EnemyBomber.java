package game.entity.enemy;

import game.Vector;
import game.entity.unit.Unit;

public class EnemyBomber extends Unit {
    public EnemyBomber(Vector position) {
        this.hitPoints = 90;
        this.position = position;
        setImage("src/main/resources/enemies/enemy_bomber.png");
    }
    public void shoot(){

    }
}
