package RunTime;

import Object.SceneObject;
import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class App {
    public static ArrayList<SceneObject> sceneObjects = new ArrayList<SceneObject>();
    /**
     * Appeler au demarage
     */
    public void startApp(){

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
