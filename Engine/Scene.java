package Engine;

import Engine.UI.Display;
import Objects.SceneObject;

import java.time.Duration;
import java.util.ArrayList;

/**
 * <p lang="en">App scene</p>
 * <p lang="fr">Scène de l'application</p>
 * @author Linden Brochu
 */
public class Scene {
    public static ArrayList<SceneObject> objects = new ArrayList<>(); //Liste de tout les objets de la scène
    public Display display;
    public boolean running;
    public int fps = 0;

    /**
     * <p lang="en">Add an object to the scene</p>
     * <p lang="fr">Ajouter un objet à la scène</p>
     * @param object SceneObject à ajouter
     */
    public static void ajouterObject(SceneObject object){
        objects.add(object);
    }

    /**
     * <p lang="en">Initialize the scene</p>
     * <p lang="fr">Initialise la scène</p>
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
     * <p lang="en">Start scene's update sequence</p>
     * <p lang="fr">Démarre la sécance de mise à jour de la scène</p>
     * @throws InterruptedException Exception
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
     * <p lang="en">Scene's update sequence</p>
     * <p lang="fr">Sécance de mise à jour de la scène</p>
     */
    private void update(){
        for (SceneObject elem : objects) {
            for (Script script : elem.scripts)
                script.update();
            elem.transform.appliquerTransform();
        }
        display.runUpdate();
    }

    /**
     * <p lang="en">Reinitialize the scene</p>
     * <p lang="fr">Réinitialise la scène</p>
     */
    public static void clearScene(){
        objects.clear();
    }
}
