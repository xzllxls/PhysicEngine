package Object;

import java.text.DecimalFormat;

/**
 * @author Linden Brochu
 */
public class Rotation {
    private double rotH, rotV, rotLocal; //Rotation

    /**
     * Instancier une rotation
     * @param rotH Rotation horizontale 0°-360°
     * @param rotV Rotation verticale -90°-90°
     */
    public Rotation(double rotH, double rotV){
        this.rotV = rotV;
        this.rotH = rotH;
        rotLocal = 0;
    }

    /**
     * Instancier une rotation
     * @param rotH Rotation horizontale 0°-360°
     * @param rotV Rotation vectricale -90°-90°
     * @param rotLocal Rotation sur l'axe local/radiale aux 2 autres axes 0°-360°
     */
    public Rotation(double rotH, double rotV, double rotLocal){
        this.rotV = rotV;
        this.rotH = rotH;
        this.rotLocal = rotLocal;
    }

    /**
     * Affiche a la console les valeurs d'axe
     */
    public void print(){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(rotH) + " " + df.format(rotV) + " " + df.format(rotLocal));
    }

    public double getRotH() {
        return rotH;
    }

    public void setRotH(double rotH) {
        this.rotH = rotH;
    }

    public double getRotV() {
        return rotV;
    }

    public void setRotV(double rotV) {
        this.rotV = rotV;
    }

    public double getRotLocal() {
        return rotLocal;
    }

    public void setRotLocal(double rotLocal) {
        this.rotLocal = rotLocal;
    }
}
