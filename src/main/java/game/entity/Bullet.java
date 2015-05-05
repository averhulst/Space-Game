package game.entity;

import game.Game;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet extends Entity{

    public Bullet() {
        try {
            image = new Image("src/main/resources/effects/basic_bullet.png");
            height = image.getHeight();
            width = image.getWidth();
        } catch (SlickException e) {
            e.printStackTrace();
        }

        speed = 5f;
    }

    public void update(){

    }
    public void render(){
        image.draw(position.getX(), position.getY());
    }
}
