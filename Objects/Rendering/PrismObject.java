package Objects.Rendering;

import Engine.TypeObject;
import Objects.Rendering.Prefab.TypePrism;

/**
 * @author Linden Brochu
 */
public class PrismObject extends TypeObject {
    public TypePrism prism;

    public PrismObject(TypePrism prism){
        this.prism = prism;
    }
}
