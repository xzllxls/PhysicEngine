package Engine.Abstract;

import Engine.TypePoint;
import Engine.Vector;

/**
 * @author Linden Brochu
 */
public class ObjectVector extends Vector {
    public ObjectVector(double x, double y, double z) {
        super(x, y, z);
    }

    public static ObjectVector fromPoint(TypePoint p1, TypePoint p2){
        return new ObjectVector(p1.x - p2.x, p1.y - p2.y, p1.z - p2.z);
    }
}
