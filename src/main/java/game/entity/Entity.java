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

    public Entity(){
        //initialize entity off screen, until position is set
        position = new Vector(-500, -500);
    }
    public void render(){
        image.draw(position.getX(), position.getY());
    };

    public void setPosition(Vector position){
        this.position = position;
    }

    public float getXPosition() {
        return position.getX();
    }

    public Vector getCenter(){
        Vector center = new Vector(0,0);
        center.setX(position.getX() + width / 2);
        center.setY(position.getY() + height / 2);
        return center;
    }

    public void setCenter(Vector v){
        position.setX(v.getX() - width / 2);
        position.setY(v.getY() - height /2);
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
            Vector center = getCenter();
            image = new Image(path);
            height = image.getHeight();
            width = image.getWidth();
            setCenter(center);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
