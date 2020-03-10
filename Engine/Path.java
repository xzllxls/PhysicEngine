package Engine;

import Object.Position3D;
import java.time.Duration;
import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class Path {
    private ArrayList<PathPoint> pathPointArrayList = new ArrayList();
    private Duration time;
    private Position3D initPoint;
    private Position3D finalPoint;

    /**
     * Instancier un Path
     * @param time Duree du trajet
     * @param initialPos Position initiale
     */
    public Path(Duration time, Position3D initialPos){
        this.time = time;
        this.initPoint = initialPos;
    }

    public ArrayList<PathPoint> getPathPointArrayList() {
        return pathPointArrayList;
    }

    public void setPathPointArrayList(ArrayList<PathPoint> pathPointArrayList) {
        this.pathPointArrayList = pathPointArrayList;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
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
}
