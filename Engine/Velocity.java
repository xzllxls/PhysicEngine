package Engine;

import Object.Vector3D;
import java.time.*;

/**
 * @author Linden Brochu
 */
public class Velocity {
    private Vector3D vit;
    private double linearVelocity;

    public Velocity(){
        vit = new Vector3D();
        linearVelocity = 0;
    }

    public Velocity(double x, double y, double z){
        vit = new Vector3D(x, y, z);
        //set linearVelocity
    }

    public Vector3D getVit() {
        return vit;
    }

    public void setVit(Vector3D vit) {
        this.vit = vit;
    }

    public double getLinearVelocity() {
        return linearVelocity;
    }

    public void setLinearVelocity(double linearVelocity) {
        this.linearVelocity = linearVelocity;
    }
}
