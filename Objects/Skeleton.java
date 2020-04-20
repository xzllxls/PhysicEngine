package Objects;

import Engine.Component;
import Objects.Rendering.PrismObject;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public class Skeleton extends Component {
    public PrismObject prism;

    public enum BodyType {
        Rigid, Static, Elastic
    }

    public Skeleton(SceneObject parent) {
        super(parent);
    }

    public void render(Graphics g){
        if (prism != null) {
            if (prism.pos == null) {
                prism.pos = parent.transform.position;
            }
            prism.render(g);
        }
    }

    public void setPrism(PrismObject prism){
        this.prism = prism;
        prism.pos = parent.transform.position;
    }
}
