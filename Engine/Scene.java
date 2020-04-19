package Engine;

import Engine.UI.Display;
import Objects.SceneObject;

import java.time.Duration;
import java.util.ArrayList;

/**
 * Scène de l'application
 * @author Linden Brochu
 */
public class Scene {
    public static ArrayList<SceneObject> objects = new ArrayList<>(); //Liste de tout les objets de la scène
    public Display display;
    public boolean running;
    public int fps = 0;
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
        display = new Display(this);
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
        long latence = 0;
        int fps = 0;
        long lastTimeFrame = System.currentTimeMillis();
        while (running){
             frameStart = System.currentTimeMillis();
             update();
             frameEnd = System.currentTimeMillis();
             frameTime = frameEnd - frameStart;
             if (maxFrameTime > frameTime + latence) {
                 latence = 0;
                 Thread.sleep(maxFrameTime - frameTime);
             }
             else {
                 latence += frameTime - maxFrameTime;
                 System.out.println(latence + " millisecondes de latence");
             }
             fps++;
             if(System.currentTimeMillis() - lastTimeFrame >= Duration.ofSeconds(1).toMillis()){
                this.fps = fps;
                fps = 0;
                lastTimeFrame = System.currentTimeMillis();
             }
        }
    }

    /**
     * Sécance de mise à jour de la scène
     */
    private void update(){
        for (SceneObject elem : objects) {
            for (Script script : elem.scripts)
                script.update();
            elem.transform.appliquerTransform();
        }
        display.runUpdate();
    }

}
