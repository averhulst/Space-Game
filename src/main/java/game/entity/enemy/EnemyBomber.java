package game.entity.enemy;

import game.Vector;

public class EnemyBomber extends Enemy {
    public EnemyBomber(Vector position) {
        this.hitPoints = 90;
        this.position = position;
        this.speed = 1f;
        setImage("src/main/resources/enemies/enemy_bomber.png");
    }
    public void shoot(){

    }
}
