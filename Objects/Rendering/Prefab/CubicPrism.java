package Objects.Rendering.Prefab;

import Engine.Vector;
import Objects.Rendering.Quadrilateral;
import Objects.Rendering.TypePolygon;
import Objects.Rendering.Vertex;

import java.awt.*;

public class CubicPrism extends TypePrism {

    public CubicPrism(Color color, Quadrilateral front, Quadrilateral back, Quadrilateral left, Quadrilateral top, Quadrilateral right, Quadrilateral bottom){
        super(color, front, back, left, right, top, bottom);
    }

    public CubicPrism(Quadrilateral front, Quadrilateral back, Quadrilateral left, Quadrilateral top, Quadrilateral right, Quadrilateral bottom){
        super(front, back, left, right, top, bottom);
    }

    public CubicPrism(Color color, TypePolygon.Surface surface, double width, double height, double depth){
        super(color, calculate(surface, width, height, depth));
    }

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
