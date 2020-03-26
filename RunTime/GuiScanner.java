package RunTime;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Linden Brochu
 */
public class GuiScanner {
    private File file;
    public GuiScanner(File file) throws FileNotFoundException {
        if (!file.exists())
            throw new FileNotFoundException("File " + file.getName() + " does not exist");
        else this.file = file;
    }

    /**
     * Analyser un fichier
     * @return Container
     */
    public JPanel analyseFile() throws FileSystemException, FileNotFoundException {
        JPanel root = new JPanel();
        root.setLayout(null);
        root.setBounds(0, 0, AppConf.width, AppConf.height);
        Scanner scanner = new Scanner(file);
        ArrayList<String> tree = new ArrayList<>();
        ArrayList<Component> objectsTree = new ArrayList<>();
        Component parent;
        tree.add("root");
        objectsTree.add(root);
        if (!scanner.nextLine().equals("<?gui ?>"))
            throw new FileSystemException("File " + file.getName() + " is not gui file");
        if (!scanner.nextLine().contains("root"))
            throw new FileSystemException("File " + file.getName() + " has no start root tag");
        ArrayList<String> line = new ArrayList<>();
        while (scanner.hasNextLine()) {
            parent = objectsTree.get(objectsTree.size() - 1);
            String temp = scanner.nextLine();
            line.add(temp);
            if (!temp.contains("</")) {
                Pattern p = Pattern.compile("<(\\S+)(\\s.+)>");
                Matcher m = p.matcher(temp);
                m.find();
                ArrayList<String> attributes = new ArrayList<>();
                Pattern p1 = Pattern.compile("\\s([a-zA-Z]+)=\"(\\S+)\"");
                Matcher m1 = p1.matcher(m.group(2));

                while (m1.find()) {
                    attributes.add(m1.group());
                }
                String object = m.group(1);
                JComponent component = createComponent(object);
                setAttribute(component, attributes, parent);
                ((Container) parent).add(component);
                if (!temp.contains("/>"))
                {
                    tree.add(m.group(1));
                    objectsTree.add(component);
                }
            }
            else {
                if (!temp.contains(tree.get(tree.size() - 1)))
                    throw new FileSystemException("a closing marker is misplace at line " + line.size());
                else {
                    tree.remove(tree.size() - 1);
                    objectsTree.remove(objectsTree.size() - 1);
                }
            }
        }
        if (tree.size() > 0 || objectsTree.size() > 0){
            throw new InternalError("An unexpected error occurred");
        }
        if (!line.get(line.size() - 1).contains("root"))
            throw new FileSystemException("File " + file.getName() + " has no end root tag");
        scanner.close();
        return root;
    }

    enum componentList {
        Panel, TabPanel, RenderPane, TextField, TextArea, Text, Button, CheckBox, RadioButton, ToggleButton, ColorPicker, ComboBox, List, ProgressionBar, Slider
    }
    enum attribList {
        text, defaultSelect, minValue, maxValue, value, size, action, componentID
    }

    /**
     * Selon le nom de la composante, retourne la composante du meme nom
     * @param componentType Nome de la composante
     * @return JComponent
     * @throws FileSystemException If the component name doesn't exist
     */
    public JComponent createComponent(String componentType) throws FileSystemException{
        JComponent component;
        switch (componentList.valueOf(componentType)){
            case Panel:
                component = new JPanel();
                return component;
            case TabPanel:
                component = new JTabbedPane();
                return component;
            case RenderPane:
                component = new RenderingPanel();
                return component;
            case TextField:
                component = new JTextField();
                return component;
            case TextArea:
                component = new JTextArea();
                return component;
            case Text:
                component = new JTextField();
                ((JTextField) component).setEditable(false);
                return component;
            case Button:
                component = new JButton();
                return component;
            case CheckBox:
                component = new JCheckBox();
                return component;
            case RadioButton:
                component = new JRadioButton();
                return component;
            case ToggleButton:
                component = new JToggleButton();
                return component;
            case ColorPicker:
                component = new JColorChooser();
                return component;
            case ComboBox:
                component = new JComboBox<>();
                return component;
            case List:
                component = new JList<>();
                return component;
            case ProgressionBar:
                component = new JProgressBar();
                return component;
            case Slider:
                component = new JSlider();
                return component;
            default:
                throw new FileSystemException("Not every marker exist");
        }
    }

    /**
     * Appliquer les attributs sur la composante
     * @param component Composante a modifier
     * @param attributes Attribut a appliquer
     * @param parent Parent
     * @throws FileSystemException If the component have attribute issue
     */
    public void setAttribute(JComponent component, ArrayList<String> attributes, Component parent) throws FileSystemException{
        App app = App.app;
        component.setLayout(null);
        for (String attribute : attributes) {
            Pattern p = Pattern.compile("\\s([a-zA-Z]+)=\"(\\S+)\"");
            Matcher m = p.matcher(attribute);
            m.find();

            switch (attribList.valueOf(m.group(1))) {
                case text:
                    if (component instanceof JTextComponent)
                        ((JTextComponent) component).setText(m.group(2).replaceAll("_"," "));
                    else if (component instanceof AbstractButton)
                        ((AbstractButton) component).setText(m.group(2).replaceAll("_"," "));
                    else throw new FileSystemException("Some component must not have text attribute");
                    break;
                case defaultSelect:
                    if (component instanceof JToggleButton)
                        ((JToggleButton) component).setSelected(true);
                    else throw new FileSystemException("Some component must not have defaultSelect attribute");
                    break;
                case minValue:
                    if (component instanceof JSlider) {
                        try {
                            ((JSlider) component).setMinimum(Integer.parseInt(m.group(2)));
                        }catch (NumberFormatException e){
                            throw new FileSystemException("A slider minValue is corrupted");
                        }
                    }
                    else if (component instanceof JProgressBar) {
                        try {
                            ((JProgressBar) component).setMinimum(Integer.parseInt(m.group(2)));
                        }catch (NumberFormatException e){
                            throw new FileSystemException("A progress bar minValue is corrupted");
                        }
                    }
                    else throw new FileSystemException("Some component must not have minValue attribute");
                    break;
                case maxValue:
                    if (component instanceof JSlider) {
                        try {
                            ((JSlider) component).setMaximum(Integer.parseInt(m.group(2)));
                        }catch (NumberFormatException e){
                            throw new FileSystemException("A slider maxValue is corrupted");
                        }
                    }
                    else if (component instanceof JProgressBar) {
                        try {
                            ((JProgressBar) component).setMaximum(Integer.parseInt(m.group(2)));
                        }catch (NumberFormatException e){
                            throw new FileSystemException("A progress bar maxValue is corrupted");
                        }
                    }
                    else throw new FileSystemException("Some component must not have minValue attribute");
                    break;
                case value:
                    if (component instanceof JSlider) {
                        try {
                            ((JSlider) component).setValue(Integer.parseInt(m.group(2)));
                        }catch (NumberFormatException e){
                            throw new FileSystemException("A slider value is corrupted");
                        }
                    }
                    else if (component instanceof JProgressBar) {
                        try {
                            ((JProgressBar) component).setValue(Integer.parseInt(m.group(2)));
                        }catch (NumberFormatException e){
                            throw new FileSystemException("A progress bar value is corrupted");
                        }
                    }
                    else throw new FileSystemException("Some component must not have minValue attribute");
                    break;
                case size:
                    Pattern p1 = Pattern.compile("[0-9]{1,3}:[0-9]{1,3}:[0-9]{1,3}:[0-9]{1,3}|MAX");
                    Matcher m1 = p1.matcher(m.group(2));
                    if (m1.find()){
                        Pattern p2 = Pattern.compile("([0-9]{1,3}):([0-9]{1,3}):([0-9]{1,3}):([0-9]{1,3})");
                        Matcher m2 = p2.matcher(m1.group());
                        if (m2.find()){
                            component.setBounds(Integer.parseInt(m2.group(1)) * parent.getWidth() / 100,
                                    Integer.parseInt(m2.group(3)) * parent.getWidth() / 100,
                                    (Integer.parseInt(m2.group(2)) - Integer.parseInt(m2.group(1))) * parent.getWidth() / 100,
                                    (Integer.parseInt(m2.group(4)) - Integer.parseInt(m2.group(3))) * parent.getWidth() / 100);
                            if (component instanceof RenderingPanel){
                                RenderingPanel.width = (Integer.parseInt(m2.group(2)) - Integer.parseInt(m2.group(1))) * parent.getWidth() / 100;
                                RenderingPanel.height = (Integer.parseInt(m2.group(4)) - Integer.parseInt(m2.group(3))) * parent.getWidth() / 100;
                                ((RenderingPanel) component).paneInit();
                            }
                        }
                        else if (m1.group().equals("MAX")) {
                            component.setBounds(0, 0, parent.getWidth(), parent.getHeight());
                            if (component instanceof RenderingPanel){
                                RenderingPanel.width = parent.getWidth();
                                RenderingPanel.height = parent.getHeight();
                                ((RenderingPanel) component).paneInit();
                            }
                        }
                        else throw new FileSystemException("Some size attribute are corrupted");
                    }
                    else throw new FileSystemException("Some marker don't have size attribute");
                    break;
                case action:
                    if (component instanceof AbstractButton) {
                        ((AbstractButton) component).addActionListener(e -> {
                            Class<?> c = app.controller.getClass();
                            try {
                                Class<?>[] argTypes = new Class[] { ActionEvent.class };
                                Method method = c.getDeclaredMethod(m.group(2), argTypes);
                                method.invoke(app.controller, e);
                            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                                try {
                                    throw new FileSystemException("Some method in action attribute does not exist in controller");
                                } catch (FileSystemException exc) {
                                    exc.printStackTrace();
                                }
                            }
                        });
                    }
                    else if (component instanceof JSlider){
                        ((JSlider) component).addChangeListener(e -> {
                            Class<?> c = app.controller.getClass();
                            try {
                                Class<?>[] argTypes = new Class[] { ChangeEvent.class };
                                Method method = c.getDeclaredMethod(m.group(2), argTypes);
                                method.invoke(app.controller, e);
                            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                                try {
                                    throw new FileSystemException("Some method in action attribute does not exist in controller");
                                } catch (FileSystemException exc) {
                                    exc.printStackTrace();
                                }
                            }
                        });
                    }
                    else throw new FileSystemException("Some component must not have action attribute");
                    break;
                case componentID:
                    Class<?> c = app.controller.getClass();
                    try {
                        Field f = c.getField(m.group(2));
                        if (f.getType() == component.getClass()) {
                            f.set(app.controller, component);
                        }
                        else throw new InternalError("An unexpected error occurred");
                    } catch (NoSuchFieldException e) {
                        throw new FileSystemException("Some field in componentID attribute does not exit in controller");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    throw new FileSystemException("Some marker have incompatible attribute");
            }
        }
    }
}