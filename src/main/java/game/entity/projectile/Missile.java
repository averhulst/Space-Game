package game.entity.projectile;

import game.Vector;

public class Missile extends Projectile{
    public Missile() {
        this.damage = 20;
        this.movementRate = new Vector(0, -5f);
        setImage("src/main/resources/effects/basic_bullet.png");
    }
}
