package Objects;

import Engine.Component;
import Objects.Rendering.PrismObject;

import java.awt.*;

/**
 * <p lang="en">Skeleton of an object</p>
 * <p lang="fr">Squelette d'un object</p>
 * @author Linden Brochu
 */
public class Skeleton extends Component {
    public PrismObject prism;

    /**
     * <p lang="en">General type of surface</p>
     * <p lang="fr">Type général de surface</p>
     */
    public enum BodyType {
        Rigid, Static, Elastic
    }

    /**
     * <p lang="en">Instantiate a Skeleton</p>
     * <p lang="fr">Instancier un squelette</p>
     * @param parent SceneObject parent
     */
    public Skeleton(SceneObject parent) {
        super(parent);
    }

    /**
     * <p lang="en">Render the modal</p>
     * <p lang="fr">Fait le rendu du model</p>
     * @param g Graphic
     */
    public void render(Graphics g){
        if (prism != null) {
            if (prism.pos == null) {
                prism.pos = parent.transform.position;
            }
            prism.render(g);
        }
    }

    /**
     * <p lang="en">Set the modal of the Skeleton</p>
     * <p lang="fr">Ajuste le model du squelette</p>
     * @param prism Model
     */
    public void setPrism(PrismObject prism){
        this.prism = prism;
        prism.pos = parent.transform.position;
    }
}
