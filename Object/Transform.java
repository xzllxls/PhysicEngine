package Object;

/**
 * @author Linden Brochu
 */
public class Transform {
    private Position3D pos;
    private Rotation rot;

    /**
     * Instancier position sur les 3 axes
     * @param x Position axe x
     * @param y Position axe y
     * @param z Position axe z
     */
    public Transform(double x, double y, double z){
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
    public Transform(double x, double y, double z, double rotH, double rotV){
        pos = new Position3D(x, y, z);
        rot = new Rotation(rotH, rotV);
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
    public Transform(double x, double y, double z, double rotH, double rotV, double rotLocal){
        pos = new Position3D(x, y, z);
        rot = new Rotation(rotH, rotV, rotLocal);
    }

    public Position3D getPos() {
        return pos;
    }

    public void setPos(Position3D pos) {
        this.pos = pos;
    }

    public Rotation getRot() {
        return rot;
    }

    public void setRot(Rotation rot) {
        this.rot = rot;
    }
}
