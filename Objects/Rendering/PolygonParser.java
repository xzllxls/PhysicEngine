package Objects.Rendering;

/**
 * <p lang="en">Polygon parser</p>
 * <p lang="fr">Modifieur de polygone</p>
 * @author Linden Brochu
 */
public class PolygonParser {

    /**
     * <p lang="en">Subdivide a polygon into triangle</p>
     * <p lang="fr">Subdivise un polygone en triangles</p>
     * @param polygon Polygone
     * @return Liste de triangle
     */
    public static Triangle[] subdivideIntoTriangle(TypePolygon polygon){
        Vertex v = breakPolygon(polygon);
        Triangle[] t = new Triangle[polygon.vertices.length];
        for (int i = 0; i < polygon.vertices.length - 1; i++){
            t[i] = new Triangle(polygon.surfaceType, polygon.color, polygon.vertices[i], polygon.vertices[i + 1], v);
        }
        t[polygon.vertices.length - 1] = new Triangle(polygon.surfaceType, polygon.color, polygon.vertices[polygon.vertices.length - 1], polygon.vertices[0], v);
        return t;
    }

    /**
     * <p lang="en">Break a polygon to find the mid point of it</p>
     * <p lang="fr">Brise un polygone pour trouver son point milieur</p>
     * @param polygon Polygone
     * @return Vertex central
     */
    public static Vertex breakPolygon(TypePolygon polygon){
        Vertex vertex = new Vertex(0,0,0);
        for (Vertex v : polygon.vertices){
            vertex.x += v.x;
            vertex.y += v.y;
            vertex.z += v.z;
        }
        vertex.x /= polygon.vertices.length;
        vertex.y /= polygon.vertices.length;
        vertex.z /= polygon.vertices.length;
        return vertex;
    }
}
