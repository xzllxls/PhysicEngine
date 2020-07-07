import Engine.PhysicEngine;
import Engine.Scene;
import Objects.Rendering.Prefab.CubicPrism;
import Objects.Rendering.PrismObject;
import Objects.Rendering.TypePolygon;
import Objects.SceneObject;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        PhysicEngine.scene = new Scene();

        SceneObject object = new SceneObject(10);
        CubicPrism cube = new CubicPrism(Color.WHITE, TypePolygon.Surface.Solid, 10, 10, 10);
        PrismObject prism = new PrismObject(cube, 0, 0, 0);
        object.skeleton.setPrism(prism);
        object.transform.setPosition(-20,-10,0);
        object.transform.setRotation(0,0,0);
        object.transform.setVelocity(20, 20, 0);
        object.transform.setRotationVelocity(0,10,5);

        Scene.camera.setPos(0,0,-20);

        PhysicEngine.scene.start();
    }
}
