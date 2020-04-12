package Engine;

import Objects.Force;

/**
 * Contient toutes les constantes physiques
 * @author Linden Brochu
 */
public class PhysicEngine {
    public static final double GRAVITY = -1.0; //linearValue
    public static final double AIR_RESISTANCE = -1.0; //linearValue
    public static final int CONSTANT_FRAME = 30;
    public static final double PI = 3.141592653589793; //+/- 1cm de perte par milliers de km

    public static final Force GRAVITY_VECTOR = new Force(0, GRAVITY, 0, Force.Type.Naturel); //Force de gravité
    public static final Force AIR_RESISTANCE_VECTOR = new Force(AIR_RESISTANCE, AIR_RESISTANCE, AIR_RESISTANCE, Force.Type.Scalable); //Résistance de l'air

    /**
     * Créer une instance de la physique
     * @param scene Scène du logiciel
     */
    public PhysicEngine(Scene scene) throws InterruptedException {
        scene.start();
    }
}
