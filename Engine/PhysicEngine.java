package Engine;

import Objects.Force;

/**
 * <p lang="en">Contain all physics constraints</p>
 * <p lang="fr">Contient toutes les constantes physiques</p>
 * @author Linden Brochu
 */
public class PhysicEngine {
    public static final double GRAVITY = 0; //linearValue
    public static final double AIR_RESISTANCE = -1.0; //linearValue
    public static final int CONSTANT_FRAME = 30;
    public static final double PI = 3.141592653589793; //+/- 1cm de perte par milliers de km
    public static final double PIXEL_PER_METER = 10; //Nb pixel pour former 1 mètre
    public static final double VECTOR_MIN_LIMIT = 0.01; //Vitesse minimal avant 0m/s (ex 0.01 -> 1 cm/s) (sera remplacé par la camera)

    public static final Force GRAVITY_VECTOR = new Force(0, GRAVITY, 0, Force.Type.Naturel); //Force de gravité
    public static final Force AIR_RESISTANCE_VECTOR = new Force(AIR_RESISTANCE, AIR_RESISTANCE, AIR_RESISTANCE, Force.Type.Scalable); //Résistance de l'air


    public static Scene scene;

}
