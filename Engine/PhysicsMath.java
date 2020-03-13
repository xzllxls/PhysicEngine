package Engine;

import Object.*;

import java.time.Duration;

/**
 * @author Linden Brochu
 */
public class PhysicsMath {

    /**
     * Calculer une acceleration
     * @param time Temps de l'acceleration
     * @param vit Vitesse de l'objet
     * @return Acceleration
     */
    public static Acceleration calculAcc(Duration time, Velocity vit) {
        Acceleration acc = new Acceleration();
        acc.getNewtonVector().setX(vit.getVit().getX() / time.getSeconds());
        return acc;
    }

    /**
     * Calculer une accelerataion
     * @param mass Masse de l'objet
     * @param force Force unique appliquee a l'objet
     * @return Acceleration de l'objet
     */
    public static Acceleration calculAcc(double mass, Force force){
        Acceleration acc = new Acceleration();
        acc.getNewtonVector().add(force.getDirection());
        acc.getNewtonVector().subMultiplicator(mass);
        acc.updateLinearAcceleration();
        return acc;
    }

    /**
     * Calculer une acceleration
     * @param mass Masse de l'objet
     * @param forces Forces multiples appliquees a l'objet
     * @return Acceleration de l'objet
     */
    public static Acceleration calculAcc(int mass, Force[] forces){
        Acceleration acc = new Acceleration();
        Vector3D newtonVector = acc.getNewtonVector();
        for (Force direction : forces)
            newtonVector.add(direction.getDirection());
        newtonVector.setX(newtonVector.getX() * mass);
        newtonVector.setY(newtonVector.getX() * mass);
        newtonVector.setZ(newtonVector.getX() * mass);
        acc.updateLinearAcceleration();
        return acc;
    }

    /**
     * Calculer une velocite
     * @param acc Acceleration d'un objet
     * @param time Temps de l'acceleration
     * @return Velocite apres l'acceleration
     */
    public static Velocity calculVel(Acceleration acc, Duration time){
        Velocity vel = new Velocity();
        vel.getVit().add(acc.getNewtonVector());
        vel.getVit().addMultiplicator(time.getSeconds());
        return vel;
    }

    /**
     * Calculer une velocite
     * @param initVel Velocite initial
     * @param acc Acceleration de l'objet
     * @param time Temps de l'acceleration
     * @return Velocite apres acceleration
     */
    public static Velocity calculVel(Velocity initVel, Acceleration acc, Duration time){
        Velocity newVel = new Velocity();
        Vector3D accVector = new Vector3D();
        newVel.getVit().add(initVel.getVit());
        accVector.add(acc.getNewtonVector());
        accVector.addMultiplicator(time.getSeconds());
        newVel.getVit().add(accVector);
        return newVel;
    }

    /**
     * Calculer un deplacement
     * @param acc Acceleration
     * @param time Temps de l'acceleration
     * @return Vecteur du deplacement
     */
    public static Vector3D calculMove(Acceleration acc, Duration time){
        Vector3D move = new Vector3D();
        move.add(acc.getNewtonVector());
        move.addMultiplicator(Math.pow(time.getSeconds(), 2));
        return move;
    }

    /**
     * Calculer un deplacement
     * @param initVel Velocite initiale
     * @param finalVel Velocite finale
     * @param time Temps de deplacement
     * @return Vecteur du deplacement
     */
    public static Vector3D calculMove(Velocity initVel, Velocity finalVel, Duration time){
        Vector3D move = new Vector3D();
        move.add(initVel.getVit());
        move.add(finalVel.getVit());
        move.addMultiplicator(time.getSeconds() / 2.0);
        return move;
    }
}
