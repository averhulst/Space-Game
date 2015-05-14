package game.equipment;

import game.entity.Entity;
import game.entity.projectile.BasicBullet;

public class BasicGun implements Gun{
    private final short FIRE_INTERVAL_MS = 100;
    private long lastFire = 0;
    private int ammo = -1;

    public Entity shoot(){
        if(canShoot()){
            return new BasicBullet();
        }
        return null;
    }

    private boolean canShoot(){
        boolean canShoot = true;
        if(System.currentTimeMillis() - lastFire < FIRE_INTERVAL_MS){
            canShoot = false;
        }else{
            lastFire = System.currentTimeMillis();
        }

        if(ammo != -1 && ammo < 0){
            canShoot = false;
        }

        return canShoot;
    }
}
