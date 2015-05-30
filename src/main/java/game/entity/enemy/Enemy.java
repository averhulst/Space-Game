package game.entity.enemy;

import game.Game;
import game.Vector;
import game.entity.unit.Unit;

public abstract class Enemy extends Unit {
    private Direction directionOfTravel;
    private short distanceTraveled;
    private short travelLeash = 100;

    public Enemy(){
        directionOfTravel = getRandomDirection();
    }

    public void update(){
        super.update();

        Vector desiredMovement = new Vector(0,0);
        switch (directionOfTravel){
            case UP:
                desiredMovement.subtract(new Vector(0, speed));
                break;
            case DOWN:
                if(position.getY() < Game.WINDOW_HEIGHT * .2){
                    desiredMovement.add(new Vector(0, speed));
                }
                break;
            case LEFT:
                desiredMovement.subtract(new Vector(speed, speed));
                break;
            case RIGHT:
                desiredMovement.add(new Vector(speed, speed));
                break;
            default:
                throw new RuntimeException("Unrecognized direction of travel");
        }

        distanceTraveled += speed;
        if(isAlive){
            move(desiredMovement);
        }


        if(distanceTraveled > travelLeash){
            decideDirectionOfTravel();
            distanceTraveled = 0;
        }
    }

    public void decideDirectionOfTravel(){
        Direction newDirection = getRandomDirection();
        while(newDirection == directionOfTravel){
            newDirection = getRandomDirection();
        }
        directionOfTravel = newDirection;
    }
    public Direction getRandomDirection(){
        int randomNum = (int)(Math.random() * 3 + 1);
        return Direction.values()[randomNum];

    }
}
