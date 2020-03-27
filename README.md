# PhysicEngine
## Contexte - Fr
**Simulateur de physique en java**

Après de longue heure (15 minutes) à chercher un simulateur de physique en java, j'ai décidé d'en créer un de toute 
pièce. Il s'agit, en premier lieu, d'un simulateur en 3 dimensions, néanmoins lorsque cette partie sera complétée, un 
extension gérant 2 dimensions sera ajouté.

Le but du simulateur sera de gérer des IAs dans un environnement physique complexe. Des cerveaux basiques d'IA seront 
aussi implémentés pour permettre aux programmeurs inexpérimentés dans ce domain de pouvoir en faire usage.

Tout le reste du document est écrit en anglais

## Context - En
**Physics Engine with java**

After some hours (15 minutes) of research for a java physics engine, I've decide to create one from scratch. In first 
time, this is a 3 dimensions simulator, but when this part is completed, an extension for 2 dimensions physics will be make.

The goal of the simulator will be to integrate AIs in a complex physic environment. Some basic IA brain will be 
implement to allow junior programmers in this domain field to get a base.

The rest of this file is write in english

## Development tool
* IntelliJ
* SDK 14
    
## Repository
### RunTime
* Contain every script required for running the application

### Rendered
* Contain every script required to do / to load an 3d object

#### RenderFile
* Must contain all 3d .rend file

### Objects
* Contain every script required to create a virtual object

### Engine
* Contain every script required to manage the physics

## Usage
### As library
* If you want to integrate physic in your project or if you want to do your own application

### As application
* If you want to develop a simulation modal

## Specifics scripts
* RunTime/App
    * Operate update at Engine/PhysicEngine.CONSTANT_FRAME per second
* RunTime/AppConf
    * Contain all data that application need to work
* RunTime/RunTimeApp
    * Contain the update mechanic
    * Entry point of the application
* RunTime/UI
    * Contain the UI
* Engine/PhysicEngine
    * Contain all data for physic simulation
* Engine/PhysicsMath
    * Contain many method to instantiate Engine's and Objects's scripts
* Engine/PathMath
    * Contain many method to calculate Path
* Rendered/RenderObject
    * Objects that we can see
* Objects/SceneObject
    * Objects that contain data and that we operate physic
* Objects/Vector3D
    * Base script to describe a 3d line

## 3D File format
* Position of all vertex
    * Ex : "[P{n=p1,x=10,y=10,z=10},P{n=p2,x=30,y=30,z=30},(...)]"
    * The vertex must be at the begging of the file
    * The x, y and z value are the value from the object center point
    * This data section must start with "Vertices" before the "[]"
* All geometric form
    * Ex : "[T{n=t1,p={p1,p2,p3},c=COLOR_CODE},T{...}]"
    * In the p section, specified the 3 vertices names you give
    * The c section is for a color, replace "COLOR_CODE" by the color code you want to --> #rr#gg#bb
    * This data section must start with "Tris" before the "[]"
* Other specification
    * All data section must have an "\|data_section\|" before the section
    * All data name, like "n=p1" must start with the section name, like P, in minus char and the number of item<br>
    Ex : first will be p1, second p2, third p3, ... you get it
    * The extension name is .rend (for render)
    * To end a data section : "\|data_end\|"

## UI file format
* Must start with <root>
* The extension name is .gui (for graphic user interface)
* Interactive and "final" component must not have child
* Each component need to have 2 2d pos, one for the top left and one for the bottom right corner
* Here is each component you can put and their definition
    * Non interactive component
        * Panel --> simple panel
        * TabPane --> simple tabbed pane
    * Interactive and "final" component
        * RenderPane --> the rendering zone if you want one (1 max)
        * TextField --> simple editable text
        * TextArea --> big editable text
        * Text --> simple non editable text
        * Button --> simple button
        * CheckBox --> simple check box
        * RadioButton --> simple radio button
        * ToggleButton --> simple toggle button
        * ColorPicker --> simple color chooser
        * ComboBox --> simple combo box
        * List --> simple list
        * ProgressionBar --> simple progression bar
        * Slider --> simple slider
* You can put dialog window with code
* You can put file chooser with code
* All attribute
    * backgroundColor="" --> default background color is Color.WHITE except for RenderPane (not implement yet)
    * size="##:##:##:##" --> the size of the component (top left corner x, bottom right corner x, top left corner y, bottom right corner y)
    * size="MAX" --> inherit the size of it's parent
    * borderColor="" --> default border color is Color.BLACK (not implement yet)
    * componentID="" --> set the id in controller
* Specific non attribute
    * Button, CheckBox, RadioButton, ToggleButton, TextField, TextArea, Text
        * text="" --> The component text (whitespace is _)
    * RadioButton, ToggleButton
        * selectGroup="" --> the GroupComponent (not implement yet)
    * RadioButton, ToggleButton, CheckBox
        * defaultSelect="" (true or false) --> The initial selection value
        * If multiple RadioButton or ToggleButton are selected in a GroupComponent, they will be selected when the application start
    * RadioButton, ToggleButton, CheckBox, Button, Slider
        * action="" --> set the ActionListener on the action attribute content
        * The method in controller, for most of the action, require ActionEvent param, except for the slider who required a ChangeEvent param
    * ProgressionBar, Slider
        * minValue=""
        * maxValue=""
        * value=""
    * ColorPicker
        * defaultColor="" --> default color is Color.RED (not implement yet)
    * TextField, TextArea, Text
        * Every marker must start and end at same line
* Root don't take any attribute