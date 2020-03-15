package RunTime;



/**
 * @author Linden Brochu
 */
public class AppUi extends Thread{
    public static AppRenderer renderer = new AppRenderer();

    public AppUi(int width, int height){

    }

    public void run(){
        renderer.start();
    }

}
