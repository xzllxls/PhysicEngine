package Engine.UI;

import Engine.Scene;
import Objects.Rendering.TypePolygon;
import Objects.Rendering.Vertex;
import Objects.SceneObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends Canvas {
    public Scene parent;

    private JFrame frame;
    private static String title = "PhysicEngine";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public Display(Scene parent){
        this.parent = parent;
        this.frame = new JFrame();

        Dimension dimension = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(dimension);

        this.frame.setTitle(title);
        this.frame.add(this);
        this.frame.pack();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setVisible(true);

        start();
    }

    public synchronized void start(){
        parent.running = true;
    }

    public synchronized void stop(){
        parent.running = false;
    }

    public void runUpdate(){
        this.frame.setTitle(title + " " + parent.fps);
        render();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);

        for (SceneObject object : Scene.objects){
            object.skeleton.render(g);
        }

        TypePolygon poly = new TypePolygon(TypePolygon.Surface.Solid,
                new Vertex(100, 0, 0),
                new Vertex(0, 0, 0),
                new Vertex(50, 50, 0)) {
            @Override
            public void render(Graphics g) {
                super.render(g);
            }

            @Override
            public void setColor(Color color) {
                super.setColor(color);
            }
        };
        poly.render(g);

        g.dispose();
        bs.show();
    }
}
