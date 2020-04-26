package Engine.Abstract;

import Objects.Position;

/**
 * @author Linden Brochu
 */
public class Camera {
    public Position pos = new Position(0,0,0);

    public enum CameraType {
        Orthographic, Perspective
    }

    public CameraType type = CameraType.Perspective;
}
