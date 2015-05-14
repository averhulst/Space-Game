package game.equipment;

import game.entity.Entity;
import game.entity.projectile.BasicBullet;

public class BasicGun extends BaseGun{
    public Entity shoot(){
        if(canShoot()){
            return new BasicBullet();
        }
        return null;
    }
}
