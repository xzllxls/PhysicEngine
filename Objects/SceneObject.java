package Objects;

import Engine.Component;
import Engine.Scene;
import Engine.Script;

import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class SceneObject {
    public ArrayList<Script> scripts;
    public Transform transform = new Transform(this);
    Skeleton skeleton;

    public double mass;

    public SceneObject(ArrayList<Script> scripts, double mass){
        this.scripts = scripts;
        this.mass = mass;
        ajouterScene();
    }

    private void ajouterScene(){
        Scene.ajouterObject(this);
    }

    public void addScript(Script script){
        scripts.add(script);
    }
}
