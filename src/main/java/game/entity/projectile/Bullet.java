package game.entity.projectile;

import game.Vector;
import game.entity.Entity;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet extends Entity{

    public Bullet(Vector position) {
        this.position = position;
        this.movementVector = new Vector(0, -5f);

        try {
            this.image =  new Image("src/main/resources/effects/basic_bullet.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        position.add(movementVector);
    }
    public void render(){
        image.draw(position.getX(), position.getY());
    }
}
