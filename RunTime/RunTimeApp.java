package RunTime;

import Engine.PhysicEngine;
import java.util.concurrent.TimeUnit;

/**
 * @author Linden Brochu
 * Porte d'entree du programme
 */
public class RunTimeApp {
    public static boolean endProgram = false;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        //Start UI by new Thread ---> fonctionnement en parallele avec les updates
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
        while (!endProgram){
            try {
                frameStart = System.currentTimeMillis();
                App.update();
                frameEnd = System.currentTimeMillis();
                timeToWait = frameEnd - frameStart;
                if (timeToWait < milisecondPerFrame)
                    TimeUnit.MILLISECONDS.sleep(milisecondPerFrame - timeToWait);
                else {
                    System.out.println(ANSI_RED + "Current \"fixed\" frame is to high for computer hardware" + ANSI_RESET);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
