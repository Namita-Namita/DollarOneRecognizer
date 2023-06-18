

##                          Course : CIS6930: Human-Centered Input Recognition Algorithms (HCIRA)
#                                  Implementation of $1 Gesture Recognition Algorithm
**Project Description :**
------
The main goal of this project was to create a user interface that specifically detects and recognizes 16 predetermined unistroke gestures using the $1 recognition algorithm. Furthermore, I extended the project to evaluate the algorithm's accuracy by testing its recognition capabilities with three additional input modes: mouse, touch with a stylus, and touch without a stylus.

**$1 Algorithm Reference :**
-----
[Jacob O. Wobbrock, Andrew D. Wilson, and Yang Li. 2007. Gestures without libraries, toolkits or training: a $1 recognizer for user interface prototypes. In Proceedings of the 20th annual ACM symposium on User interface software and technology (UIST '07). ACM, New York, NY, USA, 159-168.](https://dl.acm.org/doi/abs/10.1145/1294211.1294238?casa_token=5FbPgYWhczkAAAAA:4i8ClOkuH7NJi2HkSZyMKIVGQPU7wq1l-hK2YiOxAsKQh1fMx4WqrydSZqOj2aUGWhr7ApxtG-uZ)

**Problem Statement:**
-----
The goal of Project #1 is to implement the $1 Gesture recognizer algorithm for the 16 gestures given below. Additionally, the project goal comprises of the following:
*	Developing an Offline recognition module for analysis.
*	Developing a module to collect data from users for offline analysis.
*	Measure performance of the algorithm based on the recognition accuracy.
<img width="302" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/0f51550c-b937-4cab-b886-1a7ae5e6ca34">

 
**Project #2 (Extension of Project1) Goals:**
-----
*	Modify the system to collect samples of all 16 gestures in three more different input modes (Mouse, Touch with stylus, Touch without stylus).
*	Create a setup module to simplify the process of collecting the dataset.
*	Measure performance of system for the new datasets and compare the same.
Project Demo:

**Demo is uploaded in the git with name “demo”.**

**Project Milestones:**
-----
The project #1 has been divided into 5 milestones to build the complete system. Project #2 is completed as a single milestone.
*	Part 1 : Drawing on a Canvas
*	Part 2 : Online/Live Recognition
*	Part 3 : Offline/Test Recognition with $1
*	Part 4 : Collecting Data from People
*	Part 5 : Exploring Data from People

**Implemented Functionality:**
-----
**Online/Live Recognizer GUI system:**
*	The system identifies specified unistroke gestures.
*	Users can draw gestures on the canvas using a mouse, stylus, or finger.
*	System displays the Gesture Name and its similarity score as soon as user lifts their pen or releases their mouse.
*	The system includes a Clear button that allows users to clean the screen.

**User Data Collection GUI system:**
*	Display Gesture name, reference image, basic instructions, and a counter to indicate number of gestures drawn.
*	Gesture types are collected in a random order to accommodate for user fatigue.
*	Re-draw button to allow user to redraw,
*	Submit button stores the data in XML.
*	In case user hits submit without drawing, a popup message is displayed requesting the user to draw.
*	A popup message is displayed as soon as 10 samples of a gesture out of 16 gestures is completed.
*	A popup message is displayed once the activity is completed.

**Offline Recognition Analysis**
*	Extract Gesture data from XML file. XML file consists of the (x,y) points and details like Subject ID, Sample Number, Gesture Name etc.
*	Run User-Dependent analysis : Test the chosen candidate gesture against e template samples of each gesture of the same user.
*	Run User-Independent Analysis : Test randomly chosen candidate gesture against e template samples of each gesture of the r randomly chosen user.

**System**
----
* Language : Java
* IDE : Microsoft Visual Studio Code
* Version Control : Github repository

**Installation and Execution**
-----
**Installation**
*	Java : The computer must have Java compiling and runtime capabilities available.
*	Code file: Download all files into "DollarOneRecognizer" folder
*	Dataset : Download the dataset (XML Folder : https://depts.washington.edu/acelab/proj/dollar/index.html) and unzip the folder. Move it to " DollarOneRecognizer /xml_logs"
*	online Templates : For the 16 default gestures, no setup needed.

**Compile files**
```
cd <folder_name>
javac  UiFrame.java
javac  CollectionUI.java
javac TrainandTest.java
```
Note : Both files need to be compiled always since there are functions being used across the files.

**Run Online recognizer**
```
java UiFrame
```

**Run Data collector**
```
java CollectionUI
```

**Run Offline recognizer**
```
java TrainandTest
```

**Implementation**
-----
**System Flow chart**
 

<img width="519" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/a955e4b5-8345-405a-a34c-d7fa1bb859e5">











<br> <br>**Snapshots of GUI**
<br>  <img width="275" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/0d791665-35e2-4e52-bc93-b51778f7f5b3">
<img width="275" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/7810cb19-06d8-4403-9e7a-9f3c87203991">
<img width="275" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/804d2a2a-6428-4532-a6f0-64c2c9c0936d">
 

 

**Analysis and Results**
----
**Offline Recognition Test :** </br>Recognition Accuracy using User Dependent Analysis for the 16 pre-defined gestures.
The recognition accuracy is plotted against the template size for all types of modality (Trackpad, Mouse, Touch with stylus, Touch without stylus).
 
<img width="457" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/32db89a1-1f82-403d-90ba-31a93dcc8086">


**Ghost Heatmap Analysis:**
 
 <img width="500" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/b2fbc766-001b-4d07-abf7-d286a6773495">
<img width="500" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/8765cf91-4748-4c9e-8ba1-bd4bbe135214">
<img width="500" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/3e158d04-9a3a-4397-a2ce-b940b88aba88">
<img width="500" alt="image" src="https://github.com/Namita-Namita/DollarOneRecognizer/assets/31967922/49871734-d16c-4861-be4a-c48d212f0491">


Data collected by authors have a uniform drawing speed whereas the users recruited by us did not maintain a uniform speed which is why the samples had lot of variability. 
</br>The proposed extension outcome did not fully meet the expectations, as the mouse data, which was initially anticipated to be the most accurate, turned out to be the least consistent and relatively inaccurate, based on the results. The recognizer's overall accuracy was greatest when using the trackpad and least when using the mouse, while touch input with or without a stylus had roughly equal accuracy. Through GHoST analysis, we were able to identify those certain gestures performed with specific input modalities exhibited inconsistencies when compared to other gestures performed with the same or different input modalities. 
</br>However, one aspect that did align with our expectations was that the accuracy of the results increased and reached its peak at a certain value as we increased the number of training examples.

**References:**
----
**$1 Algorithm:**
</br>Jacob O. Wobbrock, Andrew D. Wilson, and Yang Li. 2007. Gestures without libraries, toolkits or training: a $1 recognizer for user interface prototypes. In Proceedings of the 20th annual ACM symposium on User interface software and technology (UIST '07). ACM, New York, NY, USA, 159-168. https://doi.org/10.1145/1294211.1294238

**Gesture Templates:**
</br>https://depts.washington.edu/acelab/proj/dollar/index.html

**XML Files for Offline Recognition**
</br>https://depts.washington.edu/acelab/proj/dollar/index.html
