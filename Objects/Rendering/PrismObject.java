package Objects.Rendering;

import Engine.TypeObject;
import Objects.Position;
import Objects.Rendering.Prefab.TypePrism;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public class PrismObject extends TypeObject {
    public TypePrism prism;
    public Position pos;

    public PrismObject(TypePrism prism, Position pos){
        this.prism = prism;
        this.pos = pos;
    }

    public PrismObject(TypePrism prism, double x, double y, double z){
        this.prism = prism;
        this.pos = new Position(x, y, z);
    }

    public void render(Graphics g){
        prism.render(g, pos);
    }
}
