package Engine;

import Objects.SceneObject;

/**
 * Script personnalisé de l'utilisateur
 * @author Linden Brochu
 */
public abstract class Script extends Component {
    public Script(SceneObject parent){
        super(parent);
        parent.addScript(this);
    }
}
