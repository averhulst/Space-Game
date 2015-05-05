package game.entity;

import game.Game;
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

        yPosition = -image.getHeight() + Game.WINDOW_HEIGHT;
        xPosition = 0;
        speed = 1f;
    }

    public void update(){
        yPosition += speed;
    }

    public void render(){
        image.draw(xPosition, yPosition);
    }
}
