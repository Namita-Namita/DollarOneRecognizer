/*
 * @author Namita Namita
 */
// Import statement for all necessary libraries

import org.w3c.dom.*; // The Document Object Model (DOM) is an API that allows Java programs to read and write XML files
import javax.xml.parsers.DocumentBuilder; // The DocumentBuilder class is used to obtain a Document object from an XML document.
import javax.xml.parsers.DocumentBuilderFactory; // The DocumentBuilderFactory class provides a factory for creating DocumentBuilder objects.
import javax.xml.transform.OutputKeys; // The OutputKeys class provides constants that can be used to set output properties for a Transformer object.
import javax.xml.transform.Transformer; // The Transformer class is used to transform a source tree into a result tree.
import javax.xml.transform.TransformerFactory; // The TransformerFactory class provides a factory for creating Transformer objects.
import javax.xml.transform.dom.DOMSource; // The DOMSource class is used as input to a transformer.
import javax.xml.transform.stream.StreamResult; // The StreamResult class is used as output from a transformer.
import java.io.File;
//import java.util.ArrayDeque;
import java.util.ArrayList;
//import java.util.Deque;

public class WriteXML{/**
     * Saves a gesture to an xml file.
     * gesture arraylist of gesture points
     * gestureName The name of the gesture
     * fileName The filename for the gesture. (e.g. arrow.xml)
     */
    public void saveGesture(ArrayList<Point> gesture, String gestureName, String fileName, int num){
        // folder path for the xml file
        String directoryPath = "xml/".concat(gestureName);
        // file path for the xml file
        String filePath = directoryPath.concat("/").concat(fileName);

        // Creates the directory if it doesn't already exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            // Find the res folder and append the filename to the path.
            // Path path = Paths.get(getClass().getClassLoader().getResource("").toURI());
            // String filePath =  path.getParent().resolve(fileName).toString();
            // filePath = filePath.replace("%20", " ");
            // System.out.println(filePath);

            File xmlfile = new File(filePath);
            // Creates a new Document object
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setIgnoringComments(true); // Ignore comment nodes.
            documentBuilderFactory.setIgnoringElementContentWhitespace(true); // Ignore whitespace-only text nodes.
            documentBuilderFactory.setValidating(false); // Turn off validation.
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            //Text lineBreak = document.createTextNode("\n");
            //Element element = document.createElement("newline");
            
            // Create a new Element object for the Gesture tag and add attributes.
            Element gestureTag = document.createElement("Gesture");
            //document.appendChild(lineBreak);
            gestureTag.setAttribute("Name", fileName);
            gestureTag.setAttribute("Number", Integer.toString(num));
            gestureTag.setAttribute("NumPts", Integer.toString(gesture.size()));
            gestureTag.setAttribute("Milliseconds", Integer.toString((int)(gesture.get(gesture.size()-1).getTime()-gesture.get(0).getTime())));
            //Text lineBreak = document.createTextNode("\n");
           // Element element1 = document.getDocumentElement();
            //document.appendChild(lineBreak);
            //System.out.println(gesture.get(0).getX());
            //System.out.println(gesture.get(0).getY());
            
            // Loop through each point in the gesture ArrayList and add Point tags to the Gesture tag.
            for(Point point : gesture){
                Element pointTag = document.createElement("Point");
                //System.out.println(point.getX());
                //System.out.println(point.getY());
                //gestureTag.appendChild(lineBreak);
                pointTag.setAttribute("T", Long.toString(Math.round(point.getTime() / Math.pow(10, Math.floor(Math.log10(point.getTime())) - 3))));
                pointTag.setAttribute("X", Double.toString(point.getX()));
                pointTag.setAttribute("Y", Double.toString(point.getY()));
                // Add the pointTag to the gestureTag element.
                gestureTag.appendChild(pointTag);
                //pointTag.appendChild(lineBreak);
                //gestureTag.appendChild(lineBreak);
                
            }
            // Add the Gesture tag to the Document object.
            document.appendChild(gestureTag);
            // Transform the Document object into an XML file and save it to the specified file path.
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domsource = new DOMSource(document);
            StreamResult Streamresult = new StreamResult(xmlfile);
            transformer.transform(domsource, Streamresult);
            //System.out.println("Saved file to "+filePath);
        }
        catch (Exception e){
            System.out.println("ERROR saving file:");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
  }
