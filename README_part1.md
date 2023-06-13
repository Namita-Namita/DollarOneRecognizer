# HCIRA_Project1_Part1
Human-Centered Input Recognition Algorithms - Project 1 Part 1

Group members:-
- Namita Namita (48479313)
- Harshwardhan Chauhan (42046851)

Steps to run the project:-
- Unzip the Project1_Part1.zip file.
- Double-click the UiFrame.java file to open the source code in the editor.
- Compile the UiFrame.java file.
  javac UiFrame.java
- Run the UiFrame.java file.
  java UiFrame
- The canvas along with the clear button will appear as expected.

Goals achieved:
a)Set up a development environment 
	- In this project, JDK 17 and VScode IDE were used for the development and execution of the project.
	- The development environment(JDK, SDK, and editor) was set up for Java programming language with the help of the internet.

b)Instantiating a canvas
	- An empty canvas was instantiated, with a code present at line 21. Upon creation of an object canvas, a canvas with a size of 500 * 400 was created with the title "canvas".
	- The canvas is added to the frame as a component at line 37.

	// create an empty canvas
	canvas = new Canvas(){
            public void paint(Graphics gr)
            {  
            }
        };
	// set size of the canvas in the frame
        canvas.setSize(500, 400);
	add(canvas);

c)Listening for mouse or touch events
	- To listen for mouse or touch events, the MouseListener and MouseMotionListener class from the java.awt.* package was implemented with the class UiFrame. (Line 33 and 34)

	// add mouse listener
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);

	- When the mouse was clicked for the first time, the mousePressed function at line 62 was called and the X and Y coordinates of that point were stored in variables prevx and prevy. Then an oval post is made 	  at that point with the help of the "fillOval" function.

	public void mousePressed(MouseEvent e)
    {
        Graphics gr = canvas.getGraphics();
 
        gr.setColor(Color.red);
 
        // get X and y position
        prevx = e.getX();
        prevy = e.getY();
        // draw a Oval at the point
        // where mouse is moved
        gr.fillOval(prevx, prevy, 10, 10);
    }

	- The mouseDragged function at line 76 was called when the mouse was dragged on the canvas. This function stores the X and Y coordinates of the points touched in variables x and y and draws the line from the 	  initially stored X, Y (prevx, prevy) coordinate to the newly stored X, Y coordinates (x,y). This is done with the help of the "drawLine" function.

	 public void mouseDragged(MouseEvent e)
    {
        Graphics gr = canvas.getGraphics();
        Graphics2D g2= (Graphics2D)gr;
       
        gr.setColor(Color.red);
        g2.setStroke(new BasicStroke(5));
        // get X and y position
        int x, y;
        x = e.getX();
        y = e.getY();
 
        // draw a line with the points where mouse is moved
        gr.drawLine(prevx, prevy, x, y);
        prevx=x;
        prevy=y;
        
    }

	

d)Clearing the canvas
	- A button named "Clear" was created at line 39.
	- The button is added to the frame as a component at line 43.

	 // Create a clear button. 
	    button = new JButton ("Clear");
	    button.setBackground (Color.white);
        // b button setbounds
        button.setBounds(180 , 400, 100, 50);
        add(button);
	// Add a listenet fir vthe button
        button.addActionListener (this);

	- The ActionListener implemented in the code will respond to the click on the "Clear" button. Upon clicking, the actionPerformed function at line 49 is called. The actionPerformed function will get the 	  command from the click of the button and perform canvas clear functionality by repainting the background of the canvas with the color defined.

     // This method is required to implement the  
    // ActionListener interface. 
    public void actionPerformed (ActionEvent e)
    {
	    String str = e.getActionCommand();
        if (str.equalsIgnoreCase ("Clear")) {
	    // Note: must call repaint() of canvas 
	    // to reset the background. 
	    canvas.setBackground (Color.gray);
	    canvas.repaint ();
	    }
    }
