package Objects;

import Engine.Component;
import Engine.Scene;

import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class SceneObject {
    public ArrayList<Component> components;
    public Transform transform = new Transform();
    Skeleton skeleton;

    public SceneObject(ArrayList<Component> components){
        this.components = components;
        ajouterScene();
    }

    private void ajouterScene(){
        Scene.ajouterObject(this);
    }
}
