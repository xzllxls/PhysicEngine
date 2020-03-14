package RunTime;

import Engine.*;
import Object.SceneObject;
import Object.Position3D;
import Object.PathListener;

import java.time.Duration;

public class App {
    SceneObject object;
    Path path;

    /**
     * Appeler au demarage
     */
    public void startApp(){
        object = new SceneObject(10, false);
        path = PathMath.createPath(Duration.ofSeconds(3), Position3D.clone(object.getTransform().getPos()),
                new Velocity(object.getVitesse().getVit()), PhysicsMath.calculAcc(object.getMass(),
                        new Force(3, 3, 3)));
        object.setPathListener(new PathListener(path));
    }

    /**
     * Appeler plusieurs fois par seconde
     */
    public void update(){
        //Call your object update function
        object.followSimplePath();
    }

    /**
     * Permet de fermer l'application
     */
    public static void appQuit(){
        RunTimeApp.endProgram = true;
    }

}
