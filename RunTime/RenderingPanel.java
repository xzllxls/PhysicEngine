package RunTime;

import Rendered.RenderObject;
import Rendered.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class RenderingPanel extends JPanel {
        ArrayList<RenderObject> renderObjects = Viewport.renderObjects;

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.setColor(Color.WHITE);

            for (RenderObject object : renderObjects)
               for (Triangle tris : object.getTris()){
                    //Put render here
               }
    }

}
