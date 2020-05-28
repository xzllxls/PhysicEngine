package Objects;

import Engine.Component;
import Engine.PhysicEngine;
import Engine.Vector;

/**
 * <p lang="en">Transform component</p>
 * <p lang="fr">Composante de mouvement</p>
 * @author Linden Brochu
 */
public class Transform extends Component {
    public Position position = new Position(0,0,0);
    public Rotation rotation = new Rotation(0,0,0);
    public Velocity velocity = new Velocity(0,0,0);
    public Velocity rotationVelocity = new Velocity(0,0,0);
    public Acceleration acceleration = new Acceleration(0,0,0);
    public Acceleration rotationAcceleration = new Acceleration(0,0,0);

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
        position.appliquerVecteur(vector);
    }

    /**
     * <p lang="en">Rotate the modal</p>
     * <p lang="fr">Rotationne le model</p>
     * @param x Degree x
     * @param y Degree y
     * @param z Degree z
     */
    public void rotate(double x, double y, double z){
        double tempX = rotation.x + x;
        double tempY = rotation.y + y;
        double tempZ = rotation.z + z;
        if (parent.skeleton.prism != null){
            rotation.setRotation(x, y, z);
            parent.skeleton.prism.rotate(false);
        }
        rotation.setRotation(tempX, tempY, tempZ);
    }

    public void rotate(Vector vector){
        rotate(vector.x, vector.y, vector.z);
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
     * <p lang="en">Absolute change of rotation</p>
     * <p lang="fr">Changement absolu de rotation</p>
     * @param x Rotation x
     * @param y Rotation y
     * @param z Rotation z
     */
    public void setRotation(double x, double y, double z){
        if (parent.skeleton.prism != null){
            rotation.setRotation(-rotation.x, -rotation.y, -rotation.z);
            parent.skeleton.prism.rotate(true);
        }
        rotation.setRotation(x, y, z);
        if (parent.skeleton.prism != null){
            parent.skeleton.prism.rotate(true);
        }
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
        acc.appliquerVecteur((new Force(PhysicEngine.AIR_RESISTANCE_VECTOR)).scale(velocity).exp(1,2));
        if (acc.linearDistance != 0) {
            velocity.appliquerVecteur(acc.scale(1.0 / PhysicEngine.CONSTANT_FRAME));
            velocity.roundMin(PhysicEngine.VECTOR_MIN_LIMIT);
        }
        acc = new Acceleration(rotationAcceleration);
        acc.appliquerVecteur((new Force(PhysicEngine.AIR_RESISTANCE_VECTOR)).scale(rotationVelocity).exp(1,2));
        if (acc.linearDistance != 0) {
            rotationVelocity.appliquerVecteur(acc.scale(1.0 / PhysicEngine.CONSTANT_FRAME));
            rotationVelocity.roundMin(PhysicEngine.VECTOR_MIN_LIMIT);
        }
    }

    /**
     * <p lang="en">Applied velocity on position</p>
     * <p lang="fr">Appliquer la vitesse sur la position</p>
     */
    private void appliquerVelocity(){
        System.out.println(velocity.y);
        if (velocity.linearDistance != 0)
            translate(new Velocity(velocity).scale(1.0/PhysicEngine.CONSTANT_FRAME));
        if (rotationVelocity.linearDistance != 0)
            rotate(new Velocity(rotationVelocity));
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
