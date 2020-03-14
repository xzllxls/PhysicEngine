package Object;

import Engine.Path;

/**
 * @author Linden Brochu
 */
public class PathListener {
    private int step = 0;
    private Path path;

    public PathListener(Path path){
        this.path = path;
    }

    public void changeStep(){
        step++;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getStep() {
        return step;
    }
}
