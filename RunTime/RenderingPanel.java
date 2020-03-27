package RunTime;

import Objects.Transform;
import Rendered.*;
import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class RenderingPanel extends GraphicsRender{
    ArrayList<RenderObject> renderObjects = Viewport.renderObjects;
    Viewport viewport = Viewport.viewport;
    public static RenderingPanel renderingPanel;
    public static int width = 400;
    public static int height = 400;
    public static double hrot = 0;
    public static double vrot = 0;

    public void paneInit(){
        renderingPanel = this;
        Transform cameraTransform = new Transform(-15,0,0);
        camera = new Camera(Camera.View.Perspective, 1000, 600,cameraTransform.getPos(), 10, 10000,0,0);
    }
}