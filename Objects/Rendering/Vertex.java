package Objects.Rendering;

import Engine.TypePoint;
import Objects.Position;

/**
 * Position 3d
 * @author Linden Brochu
 */
public class Vertex extends TypePoint {

    /**
     * Instancier un vertex
     * @param x Position x
     * @param y Position y
     * @param z Position z
     */
    public Vertex(double x, double y, double z){
        super(x, y, z);
    }

    public static Vertex vertexFromPos(Vertex vertex, double x, double y, double z){
        return new Vertex(vertex.x + x, vertex.y + y, vertex.z + z);
    }

    public static Vertex vertexFromPos(Vertex vertex, Position pos){
        return new Vertex(vertex.x + pos.x, vertex.y + pos.y, vertex.z + pos.z);
    }

}
