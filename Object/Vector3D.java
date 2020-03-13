package Object;

import java.text.DecimalFormat;

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
     * Ajouter un vecteur au present vecteur
     * @param vector Vector3D a ajouter
     */
    public void add(Vector3D vector){
        x += vector.getX();
        y += vector.getY();
        z += vector.getZ();
    }

    /**
     * Multilpier chaque terme d'un vecteur par un terme
     * @param mul Terme a utiliser
     */
    public void addMultiplicator(double mul){
        x *= mul;
        y *= mul;
        z *= mul;
    }

    /**
     * Diviser chaque terme d'un vecteur par un terme
     * @param mul Terme a utiliser
     */
    public void subMultiplicator(double mul){
        x /= mul;
        y /= mul;
        z /= mul;
    }

    /**
     * Creer un vecteur identique au present vecteur
     * @return Vector3D
     */
    public Vector3D cloneVector(){
        return new Vector3D(this.x, this.y, this.y);
    }

    /**
     * Affiche a la console les valeurs d'axe
     */
    public void print(){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(x) + " " + df.format(y) + " " + df.format(z));
    }

    /**
     * Inverse le vecteur
     */
    public void invertVector(){
        this.addMultiplicator(-1);
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
