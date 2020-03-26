package Engine;

import Objects.Vector3D;

/**
 * @author Linden Brochu
 */
public class PhysicEngine {
    public static final double GRAVITY = -1.0; //linearValue
    public static final double AIR_RESISTANCE = -1.0; //linearValue
    public static final int CONSTANT_FRAME = 30;

    public static final Vector3D GRAVITY_VECTOR = new Vector3D(0, GRAVITY, 0); //vectorValue
    public static final Vector3D AIR_RESISTANCE_VECTOR = new Vector3D(AIR_RESISTANCE, AIR_RESISTANCE, AIR_RESISTANCE); //vectorValue

}
