package Objects.Rendering;


import Engine.UI.Display;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public class VertexParser {

    private static double scale = 1;

    public static Point convert(Vertex vertex){
        double x = vertex.x * scale;
        double y = vertex.y * scale;
        double depth = vertex.z * scale;
        double[] newVal = scale(x,y,depth);
        int x2 = (int) (Display.WIDTH / 2 + newVal[0]);
        int y2 = (int) (Display.HEIGHT / 2 - newVal[1]);

        Point point = new Point(x2, y2);
        return point;
    }

    private static double[] scale(double x, double y, double depth){
        double dist = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(x, y);
        double depth2 = 15 - depth;
        double localScale = Math.abs(1400/(depth2 + 1400));
        dist *= localScale;
        return new double[]{
            dist * Math.cos(theta),
                dist * Math.sin(theta)
        };
    }

}
