package Rendered;

import Object.Position3D;

/**
 * @author Linden Brochu
 */
public class Vertex {
    private Position3D pos;

    /**
     * Instancier un vertex
     * @param x Position sur l'axe x
     * @param y Position sur l'axe y
     * @param z Position sur l'axe z
     */
    public Vertex(double x, double y, double z){
        pos = new Position3D(x, y, z);
    }

    /**
     * Instancier un vertex
     * @param pos Position du vertex
     */
    public Vertex(Position3D pos){
        this.pos = pos;
    }

    public Position3D getPos() {
        return pos;
    }

    public void setPos(Position3D pos) {
        this.pos = pos;
    }
}
