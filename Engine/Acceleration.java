package Engine;

import Object.Vector3D;

/**
 * @author Linden Brochu
 */
public class Acceleration {
    private Vector3D newtonVector;
    private double linearAcceleration;

    /**
     * Instancier une acceleration nulle
     */
    public Acceleration(){
        newtonVector = new Vector3D();
    }

    /**
     * Instancier une acceleration
     * @param x Acceleration sur l'axe x
     * @param y Acceleration sur l'axe y
     * @param z Acceleration sur l'axe z
     */
    public Acceleration(double x, double y, double z){
        newtonVector = new Vector3D(x, y, z);
        updateLinearAcceleration();
    }

    public void updateLinearAcceleration(){
        linearAcceleration = Math.pow(Math.pow(newtonVector.getX(), 2) + Math.pow(newtonVector.getY(), 2) +
                Math.pow(newtonVector.getZ(), 2), (0.5));
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
