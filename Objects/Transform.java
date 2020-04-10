package Objects;

import Engine.Component;

/**
 * @author Linden Brochu
 */
public class Transform extends Component {
    public Position3D position = new Position3D(0,0,0);
    public Velocity velocity = new Velocity(0,0,0);
    public Acceleration acceleration = new Acceleration(0,0,0);

    public void appliquerTransorm(){
        position.appliquerVecteur(velocity.appliquerVecteur(acceleration));
    }
}
