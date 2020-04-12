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
     * Instancier un vitesse nulle
     */
    public Velocity(){
        super();
    }

}
