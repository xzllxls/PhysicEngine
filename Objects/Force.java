package Objects;

import Engine.Vector;

/**
 * Vecteur de force
 * @author Linden Brochu
 */
public class Force extends Vector {
    /**
     * Type de force
     */
    public enum Type {
        Naturel, Scalable
    }

    Type type; //Type de force

    /**
     * Instancier une force
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
     * Instancier une force
     * @param x Unité en i
     * @param y Unité en j
     * @param z Unité en k
     */
    public Force(double x, double y, double z){
        super(x, y, z);
        type = Type.Naturel;
    }

    /**
     * Instancier une force nulle
     */
    public Force(){
        super();
        type = Type.Naturel;
    }
}
