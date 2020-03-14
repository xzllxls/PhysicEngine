package Rendered;

import java.awt.*;

/**
 * @author Linden Brochu
 */
public class Face {
    private Edge[] side;
    private Color color;

    /**
     * Instancier une face
     * @param color Couleur de la face
     * @param side Cotes
     */
    public Face(Color color, Edge[] side){
        this.color = color;
        this.side = side;
    }

    public Edge[] getSide() {
        return side;
    }

    public void setSide(Edge[] side) {
        this.side = side;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
