/*
 * @author Namita Namita
 *
 */
// Import statement for all necessary libraries
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

// A class called UiFrame which extends JFrame and implements MouseListener, MouseMotionListener, and ActionListener
// This class creates a blank canvas on the screen using GUI elements
// It listens for mouse or touch events on the canvas and draws them as the user makes them
// It also allows the user to clear the canvas
class CollectionUI extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

    // JButton button1 and button2 to add on the GUI for submitting the gesture and
    // re drawing
    // when the user needs to draw again.
    JButton button1, button2;
    // canvas variable is declared to launch canvas in the frame
    Canvas canvas;
    // prevx and prevy integfers are declared to store previous points
    int prevx, prevy;
    // A hanshmap gesture is declared to store the gesture with the count of
    // samples.
    Map<String, Integer> gesture = new HashMap<>();
    // ArrayList points declared to store an array of points.
    ArrayList<Point> points = new ArrayList<>();
    // Filename string is declared to store the name of the file to store the sample
    // into
    StringBuilder Filename = new StringBuilder("arrow01.xml");
    // randomGesture string is declared to store the name of the gesture randomly
    // choosen
    StringBuilder randomGesture = new StringBuilder("arrow");
    int i = 0;
    int n = 0;
    // JLabels are declared to preform the display function for texts in the frame.
    JLabel Label1 = new JLabel("Instructions:");
    JLabel Label5 = new JLabel("There are 16 different gestures and you will be presented with all of them in random order.");
    JLabel Label6 = new JLabel("You will be asked to draw each gesture 10 times randomly one by one.");
    JLabel Label7 = new JLabel("The count is shown on top of the screen with the gesture name.");
    JLabel Label2 = new JLabel("Draw arrow. You can refer the image for reference.");
    JLabel Label4 = new JLabel("Draw the gesture in one stroke and click on submit button");
    JLabel Label3 = new JLabel("Click Draw Again button in case of any mistake.");
    // Loads an image from file and scale it down to half the original size
    ImageIcon imageIcon = new ImageIcon("res/image/arrow.png");
    Image image = imageIcon.getImage();
    int newWidth = imageIcon.getIconWidth() / 2; // scale down the width of the image to half the original width
    int newHeight = imageIcon.getIconHeight() / 2; // scale down the height of the image to half the original height
    Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    // Creates a JLabel "label" and set its icon to the scaled image "scaledIcon"
    JLabel label = new JLabel(scaledIcon);

    // constructor to set up the frame with canvas, buttons and texts to make the
    // GUI user friendly
    CollectionUI() {
        super("canvas");

        // Creates an empty canvas and set its size and background color
        canvas = new Canvas() {
            public void paint(Graphics gr) {
            }
        };
        // Sets the layout to null and size of the frame to 900*1000 pixels
        setLayout(null);
        setSize(900, 1100);
        // sets the background of the canvas with color gray
        canvas.setBackground(Color.gray);
        // Adds mouse listeners for mouse actions on the canvas
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        // Sets the size of the canvas in the frame to 900*400 pixels and add it to the
        // frame
        canvas.setSize(900, 400);
        add(canvas);
        // Creates a "Draw Again" button, set other properties of the button
        // like background color, button size, button placement and add it to the frame
        button1 = new JButton("Draw Again");
        button1.setUI(new MyButtonUI());
        add(button1);
        // Adds a listener for the "Draw Again" button to listen to button clicks
        button1.addActionListener(this);
        // Create a "Submit" button, set other properties of the button
        // like background color, button size, button placement and add it to the frame
        button2 = new JButton("Submit");
        button2.setUI(new MyButtonUI());
        button2.setBackground(Color.BLUE);
        // button2.setOpaque(true);
        // button2.setForeground(Color.white);
        // button setbounds function to set the sezi and placement of the button
        button2.setBounds(450, 420, 120, 50);
        // Border border = BorderFactory.createLineBorder(Color.BLACK);
        // button2.setBorder(border);
        add(button2);
        // Adds a listener for the "Submit" button to listen to button clicks
        button2.addActionListener(this);
        // Adds all 16 gestures to the hashmap with the count to 0 as the samples taken
        // initially is 0.
        gesture.put("arrow", 1);
        gesture.put("x", 0);
        gesture.put("rectangle", 0);
        gesture.put("delete", 0);
        gesture.put("triangle", 0);
        gesture.put("circle", 0);
        gesture.put("check", 0);
        gesture.put("caret", 0);
        gesture.put("pigtail", 0);
        gesture.put("zigzag", 0);
        // gesture.put("Question", 0);
        gesture.put("right_sq_bracket", 0);
        gesture.put("left_sq_bracket", 0);
        gesture.put("right_curly_brace", 0);
        gesture.put("left_curly_brace", 0);
        gesture.put("v", 0);
        gesture.put("star", 0);
        Label1.setBounds(10, 450, 800, 70);
        Label2.setBounds(10, 450, 800, 110); // x, y, width, height
        Label4.setBounds(10, 450, 800, 150); // x, y, width, height
        Label3.setBounds(10, 450, 800, 190); // x, y, width, height
        Label5.setBounds(10, 450, 800, 230); // x, y, width, height
        Label6.setBounds(10, 450, 800, 270); // x, y, width, height
        Label7.setBounds(10, 450, 800, 310); // x, y, width, height
        this.setTitle("arrow #" + gesture.get("arrow"));
        // gesture.put("Arrow", gesture.get("Arrow") + 1);

        // Sets the position and size of the label where the imageicon is setting
        label.setBounds(550, 430, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        // Adds the label to the frame for the image to display on the GUI
        add(label);
        // Adds the labels to the frame for the all texts to be visible on the GUI and
        // sets the frame to be visible
        add(Label1);
        add(Label2);
        add(Label4);
        add(Label3);
        add(Label5);
        add(Label6);
        add(Label7);
        setVisible(true);

    }

    /**
     * 
     * This method is called when the Submit and Draw Again buttons are clicked
     * 
     * It implements the ActionListener interface
     */
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        WriteXML w = new WriteXML();
        // points.clear();
        if (str.equalsIgnoreCase("Draw Again")) {
            // If the button "Draw Again" is clicked by the user
            // the canvas will be clared and reset witth canvas.repaint
            // All the points saved on mouse actions will be cleared when the button is clicked.
            canvas.setBackground(Color.gray);
            canvas.repaint();
            points.clear();
        }
        // Set the title to the match found and the score calculated.
        // this.setTitle("Result: "+templateName+" ("+score+") in
        // "+(endTime-startTime)+"ms");
        // If the user clicks "Submit" button and the user trial is less than 159 times
        // write the points in the designated gesture file.
        else if (str.equalsIgnoreCase("Submit") && n < 159) {
            // if the submit button is clicked without drawing anything on the canvas
            // a dialog box will pop up with a message.
            if (points.size() == 0) {
                JOptionPane.showMessageDialog(null, "Gesuture not drawn, Re-Draw " + randomGesture);
                // Label2.setText("");
                // Label2.setText("Gesuture not drawn Re-Draw " + randomGesture);
            } // If a gesture say "X" is drawn 10 times, 10th iteration  will be written 
            //to the file as well as removed from hashmap so that it is not shown to the user as a gesture to draw for sample collection
            else if (gesture.get(randomGesture.toString()) == 10) {
                n++;
                // write the drawn gesture to the file and clear the canvas for another gesture to be drawn
                w.saveGesture(points, randomGesture.toString().toLowerCase(), Filename.toString().toLowerCase(),
                        gesture.get(randomGesture.toString()));
                JOptionPane.showMessageDialog(null, "All 10 samples for gesture "+ randomGesture.toString().toLowerCase()+" drawn. Proceed to complete other gestures.");
                canvas.setBackground(Color.gray);
                canvas.repaint();
                // All the points saved on mouse actions will be cleared after it is written to the file.
                points.clear();
                // gesture is removed from hashmap so that it is not shown to the user as a gesture to draw for sample collection
                gesture.remove(randomGesture.toString());
                // Selecting a random gedsture from the hashmap 
                // and asking the user to draw the same for sample collection.
                Random random = new Random();
                Object[] keys = gesture.keySet().toArray();
                // System.out.println(gesture);
                String randomges = (String) keys[random.nextInt(keys.length)];
                gesture.put(randomges.toString(), gesture.get(randomges.toString()) + 1);
                // System.out.println(gesture.get(randomges.toString()) + "-----" +
                // randomges.toString());
                // Create a label with text
                randomGesture.replace(0, randomGesture.length(), randomges);
                String img = "res/image/".concat((randomges.concat(".png")));
                ImageIcon newImageIcon = new ImageIcon(img);
                // Set the icon of the label to the new image
                Image image = newImageIcon.getImage();
                int newWidth = newImageIcon.getIconWidth() / 2; // scale down to half the original width
                int newHeight = newImageIcon.getIconHeight() / 2; // scale down to half the original height
                Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                label.setIcon(scaledIcon);
                Label2.setText("Draw " + randomGesture + ". You can refer the image for reference.");
                //Label3.setText("Draw the gesture in one stroke and click on submit button");
                //Label4.setText(
                  //      "Re-draw by clicking re-draw button if the gesture you are not satisfied with the gesture you drew.");
                this.setTitle(randomges + " #" + gesture.get(randomges));
                if(gesture.get(randomges)<10)
                Filename = new StringBuilder(randomGesture.append("0"+gesture.get(randomges)+".xml").toString());
                else
                Filename = new StringBuilder(randomGesture.append(gesture.get(randomges)+".xml").toString());
                // gesture.put(randomges, gesture.get(randomges) + 1);
                randomGesture.replace(0, randomGesture.length(), randomges);
                // w.saveGesture(points, randomGesture.toString(), Filename.toString());
                // n++;
            }
            // If a gesture say "X" is drawn and its drawn for n times which is less than 10 times,
            //it will be written to the file and then new random gesture is slected after the canvas is
            // cleared and old points are discarded.
            else if (gesture.get(randomGesture.toString()) < 10) {
                n++;
                // write the drawn gesture to the file and clear the canvas for another gesture to be drawn
                w.saveGesture(points, randomGesture.toString().toLowerCase(), Filename.toString().toLowerCase(),
                        gesture.get(randomGesture.toString()));
                canvas.setBackground(Color.gray);
                canvas.repaint();
                // All the points saved on mouse actions will be cleared after it is written to the file.
                points.clear();
                // Selecting a random gedsture from the hashmap 
                // and asking the user to draw the same for sample collection.
                Random random = new Random();
                Object[] keys = gesture.keySet().toArray();
                String randomges = (String) keys[random.nextInt(keys.length)];
                gesture.put(randomges.toString(), gesture.get(randomges.toString()) + 1);
                // System.out.println(gesture.get(randomges.toString()) + "-----" +
                // randomges.toString());
                // System.out.println(randomGesture);
                // Create a label with text
                randomGesture.replace(0, randomGesture.length(), randomges);
                String img = "res/image/".concat((randomges.concat(".png")));
                ImageIcon newImageIcon = new ImageIcon(img);
                Image image = newImageIcon.getImage();
                int newWidth = newImageIcon.getIconWidth() / 2; // scale down to half the original width
                int newHeight = newImageIcon.getIconHeight() / 2; // scale down to half the original height
                Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                // Set the icon of the label to the new image
                label.setIcon(scaledIcon);
                Label2.setText("Draw " + randomGesture + ". You can refer the image for reference.");
                this.setTitle(randomges + " #" + gesture.get(randomges));
                if(gesture.get(randomges)<10)
                Filename = new StringBuilder(randomGesture.append("0"+gesture.get(randomges)+".xml").toString());
                else
                Filename = new StringBuilder(randomGesture.append(gesture.get(randomges)+".xml").toString());
                randomGesture.replace(0, randomGesture.length(), randomges);
                // System.out.println(Filename);
            }
        } // if the user is done drawing all gestures 10 times each 
        // a popup is displayed on clicking the "submit" button with a thank you message
        else if (str.equalsIgnoreCase("Submit") && n == 159) {
            n++;
            // write the last drawn gesture to the file and clear the canvas 
            w.saveGesture(points, randomGesture.toString().toLowerCase(), Filename.toString().toLowerCase(), gesture.get(randomGesture.toString()));
            Label1.setText("");
            Label2.setText("");
            Label3.setText(" ");
            Label4.setText(" ");
            Label5.setText(" ");
            Label6.setText(" ");
            Label7.setText(" ");

            label.setIcon(null);
            // Note: must call repaint() of canvas
            // to reset the background.
            canvas.setBackground(Color.gray);
            canvas.repaint();
            points.clear();
            // a dialog box is poped up with a thank you message.
            JOptionPane.showMessageDialog(null, "Task Complete! Thank you for participation. :)");
            remove(button1);
            remove(button2);
            remove(label);
            revalidate();
            repaint();
        }

    }

    public long startTime, endTime;

    // methods for listening to the mouse events and recognizing gestures.
    // The mousePressed method listens for the press action of the mouse and adds the points to an arraylist.
    public void mousePressed(MouseEvent e) {
        startTime = System.currentTimeMillis();
        Graphics gr = canvas.getGraphics();

        gr.setColor(Color.red);

        // get X and Y position in prevx and prevy variables.
        prevx = e.getX();
        prevy = e.getY();
        // Adds point prevx and prevy fetched to the list of Array points.
        points.add(new Point((double) prevx, (double) prevy, startTime));
        // draw an Oval at the point
        // prevx and prevy
        gr.fillOval(prevx, prevy, 15, 10);
    }

    // The mouseDragged method listens for the drag action of the mouse and adds the points to an array.
    public void mouseDragged(MouseEvent e) {
        endTime = System.currentTimeMillis();
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
        new CollectionUI();

    }
}
// The MyButtonUI class extends the BasicButtonUI class and sets the background color, bounds, and foreground color of the button.
class MyButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
    @Override
    public void installDefaults(AbstractButton button) {
        super.installDefaults(button);
        button.setBackground(Color.RED); // Set the background color
        button.setOpaque(true); // Ensure that the button is opaque
        button.setBounds(200, 420, 120, 50);
        button.setForeground(Color.WHITE);
    }
}
