package Engine;

/**
 * @author Linden Brochu
 */
public abstract class Point3d {
    protected double x;
    protected double y;
    protected double z;

    public abstract double getX();

    public abstract void setX(double x);

    public abstract double getY();

    public abstract void setY(double y);

    public abstract double getZ();

    public abstract void setZ(double z);
}
