package Objects.Rendering;

import Engine.Scene;
import Engine.TypePoint;
import Objects.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    /**
     * <p lang="en">Get the average depth</p>
     * <p lang="fr">Calcul la profondeur moyenne</p>
     * @return Profondeur moyenne
     */
    public double averageDepth(){
        double sum = 0;
        for (Vertex vertex : vertices)
            sum += vertex.z;
        return sum / vertices.length;
    }

    public Vertex averagePosition(){
        return PolygonParser.breakPolygon(this);
    }

    /**
     * <p lang="en">Sort the polygon</p>
     * <p lang="fr">Trie les polygones</p>
     * @param polygons Liste de polygones
     * @return Liste de polygones triée
     */
    public static TypePolygon[] sortPolygons(TypePolygon[] polygons){
        ArrayList<TypePolygon> list = new ArrayList<>(Arrays.asList(polygons));

        list.sort((o1, o2) -> {
            double diff = TypePoint.distance(o2.averagePosition(), Scene.camera.pos) - TypePoint.distance(o1.averagePosition(), Scene.camera.pos);
            if (diff > 0)
                return 1;
            else if (diff < 0)
                return -1;
            else return 0;
        });
        for (int i = 0; i < polygons.length; i++){
            polygons[i] = list.get(i);
        }
        return polygons;
    }
}
