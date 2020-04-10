package Engine;

import Objects.Velocity;

/**
 * @author Linden Brochu
 */
public abstract class Vector {
    protected double x;
    protected double y;
    protected double z;
    protected double linearDistance;

    public Vector appliquerVecteur(Vector vector){
        x += vector.getX();
        y += vector.getY();
        z += vector.getZ();
        return this;
    }

    public abstract double getX();

    public abstract void setX(double x);

    public abstract double getY();

    public abstract void setY(double y);

    public abstract double getZ();

    public abstract void setZ(double z);

    public abstract double getLinearDistance();
}
