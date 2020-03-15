package RunTime;


import Rendered.RenderObject;
import Rendered.Triangle;
import Rendered.Vertex;

import java.awt.*;


/**
 * @author Linden Brochu
 */
public class AppRenderer {
    public RenderObject object;

    public void start(){
        object = new RenderObject();
        object.getTris().add(new Triangle(new Vertex(100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(-100, 100, -100),
                Color.WHITE));
        object.getTris().add(new Triangle(new Vertex(100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(100, -100, -100),
                Color.RED));
        object.getTris().add(new Triangle(new Vertex(-100, 100, -100),
                new Vertex(100, -100, -100),
                new Vertex(100, 100, 100),
                Color.GREEN));
        object.getTris().add(new Triangle(new Vertex(-100, 100, -100),
                new Vertex(100, -100, -100),
                new Vertex(-100, -100, 100),
                Color.BLUE));
        object.mergeVertices();

    }

}
