package Objects.Modules.Transform;

import Engine.Event.Exception.ColliderException;
import Engine.Script;
import Objects.SceneObject;

/**
 * @author Linden Brochu
 */
public class CollisionManager extends Script{
    public CompoundCollider colliders = null;

    /**
     * Instancier un ColliderManager
     * @param parent SceneObject auquel le script est rataché
     */
    public CollisionManager(SceneObject parent) {
        super(parent);
    }

    public void addCompoundCollider(CompoundCollider colliders){
        this.colliders = colliders;
    }

    @Override
    public void start(){

    }

    @Override
    public void update() {

    }


}
