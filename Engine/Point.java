package Engine;

/**
 * @author Linden Brochu
 */
public abstract class Point {
    protected double x;
    protected double y;
    protected double z;

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Point appliquerVecteur(Vector vector){
        x += vector.x;
        y += vector.y;
        z += vector.z;
        return this;
    }
}
