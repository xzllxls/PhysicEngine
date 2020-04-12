package Engine;

import Objects.SceneObject;

import java.time.Duration;
import java.util.ArrayList;

/**
 * Scène de l'application
 * @author Linden Brochu
 */
public class Scene {
    public static ArrayList<SceneObject> objects = new ArrayList<>(); //Liste de tout les objets de la scène

    /**
     * Ajouter un objet à la scène
     * @param object SceneObject à ajouter
     */
    public static void ajouterObject(SceneObject object){
        objects.add(object);
    }

    /**
     * Initialise la scène
     */
    public void start(){
        for (SceneObject elem : objects) {
            for (Script script : elem.scripts)
                script.start();
        }
        try {
            updateStart();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Démarre la sécance de mise à jour de la scène
     * @throws InterruptedException
     */
    private void updateStart() throws InterruptedException {
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

    /**
     * Sécance de mise à jour de la scène
     */
    private void update(){
        for (SceneObject elem : objects) {
            elem.transform.appliquerTransorm();
            for (Script script : elem.scripts)
                script.update();
        }
    }

}
