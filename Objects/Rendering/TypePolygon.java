package Objects.Rendering;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public abstract class TypePolygon {
    public Vertex[] vertices;
    public Color color;

    public enum Surface {
        Soft, Solid
    }

    public Surface surfaceType;

    public TypePolygon(Surface surfaceType, Color color, Vertex... vertices){
        this.vertices = vertices;
        this.color = color;
        this.surfaceType = surfaceType;
    }

    public TypePolygon(Surface surfaceType, Vertex... vertices){
        this.vertices = vertices;
        this.color = Color.WHITE;
        this.surfaceType = surfaceType;
    }

    public void render(Graphics g){
        Polygon poly = new Polygon();
        for (int i = 0; i < vertices.length; i++){
            Point p = VertexConverter.convert(vertices[i]);
            poly.addPoint(p.x, p.y);
        }
        g.setColor(color);
        g.fillPolygon(poly);
    }

    public void setColor(Color color){
        this.color = color;
    }
}
