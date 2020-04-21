package Engine;

import Objects.SceneObject;

/**
 * <p lang="en">SceneObject's component</p>
 * <p lang="fr">Composante d'un SceneObject</p>
 * @author Linden Brochu
 */
public abstract class Component {
    protected SceneObject parent; //SceneObject parent

    /**
     * <p lang="en">Instantiate a component</p>
     * <p lang="fr">Instancier une composante</p>
     * @param parent SceneObject parent
     */
    public Component(SceneObject parent){
        this.parent = parent;
    }
}
