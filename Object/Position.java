package Object;

/**
 * @author Linden Brochu
 */
public class Position {
    private Position3D pos;
    private double[] rotation = new double[3]; //Rotation

    /**
     * Instancier position sur les 3 axes
     * @param x Position axe x
     * @param y Position axe y
     * @param z Position axe z
     */
    public Position(double x, double y, double z){
        pos = new Position3D(x, y, z);
    }

    /**
     * Instancier position sur les 3 axes de positionnement et la rotation horizontale et verticale
     * @param x Position axe x
     * @param y Position axe y
     * @param z Position axe z
     * @param rotH Rotation horizontale
     * @param rotV Rotation verticale
     */
    public Position(double x, double y, double z, double rotH, double rotV){
        pos = new Position3D(x, y, z);
        rotation[0] = rotH;
        rotation[1] = rotV;
        rotation[2] = 0;
    }

    /**
     * Instancier position sur les 3 axes de positionnement et les 3 axes de rotation
     * @param x Position axe x
     * @param y Position axe y
     * @param z Position axe z
     * @param rotH Rotation horizontale
     * @param rotV Rotation verticale
     * @param rotLocal Rotation radiale centrée sur l'axe locale créer par les 2 autres axes de rotation
     */
    public Position(double x, double y, double z, double rotH, double rotV, double rotLocal){
        pos = new Position3D(x, y, z);
        rotation[0] = rotH;
        rotation[1] = rotV;
        rotation[2] = rotLocal;
    }

    public Position3D getPos() {
        return pos;
    }

    public double[] getRotation() {
        return rotation;
    }

    public void setPos(Position3D pos) {
        this.pos = pos;
    }

    public void setRotation(double[] rotation) {
        this.rotation = rotation;
    }
}
