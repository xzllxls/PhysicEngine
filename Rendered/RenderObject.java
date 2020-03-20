package Rendered;

import RunTime.RunTimeApp;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Linden Brochu
 * Sera compatible avec les fichiers
 */
public class RenderObject {
    private ArrayList<Triangle> tris = new ArrayList<>();
    private ArrayList<Vertex> vertices = new ArrayList<>();

    /**
     * Instancier un RenderObject a partir d'un fichier
     * @param file Fichier a lire
     */
    public RenderObject(File file){
        String vertexList;
        String trisList;
        try {
            Scanner myReader = new Scanner(file);
            vertexList = myReader.nextLine();
            trisList = myReader.nextLine();
            myReader.close();
            convertFileToJava(vertexList, trisList);
        } catch (FileNotFoundException e) {
            System.out.println(RunTimeApp.ANSI_RED + "An error occurred." + RunTimeApp.ANSI_RESET);
            e.printStackTrace();
        }
    }

    /**
     * Traduire en donnees lisibles
     * @param vList Liste de Vertex
     * @param tList Liste de Triangle
     */
    private void convertFileToJava(String vList, String tList){
        Pattern p = Pattern.compile("P\\{n=p[0-9]+,x=-?[0-9]+,y=-?[0-9]+,z=-?[0-9]+}");
        Matcher m = p.matcher(vList);
        while (m.find()){
            Pattern p1 = Pattern.compile("x=(-?[0-9]+),y=(-?[0-9]+),z=(-?[0-9]+)");
            Matcher m1 = p1.matcher(m.group());
            m1.find();
            Vertex vert = new Vertex(Double.parseDouble(m1.group(1)), Double.parseDouble(m1.group(2)), Double.parseDouble(m1.group(3)));
            vertices.add(vert);
        }
        p = Pattern.compile("T\\{n=t[0-9]+,p=\\{p[0-9]+,p[0-9]+,p[0-9]+},c=#([0-9]+)#([0-9]+)#([0-9]+)}");
        m = p.matcher(tList);
        while (m.find()){
            Pattern p1 = Pattern.compile("\\{p([0-9]+),p([0-9]+),p([0-9]+)}");
            Pattern p2 = Pattern.compile("c=#([0-9]+)#([0-9]+)#([0-9]+)");
            Matcher m1 = p1.matcher(m.group());
            Matcher m2 = p2.matcher(m.group());
            m1.find();
            m2.find();
            Triangle tri = new Triangle(vertices.get(Integer.parseInt(m1.group(1)) - 1), vertices.get(Integer.parseInt(m1.group(2)) - 1),
                    vertices.get(Integer.parseInt(m1.group(3)) - 1),
            new Color(Integer.parseInt(m2.group(1)), Integer.parseInt(m2.group(2)), Integer.parseInt(m2.group(3))));
            tris.add(tri);
        }
    }

    /**
     * Creer un fichier
     * @param filename Nom du fichier
     */
    public void createFile(String filename){
        File myObj;
        try {
            if (System.getProperty("sun.desktop").contains("windows"))
                myObj = new File("C:\\Users\\Admin\\IdeaProjects\\PhysicAndIA\\src\\Rendered\\RenderFile\\" + filename + ".rend");
            else myObj = new File("/RenderFile/" + filename + ".rend");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                convertJavaToFile(myObj);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Ecrire les donnees du RenderObject dans un fichier
     * @param file Fichier a ecrire
     */
    private void convertJavaToFile(File file){
        FileWriter myWriter;
        try {
            if(System.getProperty("sun.desktop").contains("windows"))
                myWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\PhysicAndIA\\src\\Rendered\\RenderFile\\" + file.getName());
            else myWriter = new FileWriter("./RenderFile/" + file.getName());
            String verticesString = "|data_section|[";
            String trisString = "|data_section|[";
            setPosName();
            for (Vertex elem : vertices){
                verticesString = verticesString.concat("P{n=" + elem.getPosName() + ",x=" + elem.getPos().getPosX() + ",y=" + elem.getPos().getPosY()
                + ",z=" + elem.getPos().getPosZ() + "},");
            }
            verticesString = verticesString.substring(0, verticesString.length() - 1);
            verticesString = verticesString.concat("]|data_end|\n");
            for (Triangle elem : tris){
                trisString = trisString.concat("T{n=" + elem.getPosName() + "p={" + elem.getVertex1().getPosName() + "," + elem.getVertex2().getPosName()
                + "," + elem.getVertex3().getPosName() + "},c=#" + elem.getColor().getRed() + "#" + elem.getColor().getGreen()
                + "#" + elem.getColor().getBlue() + "},");
            }
            trisString = trisString.substring(0, trisString.length() - 1);
            trisString = trisString.concat("]|data_end|");
            myWriter.write(verticesString + trisString);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Ajouter un nom aux items de vertices et de tris
     */
    private void setPosName(){
        for (int i = 0; i < vertices.size(); i++)
            vertices.get(i).setPosName("p" + (i + 1));
        for (int i = 0; i < tris.size(); i++)
            tris.get(i).setPosName("t" + (i + 1));
    }

    public ArrayList<Triangle> getTris() {
        return tris;
    }

    public void setTris(ArrayList<Triangle> tris) {
        this.tris = tris;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
}
