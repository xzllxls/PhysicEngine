package Object;

/**
 * @author Linden Brochu
 */
public class Position3D {
    private double[] pos; //Position par rapport au monde

    /**
     * Instancier position sur les 3 axes
     * @param x Position axe x
     * @param y Position axe y
     * @param z Position axe z
     */
    public Position3D(double x, double y, double z){
        pos = new double[3];
        pos[0] = x;
        pos[1] = y;
        pos[2] = z;
    }

    /**
     * Creer un point (position3D)
     * @param point Position3D du point d'origine
     * @param vector Vecteur a appliquer au point
     */
    public Position3D(Position3D point, Vector3D vector){
        point.pos[0] += vector.getX();
        point.pos[1] += vector.getY();
        point.pos[2] += vector.getZ();
    }

    /**
     * Creer un vecteur entre 2 points
     * @param pos2 Postion3D du second point
     * @return Vecteur3D du deplacement entre deux points
     */
    public Vector3D distanceFromPos(Position3D pos2){
        Vector3D deplacement = new Vector3D();
        deplacement.setX(pos[0] - pos2.pos[0]);
        deplacement.setY(pos[1] - pos2.pos[1]);
        deplacement.setZ(pos[2] - pos2.pos[2]);
        return deplacement;
    }

    public double[] getPos() {
        return pos;
    }

    public void setPos(double[] pos) {
        this.pos = pos;
    }
}
