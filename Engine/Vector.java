package Engine;

/**
 * @author Linden Brochu
 */
public abstract class Vector {
    protected double x;
    protected double y;
    protected double z;
    protected double linearDistance;

    public Vector(Vector vector){
        x = vector.x;
        y = vector.y;
        z = vector.z;
        setLinearDistance();
    }

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        setLinearDistance();
    }

    public Vector(){
        x = 0;
        y = 0;
        z = 0;
        linearDistance = 0;
    }

    public Vector appliquerVecteur(Vector vector){
        x += vector.x;
        y += vector.y;
        z += vector.z;
        setLinearDistance();
        return this;
    }

    public Vector scale(double scaleValue){
        x *= scaleValue;
        y *= scaleValue;
        z *= scaleValue;
        setLinearDistance();
        return this;
    }

    public Vector scale(Vector scaleValue){
        x *= scaleValue.x;
        y *= scaleValue.y;
        z *= scaleValue.z;
        setLinearDistance();
        return this;
    }

    protected void setLinearDistance(){
        linearDistance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", linearDistance=" + linearDistance +
                '}';
    }
}
