package Objects.Rendering;


import Engine.Abstract.Camera;
import Engine.PhysicEngine;
import Engine.Scene;
import Engine.UI.Display;

import java.awt.*;

/**
 * <p lang="en">Vertex parser</p>
 * <p lang="fr">Modifieur de vertex</p>
 * @author Linden Brochu
 */
public class VertexParser {

    private static double scale = 1;

    /**
     * <p lang="en">Convert a vertex to a 2 dimensions screen point</p>
     * <p lang="fr">Convertir un vertex en un point d'écran en 2 dimensions</p>
     * @param vertex Vertex
     * @return Point
     */
    public static Point convert(Vertex vertex){
        double x = vertex.x * scale;
        double y = vertex.y * scale;
        double depth = vertex.z * scale;
        double[] newVal = {y, x};
        if (Scene.camera.type == Camera.CameraType.Perspective)
            newVal = scale(x,y,depth);
        int x2 = (int) (Display.WIDTH / 2 + newVal[1]);
        int y2 = (int) (Display.HEIGHT / 2 - newVal[0]);

        return new Point(x2, y2);
    }

    /**
     * <p lang="en">Scale a point</p>
     * <p lang="fr">Étire un point</p>
     * @param x Valeur x
     * @param y Valeur y
     * @param depth Profondeur
     * @return Coordonnées
     */
    private static double[] scale(double x, double y, double depth){
        double dist = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(x, y);
        double depth2 = 15 - depth;
        double localScale = Math.abs(1400/(depth2 + 1400));
        dist *= localScale;
        return new double[]{
            y + (y - dist * Math.cos(theta)) * 2,
            x + (x - dist * Math.sin(theta)) * 2
        };
    }

    /**
     * <p lang="en">Do a rotation on x axis</p>
     * <p lang="fr">Oppérer une rotation sur l'axe x</p>
     * @param vertex Vertex
     * @param degrees Degré
     */
    public static void rotateAxisX(Vertex vertex, double degrees){
        double radius = Math.sqrt(vertex.z * vertex.z + vertex.y * vertex.y);
        double theta = Math.atan2(vertex.z, vertex.y);
        theta += ((2 * PhysicEngine.PI) / 360) * degrees;
        vertex.y = radius * Math.cos(theta);
        vertex.z = radius * Math.sin(theta);
    }

    /**
     * <p lang="en">Do a rotation on y axis</p>
     * <p lang="fr">Oppérer une rotation sur l'axe y</p>
     * @param vertex Vertex
     * @param degrees Degré
     */
    public static void rotateAxisY(Vertex vertex, double degrees){
        double radius = Math.sqrt(vertex.x * vertex.x + vertex.z * vertex.z);
        double theta = Math.atan2(vertex.x, vertex.z);
        theta += ((2 * PhysicEngine.PI) / 360) * degrees;
        vertex.x = radius * Math.sin(theta);
        vertex.z = radius * Math.cos(theta);
    }

    /**
     * <p lang="en">Do a rotation on z axis</p>
     * <p lang="fr">Oppérer une rotation sur l'axe z</p>
     * @param vertex Vertex
     * @param degrees Degré
     */
    public static void rotateAxisZ(Vertex vertex, double degrees){
        double radius = Math.sqrt(vertex.x * vertex.x + vertex.y * vertex.y);
        double theta = Math.atan2(vertex.x, vertex.y);
        theta += ((2 * PhysicEngine.PI) / 360) * degrees;
        vertex.x = radius * Math.sin(theta);
        vertex.y = radius * Math.cos(theta);
    }

}
