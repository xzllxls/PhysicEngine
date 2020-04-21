package Objects;

import Engine.Vector;

/**
 * <p lang="en">Acceleration vector</p>
 * <p lang="fr">Vecteur d'accélération</p>
 * @author Linden Brochu
 */
public class Acceleration extends Vector {

    /**
     * <p lang="en">Instantiate an acceleration from an other</p>
     * <p lang="fr">Instancier une accélération identique à une autre</p>
     * @param acc Accélération à copier
     */
    public Acceleration(Acceleration acc){
        super(acc);
    }

    /**
     * <p lang="en">Instantiate an acceleration of x, y and z m/s2</p>
     * <p lang="fr">Instancier une accélération de x, y et z m/s2</p>
     * @param x Unité en i
     * @param y Unité en j
     * @param z Unité en k
     */
    public Acceleration(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * <p lang="en">Instantiate a null acceleration</p>
     * <p lang="fr">Instancier une accélération nulle</p>
     */
    public Acceleration(){
        super();
    }
}
