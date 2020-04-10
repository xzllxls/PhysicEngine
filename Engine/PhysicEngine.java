package Engine;

import Objects.Force;

/**
 * @author Linden Brochu
 */
public class PhysicEngine {
    public static final double GRAVITY = -1.0; //linearValue
    public static final double AIR_RESISTANCE = -1.0; //linearValue
    public static final int CONSTANT_FRAME = 30;

    public static final Force GRAVITY_VECTOR = new Force(0, GRAVITY, 0);
    public static final Force AIR_RESISTANCE_VECTOR = new Force(AIR_RESISTANCE, AIR_RESISTANCE, AIR_RESISTANCE);
}
