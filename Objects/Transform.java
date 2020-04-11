package Objects;

import Engine.Component;
import Engine.PhysicEngine;

/**
 * @author Linden Brochu
 */
public class Transform extends Component {
    public Position3D position = new Position3D(0,0,0);
    public Velocity velocity = new Velocity(0,0,0);
    public Acceleration acceleration = new Acceleration(0,0,0);

    public Transform(SceneObject parent) {
        super(parent);
    }

    public void appliquerTransorm(){
        Acceleration acc = new Acceleration(acceleration);
        acc.appliquerVecteur(PhysicEngine.AIR_RESISTANCE_VECTOR.scale(velocity));
        acc.scale(parent.mass);
        position.appliquerVecteur(velocity.appliquerVecteur(acc));
    }

    public void appliquerForce(Force[] forces){
        for (Force force : forces){
            acceleration.appliquerVecteur(force);
        }
    }
}
