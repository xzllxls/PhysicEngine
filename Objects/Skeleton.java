package Objects;

import Engine.Component;
import Objects.Rendering.Prefab.TypePrism;
import Objects.Rendering.TypePolygon;
import Objects.Rendering.Vertex;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Linden Brochu
 */
public class Skeleton extends Component {
    public ArrayList<Vertex> vertices = new ArrayList<>();
    public ArrayList<TypePolygon> polygons = new ArrayList<>();
    //public ArrayList<BoneSkeleton> bones = new ArrayList<>();

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
            poly.render(g, parent.transform.position);
        }
    }

    public void convertTypePrism(TypePrism prism){
        vertices.clear();
        polygons.clear();
        for (TypePolygon poly : prism.polygons){
            vertices.addAll(Arrays.asList(poly.vertices));
            polygons.add(poly);
        }
    }
}
