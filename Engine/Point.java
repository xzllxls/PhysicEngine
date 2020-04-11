package Engine;

/**
 * @author Linden Brochu
 */
public abstract class Point {
    public double x;
    public double y;
    public double z;

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

    public Point move(double x, double y, double z){
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Point appliquerVecteur(Vector vector){
        x += vector.x;
        y += vector.y;
        z += vector.z;
        return this;
    }
}
