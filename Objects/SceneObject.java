package Objects;

import Engine.Scene;
import Engine.Script;

import java.util.ArrayList;

/**
 * Objet présent dans une scène
 * @author Linden Brochu
 */
public class SceneObject {
    public ArrayList<Script> scripts = new ArrayList<>(); //Liste de script
    public Transform transform = new Transform(this); //Composante transform de l'objet
    public Skeleton skeleton = new Skeleton(this); //Squelette et mesh de l'objet

    public double mass; //mass de l'objet

    /**
     * Instancier un objet de scène
     * @param mass Masse de l'objet
     */
    public SceneObject(double mass){
        this.mass = mass;
        ajouterScene();
    }

    /**
     * Permet de lier l'objet à la scène actuelle
     */
    private void ajouterScene(){
        Scene.ajouterObject(this);
    }

    /**
     * Permet d'ajouter un script sur l'objet
     * @param script Script à ajouter
     */
    public void addScript(Script script){
        scripts.add(script);
    }
}
