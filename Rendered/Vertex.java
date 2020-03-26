package Rendered;

import Objects.Position3D;

import java.util.Objects;

/**
 * @author Linden Brochu
 */
public class Vertex extends Position3D{
    private double x,y,z;

    private String posName;
    /**
     * Instancier un vertex
     * @param x Position sur l'axe x
     * @param y Position sur l'axe y
     * @param z Position sur l'axe z
     */
    public Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    @Override
    public double getPosX() {
        return x;
    }

    @Override
    public void setPosX(double x) {
        this.x = x;
    }

    @Override
    public double getPosY() {
        return y;
    }

    @Override
    public void setPosY(double y) {
        this.y = y;
    }

    @Override
    public double getPosZ() {
        return z;
    }

    @Override
    public void setPosZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vertex vertex = (Vertex) o;
        return Double.compare(vertex.x, x) == 0 &&
                Double.compare(vertex.y, y) == 0 &&
                Double.compare(vertex.z, z) == 0 &&
                Objects.equals(posName, vertex.posName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x, y, z);
    }
}
