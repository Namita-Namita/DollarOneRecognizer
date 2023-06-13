Human-Centered Input Recognition Algorithms - Project 1 Part 4

###Group members:-
- Namita Namita (48479313)
- Harshwardhan Chauhan (42046851)

##System:-
The application was developed using Java. Implementation was carried out in Microsoft Visual Studio Code, a straightforward yet effective solution that provides all the IDE features required by our team for this specific project.

##Submission files:-
HCIRA_Project1_part4.zip, readme.txt, Dataset.zip, Project1Part4.mp4.


###Steps to install and execute the project:-
- Unzip the Project1_Part4.zip file.
- Open the Project1_Part4 folder in VS code by navigating to the editor.
- Click the UiFrame.java file to open the source code in the editor.
- Run the UiFrame.java file by clicking the run button in the right corner of the VS Code.
- The canvas along with the buttons and instructions will appear as expected.
- Try out gestures by dragging the mouse in the canvas, and clicking the "submit" or "Draw Again" button to submit the sample or retry the gesture.

###Functionality implemented:-
- In part 1 of project 1, we launched the canvas to draw the gestures on mouse motion along with a button to clear the gesture.
- In part 2 of project 1, we have implemented the Live version of the $1 recognizer.
- In part 3 of project 1, we have implemented the offline version of the $1 recognizer.
- As part of this submission, we have implemented a GUI to collect samples of 16 gestures from different users and write them into an xml file at a specific location.
- The user can then use the "Draw again" button to clear the screen and re-draw the gestures.
- The user can use the "Submit" button to submit the gesture sample drawn.

###Goals achieved:
a) update your GUI canvas code to write the gesture the user draws to a file;
- The code is updated in the "WriteXML.java" file to write gestures the user draws to a file.
- The method "saveGesture()" will write the points to the file.
- Line numbers 172, 217, and 254 in the file "UiFrame.java" will call "WriteXML.java" to write the points collected by mouse motion in the file passed as an argument.

	 w.saveGesture(points, randomGesture.toString(), Filename.toString(), gesture.get(randomGesture.toString()));

- The "Submit" button in the canvas will instantiate the write to XML method "saveGesture()" to write into the file. It is implemented in line numbers 160 and 251 in the file "UiFrame.java" file.

b) add prompts to the user to draw 10 samples of each gesture type one at a time (and write them to files);
- The "UiFrame.java" file contains all setups to show prompts to the user to draw 10 samples of each gesture.
- Line number 38-45 has labels that will give instructions to the user to draw gestures.
- Line number 47 displays the image of the gesture to be drawn.
- The buttons on line number 82 and 96 is adding "Submit" and "Draw Again" buttons for the user to retry the gesture or submit the sample drawn.
- The total number of samples drawn for a gesture is shown on top of the canvas.

c) recruit 6 people to provide gesture samples for your project; 
- 6 people are recruited to collect samples of all 16 gestures (10 samples each)
- A consent form was presented to them to read and sign before the activity.


d) submit your full dataset.
- The dataset for each user is stored in separate folders named "xml_user*". Where * is the random identifier. (Example s,u,a,....).