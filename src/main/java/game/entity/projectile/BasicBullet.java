package game.entity.projectile;

import game.Vector;

public class BasicBullet extends Projectile{
    public BasicBullet(){
        this.damage = 2;
        this.movementRate = new Vector(0, -5f);
        setImage("src/main/resources/effects/basic_bullet.png");
    }
}
