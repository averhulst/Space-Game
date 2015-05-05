package game.entity;

import game.Game;
import game.Input;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Entity{

    public Player() {
        try {
            image = new Image("src/main/resources/player.png");
            height = image.getHeight();
            width = image.getWidth();
        } catch (SlickException e) {
            e.printStackTrace();
        }

        yPosition = Game.WINDOW_HEIGHT / 2;
        xPosition = Game.WINDOW_WIDTH/ 2;
        speed = 5f;
    }

    public void update(){
        if(Input.isKeyDown(Input.KEY_UP) || Input.isKeyDown(Input.KEY_W)){
            yPosition -= speed;
        }
        if(Input.isKeyDown(Input.KEY_DOWN) || Input.isKeyDown(Input.KEY_S)){
            yPosition += speed;
        }
        if(Input.isKeyDown(Input.KEY_LEFT) || Input.isKeyDown(Input.KEY_A)){
            xPosition -= speed;
        }
        if(Input.isKeyDown(Input.KEY_RIGHT) || Input.isKeyDown(Input.KEY_D)){
            xPosition += speed;
        }
    }

    public void render(){
        image.draw(xPosition, yPosition);
    }
}
