package RunTime;

import Rendered.RenderObject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;

public class Viewport implements Runnable{
    public static ArrayList<RenderObject> renderObjects = new ArrayList<>();
    JFrame frame;
    public static Viewport viewport;

    @Override
    public void run() {
        viewport = this;
        Thread.currentThread().setName("GUI Thread");
        frame = new JFrame(AppConf.title + " Viewport");
        frame.setLayout(null);
        frame.setBounds(0, 0, AppConf.width, AppConf.height);
        JPanel panel = setGui("default.gui"); //This is the background
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        frame.add(panel);
        frame.setSize(AppConf.width, AppConf.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(AppConf.canResize);
        frame.setVisible(true);
    }

    /**
     * Charger une interface graphique a partir d'un fichier
     * @param filename Nom du fichier
     * @return JPanel contenant le UI
     */
    public JPanel setGui(String filename){
        File file = new File("src\\RunTime\\RenderUI\\" + filename);
        try {
            GuiScanner scanner = new GuiScanner(file);
            return scanner.analyseFile();
        } catch (FileNotFoundException e) {
            System.out.println(RunTimeApp.ANSI_RED + "An error occurred." + RunTimeApp.ANSI_RESET);
            e.printStackTrace();
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
        return null;
    }

}