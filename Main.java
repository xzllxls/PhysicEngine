import Engine.PhysicEngine;
import Engine.Scene;
import Objects.SceneObject;

public class Main {
    public static void main(String[] args) {
        SceneObject object = new SceneObject(10);
        SceneObject object2 = new SceneObject(10);
        PhysicEngine.scene = new Scene();
        PhysicEngine.scene.start();
    }
}
