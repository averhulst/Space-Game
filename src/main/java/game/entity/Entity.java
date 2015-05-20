package game.entity;

import game.Game;
import game.Vector;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Entity {
    protected Vector position;
    protected Vector movementRate;
    protected float speed;
    protected float width;
    protected float height;
    protected Image image;

    public abstract void update();

    public void render(){
        image.draw(position.getX(), position.getY());
    };

    public void setPosition(Vector position){
        this.position = position;
    }

    public float getXPosition() {
        return position.getX();
    }

    public void setXPosition(float x) {
        this.position.setX(x);
    }

    public float getYPosition() {
        return position.getY();
    }

    public void setYPosition(float y) {
        this.position.setY(y);
    }

    public Vector getPosition(){
        return position;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean collidesWith(Entity e){
        return
                    (getYMax() >= e.getYMin() && getYMin() <= e.getYMax())
             &&
                    (getXMax() >= e.getXMin() && getXMin() <= e.getXMax());
    }

    public float getXMax(){
        return position.getX() + width/2;
    }

    public float getXMin(){
        return position.getX() - width/2;
    }

    public float getYMax(){
        return position.getY() + height/2;
    }

    public float getYMin(){
        return position.getY() - height/2;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void move(Vector desiredMove){
        if(desiredMove.getY() < 0){
            if(position.getY() > 0){
                position.add(new Vector(0, desiredMove.getY()));
            }
        }else if(desiredMove.getY() > 0){
            if(position.getY() + height < Game.WINDOW_HEIGHT){
                position.add(new Vector(0, desiredMove.getY()));
            }
        }

        if(desiredMove.getX() < 0){
            if(position.getX() > 0){
                position.add(new Vector(desiredMove.getX(), 0));
            }
        }else if(desiredMove.getX() > 0){
            if(position.getX() + width < Game.WINDOW_WIDTH){
                position.add(new Vector(desiredMove.getX(), 0));
            }
        }

    }

    public void setImage(String path){
        try {
            image = new Image(path);
            height = image.getHeight();
            width = image.getWidth();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
