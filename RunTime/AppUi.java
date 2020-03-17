package RunTime;

/**
 * @author Linden Brochu
 */
public class AppUi extends Thread{
    public static AppRenderer renderer;

    public AppUi(int width, int height){
        renderer = new AppRenderer(width, height);
        start();
    }

    public void start(){

    }


}
