package Engine;

/**
 * <p lang="en">3 dimension coordinates</p>
 * <p lang="fr">Coordonnée en 3 dimension</p>
 * @author Linden Brochu
 */
public abstract class TypePoint {
    public double x; //Position x
    public double y; //Position y
    public double z; //Position z

    /**
     * <p lang="en">Instantiate a point on coordinates</p>
     * <p lang="fr">Instancier un point à des coordonnées</p>
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
     * <p lang="en">Instantiate a point on (0,0,0)</p>
     * <p lang="fr">Instancier un point en (0,0,0)</p>
     */
    public TypePoint(){
        x = 0;
        y = 0;
        z = 0;
    }

    /**
     * <p lang="en">Move a point of x, y and z unite</p>
     * <p lang="fr">Déplacer un point de point de x, y et z unités</p>
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
     * <p lang="en">Change point coordinates</p>
     * <p lang="fr">Changer la position d'un point</p>
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
     * <p lang="en">Applied a vector to the point</p>
     * <p lang="fr">Applique un vecteur au point</p>
     * @param vector Vecteur à appliquer
     * @return Le point déplacé
     */
    public TypePoint appliquerVecteur(Vector vector){
        x += vector.x;
        y += vector.y;
        z += vector.z;
        return this;
    }

    public static double distance(TypePoint p1, TypePoint p2){
        double x = p1.x - p2.x;
        double y = p1.y - p2.y;
        double z = p1.z - p2.z;
        return Math.sqrt(x * x + y * y + z * z);
    }
}
