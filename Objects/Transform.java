package Objects;

import Engine.Component;
import Engine.PhysicEngine;
import Engine.Vector;

/**
 * @author Linden Brochu
 */
public class Transform extends Component {
    public Position position = new Position(0,0,0);
    public Velocity velocity = new Velocity(0,0,0);
    public Acceleration acceleration = new Acceleration(0,0,0);

    public Transform(SceneObject parent) {
        super(parent);
    }

    public void translate(double x, double y, double z){
        position.move(x, y, z);
    }

    public void translate(Vector vector){
        position.move(vector.x, vector.y, vector.z);
    }

    public void setPosition(double x, double y, double z){
        position.x = x;
        position.y = y;
        position.z = z;
    }

    public void appliquerTransorm(){
        Acceleration acc = new Acceleration(acceleration);
        acc.appliquerVecteur(PhysicEngine.AIR_RESISTANCE_VECTOR.scale(velocity));
        acc.scale(parent.mass / PhysicEngine.CONSTANT_FRAME);
        position.appliquerVecteur(velocity.appliquerVecteur(acc));
    }

    public void appliquerForce(Force[] forces){
        for (Force force : forces){
            acceleration.appliquerVecteur(force);
        }
    }
}
