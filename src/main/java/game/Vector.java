package game;

public class Vector {
    private float x;
    private float y;
    private float z;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void multiply(Vector v){
        this.x *= v.getX();
        this.y *= v.getY();
    }

    public void add(Vector v){
        this.x += v.getX();
        this.y += v.getY();
    }

    public void subtract(Vector v){
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public void set(Vector v){
        this.x = v.getX();
        this.y = v.getY();
    }
}
