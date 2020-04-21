package Objects;

import Engine.Component;
import Engine.PhysicEngine;
import Engine.Vector;
import Objects.Modules.Transform.CollisionManager;

/**
 * <p lang="en">Transform component</p>
 * <p lang="fr">Composante de mouvement</p>
 * @author Linden Brochu
 */
public class Transform extends Component {
    public Position position = new Position(0,0,0);
    public Velocity velocity = new Velocity(0,0,0);
    public Acceleration acceleration = new Acceleration(0,0,0);
    public CollisionManager collisionManager;

    /**
     * <p lang="en">Instantiate a transform component</p>
     * <p lang="fr">Instancier une composante de mouvement</p>
     * @param parent SceneObject parent
     */
    public Transform(SceneObject parent) {
        super(parent);
    }

    /**
     * <p lang="en">Move the modal</p>
     * <p lang="fr">Déplace le model</p>
     * @param x Mouvement x
     * @param y Mouvement y
     * @param z Mouvement z
     */
    public void translate(double x, double y, double z){
        position.move(x, y, z);
    }

    /**
     * <p lang="en">Move the modal</p>
     * <p lang="fr">Déplace le model</p>
     * @param vector Vecteur de déplacement
     */
    public void translate(Vector vector){
        position.move(vector.x, vector.y, vector.z);
    }

    /**
     * <p lang="en">Absolute change of position</p>
     * <p lang="fr">Changement absolu de position</p>
     * @param x Position x
     * @param y Position y
     * @param z Position z
     */
    public void setPosition(double x, double y, double z){
        position.x = x;
        position.y = y;
        position.z = z;
    }

    /**
     * <p lang="en">Applied acceleration and velocity vector</p>
     * <p lang="fr">Applique les vecteurs d'accélération et de vitesse</p>
     */
    public void appliquerTransform(){
        appliquerAcceleration();
        appliquerVelocity();
    }

    /**
     * <p lang="en">Applied the gravity and air friction</p>
     * <p lang="fr">Appliquer les vecteurs de gravité et de friction de l'air</p>
     */
    private void appliquerAcceleration(){
        Acceleration acc = new Acceleration(acceleration);
        acc.appliquerVecteur(new Force(PhysicEngine.GRAVITY_VECTOR));
        acc.appliquerVecteur((new Force(PhysicEngine.AIR_RESISTANCE_VECTOR)).scale(velocity));
        velocity.appliquerVecteur(acc.scale(1.0/PhysicEngine.CONSTANT_FRAME));
        velocity.roundMin(PhysicEngine.VECTOR_MIN_LIMIT);
    }

    /**
     * <p lang="en">Applied velocity on position</p>
     * <p lang="fr">Appliquer la vitesse sur la position</p>
     */
    private void appliquerVelocity(){
        position.appliquerVecteur(new Velocity(velocity).scale(PhysicEngine.PIXEL_PER_METER/PhysicEngine.CONSTANT_FRAME));
    }

    /**
     * <p lang="en">Applied a group of force on the acceleration</p>
     * <p lang="fr">Appliquer un groupe de force sur l'accélération</p>
     * @param forces Forces à appliquer
     */
    public void appliquerForce(Force... forces){
        for (Force force : forces){
            acceleration.appliquerVecteur(new Acceleration(force.x, force.y, force.z).scale(1.0/parent.mass));
        }
    }
}
