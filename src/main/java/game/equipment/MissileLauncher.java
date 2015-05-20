package game.equipment;

import game.entity.Entity;
import game.entity.projectile.BasicBullet;
import game.entity.projectile.Projectile;

public class MissileLauncher extends BaseGun{
    public MissileLauncher() {
        this.fireIntervalMs = 800;
    }

    public Projectile shoot(){
        if(canShoot()){
            return new BasicBullet();
        }
        return null;
    }

}
