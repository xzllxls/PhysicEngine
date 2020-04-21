package Objects;

import Engine.Scene;
import Engine.Script;

import java.util.ArrayList;

/**
 * <p lang="en">An object in a scene</p>
 * <p lang="fr">Objet présent dans une scène</p>
 * @author Linden Brochu
 */
public class SceneObject {
    public ArrayList<Script> scripts = new ArrayList<>(); //Liste de script
    public Transform transform = new Transform(this); //Composante transform de l'objet
    public Skeleton skeleton = new Skeleton(this); //Squelette et mesh de l'objet

    public double mass; //mass de l'objet

    /**
     * <p lang="en">Instantiate a scene's object</p>
     * <p lang="fr">Instancier un objet de scène</p>
     * @param mass Masse de l'objet
     */
    public SceneObject(double mass){
        this.mass = mass;
        ajouterScene();
    }

    /**
     * <p lang="en">Link the object to the actual scene</p>
     * <p lang="fr">Lier l'objet à la scène actuelle</p>
     */
    private void ajouterScene(){
        Scene.ajouterObject(this);
    }

    /**
     * <p lang="en">Add a script to the object</p>
     * <p lang="fr">Ajouter un script sur l'objet</p>
     * @param script Script à ajouter
     */
    public void addScript(Script script){
        scripts.add(script);
    }
}
