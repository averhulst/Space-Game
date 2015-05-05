package game.entity;

import org.newdawn.slick.Image;

public abstract class Entity {
    protected float xPosition;
    protected float yPosition;
    protected float speed;
    protected Image image;
    protected float width;
    protected float height;

    public abstract void update();

    public abstract void render();

    public float getxPosition() {
        return xPosition;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
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
             && (getXMax() >= e.getXMin() && getXMin() <= e.getXMax());
    }
    public float getXMax(){
        return xPosition + width/2;
    }

    public float getXMin(){
        return xPosition - width/2;
    }
    public float getYMax(){
        return yPosition + height/2;
    }
    public float getYMin(){
        return yPosition - height/2;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
