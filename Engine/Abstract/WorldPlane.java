package Engine.Abstract;

import Engine.Grid;

public class WorldPlane extends Grid {

    public WorldPlane() {
        super(new double[]{1, 0, 0}, new double[]{0, 1, 0}, new double[]{0, 0, 1});
    }
}
