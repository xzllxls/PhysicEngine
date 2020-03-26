package RunTime;

import javax.swing.*;
import javax.swing.event.ChangeEvent;


/**
 * @author Linden Brochu
 */
public class Controller {
    public void sliderAction(ChangeEvent e){
        System.out.println(((JSlider)e.getSource()).getValue());
    }
}
