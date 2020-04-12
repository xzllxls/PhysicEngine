package Engine;

/**
 * Vecteur à 3 valeur
 * @author Linden Brochu
 */
public abstract class Vector {
    public double x; //Valeur en x (x * i)
    public double y; //Valeur en y (y * j)
    public double z; //Valeur en z (z * k)
    public double linearDistance; //Norme du vecteur

    /**
     * Instancier un vecteur identique à un autre
     * @param vector Vecteur à copier
     */
    public Vector(Vector vector){
        x = vector.x;
        y = vector.y;
        z = vector.z;
        setLinearDistance();
    }

    /**
     * Instancier un vecteur de x, y et z unités
     * @param x Unité en i
     * @param y Unité en j
     * @param z Unité en k
     */
    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        setLinearDistance();
    }

    /**
     * Instancier un vecteur nul
     */
    public Vector(){
        x = 0;
        y = 0;
        z = 0;
        linearDistance = 0;
    }

    /**
     * Additionner un vecteur
     * @param vector Vecteur à additionner
     * @return Le vecteur modifié
     */
    public Vector appliquerVecteur(Vector vector){
        x += vector.x;
        y += vector.y;
        z += vector.z;
        setLinearDistance();
        return this;
    }

    /**
     * Étirer un vecteur
     * @param scaleValue Valeur en x, y, z de l'étirement
     * @return Le vecteur étirer
     */
    public Vector scale(double scaleValue){
        x *= scaleValue;
        y *= scaleValue;
        z *= scaleValue;
        setLinearDistance();
        return this;
    }

    /**
     * Étirer un vecteur
     * @param scaleValue Valeur vectorielle de l'étirement
     * @return Le vecteur étirer
     */
    public Vector scale(Vector scaleValue){
        x *= scaleValue.x;
        y *= scaleValue.y;
        z *= scaleValue.z;
        setLinearDistance();
        return this;
    }

    /**
     * Ajuster la norme du vecteur
     */
    protected void setLinearDistance(){
        linearDistance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    }
}
