import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// a canvas class to instantiate a blank ‘canvas’ to the screen using GUI elements
//listen for mouse or touch events on the canvas and draw them as the user makes them
// allow the user to clear the canvas
class canvas extends JFrame implements MouseListener, MouseMotionListener, ActionListener{

    Canvas c;

    
    
	// constructor
	canvas()
	{
		super("canvas");

		// create a empty canvas
		c = new Canvas(){
            public void paint(Graphics g)
            {  
            }
        };
        // sets the frame to put canvas as a component
        setLayout(null);
        // sets size of the frame
		setSize(500, 500);
        // set background for the canvas
		c.setBackground(Color.gray);

        // set size of the canvas in the frame
        c.setSize(500, 400);
		add(c);
        
        setVisible(true);
	}
    
 
    public static void main (String[] argv)
    {
        // creates a canvas object
        canvas c= new canvas();
    }
}
