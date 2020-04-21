package Objects;

import Engine.Vector;

/**
 * <p lang="en">Force vector</p>
 * <p lang="fr">Vecteur de force</p>
 * @author Linden Brochu
 */
public class Force extends Vector {

    /**
     * <p lang="en">Force type</p>
     * <p lang="fr">Type de force</p>
     */
    public enum Type {
        Naturel, Scalable
    }

    Type type; //Type de force

    /**
     * <p lang="en">Instantiate a force</p>
     * <p lang="fr">Instancier une force</p>
     * @param x Unité en i
     * @param y Unité en j
     * @param z Unité en k
     * @param type Type de force
     */
    public Force(double x, double y, double z, Type type){
        super(x, y, z);
        this.type = type;
    }

    /**
     * <p lang="en">Instantiate a force</p>
     * <p lang="fr">Instancier une force</p>
     * @param x Unité en i
     * @param y Unité en j
     * @param z Unité en k
     */
    public Force(double x, double y, double z){
        super(x, y, z);
        type = Type.Naturel;
    }

    /**
     * <p lang="en">Instantiate a copie of a force</p>
     * <p lang="fr">Instancier une copie d'une force</p>
     * @param force Force à copier
     */
    public Force(Force force){
        super(force);
        this.type = force.type;
    }

    /**
     * <p lang="en">Instantiate a null force</p>
     * <p lang="fr">Instancier une force nulle</p>
     */
    public Force(){
        super();
        type = Type.Naturel;
    }
}
