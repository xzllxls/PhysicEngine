import Engine.PhysicEngine;
import Engine.Scene;
import Engine.SceneParser;
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
        object.transform.setPosition(0,30,0);
        object.transform.setRotation(0,0,0);

        PhysicEngine.scene.start();
    }
}
