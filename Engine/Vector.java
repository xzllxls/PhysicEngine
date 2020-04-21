package Engine;

/**
 * <p lang="en">3 value vector</p>
 * <p lang="fr">Vecteur à 3 valeur</p>
 * @author Linden Brochu
 */
public abstract class Vector {
    public double x; //Valeur en x (x * i)
    public double y; //Valeur en y (y * j)
    public double z; //Valeur en z (z * k)
    public double linearDistance; //Norme du vecteur

    /**
     * <p lang="en">Instantiate a vector from an other one</p>
     * <p lang="fr">Instancier un vecteur identique à un autre</p>
     * @param vector Vecteur à copier
     */
    public Vector(Vector vector){
        x = vector.x;
        y = vector.y;
        z = vector.z;
        setLinearDistance();
    }

    /**
     * <p lang="en">Instantiate a vector of x, y and z unite</p>
     * <p lang="fr">Instancier un vecteur de x, y et z unités</p>
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
     * <p lang="en">Instantiate a null vector</p>
     * <p lang="fr">Instancier un vecteur nul</p>
     */
    public Vector(){
        x = 0;
        y = 0;
        z = 0;
        linearDistance = 0;
    }

    /**
     * <p lang="en">Add a vector</p>
     * <p lang="fr">Additionner un vecteur</p>
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
     * <p lang="en">Scale a vector</p>
     * <p lang="fr">Étirer un vecteur</p>
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
     * <p lang="en">Scale a vecor</p>
     * <p lang="fr">Étirer un vecteur</p>
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
     * <p lang="en">Set the vector norm</p>
     * <p lang="fr">Ajuster la norme du vecteur</p>
     */
    protected void setLinearDistance(){
        linearDistance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    }

    /**
     * <p lang="en">Limit the component value (Can deform the vector)</p>
     * <p lang="fr">Limiter les composantes du vecteur (Peut déformer le vecteur)</p>
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
     * <p lang="en">Limit the component value (keep proportion)</p>
     * <p lang="fr">Limite la norme du vecteur (garde les proportions du vecteur)</p>
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
     * <p lang="en">Limit the component value (Can deform the vector)</p>
     * <p lang="fr">Limiter les composantes du vecteur (Peut déformer le vecteur)</p>
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

    /**
     * <p lang="en">Round to zero the components when they are under their threshold</p>
     * <p lang="fr">Arrondi à zero lorsque les composantes sont sous le seuil</p>
     * @param xMin Seuil x
     * @param yMin Seuil y
     * @param zMin Seuil z
     * @return Le vecteur
     */
    public Vector roundMin(double xMin, double yMin, double zMin){
        if (this.x < xMin && this.x > -xMin)
            this.x = 0;
        if (this.y < yMin && this.y > -yMin)
            this.y = 0;
        if (this.z < zMin && this.z > -zMin)
            this.z = 0;
        return this;
    }

    /**
     * <p lang="en">Round to zero the components when they are under their threshold</p>
     * <p lang="fr">Arrondi à zero lorsque les composantes sont sous le seuil</p>
     * @param min Seuil
     * @return Le vecteur
     */
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
