package Engine.UI;

import Engine.Scene;
import Objects.Force;
import Objects.Position;
import Objects.Rendering.Prefab.CubicPrism;
import Objects.Rendering.PrismObject;
import Objects.Rendering.TypePolygon;
import Objects.SceneObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Collections;

public class Display extends Canvas {
    public Scene parent;

    private final JFrame frame;
    private static final String title = "PhysicEngine";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    CubicPrism cube = new CubicPrism(Color.WHITE, TypePolygon.Surface.Solid, 50, 100, 100);
    PrismObject prism = new PrismObject(cube, 0, 0, 0);

    CubicPrism cube2 = new CubicPrism(Color.WHITE, TypePolygon.Surface.Solid, 50, 100, 100);
    PrismObject prism2 = new PrismObject(cube2, 0, 0, 0);


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

        Scene.objects.get(0).transform.position = new Position(0,100,-1000);
        Scene.objects.get(0).skeleton.prism = prism;
        Scene.objects.get(0).transform.acceleration.x = 1;

        Scene.objects.get(1).transform.position = new Position(0,-100,0);
        Scene.objects.get(1).skeleton.prism = prism;
        Scene.objects.get(1).transform.appliquerForce(new Force(10,0,0));
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

//        prism.render(g);
//        cube.rotate(0,0,0);

//        System.out.println(Scene.objects.get(0).transform.position.x);

        g.dispose();
        bs.show();
    }
}
