package Core.Engine;

public class RunningEngine extends BaseEngine {

    public static HandlerEngine handler;

    @Override
    public int start() {
        int handlerCode = RunningEngine.handler.start();
        if (handlerCode != 0) return -1;
        return 0;
    }
}
