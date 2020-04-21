package Objects.Rendering;

import Engine.TypeObject;
import Objects.Position;
import Objects.Rendering.Prefab.TypePrism;

import java.awt.*;

/**
 * <p lang="en">A visual object / mesh</p>
 * <p lang="fr">Objet visuel / mesh</p>
 * @author Linden Brochu
 */
public class PrismObject extends TypeObject {
    public TypePrism prism;
    public Position pos;

    /**
     * <p lang="en">Instantiate a prism object</p>
     * <p lang="fr">Instancier un objet prisme</p>
     * @param prism Prisme
     * @param pos Position
     */
    public PrismObject(TypePrism prism, Position pos){
        this.prism = prism;
        this.pos = pos;
    }

    /**
     * <p lang="en">Instantiate a prism object</p>
     * <p lang="fr">Instancier un objet prisme</p>
     * @param prism Prisme
     * @param x Position x
     * @param y Position y
     * @param z Position z
     */
    public PrismObject(TypePrism prism, double x, double y, double z){
        this.prism = prism;
        this.pos = new Position(x, y, z);
    }

    /**
     * <p lang="en">Render</p>
     * <p lang="fr">Fait le rendu</p>
     * @param g Graphic
     */
    public void render(Graphics g){
        prism.render(g, pos);
    }

    /**
     * <p lang="en">Render</p>
     * <p lang="fr">Fait le rendu</p>
     * @param g Graphic
     * @param pos Position absolue
     */
    public void render(Graphics g, Position pos){
        prism.render(g, pos);
    }
}
