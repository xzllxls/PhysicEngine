package Objects;

import Engine.Vector;

/**
 * Vecteur d'accélération
 * @author Linden Brochu
 */
public class Acceleration extends Vector {

    /**
     * Instancier une accélération identique à une autre
     * @param acc Accélération à copier
     */
    public Acceleration(Acceleration acc){
        super(acc);
    }

    /**
     * Instancier une accélération de x, y et z m/s2
     * @param x Unité en i
     * @param y Unité en j
     * @param z Unité en k
     */
    public Acceleration(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Instancier une accélération nulle
     */
    public Acceleration(){
        super();
    }
}
