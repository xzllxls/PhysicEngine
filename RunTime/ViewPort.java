package RunTime;

import Rendered.RenderObject;
import Rendered.Triangle;
import Rendered.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.io.File;

public class ViewPort extends JPanel implements Runnable{
    public RenderObject object = new RenderObject(new File("src\\Rendered\\RenderFile\\patate.rend"));
    JSlider headingSlider;
    JSlider pitchSlider;
    @Override
    public void run() {
        JFrame frame = new JFrame(AppConf.title + " ViewPort");
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.setSize(AppConf.width, AppConf.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // slider to control horizontal rotation
        headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);

        // slider to control vertical rotation
        pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);

        pitchSlider.addChangeListener(e -> this.repaint());
        headingSlider.addChangeListener(e -> this.repaint());

        frame.setVisible(true);
        while (!RunTimeApp.endProgram) {
            this.repaint();
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.setColor(Color.WHITE);
        for (Triangle t : object.getTris()) {
            Path2D path = new Path2D.Double();
            path.moveTo(t.getVertex1().getPos().getPosX(), t.getVertex1().getPos().getPosY());
            path.lineTo(t.getVertex2().getPos().getPosX(), t.getVertex2().getPos().getPosY());
            path.lineTo(t.getVertex3().getPos().getPosX(), t.getVertex3().getPos().getPosY());
            path.closePath();
            g2.draw(path);
        }
    }

}