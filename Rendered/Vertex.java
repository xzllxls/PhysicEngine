package Rendered;

import Object.Position3D;

import java.util.Objects;

/**
 * @author Linden Brochu
 */
public class Vertex {
    private Position3D pos;
    private String posName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return pos.equals(vertex.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos);
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }
}
