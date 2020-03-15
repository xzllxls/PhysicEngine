package Rendered;

import java.awt.*;
import java.util.Objects;

/**
 * @author Linden Brochu
 */
public class Triangle {
    private Vertex vertex1;
    private Vertex vertex2;
    private Vertex vertex3;
    private Color color;

    /**
     * Instancier un triangle
     * @param vertex1 Coin #1
     * @param vertex2 Coin #2
     * @param vertex3 Coin #3
     * @param color Couleur
     */
    public Triangle(Vertex vertex1, Vertex vertex2, Vertex vertex3, Color color){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.color = color;
    }


    public Vertex getVertex1() {
        return vertex1;
    }

    public void setVertex1(Vertex vertex1) {
        this.vertex1 = vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public void setVertex2(Vertex vertex2) {
        this.vertex2 = vertex2;
    }

    public Vertex getVertex3() {
        return vertex3;
    }

    public void setVertex3(Vertex vertex3) {
        this.vertex3 = vertex3;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
