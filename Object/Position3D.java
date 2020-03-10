package Object;

import java.text.DecimalFormat;

/**
 * @author Linden Brochu
 */
public class Position3D {
    private double posX, posY, posZ; //Position par rapport au monde

    /**
     * Instancier position sur les 3 axes
     * @param x Position axe x
     * @param y Position axe y
     * @param z Position axe z
     */
    public Position3D(double x, double y, double z){
        posX = x;
        posY = y;
        posZ = z;
    }

    /**
     * Creer un point (position3D)
     * @param point Position3D du point d'origine
     * @param vector Vecteur a appliquer au point
     */
    public Position3D(Position3D point, Vector3D vector){
        posX = point.getPosX() + vector.getX();
        posY = point.getPosY() + vector.getY();
        posZ = point.getPosZ() + vector.getZ();

    }

    /**
     * Creer un vecteur entre 2 points
     * @param pos2 Postion3D du second point
     * @return Vecteur3D du deplacement entre deux points
     */
    public Vector3D distanceFromPos(Position3D pos2){
        Vector3D deplacement = new Vector3D();
        deplacement.setX(posX - pos2.getPosX());
        deplacement.setY(posX - pos2.getPosY());
        deplacement.setZ(posX - pos2.getPosZ());
        return deplacement;
    }

    /**
     * Affiche a la console les valeurs d'axe
     */
    public void print(){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(posX) + " " + df.format(posY) + " " + df.format(posZ));
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getPosZ() {
        return posZ;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }
}
