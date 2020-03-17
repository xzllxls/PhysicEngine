package Rendered;

import java.util.ArrayList;

/**
 * @author Linden Brochu
 * Sera compatible avec les fichiers
 */
public class RenderObject {
    private ArrayList<Triangle> tris;


    public RenderObject(){
        tris = new ArrayList<>();
    }

    public ArrayList<Triangle> getTris() {
        return tris;
    }

    public void setTris(ArrayList<Triangle> tris) {
        this.tris = tris;
    }
}
