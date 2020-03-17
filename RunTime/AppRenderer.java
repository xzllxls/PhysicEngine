package RunTime;

/**
 * @author Linden Brochu
 */
public class AppRenderer {
    private UI userInterface;

    public AppRenderer(int width, int height){
        userInterface = new UI(width, height);
    }

    public AppRenderer(){
        //set the dimension to frame dimension
    }
}
