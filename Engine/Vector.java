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

    /**
     * Limiter les composantes du vecteur (Peut déformer le vecteur)
     * @param vector Vecteur max
     * @return Le vecteur limité
     */
    public Vector limit(Vector vector){
        if (x > vector.x)
            x = vector.x;
        if (y > vector.y)
            y = vector.y;
        if (z > vector.z)
            z = vector.z;
        setLinearDistance();
        return this;
    }

    /**
     * Limite la norme du vecteur (garde les proportions du vecteur)
     * @param linearDistance Norme max
     * @return Le vecteur limité
     */
    public Vector limit(double linearDistance){
        if (this.linearDistance > linearDistance){
            double ratio = linearDistance / this.linearDistance;
            x *= ratio;
            y *= ratio;
            z *= ratio;
        }
        setLinearDistance();
        return this;
    }

    /**
     * Limiter les composantes du vecteur (Peut déformer le vecteur)
     * @param x Composante x
     * @param y Composante y
     * @param z Composante z
     * @return Le vecteur limité
     */
    public Vector limit(double x, double y, double z){
        if (this.x > x)
            this.x = x;
        if (this.y > y)
            this.y = y;
        if (this.z > z)
            this.z = z;
        setLinearDistance();
        return this;
    }

    public Vector roundMin(double xMin, double yMin, double zMin){
        if (this.x < xMin && this.x > -xMin)
            this.x = 0;
        if (this.y < yMin && this.y > -yMin)
            this.y = 0;
        if (this.z < zMin && this.z > -zMin)
            this.z = 0;
        return this;
    }

    public Vector roundMin(double min){
        if (this.x < min && this.x > -min)
            this.x = 0;
        if (this.y < min && this.y > -min)
            this.y = 0;
        if (this.z < min && this.z > -min)
            this.z = 0;
        return this;
    }
}
