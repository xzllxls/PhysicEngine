package Objects.Rendering.Prefab;

import Engine.PhysicEngine;
import Objects.Position;
import Objects.Rendering.TypePolygon;

import java.awt.*;

/**
 * <p lang="en">Prism</p>
 * <p lang="fr">Prisme</p>
 * @author Linden Brochu
 */
public abstract class TypePrism {
    public TypePolygon[] polygons;
    public Color color;

    /**
     * <p lang="en">Instantiate a prism</p>
     * <p lang="fr">Instancier un prism</p>
     * @param polygons Liste de polygones
     */
    public TypePrism(TypePolygon... polygons){
        this.color = Color.WHITE;
        this.polygons = polygons;
    }

    /**
     * <p lang="en">Instantiate a prism</p>
     * <p lang="fr">Instancier un prism</p>
     * @param color Couleur
     * @param polygons Liste de polygones
     */
    public TypePrism(Color color, TypePolygon... polygons){
        this.color = color;
        this.polygons = polygons;
    }

    /**
     * <p lang="en">Change every polygon color to the prism color</p>
     * <p lang="fr">Change la couleur de chaque polygone pour la couleur du prism</p>
     */
    public void setPolygonColor(){
        for (TypePolygon poly : polygons){
            poly.setColor(this.color);
        }
    }

    /**
     * <p lang="en">Render</p>
     * <p lang="fr">Fait le rendu</p>
     * @param g Graphic
     */
    public void render(Graphics g){
        for (TypePolygon poly : polygons)
            poly.render(g);
    }

    /**
     * <p lang="en">Render</p>
     * <p lang="fr">Fait le rendu</p>
     * @param g Graphic
     * @param pos Position absolue
     */
    public void render(Graphics g, Position pos){
        for (TypePolygon poly : polygons)
            poly.render(g, pos);
    }

    /**
     * <p lang="en">Do a rotation</p>
     * <p lang="fr">Effectuer une rotation</p>
     * @param xDegree Degré x
     * @param yDegree Degré y
     * @param zDegree Degré z
     */
    public void rotate(double xDegree, double yDegree, double zDegree){
        for (TypePolygon poly : polygons){
            poly.rotate(xDegree / PhysicEngine.CONSTANT_FRAME, yDegree / PhysicEngine.CONSTANT_FRAME, zDegree / PhysicEngine.CONSTANT_FRAME);
        }
        this.sortPolygons();
    }

    private void sortPolygons(){

    }
}
