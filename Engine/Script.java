package Engine;

import Objects.SceneObject;

/**
 * <p lang="en">Personalised user script</p>
 * <p lang="fr">Script personnalisé de l'utilisateur</p>
 * @author Linden Brochu
 */
public abstract class Script extends Component {

    /**
     * <p lang="en">Instantiate a new script</p>
     * <p lang="fr">Instancier un nouveau script</p>
     * @param parent SceneObject auquel le script est rataché
     */
    public Script(SceneObject parent){
        super(parent);
        parent.addScript(this);
        start();
    }

    /**
     * @en Initialize the script
     * @fr Initialiser le script
     */
    public abstract void start();

    /**
     * <p lang="en">Script's update sequence</p>
     * <p lang="en">Sécance de mise à jour du script</p>
     */
    public abstract void update();
}
