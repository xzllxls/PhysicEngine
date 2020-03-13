package Engine;

import Object.Vector3D;

/**
 * @author Linden Brochu
 */
public class Force {
    private Vector3D direction;

    /**
     * Constructeur pour une force null
     */
    public Force(){
        direction = new Vector3D();
    }

    /**
     * Instancier une force
     * @param x Force sur l'axe x
     * @param y Force sur l'axe y
     * @param z Force sur l'axe z
     */
    public Force(int x, int y, int z){
        direction = new Vector3D(x, y, z);
    }

    public Vector3D getDirection() {
        return direction;
    }

    public void setDirection(Vector3D direction) {
        this.direction = direction;
    }


}
