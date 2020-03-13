package Object;

import Engine.Velocity;

/**
 * @author Linden Brochu
 */
public class SceneObject {
    private int mass;
    private boolean rigid;
    private Transform transform;
    private Velocity vitesse;

    /**
     * Instancier un SceneObject
     * @param mass Masse de l'objet
     * @param rigid Determine si l'objet peut bouger
     */
    public SceneObject(int mass, boolean rigid){
        this.mass = mass;
        this.rigid = rigid;
        transform = new Transform(0, 0, 0, 0, 0, 0);
        if (rigid)
            vitesse = new Velocity();
        else vitesse = null;
    }
}
