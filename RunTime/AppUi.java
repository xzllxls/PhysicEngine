package RunTime;

import javax.swing.*;
import java.awt.*;

public class AppUi extends Thread{
    public static Dimension appDim;
    JFrame frame;
    Container pane;


    public AppUi(int width, int height){
        appDim = new Dimension(width, height);
        frame = new JFrame();
        pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);

        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);

        JPanel renderPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                // rendering magic will happen here
            }
        };
        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(appDim);
        frame.setVisible(true);
    }

    public void run(){
        
    }

}
