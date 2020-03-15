package RunTime;

import Object.SceneObject;
import Rendered.RenderObject;

/**
 * @author Linden Brochu
 */
public class App {
    SceneObject object;

    /**
     * Appeler au demarage
     */
    public void startApp(){
        object = new SceneObject(10, false);
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
