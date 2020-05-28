package Objects.Modules.Transform;

import java.awt.*;

public class SphereCollider extends Collider {
    public double radius;


    public SphereCollider(CompoundCollider group, Type type, double radius) {
        super(group, type);
        this.radius = radius;
    }

    @Override
    public void render(Graphics g) {

    }
}
