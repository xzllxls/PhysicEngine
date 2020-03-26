package Objects;

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
     * Instancier position sur les 3 axes de positionnement et les 3 axes de rotation
     * @param x Position axe x
     * @param y Position axe y
     * @param z Position axe z
     * @param rotX Rotation axe x
     * @param rotY Rotation axe y
     * @param rotZ Rotation axe z
     */
    public Transform(double x, double y, double z, double rotX, double rotY, double rotZ){
        pos = new Position3D(x, y, z);
        rot = new Rotation(rotX, rotY, rotZ);
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
