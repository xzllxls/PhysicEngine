package Objects;

import Engine.Vector;

/**
 * @author Linden Brochu
 */
public class Force extends Vector {
    public boolean scalable;

    public enum Type {
        Naturel, Scalable
    }

    public Force(double x, double y, double z, Type type){
        super(x, y, z);
        switch (type){
            case Naturel:
                scalable = false;
                break;
            case Scalable:
                scalable = true;
                break;
        }
    }

    public Force(double x, double y, double z){
        super(x, y, z);
        scalable = false;
    }

    public Force(){
        super();
        scalable = false;
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
