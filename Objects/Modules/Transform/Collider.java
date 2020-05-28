package Objects.Modules.Transform;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public abstract class Collider extends TypeCollider {
    public enum Type {
        Sensor, Collider
    }

    public Collider(CompoundCollider group, Type type){
        switch (type) {
            case Sensor -> group.addSensor(this);
            case Collider -> group.addCollider(this);
        }
    }

    public abstract void render(Graphics g);
}
