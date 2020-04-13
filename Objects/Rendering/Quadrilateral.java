package Objects.Rendering;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public class Quadrilateral extends TypePolygon {

    public Quadrilateral(Surface surfaceType, Color color, Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        super(surfaceType, color, v1, v2, v3, v4);
    }

    public Quadrilateral(Surface surfaceType, Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
        super(surfaceType, v1, v2, v3, v4);
    }
}
