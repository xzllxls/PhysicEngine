package Objects;

/**
 * @author Linden Brochu
 */
public class Rotation {
    public double x;
    public double y;
    public double z;

    public Rotation(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void toZero(){
        x = 0;
        y = 0;
        z = 0;
    }

    public void setRotation(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Rotation rotate(double x, double y, double z){
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }
}