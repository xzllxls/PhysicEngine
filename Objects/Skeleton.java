package Objects;

import Engine.Component;
import Objects.Rendering.Polygon;
import Objects.Rendering.Vertex;

import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class Skeleton extends Component {
    ArrayList<Vertex> vertices = new ArrayList<>();
    ArrayList<Polygon> polygons = new ArrayList<>();

    public Skeleton(SceneObject parent) {
        super(parent);
    }

    public void updateSkeleton(Position refPoint){

    }
}
