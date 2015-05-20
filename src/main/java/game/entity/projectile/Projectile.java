package game.entity.projectile;

import game.entity.Entity;

public class Projectile extends Entity{
    protected int damage;

    public void update(){
        position.add(movementRate);
    }

    public int getDamage(){
        return damage;
    }
}
