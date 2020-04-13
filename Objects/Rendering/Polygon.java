package Objects.Rendering;

/**
 * @author Linden Brochu
 */
public abstract class Polygon {
    public Vertex[] vertices;

    public enum Surface {
        Soft, Solid
    }

    public Surface surfaceType;

    public Polygon(Surface surfaceType, Vertex... vertices){
        this.vertices = vertices;
        this.surfaceType = surfaceType;
    }
}
