package RunTime;

import Engine.PhysicEngine;
import java.util.concurrent.TimeUnit;

/**
 * @author Linden Brochu
 * Porte d'entree du programme
 * Modifier UI ici
 */
public class RunTimeApp {
    public static boolean endProgram = false;

    public static void main(String[] args) {
        //Start UI
        update();
    }

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
                else System.out.println("Current \"fixed\" frame is to high for computer hardware");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
