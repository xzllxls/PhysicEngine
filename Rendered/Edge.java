package Rendered;

/**
 * @author Linden Brochu
 */
public class Edge {
    private Vertex pos1;
    private Vertex pos2;

    /**
     * Instancier un cote
     * @param pos1 Extremite un
     * @param pos2 Extremite deux
     */
    public Edge(Vertex pos1, Vertex pos2){
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    /**
     * Instancier un cote
     * @param pos1X Position sur l'axe x du premier point
     * @param pos1Y Position sur l'axe y du premier point
     * @param pos1Z Position sur l'axe z du premier point
     * @param pos2X Position sur l'axe x du second point
     * @param pos2Y Position sur l'axe y du second point
     * @param pos2Z Position sur l'axe z du second point
     */
    public Edge(double pos1X, int pos1Y, int pos1Z, int pos2X, int pos2Y, int pos2Z){
        pos1 = new Vertex(pos1X, pos1Y, pos1Z);
        pos2 = new Vertex(pos2X, pos2Y, pos2Z);
    }

    public Vertex getPos1() {
        return pos1;
    }

    public void setPos1(Vertex pos1) {
        this.pos1 = pos1;
    }

    public Vertex getPos2() {
        return pos2;
    }

    public void setPos2(Vertex pos2) {
        this.pos2 = pos2;
    }
}
