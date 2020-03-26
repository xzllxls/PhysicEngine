package Engine;

import Objects.Vector3D;
import Objects.Position3D;

/**
 * @author Linden Brochu
 */
public class PathPoint {
    private Position3D initPoint;
    private Position3D finalPoint;
    private Vector3D vector;

    /**
     * Instancier un PathPoint et creer le vecteur entre les deux
     * @param initPoint Point initial
     * @param finalPoint Point final
     */
    public PathPoint(Position3D initPoint, Position3D finalPoint){
        this.initPoint = initPoint;
        this.finalPoint = finalPoint;
        vector = finalPoint.distanceFromPos(initPoint);
    }

    /**
     * Instancier un PathPoint vide
     */
    public PathPoint(){

    }

    /**
     * Determine le point final
     */
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
