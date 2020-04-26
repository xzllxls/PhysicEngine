package Engine.UI;

import Engine.Scene;
import Objects.Position;
import Objects.Rendering.Prefab.CubicPrism;
import Objects.Rendering.PrismObject;
import Objects.Rendering.TypePolygon;
import Objects.Rotation;
import Objects.SceneObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * <p lang="en">UI of the render zone</p>
 * <p lang="fr">UI de la zone de rendu</p>
 * @author Linden Brochu
 */
public class Display extends Canvas {
    public Scene parent;

    private final JFrame frame;
    private static final String title = "PhysicEngine";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    CubicPrism cube = new CubicPrism(Color.WHITE, TypePolygon.Surface.Solid, 100, 100, 100);
    PrismObject prism = new PrismObject(cube, 0, 0, 0);

//    CubicPrism cube2 = new CubicPrism(Color.WHITE, TypePolygon.Surface.Solid, 100, 100, 100);
//    PrismObject prism2 = new PrismObject(cube2, 0, 0, 0);

    /**
     * <p lang="en">Instantiate a display</p>
     * <p lang="fr">Instancier un display</p>
     * @param parent Scene parent
     */
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

        Scene.objects.get(0).skeleton.setPrism(prism);
        Scene.objects.get(0).transform.setPosition(0,0,0);
        Scene.objects.get(0).transform.setRotation(30,0,0);
        Scene.objects.get(0).transform.velocity.x = 0;


//        Scene.objects.get(1).transform.position = new Position(0,0,0);
//        Scene.objects.get(1).skeleton.setPrism(prism2);
//        Scene.objects.get(1).transform.velocity.y = 0;
        start();
    }

    /**
     * <p lang="en">Start a scene</p>
     * <p lang="fr">Démarre une scène</p>
     */
    public synchronized void start(){
        parent.running = true;
    }

    /**
     * <p lang="en">Stop a scene</p>
     * <p lang="fr">Arrête une scène</p>
     */
    public synchronized void stop(){
        parent.running = false;
    }

    /**
     * <p lang="en">Start the render</p>
     * <p lang="fr">Démarre le rendu</p>
     */
    public void runUpdate(){
        this.frame.setTitle(title + " " + parent.fps);
        render();
    }

    /**
     * <p lang="en">Render the scene's SceneObject</p>
     * <p lang="fr">Paint les les SceneObject</p>
     */
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

        Scene.objects.get(0).transform.rotate(0,0,0);

        g.dispose();
        bs.show();
    }
}
