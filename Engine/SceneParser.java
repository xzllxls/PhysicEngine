package Engine;

import Objects.SceneObject;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @author Linden Brochu
 */
public class SceneParser {
    public static String scenePath = "Scene/";

    public static ArrayList<SceneObject> loadScene(String filename) throws IOException, ParserConfigurationException, SAXException {
        ArrayList<SceneObject> objects = new ArrayList<>();
        if (!checkFile(filename))
            throw new FileNotFoundException(filename + " n'existe pas");

        return objects;
    }

    private static boolean checkFile(String filename){
        File file = new File(scenePath + filename + ".scene");
        return file.exists();
    }

}
