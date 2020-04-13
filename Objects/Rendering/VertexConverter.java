package Objects.Rendering;


import Engine.UI.Display;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public class VertexConverter {
    public static Point convert(Vertex vertex){
        int x = (int) (Display.WIDTH / 2 + vertex.x);
        int y = (int) (Display.HEIGHT / 2 - vertex.y);

        Point point = new Point(x, y);
        return point;
    }

}
