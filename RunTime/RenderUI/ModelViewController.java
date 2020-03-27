package RunTime.RenderUI;

import Objects.SceneObject;
import RunTime.Controller;
import RunTime.RenderingPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class ModelViewController extends Controller {
    public SceneObject object = new SceneObject(10, true, true, "patate.rend");
    public void vertSlider(ChangeEvent e){
        RenderingPanel.vrot = Math.toRadians(((JSlider)e.getSource()).getValue() - 90);
        RenderingPanel.renderingPanel.repaint();
    }
    public void horizSlider(ChangeEvent e){
        RenderingPanel.hrot = Math.toRadians(((JSlider)e.getSource()).getValue() - 180);
        RenderingPanel.renderingPanel.repaint();
    }
}
