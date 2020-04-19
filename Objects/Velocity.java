package Objects;

import Engine.Vector;

/**
 * Vecteur de vitesse
 * @author Linden Brochu
 */
public class Velocity extends Vector {

    /**
     * Instancier un vitesse
     * @param x Unité en i
     * @param y Unité en j
     * @param z Unité en k
     */
    public Velocity(double x, double y, double z){
        super(x, y, z);
    }

    /**
     * Instancier une copie d'une vitesse
     * @param velocity Vitesse à copier
     */
    public Velocity(Velocity velocity){
        super(velocity);
    }

    /**
     * Instancier un vitesse nulle
     */
    public Velocity(){
        super();
    }

    /**
     * Créer une copie de la vélocité, puis retourne sa valeur à l'exposant
     * @param puissance Exposant
     * @return Copie de la vélocité
     */
    @Deprecated
    public Velocity pow(int puissance){
        Velocity velocity = new Velocity(this);
        for (int i = 1; i < puissance; i++) {
            velocity.x *= Math.abs(velocity.x);
            velocity.y *= Math.abs(velocity.y);
            velocity.z *= Math.abs(velocity.z);
        }
        velocity.setLinearDistance();
        return velocity;
    }

}
