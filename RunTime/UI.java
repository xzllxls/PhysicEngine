package RunTime;

import javax.swing.*;
import java.awt.*;

/**
 * @author Linden Brochu
 */
public class UI {
    public JFrame frame;

    public UI(int width, int height){
        frame = new JFrame(AppConf.title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set UI component
        frame.setVisible(true);
    }
}
