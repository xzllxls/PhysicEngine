package Engine;

import Object.Vector3D;

/**
 * @author Linden Brochu
 */
public class Acceleration {
    private Vector3D newtonVector;
    private double linearAcceleration;

    /**
     * Calcul une acceleration a partir de forces et de la masse d'un objet
     * @param mass Masse de l'objet
     * @param forces Forces a appliquer
     */
    Acceleration(int mass, Force[] forces){
        newtonVector = new Vector3D();
        for (Force direction : forces)
            newtonVector.add(direction.getDirection());
        newtonVector.setX(newtonVector.getX() * mass);
        newtonVector.setY(newtonVector.getX() * mass);
        newtonVector.setZ(newtonVector.getX() * mass);
        linearAcceleration = Math.pow(Math.pow(newtonVector.getX(), 2) + Math.pow(newtonVector.getY(), 2) +
                                                        Math.pow(newtonVector.getZ(), 2), (0.5));
    }



    public Vector3D getNewtonVector() {
        return newtonVector;
    }

    public void setNewtonVector(Vector3D newtonVector) {
        this.newtonVector = newtonVector;
    }
}
