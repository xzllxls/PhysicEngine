package Engine;

import Objects.SceneObject;

import java.time.Duration;
import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class Scene {
    static ArrayList<SceneObject> objects = new ArrayList<>();

    public static void ajouterObject(SceneObject object){
        objects.add(object);
    }

    public void start(){

    }

    public void updateStart() throws InterruptedException {
        long frameStart;
        long frameEnd;
        long frameTime;
        long maxFrameTime = Duration.ofSeconds(1).toMillis() / PhysicEngine.CONSTANT_FRAME;
        while (true){
             frameStart = System.currentTimeMillis();
             update();
             frameEnd = System.currentTimeMillis();
             frameTime = frameEnd - frameStart;
             if (maxFrameTime > frameTime)
                Thread.sleep(maxFrameTime - frameTime);
             else System.out.println(frameTime - maxFrameTime + " millisecondes de latence");
        }
    }

    private void update(){
        for (SceneObject elem : objects)
            elem.transform.appliquerTransorm();
    }

}
