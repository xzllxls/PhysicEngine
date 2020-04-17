package Objects.Particle;

import Engine.TypePoint;

/**
 * @author Linden Brochu
 */
public abstract class Particle extends TypePoint {

    public Particle(double x, double y, double z) {
        super(x, y, z);
    }

    public Particle(){
        super();
    }
}
