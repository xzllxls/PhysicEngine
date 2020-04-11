package Objects.Particle;

import Engine.Point;

/**
 * @author Linden Brochu
 */
public abstract class Particle extends Point {

    public Particle(double x, double y, double z) {
        super(x, y, z);
    }

    public Particle(){
        super();
    }
}
