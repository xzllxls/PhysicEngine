package Engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <p lang="en">Scene parser</p>
 * <p lang="en">Manipulateur de scène</p>
 * @author Linden Brochu
 */
public class SceneParser {
    public static String scenePath = "Scene/";

    /**
     * <p lang="en"> Load a scene</p>
     * <p lang="fr">Charger une scène</p>
     * @param filename Nom du fichier
     * @throws IOException Existance du fichier
     */
    public static void loadScene(String filename) throws IOException{
        if (!checkFile(filename))
            throw new FileNotFoundException(filename + " n'existe pas");
    }

    /**
     * <p lang="en">Look if the scene file exist</p>
     * <p lang="fr">Détermine si le fichier existe</p>
     * @param filename Nom du fichier
     * @return Boolean de l'existance du fichier
     */
    private static boolean checkFile(String filename){
        File file = new File(scenePath + filename + ".scene");
        return file.exists();
    }

}
