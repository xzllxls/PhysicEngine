package Objects.Rendering;

import java.awt.*;

/**
 * <p lang="en">Triangle</p>
 * <p lang="fr">Triangle</p>
 * @author Linden Brochu
 */
public class Triangle extends TypePolygon {

    /**
     * <p lang="en">Instantiate a triangle</p>
     * <p lang="fr">Instancier un triangle</p>
     * @param surfaceType Type de surface
     * @param color Couleur
     * @param v1 Vertex 1
     * @param v2 Vertex 2
     * @param v3 Vertex 3
     */
    public Triangle(Surface surfaceType, Color color, Vertex v1, Vertex v2, Vertex v3){
        super(surfaceType, color, v1, v2, v3);
    }

    /**
     * <p lang="en">Instantiate a triangle</p>
     * <p lang="fr">Instancier un triangle</p>
     * @param surfaceType Type de surface
     * @param v1 Vertex 1
     * @param v2 Vertex 2
     * @param v3 Vertex 3
     */
    public Triangle(Surface surfaceType, Vertex v1, Vertex v2, Vertex v3){
        super(surfaceType, v1, v2, v3);
    }
}
