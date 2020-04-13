package Objects;

import Engine.Component;
import Objects.Rendering.TypePolygon;
import Objects.Rendering.Vertex;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class Skeleton extends Component {
    public ArrayList<Vertex> vertices = new ArrayList<>();
    public ArrayList<TypePolygon> polygons = new ArrayList<>();
    //public ArrayList<Bone> bones = new ArrayList<>();

    public enum BodyType {
        Rigid, Static, Elastic
    }

    public Skeleton(SceneObject parent) {
        super(parent);
    }

    public void updateSkeleton(Position refPoint){

    }

    public void render(Graphics g){
        for (TypePolygon poly : polygons){
            poly.render(g);
        }
    }
}
