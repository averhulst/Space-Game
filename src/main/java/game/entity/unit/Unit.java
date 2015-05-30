package game.entity.unit;

import game.entity.Entity;
import game.entity.projectile.Projectile;
import game.equipment.Gun;
import java.util.ArrayList;
import java.util.List;

public abstract class Unit extends Entity {
    protected boolean isAlive = true;
    protected short hitPoints;
    protected short shieldPoints;
    protected List<Projectile> firedProjectiles;
    protected Gun gun;
    public float alpha_HACK = 1f;

    public abstract void shoot();

    public void applyDamage(int damage){
        int remainingDamage = damageShieldPoints(damage);
        if(remainingDamage > 0){
            damageHitPoints(remainingDamage);
        }
    }

    private int damageShieldPoints(int damage){
        int remainingDamage;

        if(shieldPoints > 0){
            if(shieldPoints > damage){
                remainingDamage = 0;
                shieldPoints -= damage;
            }else{
                remainingDamage = damage - shieldPoints;
                shieldPoints = 0;
            }
        }else{
            remainingDamage = damage;
        }

        return remainingDamage;
    }

    private void damageHitPoints(int damage){
        if(damage > hitPoints){
            kill();
        }else{
            hitPoints -= damage;
        }
    }

    public void kill(){
        setImage("src/main/resources/effects/explosion0.png");
    }

    public void update(){
        firedProjectiles =  new ArrayList<>();
        if(hitPoints <= 0){
            if(isAlive){
                kill();
                isAlive = false;
            }
            alpha_HACK -= 0.01f;
            image.setAlpha(alpha_HACK);
        }
    }

    public void setGunType(Gun gun){
        this.gun = gun;
    }


}
