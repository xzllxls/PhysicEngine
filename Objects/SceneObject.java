package Objects;

import Engine.Component;
import Engine.Scene;

import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class SceneObject {
    ArrayList<Component> components;

    public SceneObject(ArrayList<Component> components){
        this.components = components;
        ajouterScene();
    }

    private void ajouterScene(){
        Scene.ajouterObject(this);
    }
}
