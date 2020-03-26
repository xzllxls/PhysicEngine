package RunTime;

import Object.SceneObject;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class App {
    public static ArrayList<SceneObject> sceneObjects = new ArrayList<SceneObject>();
    public static App app;
    public Controller controller = new Controller();
    /**
     * Appeler au demarage
     */
    public void startApp(){
        Thread.currentThread().setName("Math Thread");
        app = this;
    }

    /**
     * Appeler plusieurs fois par seconde
     */
    public void update(){
        //Call your object update function

    }

    /**
     * Permet de fermer l'application
     */
    public static void appQuit(){
        RunTimeApp.endProgram = true;
    }

}
