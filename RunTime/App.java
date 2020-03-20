package RunTime;




/**
 * @author Linden Brochu
 */
public class App {

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
