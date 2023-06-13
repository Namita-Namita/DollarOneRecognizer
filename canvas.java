import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// a canvas class to instantiate a blank ‘canvas’ to the screen using GUI elements
//listen for mouse or touch events on the canvas and draw them as the user makes them
// allow the user to clear the canvas
class canvas extends JFrame implements MouseListener, MouseMotionListener, ActionListener{

    Canvas canvas;
    JButton button;
    int prevx, prevy;
    
	// constructor
	canvas()
	{
		super("canvas");

		// create a empty canvas
		canvas = new Canvas(){
            public void paint(Graphics gr)
            {  
            }
        };
        // sets the frame to put canvas as a component
        setLayout(null);
        // sets size of the frame
		setSize(500, 500);
        // set background for the canvas
		canvas.setBackground(Color.gray);
        // set size of the canvas in the frame
        canvas.setSize(500, 400);
        // add mouse listener
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
		add(canvas);
         // Create a clear button. 
	    button = new JButton ("Clear");
	    button.setBackground (Color.white);
        // b button setbounds
        button.setBounds(180 , 400, 100, 50);
        add(button);
        // Add a listenet fir vthe button
        button.addActionListener (this);
        setVisible(true);
	}
     // mouse listener  and mouse motion listener methods

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
    public void mouseClicked(MouseEvent e)
    {
    }
 
    public void mouseMoved(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }
 
    public void mouseEntered(MouseEvent e)
    {
    }
 
    public void mouseReleased(MouseEvent e)
    {
    }
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
 
    public static void main (String[] argv)
    {
        // creates a canvas object
        canvas c= new canvas();
    }
}
