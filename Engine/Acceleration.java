package Engine;

import Object.Vector3D;

/**
 * @author Linden Brochu
 */
public class Acceleration {
    private Vector3D newtonVector;
    private double linearAcceleration;


    public Acceleration(){
        newtonVector = new Vector3D();
    }

    public Acceleration(double x, double y, double z){
        newtonVector = new Vector3D(x, y, z);
    }

    public Vector3D getNewtonVector() {
        return newtonVector;
    }

    public void setNewtonVector(Vector3D newtonVector) {
        this.newtonVector = newtonVector;
    }

    public double getLinearAcceleration() {
        return linearAcceleration;
    }

    public void setLinearAcceleration(double linearAcceleration) {
        this.linearAcceleration = linearAcceleration;
    }
}
