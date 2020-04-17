package Engine;

/**
 * Coordonnée en 3 dimension
 * @author Linden Brochu
 */
public abstract class TypePoint {
    public double x; //Position x
    public double y; //Position y
    public double z; //Position z

    /**
     * Instancier un point à des coordonnées
     * @param x Coordonnée en x
     * @param y Coordonnée en y
     * @param z Coordonnée en z
     */
    public TypePoint(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Instancier un point en (0,0,0)
     */
    public TypePoint(){
        x = 0;
        y = 0;
        z = 0;
    }

    /**
     * Déplacer un point de point de x, y et z unités
     * @param x Déplacement en x
     * @param y Déplacement en y
     * @param z Déplacement en z
     * @return Le point déplacé
     */
    public TypePoint move(double x, double y, double z){
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    /**
     * Changer la position d'un point
     * @param x Position absolue x
     * @param y Position absolue y
     * @param z Position absolue z
     * @return Le point déplacé
     */
    public TypePoint setPosition(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    /**
     * Applique un vecteur au point
     * @param vector Vecteur à appliquer
     * @return Le point déplacé
     */
    public TypePoint appliquerVecteur(Vector vector){
        x += vector.x;
        y += vector.y;
        z += vector.z;
        return this;
    }
}
