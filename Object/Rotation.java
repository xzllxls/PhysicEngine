package Object;

import java.text.DecimalFormat;

/**
 * @author Linden Brochu
 */
public class Rotation {
    private double rotX, rotY, rotZ;

    /**
     * Instancier un rotation nulle
     */
    public Rotation(){
        rotX = 0;
        rotY = 0;
        rotZ = 0;
    }

    /**
     * Instancier une rotation
     * @param rotX Rotation axe x
     * @param rotY Rotation axe y
     * @param rotZ Rotation axe z
     */
    public Rotation(double rotX, double rotY, double rotZ){
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
    }

    /**
     * Affiche a la console les valeurs d'axe
     */
    public void print(){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(rotX) + " " + df.format(rotY) + " " + df.format(rotZ));
    }

    /**
     * Copie la valeur d'une rotation
     * @param rotation Rotation a copier
     */
    public void cloneOtherRot(Rotation rotation){
        rotX = rotation.getRotX();
        rotY = rotation.getRotY();
        rotZ = rotation.getRotZ();
    }

    /**
     * Instancier un rotation avec les memes valeurs qu'une autre rotation
     * @param rotation Autre rotation
     * @return Rotation
     */
    public static Rotation clone(Rotation rotation){
        Rotation newRot = new Rotation();
        newRot.cloneOtherRot(rotation);
        return newRot;
    }

    public double getRotX() {
        return rotX;
    }

    public void setRotX(double rotX) {
        this.rotX = rotX;
    }

    public double getRotY() {
        return rotY;
    }

    public void setRotY(double rotY) {
        this.rotY = rotY;
    }

    public double getRotZ() {
        return rotZ;
    }

    public void setRotZ(double rotZ) {
        this.rotZ = rotZ;
    }
}
