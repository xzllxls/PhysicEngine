package Objects.Rendering;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public class Triangle extends TypePolygon {
    public Triangle(Surface surfaceType, Color color, Vertex v1, Vertex v2, Vertex v3){
        super(surfaceType, color, v1, v2, v3);
    }

    public Triangle(Surface surfaceType, Vertex v1, Vertex v2, Vertex v3){
        super(surfaceType, v1, v2, v3);
    }
}
