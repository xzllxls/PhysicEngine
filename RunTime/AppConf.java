package RunTime;

/**
 * @author Linden Brochu
 */
public class AppConf {
    public enum AppType {
        ModelView, ModelMaker, SimpleApp, UIBuilder, SceneBuilder
    }
    public static AppType appType = AppType.ModelView;
    public static int width = 1000;
    public static int height = 600;
    public static String title = "DefaultAppTitle";
    public static boolean canResize = false;
}
