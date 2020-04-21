package Objects;

import Engine.Vector;

/**
 * <p lang="en">Velocity vector</p>
 * <p lang="fr">Vecteur de vitesse</p>
 * @author Linden Brochu
 */
public class Velocity extends Vector {

    /**
     * <p lang="en">Instantiate a velocity</p>
     * <p lang="fr">Instancier un vitesse</p>
     * @param x Unité en i
     * @param y Unité en j
     * @param z Unité en k
     */
    public Velocity(double x, double y, double z){
        super(x, y, z);
    }

    /**
     * <p lang="en">Instantiate a copy of a velocity</p>
     * <p lang="fr">Instancier une copie d'une vitesse</p>
     * @param velocity Vitesse à copier
     */
    public Velocity(Velocity velocity){
        super(velocity);
    }

    /**
     * <p lang="en">Instantiate a null velocity</p>
     * <p lang="fr">Instancier un vitesse nulle</p>
     */
    public Velocity(){
        super();
    }
}
