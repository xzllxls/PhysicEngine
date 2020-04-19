package Objects.Rendering.Prefab;

import Objects.Position;
import Objects.Rendering.TypePolygon;
import Objects.Rendering.Vertex;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public abstract class TypePrism {
    public TypePolygon[] polygons;
    public Color color;

    public TypePrism(TypePolygon... polygons){
        this.color = Color.WHITE;
        this.polygons = polygons;
    }

    public TypePrism(Color color, TypePolygon... polygons){
        this.color = color;
        this.polygons = polygons;
    }

    public void setPolygonColor(){
        for (TypePolygon poly : polygons){
            poly.setColor(this.color);
        }
    }

    public void render(Graphics g){
        for (TypePolygon poly : polygons)
            poly.render(g);
    }

    public void render(Graphics g, Position pos){
        for (TypePolygon poly : polygons)
            poly.render(g, pos);
    }

    public void rotate(double xDegree, double yDegree, double zDegree){
        for (TypePolygon poly : polygons){
            poly.rotate(xDegree, yDegree, zDegree);
        }
        this.sortPolygons();
    }

    private void sortPolygons(){

    }
}
