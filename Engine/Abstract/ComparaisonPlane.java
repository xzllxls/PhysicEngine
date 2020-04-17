package Engine.Abstract;

import Engine.Grid;
import Engine.TypePoint;
import Objects.Position;
import Objects.Rendering.TypePolygon;

/**
 * @author Linden Brochu
 */
public class ComparaisonPlane extends Grid {
    public ComparaisonPlane(TypePoint p1, TypePoint p2, TypePoint normalSetter, TypePolygon poly){
        super(createPlaneMatrix(p1, p2, normalSetter)[0], createPlaneMatrix(p1, p2, normalSetter)[1], createPlaneMatrix(p1, p2, normalSetter)[2]);
    }

    public static double[][] createPlaneMatrix(TypePoint p1, TypePoint p2, TypePoint normalSetter){
        Position pos = new Position((p1.x + p2.x)/2,(p1.y + p2.y)/2,(p1.z + p2.z)/2);
        ObjectVector vector = ObjectVector.fromPoint(pos, normalSetter);
    }
}
