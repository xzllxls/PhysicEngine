package RunTime;

import Engine.PhysicEngine;
import Rendered.RenderObject;
import Rendered.Triangle;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class RenderingPanel extends GLJPanel implements GLEventListener, ActionListener {
    ArrayList<RenderObject> renderObjects = Viewport.renderObjects;
    Viewport viewport = Viewport.viewport;
    public static int width = 400;
    public static int height = 400;

    public void paneInit(){
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);

        glcanvas.addGLEventListener(this);
        glcanvas.setSize(width, height);
        this.add(glcanvas);

        Timer timer = new Timer(PhysicEngine.CONSTANT_FRAME, this);
        timer.start();

    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        GLU glu = new GLU();
        glu.gluOrtho2D(-1f,1f,-1f,1f);

        gl.glClearColor(0, 0, 0, 0);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        gl.glMatrixMode(GL2.GL_PROJECTION);


        gl.glBegin(GL2.GL_TRIANGLES);
        {
            for (RenderObject object : renderObjects)
                for (Triangle triangle : object.getTris()) {
                    gl.glColor3d(triangle.getColor().getRed() / 100d, triangle.getColor().getGreen() / 100d, triangle.getColor().getBlue() / 100d);
                    gl.glVertex3d(triangle.getVertex1().getPosX(), triangle.getVertex1().getPosY(), triangle.getVertex1().getPosZ());
                    gl.glVertex3d(triangle.getVertex2().getPosX(), triangle.getVertex2().getPosY(), triangle.getVertex2().getPosZ());
                    gl.glVertex3d(triangle.getVertex3().getPosX(), triangle.getVertex3().getPosY(), triangle.getVertex3().getPosZ());
                }
        }
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        final GL2 gl = drawable.getGL().getGL2();
        final GLU glu = new GLU();

        if (w == 0) w = 1;
        if (h == 0) h = 1;
        double aspect = w * 1.0 / h;
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        if (w > h)
            glu.gluOrtho2D(-aspect, aspect, -1, 1);
        else
            glu.gluOrtho2D(-1, 1, -1/aspect, 1/aspect);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
        this.getComponent(0).repaint();
    }
}
