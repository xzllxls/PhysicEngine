package Engine;

/**
 * @author Linden Brochu
 */
public abstract class Grid {
    double[] abscisse = new double[3];
    double[] ordonne = new double[3];
    double[] cote = new double[3];

    public Grid(double[] abscisse, double[] ordonne, double[] cote){
        this.abscisse = abscisse;
        this.ordonne = ordonne;
        this.cote = cote;
    }
}
