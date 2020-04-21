package Objects.Rendering;

import Objects.Position;

import java.awt.*;

/**
 * <p lang="en">3 dimensions polygon</p>
 * <p lang="fr">Polygone à 3 dimensions</p>
 * @author Linden Brochu
 */
public abstract class TypePolygon {
    public Vertex[] vertices;
    public Color color;

    /**
     * <p lang="en">Surface type</p>
     * <p lang="fr">Type de surface</p>
     */
    public enum Surface {
        Soft, Solid
    }

    public Surface surfaceType;

    /**
     * <p lang="en">Instantiate a polygon</p>
     * <p lang="fr">Instantier un polygone</p>
     * @param surfaceType Type de surface
     * @param color Couleur
     * @param vertices Liste de vertex
     */
    public TypePolygon(Surface surfaceType, Color color, Vertex... vertices){
        this.vertices = vertices;
        this.color = color;
        this.surfaceType = surfaceType;
    }

    /**
     * <p lang="en">Instantiate a polygon</p>
     * <p lang="fr">Instancier un polygone</p>
     * @param surfaceType Type de surface
     * @param vertices Liste de vertex
     */
    public TypePolygon(Surface surfaceType, Vertex... vertices){
        this.vertices = vertices;
        this.color = Color.WHITE;
        this.surfaceType = surfaceType;
    }

    /**
     * <p lang="en">Render</p>
     * <p lang="fr">Fait le rendu</p>
     * @param g Graphic
     */
    public void render(Graphics g){
        Polygon poly = new Polygon();
        for (Vertex vertex : vertices) {
            Point p = VertexParser.convert(vertex);
            poly.addPoint(p.x, p.y);
        }
        g.setColor(color);
        g.fillPolygon(poly);
    }

    /**
     * <p lang="en">Render</p>
     * <p lang="fr">Fait le rendu</p>
     * @param g Graphic
     * @param pos Position absolue
     */
    public void render(Graphics g, Position pos){
        Polygon poly = new Polygon();
        for (Vertex vertex : vertices) {
            Point p = VertexParser.convert(Vertex.vertexFromPos(vertex, pos));
            poly.addPoint(p.x, p.y);
        }
        g.setColor(color);
        g.fillPolygon(poly);
    }

    /**
     * <p lang="en">Do a rotation</p>
     * <p lang="fr">Effectuer une rotation</p>
     * @param xDegree Degré x
     * @param yDegree Degré y
     * @param zDegree Degré z
     */
    public void rotate(double xDegree, double yDegree, double zDegree){
        for (Vertex vertex : vertices){
            VertexParser.rotateAxisX(vertex, xDegree);
            VertexParser.rotateAxisY(vertex, yDegree);
            VertexParser.rotateAxisZ(vertex, zDegree);
        }
    }

    /**
     * <p lang="en">Change the polygon color</p>
     * <p lang="fr">Change la couleur du polygone</p>
     * @param color Couleur
     */
    public void setColor(Color color){
        this.color = color;
    }
}
