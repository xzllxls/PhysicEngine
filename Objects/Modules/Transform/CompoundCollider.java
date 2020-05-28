package Objects.Modules.Transform;

import java.util.ArrayList;

/**
 * @author Linden Brochu
 */
public class CompoundCollider extends TypeCollider {
    public ArrayList<Collider> colliders = new ArrayList<>();
    public ArrayList<Collider> sensors = new ArrayList<>();

    public void addSensor(Collider collider){
        sensors.add(collider);
    }

    public void addCollider(Collider collider){
        colliders.add(collider);
    }

}
