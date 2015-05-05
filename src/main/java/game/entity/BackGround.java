package game.entity;

import game.Game;
import game.Vector;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BackGround extends Entity {
    private Image image;

    public BackGround() {
        try {
            image = new Image("src/main/resources/background.png");
        } catch (SlickException e) {
            e.printStackTrace();
        }

        float yPosition = -image.getHeight() + Game.WINDOW_HEIGHT;
        float xPosition = 0;
        position = new Vector(xPosition, yPosition);
        speed = 1f;
    }

    public void update(){
        position.add(new Vector(0, speed));
    }

    public void render(){
        image.draw(position.getX(), position.getY());
    }
}
