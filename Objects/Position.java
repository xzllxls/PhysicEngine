package Objects;

import Engine.TypePoint;

/**
 * <p lang="en">3 dimension coordinate</p>
 * <p lang="fr">Position 3d</p>
 * @author Linden Brochu
 */
public class Position extends TypePoint {

    /**
     * <p lang="en">Instantiate a position on coordinates</p>
     * <p lang="fr">Instancier une position à des coordonnées</p>
     * @param x Coordonnée en x
     * @param y Coordonnée en y
     * @param z Coordonnée en z
     */
    public Position(double x, double y, double z){
        super(x, y, z);
    }

    /**
     * <p lang="en">Instantiate a position on (0,0,0)</p>
     * <p lang="fr">Instancier une position en (0,0,0)</p>
     */
    public Position(){
        super();
    }
}
