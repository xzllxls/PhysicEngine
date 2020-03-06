package Engine;

import Object.*;
import java.time.*;

/**
 * @author Linden Brochu
 */
public class Acceleration {
    private Vector3D newtonVector;
    private double linearAcceleration;

    /**
     * Calcul une acceleration a partir de forces (sans friction)  et de la masse d'un objet
     * @param mass Masse de l'objet
     * @param forces Forces a appliquer
     */
    public Acceleration(int mass, Force[] forces){
        newtonVector = new Vector3D();
        for (Force direction : forces)
            newtonVector.add(direction.getDirection());
        newtonVector.setX(newtonVector.getX() * mass);
        newtonVector.setY(newtonVector.getX() * mass);
        newtonVector.setZ(newtonVector.getX() * mass);
        linearAcceleration = Math.pow(Math.pow(newtonVector.getX(), 2) + Math.pow(newtonVector.getY(), 2) +
                                                        Math.pow(newtonVector.getZ(), 2), (0.5));
    }

    /**
     * Calculer la vitesse a partir d'une quantite de temps et de l'acceleration
     * @param temps Quantite de temps
     * @return Velocity de la vitesse
     */
    public Velocity getVelocityWithTime(Duration temps){
        Velocity vit = new Velocity();
        vit.getVit().add(newtonVector);
        vit.getVit().setX(vit.getVit().getX() * temps.getSeconds());
        vit.getVit().setY(vit.getVit().getY() * temps.getSeconds());
        vit.getVit().setZ(vit.getVit().getZ() * temps.getSeconds());
        vit.setLinearVelocity(Math.pow(Math.pow(vit.getVit().getX(), 2) + Math.pow(vit.getVit().getY(), 2) +
                Math.pow(vit.getVit().getZ(), 2), (0.5)));
        return vit;
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
