import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.util.*;

// a UiFrame class to instantiate a blank ‘canvas’ to the screen using GUI elements
//listen for mouse or touch events on the canvas and draw them as the user makes them
// allow the user to clear the canvas. 
class UiFrame extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

    JButton button1, button2;
    Canvas canvas;
    int prevx, prevy;
    Map<String, Integer> gesture = new HashMap<>();
    // ArrayList DS to store array of points.
    ArrayList<Point> points = new ArrayList<>();
    StringBuilder Filename = new StringBuilder("Arrow1");
    StringBuilder randomGesture = new StringBuilder("Arrow");
    int i = 0;
    int n = 1;
    JLabel Label2 = new JLabel("Draw Arrow");
    JLabel Label4 = new JLabel("Draw the gesture in one stroke and click on submit button");
    JLabel Label3 = new JLabel("Click Draw Again button in case of any mistake.");
    // Load the image from file
    ImageIcon imageIcon = new ImageIcon("Arrow.png");

    // Create a JLabel and set its icon to the image
    JLabel label = new JLabel(imageIcon);

    // constructor to set up the frame with canvas and clear button
    UiFrame() {
        super("canvas");

        // create a empty canvas
        canvas = new Canvas() {
            public void paint(Graphics gr) {
            }
        };
        // sets the frame to put canvas as a component
        setLayout(null);
        // sets size of the frame 500*500 square
        setSize(800, 800);
        // set background for the canvas with color gray
        canvas.setBackground(Color.gray);
        // add mouse listener and mouse motion listener for mouse actions
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        // set size of the canvas in the frame- 500*400
        canvas.setSize(800, 400);
        add(canvas);
        // Create a clear button labeled Clear
        button1 = new JButton("Draw Again");
        // Sets the background of the button to white.
        button1.setBackground(Color.white);
        // button setbounds function to set the sezi and placement of the button
        button1.setBounds(80, 400, 100, 50);
        add(button1);
        // Add a listener for the button to listen to the button clicks
        button1.addActionListener(this);
        button2 = new JButton("Submit");
        // Sets the background of the button to white.
        button2.setBackground(Color.white);
        // button setbounds function to set the sezi and placement of the button
        button2.setBounds(300, 400, 100, 50);
        // Border border = BorderFactory.createLineBorder(Color.BLACK);
        // button2.setBorder(border);
        add(button2);
        // Add a listener for the button to listen to the button clicks
        button2.addActionListener(this);

        gesture.put("Arrow", 9);
        gesture.put("X", 1);
        gesture.put("Rectangle", 1);
        gesture.put("Delete", 1);
        gesture.put("Triangle", 1);
        gesture.put("Circle", 9);
        gesture.put("Check", 9);
        gesture.put("Caret", 1);
        gesture.put("Pigtail", 1);
        gesture.put("Zigzag", 1);
        gesture.put("Question", 9);
        gesture.put("Right_square_bracket", 1);
        gesture.put("Left_square_bracket", 1);
        gesture.put("Right_curly_brace", 1);
        gesture.put("Left_curly_brace", 1);
        gesture.put("V", 1);
        gesture.put("Star", 1);

        Label2.setBounds(10, 450, 800, 70); // x, y, width, height
        Label4.setBounds(10, 450, 800, 110); // x, y, width, height
        Label3.setBounds(10, 450, 800, 150); // x, y, width, height
        this.setTitle("Arrow #" + gesture.get("Arrow"));
        gesture.put("Arrow", gesture.get("Arrow") + 1);

        // Set the position and size of the label
        label.setBounds(100, 550, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        // Add the label to the frame
        add(label);
        // Add the panel to the frame and show the frame
        add(Label2);
        add(Label4);
        add(Label3);
        setVisible(true);

    }

    // This method is required to implement the
    // ActionListener interface.
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        // points.clear();
        if (str.equalsIgnoreCase("Re-Draw")) {
            // Note: must call repaint() of canvas
            // to reset the background.
            canvas.setBackground(Color.gray);
            canvas.repaint();
        }
        // Set the title to the match found and the score calculated.
        // this.setTitle("Result: "+templateName+" ("+score+") in
        // "+(endTime-startTime)+"ms");
        if (str.equalsIgnoreCase("Submit") && n <= 170) {

            WriteXML w = new WriteXML();
            //System.out.println(gesture.get(randomGesture.toString()));
            if (gesture.get(randomGesture.toString()) <= 9) {
                n++;
                gesture.put(randomGesture.toString(), gesture.get(randomGesture.toString()) + 1);
                w.saveGesture(points, randomGesture.toString(), Filename.toString());
                canvas.setBackground(Color.gray);
                canvas.repaint();
                Random random = new Random();
                Object[] keys = gesture.keySet().toArray();
                String randomges = (String) keys[random.nextInt(keys.length)];
                // System.out.println(randomGesture);
                // Create a label with text
                randomGesture.replace(0, randomGesture.length(), randomges);
                String img = randomges.concat(".png");
                ImageIcon newImageIcon = new ImageIcon(img);
                // Set the icon of the label to the new image
                label.setIcon(newImageIcon);
                Label2.setText("Draw " + randomGesture);
                this.setTitle(randomges + " #" + gesture.get(randomges));
                Filename = new StringBuilder(randomGesture.append(gesture.get(randomges)).toString());
                randomGesture.replace(0, randomGesture.length(), randomges);
                // System.out.println(Filename);
            }
            else {
                canvas.setBackground(Color.gray);
                canvas.repaint();
                // JLabel Label5= new JLabel();
                // Label5.setBounds(10, 350, 800, 70);
                // Label5.setText("Gesture "+ randomGesture.toString()+" complete");
                //Label3.setText(" ");
                //Label4.setText(" ");
                //label.setIcon(null);
                gesture.remove(randomGesture.toString());
                Random random = new Random();
                Object[] keys = gesture.keySet().toArray();
                System.out.println(gesture);
                String randomges = (String) keys[random.nextInt(keys.length)];
                // System.out.println(randomGesture);
                // Create a label with text
                randomGesture.replace(0, randomGesture.length(), randomges);
                String img = randomges.concat(".png");
                ImageIcon newImageIcon = new ImageIcon(img);
                // Set the icon of the label to the new image
                label.setIcon(newImageIcon);
                Label2.setText("Draw " + randomGesture);
                Label3.setText("Draw the gesture in one stroke and click on submit button");
                Label4.setText("Re-draw by clicking re-draw button if the gesture you are not satisfied with the gesture you drew.");
                this.setTitle(randomges + " #" + gesture.get(randomges));
                Filename = new StringBuilder(randomGesture.append(gesture.get(randomges)).toString());
                gesture.put(randomges, gesture.get(randomges) + 1);
                randomGesture.replace(0, randomGesture.length(), randomges);
                //w.saveGesture(points, randomGesture.toString(), Filename.toString());
                //n++;

            }
        } else if (n == 171) {
            Label2.setText("Task Complete, Thank you");
            Label3.setText(" ");
            Label4.setText(" ");
            label.setIcon(null);
            // Note: must call repaint() of canvas
            // to reset the background.
            canvas.setBackground(Color.gray);
            canvas.repaint();
        }

    }

    public long startTime, endTime;

    // mouse listener and mouse motion listener methods
    // mousepressed method to listen to the pressed action of the mouse.
    public void mousePressed(MouseEvent e) {
        startTime = System.currentTimeMillis() * 1000;
        Graphics gr = canvas.getGraphics();

        gr.setColor(Color.red);

        // get X and Y position in prevx and prevy variables.
        prevx = e.getX();
        prevy = e.getY();
        // Adds point prevx and prevy fetched to the list of Array points.
        points.add(new Point((double) prevx, (double) prevy, startTime));
        // draw a Oval at the point
        // prevx and prevy
        gr.fillOval(prevx, prevy, 10, 10);
    }

    // mousedragged method to listen to the dragged action of the mouse.
    public void mouseDragged(MouseEvent e) {
        endTime = System.currentTimeMillis() * 1000;
        Graphics gr = canvas.getGraphics();
        Graphics2D g2 = (Graphics2D) gr;
        // stes the color of the gesture line drawn to red.
        gr.setColor(Color.red);
        // Sets the width of the line to draw.
        g2.setStroke(new BasicStroke(5));
        // get X and Y position
        int x, y;
        x = e.getX();
        y = e.getY();
        // Adds point X and Y fetched to the list of Array points.
        points.add(new Point((double) x, (double) y, endTime));

        // draw a line with the points where mouse is moved
        gr.drawLine(prevx, prevy, x, y);
        prevx = x;
        prevy = y;
        // startTime=endTime;
        // System.out.println(xcord[i]+" "+ycord[i]+"\n");
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
    // mousereleased method to listen to the released action of the mouse.
    // public void mouseReleased(MouseEvent e)
    // {

    // /**
    // * start $1 algorithm to recognize the gesture and output the result
    // * Steps involved for the reconition to happen
    // * 1. Resample
    // * 2. Rotate
    // * 3. Scale
    // * 5. Translate
    // * 6. Matching
    // * 7. O/P
    // */
    // long startTime = System.currentTimeMillis();
    // PointProcessor pointProcessor = new PointProcessor();
    // DollarOneRecognizer dollarOneRecognizer = new DollarOneRecognizer();

    // // // Resampling the points
    // ArrayList<Point> resampledPoints = pointProcessor.resample(points);

    // // //Rotate the points accordingly
    // // // Get the centroid of the gesture drawn
    // Point centroid = pointProcessor.centroid(resampledPoints);
    // // // Get the first poiint after resampling
    // Point firstPoint = resampledPoints.get(0);
    // // // Calculate the slope to get the rotation angle
    // double slope =
    // Math.atan2((firstPoint.y-centroid.y),(firstPoint.x-centroid.x));
    // // // Rotate by function to rotate the points accordingl
    // // //ArrayList<Point> rotatedPoints =
    // pointProcessor.rotateBy(resampledPoints, -1*slope,centroid);
    // ArrayList<Point> rotatedPoints = pointProcessor.rotateBy(resampledPoints,
    // -1*slope,centroid);

    // // //Scale the gesture
    // pointProcessor.scale(rotatedPoints);

    // // //Translate the gesture
    // ArrayList<Point> translatedPoints = pointProcessor.translate(rotatedPoints);

    // // //Matching
    // String result = dollarOneRecognizer.recognize(translatedPoints);
    // // // Displaying the match
    // // //String[] str = result.split(" ");
    // String[] str = result.split("-");
    // System.out.println(result);
    // // // Getting the match
    // String templateName = str[0];
    // // // Getting the score
    // double score = Double.parseDouble(str[1]);
    // long endTime = System.currentTimeMillis();
    // // // Set the title to the match found and the score calculated.
    // this.setTitle("Result: "+templateName+" ("+score+") in
    // "+(endTime-startTime)+"ms");

    // // //Draw the points
    // Graphics gr = canvas.getGraphics();
    // gr.setColor(Color.blue);
    // }

    public static void main(String[] argv) {
        // creates a canvas object
        new UiFrame();

    }
}
