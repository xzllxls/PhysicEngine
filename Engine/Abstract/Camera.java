package Engine.Abstract;

import Objects.Position;
import Objects.Rotation;

/**
 * @author Linden Brochu
 */
public class Camera {
    public Position pos = new Position(0,0,-10);
    public Rotation rot = new Rotation(0,0,0);
    public double fov = 180;

    public enum CameraType {
        Orthographic, Perspective
    }

    public CameraType type = CameraType.Perspective;
}
