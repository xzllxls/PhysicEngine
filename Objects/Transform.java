package Objects;

import Engine.Component;
import Engine.PhysicEngine;
import Engine.Vector;
import Objects.Modules.Transform.CollisionManager;

/**
 * @author Linden Brochu
 */
public class Transform extends Component {
    public Position position = new Position(0,0,0);
    public Velocity velocity = new Velocity(0,0,0);
    public Acceleration acceleration = new Acceleration(0,0,0);
    public CollisionManager collisionManager;

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

    public void appliquerTransform(){
        appliquerAcceleration();
        appliquerVelocity();
    }

    private void appliquerAcceleration(){
        Acceleration acc = new Acceleration(acceleration);
//        acc.appliquerVecteur(new Force(PhysicEngine.GRAVITY_VECTOR));
        acc.appliquerVecteur((new Force(PhysicEngine.AIR_RESISTANCE_VECTOR)).scale(velocity));
        velocity.appliquerVecteur(acc.scale(1.0/PhysicEngine.CONSTANT_FRAME));
//        velocity.roundMin(PhysicEngine.vectorMinLimit);
    }

    private void appliquerVelocity(){
        position.appliquerVecteur(new Velocity(velocity).scale(PhysicEngine.PIXEL_PER_METER));
    }

    public void appliquerForce(Force... forces){
        for (Force force : forces){
            acceleration.appliquerVecteur(new Acceleration(force.x, force.y, force.z).scale(1.0/parent.mass));
        }
    }
}
