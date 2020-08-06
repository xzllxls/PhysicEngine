package Core.Engine;

public abstract class StaticBaseEngine extends BaseEngine {
    @Override
    public int start() {
        if (!assertAllModuleExist()) return -1;
        return 0;
    }

    protected abstract boolean assertAllModuleExist();
}
