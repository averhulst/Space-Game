package game.entity.enemy;

import game.Vector;

public class EnemyFighter extends Enemy {
    public EnemyFighter(Vector position) {
        this.hitPoints = 60;
        this.position = position;
        this.speed = 2f;
        setImage("src/main/resources/enemies/enemy_fighter.png");
    }
    public void shoot(){

    }
}
