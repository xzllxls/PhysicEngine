package Objects.Rendering;


import Engine.PhysicEngine;
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
        int x2 = (int) (Display.WIDTH / 2 + newVal[1]);
        int y2 = (int) (Display.HEIGHT / 2 - newVal[0]);

        return new Point(x2, y2);
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

    public static void rotateAxisX(Vertex vertex, double degrees){
        double radius = Math.sqrt(vertex.z * vertex.z + vertex.y * vertex.y);
        double theta = Math.atan2(vertex.z, vertex.y);
        theta += ((2 * PhysicEngine.PI) / 360) * degrees;
        vertex.y = radius * Math.cos(theta);
        vertex.z = radius * Math.sin(theta);
    }

    public static void rotateAxisY(Vertex vertex, double degrees){
        double radius = Math.sqrt(vertex.x * vertex.x + vertex.z * vertex.z);
        double theta = Math.atan2(vertex.z, vertex.x);
        theta += ((2 * PhysicEngine.PI) / 360) * degrees;
        vertex.x = radius * Math.cos(theta);
        vertex.z = radius * Math.sin(theta);
    }

    public static void rotateAxisZ(Vertex vertex, double degrees){
        double radius = Math.sqrt(vertex.x * vertex.x + vertex.y * vertex.y);
        double theta = Math.atan2(vertex.y, vertex.x);
        theta += ((2 * PhysicEngine.PI) / 360) * degrees;
        vertex.x = radius * Math.cos(theta);
        vertex.y = radius * Math.sin(theta);
    }

}
