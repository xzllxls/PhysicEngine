import Engine.PhysicEngine;
import Engine.Scene;

public class Main {
    public static void main(String[] args) {
        try {
            PhysicEngine ph = new PhysicEngine(new Scene());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
