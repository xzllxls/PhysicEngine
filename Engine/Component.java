package Engine;

import Objects.SceneObject;

/**
 * Composante d'un SceneObject
 * @author Linden Brochu
 */
public abstract class Component {
    protected SceneObject parent; //SceneObject parent

    /**
     * Instancier une composante
     * @param parent SceneObject parent
     */
    public Component(SceneObject parent){
        this.parent = parent;
    }
}
