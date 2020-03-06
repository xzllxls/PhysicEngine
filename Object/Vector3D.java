package Object;

/**
 * @author Linden Brochu
 */
public class Vector3D {
    private double x, y, z;

    /**
     * Instancier vecteur
     * @param x Distance sur l'axe x
     * @param y Distance sur l'axe y
     * @param z Distance sur l'axe z
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Instancier vecteur null
     */
    public Vector3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    /**
     * Creer un point (position3D)
     * @param pos Position3D du point d'origine
     * @return Position3D d'un point à une certain distance d'un autre point
     */
    public Position3D posFromPos(Position3D pos){
        return new Position3D(pos, this);
    }

    /**
     * Ajouter un vecteur au present vecteur
     * @param vector Vector3D a ajouter
     */
    public void add(Vector3D vector){
        x += vector.getX();
        y += vector.getY();
        z += vector.getZ();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
