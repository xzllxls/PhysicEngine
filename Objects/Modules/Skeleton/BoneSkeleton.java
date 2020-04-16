package Objects.Modules.Skeleton;

import Engine.Component;
import Engine.Module.ComponentModule;
import Engine.Module.ComponentModuleGroup;
import Objects.SceneObject;

/**
 * @author Linden Brochu
 */
public class BoneSkeleton extends Component implements ComponentModule {

    /**
     * Instancier un squelette d'os
     * @param parent SceneObject parent
     */
    public BoneSkeleton(SceneObject parent) {
        super(parent);
    }

    @Override
    public void setGroup(ComponentModuleGroup g) {

    }
}
