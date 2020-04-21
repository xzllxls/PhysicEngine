package Objects.Rendering.Prefab;

import Objects.Rendering.Quadrilateral;
import Objects.Rendering.TypePolygon;
import Objects.Rendering.Vertex;

import java.awt.*;

/**
 * <p lang="en">Rectangular base prism</p>
 * <p lang="fr">Prisme à base rectangulaire</p>
 * @author Linden Brochu
 */
public class CubicPrism extends TypePrism {

    /**
     * <p lang="en">Instantiate a cubic prism</p>
     * <p lang="fr">Instancier un prisme à base rectangulaire</p>
     * @param color Couleur
     * @param front Quadrilatère avant
     * @param back Quadrilatère arrière
     * @param left Quadrilatère gauche
     * @param top Quadrilatère haut
     * @param right Quadrilatère droit
     * @param bottom Quadrilatère bas
     */
    public CubicPrism(Color color, Quadrilateral front, Quadrilateral back, Quadrilateral left, Quadrilateral top, Quadrilateral right, Quadrilateral bottom){
        super(color, front, back, left, right, top, bottom);
    }

    /**
     * <p lang="en">Instantiate a cubic prism</p>
     * <p lang="fr">Instancier un prisme à base rectangulaire</p>
     * @param front Quadrilatère avant
     * @param back Quadrilatère arrière
     * @param left Quadrilatère gauche
     * @param top Quadrilatère haut
     * @param right Quadrilatère droit
     * @param bottom Quadrilatère bas
     */
    public CubicPrism(Quadrilateral front, Quadrilateral back, Quadrilateral left, Quadrilateral top, Quadrilateral right, Quadrilateral bottom){
        super(front, back, left, right, top, bottom);
    }

    /**
     * <p lang="en">Instantiate a cubic prism</p>
     * <p lang="fr">Instancier un prisme à base rectangulaire</p>
     * @param color Couleur
     * @param surface Type de surface
     * @param width Largeur
     * @param height Hauteur
     * @param depth Profondeur
     */
    public CubicPrism(Color color, TypePolygon.Surface surface, double width, double height, double depth){
        super(color, calculate(surface, width, height, depth));
    }

    /**
     * <p lang="en">Calculate a prism</p>
     * <p lang="fr">Calculer un prism</p>
     * @param surface Type de surface
     * @param width Largeur
     * @param height Hauteur
     * @param depth Profondeur
     * @return Liste de quadrilatères
     */
    private static Quadrilateral[] calculate(TypePolygon.Surface surface, double width, double height, double depth){
        Quadrilateral front, back, left, top, right, bottom;
        Vertex v1 = new Vertex(-(width/2), height/2, depth/2);
        Vertex v2 = new Vertex(-(width/2), -height/2, depth/2);
        Vertex v3 = new Vertex((width/2), -height/2, depth/2);
        Vertex v4 = new Vertex((width/2), height/2, depth/2);
        Vertex v5 = new Vertex(-(width/2), height/2, -depth/2);
        Vertex v6 = new Vertex(-(width/2), -height/2, -depth/2);
        Vertex v7 = new Vertex((width/2), -height/2, -depth/2);
        Vertex v8 = new Vertex((width/2), height/2, -depth/2);
        front = new Quadrilateral(surface, Color.red, v5, v6, v7, v8);
        back = new Quadrilateral(surface, Color.MAGENTA, v1, v2, v3, v4);
        left = new Quadrilateral(surface, Color.GREEN, v1, v2, v6, v5);
        top = new Quadrilateral(surface, Color.CYAN, v1, v4, v8, v5);
        right = new Quadrilateral(surface, Color.ORANGE, v3, v4, v8, v7);
        bottom = new Quadrilateral(surface, Color.PINK, v2, v3, v7, v6);
        return new Quadrilateral[]{front, back, left, top, right, bottom};
    }
}
