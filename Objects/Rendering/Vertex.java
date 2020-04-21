package Objects.Rendering;

import Engine.TypePoint;
import Objects.Position;

/**
 * <p lang="en">3 dimension position</p>
 * <p lang="fr">Position 3d</p>
 * @author Linden Brochu
 */
public class Vertex extends TypePoint {

    /**
     * <p lang="en">Instantiate a vertex</p>
     * <p lang="fr">Instancier un vertex</p>
     * @param x Position x
     * @param y Position y
     * @param z Position z
     */
    public Vertex(double x, double y, double z){
        super(x, y, z);
    }

    /**
     * <p lang="en">Modify a vertex from 3 coordinates</p>
     * <p lang="fr">Modifier un vertex avec 3 coordonnées</p>
     * @param vertex Vertex
     * @param x Coordonnée x
     * @param y Coordonnée y
     * @param z Coordonnée z
     * @return Vertex
     */
    public static Vertex vertexFromPos(Vertex vertex, double x, double y, double z){
        return new Vertex(vertex.x + x, vertex.y + y, vertex.z + z);
    }

    /**
     * <p lang="en">Modify a vertex from a position</p>
     * <p lang="fr">Modifier un vertex avec une position</p>
     * @param vertex Vertex
     * @param pos Position
     * @return Vertex
     */
    public static Vertex vertexFromPos(Vertex vertex, Position pos){
        return new Vertex(vertex.x + pos.x, vertex.y + pos.y, vertex.z + pos.z);
    }

}
