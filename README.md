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

The rest of this file is writen in english

## Repository
### RunTime
* Contain every script required for running the application

### Rendered
* Contain every script required to do / to load an 3d object

### Object
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
    * Contain many method to instantiate Engine's and Object's scripts
* Engine/PathMath
    * Contain many method to calculate Path
* Rendered/RenderObject
    * Object that we can see
* Object/SceneObject
    * Object that contain data and that we operate physic
* Object/Vector3D
    * Base script to describe a 3d line