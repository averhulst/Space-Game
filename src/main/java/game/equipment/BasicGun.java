package game.equipment;

import game.entity.Entity;
import game.entity.projectile.BasicBullet;
import game.entity.projectile.Projectile;

public class BasicGun extends BaseGun{
    public Projectile shoot(){
        if(canShoot()){
            return new BasicBullet();
        }
        return null;
    }
}
