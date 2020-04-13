package Objects;

import Engine.Component;
import Objects.Rendering.Polygon;
import Objects.Rendering.Vertex;

import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class Skeleton extends Component {
    public ArrayList<Vertex> vertices = new ArrayList<>();
    public ArrayList<Polygon> polygons = new ArrayList<>();
    //public ArrayList<Bone> bones = new ArrayList<>();

    public enum BodyType {
        Rigid, Static, Elastic
    }

    public Skeleton(SceneObject parent) {
        super(parent);
    }

    public void updateSkeleton(Position refPoint){

    }
}
