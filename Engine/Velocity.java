package Engine;

import Objects.Vector3D;

/**
 * @author Linden Brochu
 */
public class Velocity {
    private Vector3D vit;
    private double linearVelocity;

    /**
     * Instancier une vitesse de 0
     */
    public Velocity(){
        vit = new Vector3D();
        linearVelocity = 0;
    }

    /**
     * Instancier une vitesse en copiant un vecteur
     * @param vector Vecteur a copier
     */
    public Velocity(Vector3D vector){
        vit = vector.cloneVector();
        updateLinearVelocity();
    }

    /**
     * Instancier une vitesse
     * @param x Vitesse de l'axe x
     * @param y Vitesse de l'axe y
     * @param z Vitesse de l'axe z
     */
    public Velocity(double x, double y, double z){
        vit = new Vector3D(x, y, z);
        updateLinearVelocity();
    }

    /**
     * Met a jour la velocite lineaire
     */
    public void updateLinearVelocity(){
        linearVelocity = Math.pow(Math.pow(vit.getX(), 2) + Math.pow(vit.getY(), 2) +
                Math.pow(vit.getZ(), 2), (0.5));
    }

    public Vector3D getVit() {
        return vit;
    }

    public void setVit(Vector3D vit) {
        this.vit = vit;
    }

    public double getLinearVelocity() {
        return linearVelocity;
    }

    public void setLinearVelocity(double linearVelocity) {
        this.linearVelocity = linearVelocity;
    }
}
