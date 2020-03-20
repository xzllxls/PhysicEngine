package RunTime;

import Engine.PhysicEngine;
import javafx.application.Application;

import java.util.concurrent.TimeUnit;

/**
 * @author Linden Brochu
 * Porte d'entree du programme
 */
public class RunTimeApp {
    public static boolean endProgram = false;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static App app = new App();
    public static ViewPort viewPort = new ViewPort();

    public static void main(String[] args) throws InterruptedException {

        if (AppConf.hasUI && !AppConf.hasViewPort)
            Application.launch(UI.class, args);
        else if (AppConf.hasViewPort && !AppConf.hasUI)
            new Thread(viewPort).start();
        else {
            Application.launch(UI.class, args);
            new Thread(viewPort).start();
        }
        update();
    }

    /**
     * Permet d'executer du code un certain nombre de fois par seconde
     * Presente une certaine instabilite, possibilite de crash soudain
     */
    public static void update(){
        long frameStart;
        long frameEnd;
        long timeToWait;
        long milisecondPerFrame = 1000 / PhysicEngine.CONSTANT_FRAME;
        app.startApp();
        while (!endProgram){
            try {
                frameStart = System.currentTimeMillis();
                app.update();
                frameEnd = System.currentTimeMillis();
                timeToWait = frameEnd - frameStart;
                if (timeToWait < milisecondPerFrame)
                    TimeUnit.MILLISECONDS.sleep(milisecondPerFrame - timeToWait);
                else {
                    System.out.println(ANSI_RED + "Current \"fixed\" frame rate is to high for computer hardware" + ANSI_RESET);
                    System.out.println((timeToWait - milisecondPerFrame) + " miliseconds of latence");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
