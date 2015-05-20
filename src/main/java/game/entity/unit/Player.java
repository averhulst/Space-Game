package game.entity.unit;

import game.Game;
import game.Input;
import game.Vector;
import game.entity.Entity;
import game.entity.projectile.Projectile;
import game.equipment.BasicGun;
import game.equipment.Gun;
import java.util.List;

public class Player extends Unit {

    private String sideToFireFrom = "left";
    private Gun gun = new BasicGun();

    public Player() {
        setImage("src/main/resources/player.png");
        shieldPoints = 25;
        hitPoints = 100;

        float xPosition = Game.WINDOW_HEIGHT / 2;
        float yPosition = Game.WINDOW_WIDTH/ 2;
        position = new Vector(xPosition, yPosition);
        speed = 5f;
    }

    public List<Projectile> getFiredProjectiles(){
        return firedProjectiles;
    }

    public void update(){
        super.update();
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
            shoot();
        }

        move(desiredMove);
    }

    public void shoot(){
        Vector bulletInitialLocation = new Vector(0,0);

        Projectile projectile = gun.shoot();
        if(projectile != null){

            if(sideToFireFrom.equals("left")){
                bulletInitialLocation.add(new Vector(position.getX(), position.getY()));
                sideToFireFrom = "right";
            }else{
                bulletInitialLocation.add(new Vector(position.getX() + width, position.getY()));
                sideToFireFrom = "left";
            }

            projectile.setPosition(bulletInitialLocation);
            firedProjectiles.add(projectile);
        }
    }

}
