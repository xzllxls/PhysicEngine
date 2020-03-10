package Engine;

import Object.Vector3D;
import Object.Position3D;

/**
 * @author Linden Brochu
 */
public class PathPoint {
    private Position3D initPoint;
    private Position3D finalPoint;
    private Vector3D vector;

    public PathPoint(Position3D initPoint, Position3D finalPoint){
        this.initPoint = initPoint;
        this.finalPoint = finalPoint;
        vector = finalPoint.distanceFromPos(initPoint);
    }

    public PathPoint(){

    }

    public void knowFinalPoint(){
        finalPoint = new Position3D(initPoint, vector);
    }

    public Position3D getInitPoint() {
        return initPoint;
    }

    public void setInitPoint(Position3D initPoint) {
        this.initPoint = initPoint;
    }

    public Position3D getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(Position3D finalPoint) {
        this.finalPoint = finalPoint;
    }

    public Vector3D getVector() {
        return vector;
    }

    public void setVector(Vector3D vector) {
        this.vector = vector;
    }
}
