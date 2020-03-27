package Rendered;

import Objects.Position3D;
import Objects.Transform;

public class Camera {
    public enum View {
        Perspective, Orthographic
    }
    View view;
    Position3D pos;

    double focalDistance;
    double width;
    double height;
    double maxDepth;
    boolean render = false;
    double vertAngle;
    double horizAngle;

    Position3D lookAt;

    public Camera(View type, double width, double height, Position3D pos, double focalDistance, double maxDepth, double vertAngle, double horizAngle){
        view = type;
        this.width = width;
        this.height = height;
        this.focalDistance = focalDistance;
        this.maxDepth = maxDepth;
        this.vertAngle = vertAngle;
        this.horizAngle = horizAngle;
        this.pos = pos;
    }

    public Camera(View type, double width, double height, Position3D pos, double focalDistance, double maxDepth, Position3D lookAt){
        view = type;
        this.width = width;
        this.height = height;
        this.focalDistance = focalDistance;
        this.maxDepth = maxDepth;
        this.pos = pos;
        this.lookAt = lookAt;
    }

    public void changeRenderState(){
        render = !render;
    }


}
