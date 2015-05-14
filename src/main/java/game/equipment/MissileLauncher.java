package game.equipment;

import game.entity.Entity;
import game.entity.projectile.BasicBullet;

public class MissileLauncher extends BaseGun{
    public MissileLauncher() {
        this.fireIntervalMs = 800;
    }

    public Entity shoot(){
        if(canShoot()){
            return new BasicBullet();
        }
        return null;
    }

}
