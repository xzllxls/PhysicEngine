package Objects;

import Engine.Point;

/**
 * Position 3d
 * @author Linden Brochu
 */
public class Position extends Point {

    /**
     * Instancier une position à des coordonnées
     * @param x Coordonnée en x
     * @param y Coordonnée en y
     * @param z Coordonnée en z
     */
    public Position(double x, double y, double z){
        super(x, y, z);
    }

    /**
     * Instancier une position en (0,0,0)
     */
    public Position(){
        super();
    }
}
