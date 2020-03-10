package Engine;

import java.time.Duration;
import Object.Position3D;
import Object.Vector3D;

/**
 * @author Linden Brochu
 */
public class PathMath {
    public static PathPoint createPathPoint (Position3D initialPos, Vector3D vector3D){
        PathPoint point = new PathPoint();
        point.setInitPoint(initialPos);
        point.setVector(vector3D);
        point.knowFinalPoint();
        return point;
    }

    public static Path createPath(Duration time, Position3D initialPos, Velocity vel, Acceleration acc){
        Path path = new Path(time, initialPos);
        Velocity newVel = new Velocity();
        Acceleration newAcc = new Acceleration();
        newVel.setVit(vel.getVit().cloneVector());
        newVel.getVit().subMultiplicator(PhysicEngine.CONSTANT_FRAME);
        newAcc.setNewtonVector(acc.getNewtonVector().cloneVector());
        newAcc.getNewtonVector().subMultiplicator(PhysicEngine.CONSTANT_FRAME);

        for (int i = 0; i < time.getSeconds() * PhysicEngine.CONSTANT_FRAME; i++){
            newVel.getVit().add(newAcc.getNewtonVector());
            if (i == 0){
                path.getPathPointArrayList().add(createPathPoint(initialPos, newVel.getVit()));
            }
            else{
                path.getPathPointArrayList().add(createPathPoint(path.getPathPointArrayList().get(i - 1).getFinalPoint(),
                        newVel.getVit()));
            }
        }
        return path;
    }
}
