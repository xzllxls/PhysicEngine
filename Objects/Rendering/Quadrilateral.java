package Objects.Rendering;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public class Quadrilateral extends TypePolygon {

    /**
     * <p lang="en">Instantiate a quadrilateral</p>
     * <p lang="fr">Instancier un quadrilatère</p>
     * @param surfaceType Type de surface
     * @param color Couleur
     * @param v1 Vertex 1
     * @param v2 Vertex 2
     * @param v3 Vertex 3
     * @param v4 Vertex 4
     */
    public Quadrilateral(Surface surfaceType, Color color, Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        super(surfaceType, color, v1, v2, v3, v4);
    }

    /**
     * <p lang="en">Instantiate a quadrilateral</p>
     * <p lang="fr">Instancier un quadrilatère</p>
     * @param surfaceType Type de surface
     * @param v1 Vertex 1
     * @param v2 Vertex 2
     * @param v3 Vertex 3
     * @param v4 Vertex 4
     */
    public Quadrilateral(Surface surfaceType, Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        super(surfaceType, v1, v2, v3, v4);
    }
}
