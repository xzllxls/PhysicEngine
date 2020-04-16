package Objects.Modules.Skeleton;

import Engine.Component;
import Engine.Module.ComponentModule;
import Engine.Module.ComponentModuleGroup;
import Objects.SceneObject;

/**
 * @author Linden Brochu
 */
public class MuscleSkeleton extends Component implements ComponentModule {
    /**
     * Instancier un squelette de muscle
     * @param parent SceneObject parent
     */
    public MuscleSkeleton(SceneObject parent) {
        super(parent);
    }


    @Override
    public void setGroup(ComponentModuleGroup g) {

    }
}
