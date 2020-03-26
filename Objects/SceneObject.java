package Objects;

import Engine.Velocity;
import Rendered.RenderObject;
import RunTime.App;

/**
 * @author Linden Brochu
 */
public class SceneObject {
    private int mass;
    private boolean rigid;
    private boolean movable;
    private Transform transform;
    private Velocity vitesse;

    private PathListener pathListener = null;

    private RenderObject model;

    private Vector3D normalVector = new Vector3D(); //This is where the object go

    /**
     * Instancier un SceneObject
     * @param mass Masse de l'objet
     * @param rigid Determine si l'objet est solide
     * @param movable Determine si l'objet peut bouger
     * @param model Model de l'objet
     */
    public SceneObject(int mass, boolean rigid, boolean movable, RenderObject model){
        this.mass = mass;
        this.rigid = rigid;
        this.movable = movable;
        transform = new Transform(0, 0, 0, 0, 0, 0);
        if (!rigid)
            vitesse = new Velocity();
        else vitesse = null;
        App.sceneObjects.add(this);
        this.model = model;
    }

    /**
     * Instancier un SceneObject
     * @param mass Masse de l'objet
     * @param rigid Determine si l'objet est solide
     * @param movable Determine si l'objet peut bouger
     * @param modelName Model de l'objet
     */
    public SceneObject(int mass, boolean rigid, boolean movable, String modelName){
        this.mass = mass;
        this.rigid = rigid;
        this.movable = movable;
        transform = new Transform(0, 0, 0, 0, 0, 0);
        if (!rigid)
            vitesse = new Velocity();
        else vitesse = null;
        App.sceneObjects.add(this);
        this.model = new RenderObject(modelName);
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
