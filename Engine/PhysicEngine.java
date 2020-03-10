package Engine;

import Object.Vector3D;

/**
 * @author Linden Brochu
 */
public class PhysicEngine {
    public static final double GRAVITY = -1.0; //linearValue
    public static final double AIR_RESISTANCE = -1.0; //linearValue
    public static final int CONSTANT_FRAME = 30;

    public static final Vector3D GRAVITY_VECTOR = new Vector3D(0, -1, 0); //vectorValue
    public static final Vector3D AIR_RESISTANCE_VECTOR = new Vector3D(-1, -1, -1); //vectorValue

}
