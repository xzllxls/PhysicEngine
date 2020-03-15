package Rendered;

import java.util.ArrayList;

/**
 * @author Linden Brochu
 * Sera compatible avec les fichiers
 */
public class RenderObject {
    private ArrayList<Triangle> tris;


    public RenderObject(){
        tris = new ArrayList();
    }

    public void mergeVertices(){
        for (int i = 0; i < tris.size() - 1; i++){
            for (int j = i + 1; j < tris.size(); i ++){
                if (tris.get(i).getVertex1().equals(tris.get(j).getVertex1()))
                    tris.get(j).setVertex1(tris.get(i).getVertex1());

                if (tris.get(i).getVertex2().equals(tris.get(j).getVertex1()))
                    tris.get(j).setVertex1(tris.get(i).getVertex2());

                if (tris.get(i).getVertex3().equals(tris.get(j).getVertex1()))
                    tris.get(j).setVertex1(tris.get(i).getVertex3());

                if (tris.get(i).getVertex1().equals(tris.get(j).getVertex2()))
                    tris.get(j).setVertex2(tris.get(i).getVertex1());

                if (tris.get(i).getVertex2().equals(tris.get(j).getVertex2()))
                    tris.get(j).setVertex2(tris.get(i).getVertex2());

                if (tris.get(i).getVertex3().equals(tris.get(j).getVertex2()))
                    tris.get(j).setVertex2(tris.get(i).getVertex3());

                if (tris.get(i).getVertex1().equals(tris.get(j).getVertex3()))
                    tris.get(j).setVertex3(tris.get(i).getVertex1());

                if (tris.get(i).getVertex2().equals(tris.get(j).getVertex3()))
                    tris.get(j).setVertex3(tris.get(i).getVertex2());

                if (tris.get(i).getVertex3().equals(tris.get(j).getVertex3()))
                    tris.get(j).setVertex3(tris.get(i).getVertex3());
            }
        }
    }

    public ArrayList<Triangle> getTris() {
        return tris;
    }

    public void setTris(ArrayList<Triangle> tris) {
        this.tris = tris;
    }
}
