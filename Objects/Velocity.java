package Objects;

import Engine.Vector;

/**
 * @author Linden Brochu
 */
public class Velocity extends Vector {

    public Velocity(double x, double y, double z){
        super(x, y, z);
    }

    public Velocity(){
        super();
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double getLinearDistance() {
        return linearDistance;
    }
}
