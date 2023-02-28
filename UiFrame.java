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
    int n = 0;
    JLabel Label1= new JLabel("Instructions:");
    JLabel Label2 = new JLabel("Draw Arrow. You can refer the below image for reference.");
    JLabel Label4 = new JLabel("Draw the gesture in one stroke and click on submit button");
    JLabel Label3 = new JLabel("Click Draw Again button in case of any mistake.");
    // Load the image from file
    ImageIcon imageIcon = new ImageIcon("res/image/Arrow.png");
    Image image = imageIcon.getImage();
    int newWidth = imageIcon.getIconWidth() / 2; // scale down to half the original width
    int newHeight = imageIcon.getIconHeight() / 2; // scale down to half the original height
    Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    // Create a JLabel and set its icon to the image
    JLabel label = new JLabel(scaledIcon);

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
        button1.setUI(new MyButtonUI());
        // Sets the background of the button to white.
        //button1.setBackground(Color.BLUE);
        //button1.setOpaque(true);
       // button1.setForeground(Color.white);
        // button setbounds function to set the sezi and placement of the button
        //button1.setBounds(80, 400, 100, 50);
        add(button1);
        // Add a listener for the button to listen to the button clicks
        button1.addActionListener(this);
        button2 = new JButton("Submit");
        // Sets the background of the button to white.
        button2.setUI(new MyButtonUI());
        button2.setBackground(Color.BLUE);
        //button2.setOpaque(true);
        //button2.setForeground(Color.white);
        // button setbounds function to set the sezi and placement of the button
        button2.setBounds(400, 420, 120, 50);
        // Border border = BorderFactory.createLineBorder(Color.BLACK);
        // button2.setBorder(border);
        add(button2);
        // Add a listener for the button to listen to the button clicks
        button2.addActionListener(this);

        gesture.put("Arrow", 1);
        gesture.put("X", 0);
        gesture.put("Rectangle", 0);
        gesture.put("Delete", 0);
        gesture.put("Triangle", 0);
        gesture.put("Circle", 0);
        gesture.put("Check", 0);
        gesture.put("Caret", 0);
        gesture.put("Pigtail", 0);
        gesture.put("Zigzag", 0);
        gesture.put("Question", 0);
        gesture.put("Right_square_bracket", 0);
        gesture.put("Left_square_bracket", 0);
        gesture.put("Right_curly_brace", 0);
        gesture.put("Left_curly_brace", 0);
        gesture.put("V", 0);
        gesture.put("Star", 0);
        Label1.setBounds(10, 450, 800, 70);
        Label2.setBounds(10, 450, 800, 110); // x, y, width, height
        Label4.setBounds(10, 450, 800, 150); // x, y, width, height
        Label3.setBounds(10, 450, 800, 190); // x, y, width, height
        this.setTitle("Arrow #" + gesture.get("Arrow"));
        // gesture.put("Arrow", gesture.get("Arrow") + 1);

        // Set the position and size of the label
        label.setBounds(100, 500, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        // Add the label to the frame
        add(label);
        // Add the panel to the frame and show the frame
        add(Label1);
        add(Label2);
        add(Label4);
        add(Label3);
        setVisible(true);

    }

    // This method is required to implement the
    // ActionListener interface.
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        WriteXML w = new WriteXML();
        // points.clear();
        if (str.equalsIgnoreCase("Draw Again")) {
            // Note: must call repaint() of canvas
            // to reset the background.
            canvas.setBackground(Color.gray);
            canvas.repaint();
            points.clear();
        }
        // Set the title to the match found and the score calculated.
        // this.setTitle("Result: "+templateName+" ("+score+") in
        // "+(endTime-startTime)+"ms");
        else if (str.equalsIgnoreCase("Submit") && n < 169) {

            if(points.size()==0){
                JOptionPane.showMessageDialog(null, "Gesuture not drawn, Re-Draw "+randomGesture);
                //Label2.setText("");
                //Label2.setText("Gesuture not drawn Re-Draw " + randomGesture);
            }
            else if (gesture.get(randomGesture.toString()) == 10) {
                n++;
                //System.out.println("n=" + n);
                w.saveGesture(points, randomGesture.toString(), Filename.toString(), gesture.get(randomGesture.toString()) );
                canvas.setBackground(Color.gray);
                canvas.repaint();
                points.clear();
                gesture.remove(randomGesture.toString());
                Random random = new Random();
                Object[] keys = gesture.keySet().toArray();
                //System.out.println(gesture);
                String randomges = (String) keys[random.nextInt(keys.length)];
                gesture.put(randomges.toString(), gesture.get(randomges.toString()) + 1);
                //System.out.println(gesture.get(randomges.toString()) + "-----" + randomges.toString());
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
                Label2.setText("Draw " + randomGesture+ ". You can refer the below image for reference.");
                Label3.setText("Draw the gesture in one stroke and click on submit button");
                Label4.setText(
                        "Re-draw by clicking re-draw button if the gesture you are not satisfied with the gesture you drew.");
                this.setTitle(randomges + " #" + gesture.get(randomges));
                Filename = new StringBuilder(randomGesture.append(gesture.get(randomges)).toString());
                // gesture.put(randomges, gesture.get(randomges) + 1);
                randomGesture.replace(0, randomGesture.length(), randomges);
                // w.saveGesture(points, randomGesture.toString(), Filename.toString());
                // n++;
            }
            // System.out.println(gesture.get(randomGesture.toString()));
            else if (gesture.get(randomGesture.toString()) < 10) {
                n++;
                //System.out.println("n=" + n);
                w.saveGesture(points, randomGesture.toString(), Filename.toString(), gesture.get(randomGesture.toString()));
                canvas.setBackground(Color.gray);
                canvas.repaint();
                points.clear();
                Random random = new Random();
                Object[] keys = gesture.keySet().toArray();
                String randomges = (String) keys[random.nextInt(keys.length)];
                gesture.put(randomges.toString(), gesture.get(randomges.toString()) + 1);
                //System.out.println(gesture.get(randomges.toString()) + "-----" + randomges.toString());
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
                Label2.setText("Draw " + randomGesture+ ". You can refer the below image for reference.");
                this.setTitle(randomges + " #" + gesture.get(randomges));
                Filename = new StringBuilder(randomGesture.append(gesture.get(randomges)).toString());
                randomGesture.replace(0, randomGesture.length(), randomges);
                // System.out.println(Filename);
            }
        } else if (str.equalsIgnoreCase("Submit") && n == 169) {
            n++;
            //System.out.println("n=" + n);
            w.saveGesture(points, randomGesture.toString(), Filename.toString(), gesture.get(randomGesture.toString()));
            Label1.setText("");
            Label2.setText("");
            Label3.setText(" ");
            Label4.setText(" ");
            label.setIcon(null);
            // Note: must call repaint() of canvas
            // to reset the background.
            canvas.setBackground(Color.gray);
            canvas.repaint();
            points.clear();
            JOptionPane.showMessageDialog(null, "Task Complete! Thank you for participation. :)");
            remove(button1);
            remove(button2);
            remove(label);
            revalidate();
            repaint();
        }

    }

    public long startTime, endTime;

    // mouse listener and mouse motion listener methods
    // mousepressed method to listen to the pressed action of the mouse.
    public void mousePressed(MouseEvent e) {
        startTime = System.currentTimeMillis();
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
        new UiFrame();

    }
}
class MyButtonUI extends javax.swing.plaf.basic.BasicButtonUI {
    @Override
    public void installDefaults(AbstractButton button) {
        super.installDefaults(button);
        button.setBackground(Color.RED); // Set the background color
        button.setOpaque(true); // Ensure that the button is opaque
        button.setBounds(150, 420, 120, 50);
        button.setForeground(Color.WHITE);
    }
}
