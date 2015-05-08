package game.entity;

import game.Game;
import game.Input;
import game.Vector;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import game.entity.projectile.Bullet;
import java.util.ArrayList;
import java.util.List;

public class Player extends Entity{
    private List<Entity> firedProjectiles;
    private String sideToFireFrom = "left";

    public Player() {
        try {
            image = new Image("src/main/resources/player.png");
            height = image.getHeight();
            width = image.getWidth();
        } catch (SlickException e) {
            e.printStackTrace();
        }

        float xPosition = Game.WINDOW_HEIGHT / 2;
        float yPosition = Game.WINDOW_WIDTH/ 2;
        position = new Vector(xPosition, yPosition);
        speed = 5f;
    }

    public List<Entity> getFiredProjectiles(){
        return firedProjectiles;
    }

    public void update(){
        firedProjectiles =  new ArrayList<>();
        Vector desiredMove = new Vector(0,0);

        if(Input.isKeyDown(Input.KEY_UP) || Input.isKeyDown(Input.KEY_W)){
            desiredMove.subtract(new Vector(0, speed));
        }
        if(Input.isKeyDown(Input.KEY_DOWN) || Input.isKeyDown(Input.KEY_S)){
            desiredMove.add(new Vector(0, speed));
        }
        if(Input.isKeyDown(Input.KEY_LEFT) || Input.isKeyDown(Input.KEY_A)){
            desiredMove.subtract(new Vector(speed, 0));
        }
        if(Input.isKeyDown(Input.KEY_RIGHT) || Input.isKeyDown(Input.KEY_D)){
            desiredMove.add(new Vector(speed, 0));
        }

        if(Input.isKeyDown(Input.KEY_SPACE)){
            shootBullet();
        }

        move(desiredMove);
    }

    public void render(){
        image.draw(position.getX(), position.getY());
    }

    public void shootBullet(){
        Vector bulletInitalLocation = new Vector(0,0);

        if(sideToFireFrom.equals("left")){
            bulletInitalLocation.add(new Vector(position.getX(), position.getY()));
            sideToFireFrom = "right";
        }else{
            bulletInitalLocation.add(new Vector(position.getX() + width, position.getY()));
            sideToFireFrom = "left";
        }

        Bullet bullet = new Bullet(bulletInitalLocation);

        firedProjectiles.add(bullet);
    }

}
