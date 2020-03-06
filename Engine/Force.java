package Engine;

import Object.Vector3D;

/**
 * @author Linden Brochu
 */
public class Force {

    enum typeForce {
        Gravite, Friction, Propulsion
    }

    private Vector3D direction;

    /**
     * Constructeur pour une force null
     */
    public Force(){
        direction = new Vector3D();
    }

    public Vector3D getDirection() {
        return direction;
    }

    public void setDirection(Vector3D direction) {
        this.direction = direction;
    }


}
