package Object;

import Engine.Velocity;
import Rendered.RenderObject;
import RunTime.App;

/**
 * @author Linden Brochu
 */
public class SceneObject {
    private int mass;
    private boolean rigid;
    private Transform transform;
    private Velocity vitesse;

    private PathListener pathListener = null;

    private RenderObject model;

    /**
     * Instancier un SceneObject
     * @param mass Masse de l'objet
     * @param rigid Determine si l'objet peut bouger
     */
    public SceneObject(int mass, boolean rigid, RenderObject model){
        this.mass = mass;
        this.rigid = rigid;
        transform = new Transform(0, 0, 0, 0, 0, 0);
        if (!rigid)
            vitesse = new Velocity();
        else vitesse = null;
        App.sceneObjects.add(this);
        this.model = model;
    }

    /**
     * Permet de suivre un path
     */
    public void followSimplePath(){
        if (pathListener.getStep() == pathListener.getPath().getPathPointArrayList().size()){
            //Debug, don't use this part
            if (pathListener.getPath().getFinalPoint().equals(transform.getPos()))
                System.out.println("Destination atteinte");
            else System.out.println("Destination non atteinte");
            App.appQuit();
        }
        else {
            transform.getPos().cloneOtherPos(pathListener.getPath().getPathPointArrayList().get(pathListener.getStep()).getFinalPoint());
            pathListener.changeStep();
        }
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public boolean isRigid() {
        return rigid;
    }

    public void setRigid(boolean rigid) {
        this.rigid = rigid;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public Velocity getVitesse() {
        return vitesse;
    }

    public void setVitesse(Velocity vitesse) {
        this.vitesse = vitesse;
    }

    public PathListener getPathListener() {
        return pathListener;
    }

    public void setPathListener(PathListener pathListener) {
        this.pathListener = pathListener;
    }
}
