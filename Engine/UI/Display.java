package Engine.UI;

import Engine.Scene;
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

        g.dispose();
        bs.show();
    }
}
