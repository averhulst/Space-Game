package game.equipment;

import game.entity.Entity;
import game.entity.projectile.BasicBullet;

public abstract class BaseGun implements Gun{
    protected short fireIntervalMs = 100;
    protected long lastFire = 0;
    protected int ammo = -1;



    protected boolean canShoot(){
        boolean canShoot = true;
        if(System.currentTimeMillis() - lastFire < fireIntervalMs){
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
