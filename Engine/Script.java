package Engine;

import Objects.SceneObject;

/**
 * Script personnalisé de l'utilisateur
 * @author Linden Brochu
 */
public abstract class Script extends Component {
    /**
     * Instancier un nouveau script
     * @param parent SceneObject auquel le script est rataché
     */
    public Script(SceneObject parent){
        super(parent);
        parent.addScript(this);
        start();
    }

    /**
     * Initialiser le script
     */
    public abstract void start();

    /**
     * Sécance de mise à jour du script
     */
    public abstract void update();
}
