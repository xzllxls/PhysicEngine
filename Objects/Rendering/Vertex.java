package Objects.Rendering;

import Engine.PhysicEngine;
import Engine.Scene;
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
     * <p lang="en">Modify a vertex from a position</p>
     * <p lang="fr">Modifier un vertex avec une position</p>
     * @param vertex Vertex
     * @param pos Position
     * @return Vertex
     */
    public static Vertex vertexFromPos(Vertex vertex, Position pos){
        return new Vertex(vertex.x + (pos.x + Scene.camera.pos.x)  * PhysicEngine.PIXEL_PER_METER, vertex.y + (pos.y + Scene.camera.pos.y) * PhysicEngine.PIXEL_PER_METER, vertex.z + (pos.z + Scene.camera.pos.z) * PhysicEngine.PIXEL_PER_METER);
    }

}
