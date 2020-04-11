package Objects;

import Engine.Vector;

/**
 * @author Linden Brochu
 */
public class Acceleration extends Vector {

    public Acceleration(Acceleration acc){
        super(acc);
    }

    public Acceleration(double x, double y, double z) {
        super(x, y, z);
    }

    public Acceleration(){
        super();
    }
}
