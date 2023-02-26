//package comp128.gestureRecognizer;

//import edu.macalester.graphics.Point;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.ArrayDeque;
import java.util.ArrayList;
//import java.util.Deque;

public class WriteXML{/**
     * Saves a gesture to an xml file.
     * @param gesture Queue of gesture points
     * @param gestureName The name of the gesture
     * @param fileName The filename for the gesture. (e.g. arrow.xml)
     */
    public void saveGesture(ArrayList<Point> gesture, String gestureName, String fileName){
        String dirPath = "xml".concat().concat(gestureName);
        String filePath = dirPath.concat("/").concat(fileName);

        // Create the directory if it doesn't already exist
        File directory = new File(dirPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            // Find the res folder and append the filename to the path.
            // Path path = Paths.get(getClass().getClassLoader().getResource("").toURI());
            // String filePath =  path.getParent().resolve(fileName).toString();
            // filePath = filePath.replace("%20", " ");
            System.out.println(filePath);

            File file = new File(filePath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setIgnoringComments(true);
            documentBuilderFactory.setIgnoringElementContentWhitespace(true);
            documentBuilderFactory.setValidating(false);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Text lineBreak = document.createTextNode("\n");
            //Element element = document.createElement("newline");
            Element gestureTag = document.createElement("Gesture");
            //document.appendChild(lineBreak);
            gestureTag.setAttribute("Name", gestureName);
            gestureTag.setAttribute("NumPts", Integer.toString(gesture.size()));
            gestureTag.setAttribute("Milliseconds", Integer.toString((int)(gesture.get(gesture.size()-1).getTime()-gesture.get(0).getTime())/1000));
            document.appendChild(gestureTag);
            //Text lineBreak = document.createTextNode("\n");
           // Element element1 = document.getDocumentElement();
            //document.appendChild(lineBreak);
            //System.out.println(gesture.get(0).getX());
            //System.out.println(gesture.get(0).getY());
            for(Point point : gesture){
                Element pointTag = document.createElement("Point");
                //System.out.println(point.getX());
                //System.out.println(point.getY());
                //gestureTag.appendChild(lineBreak);
                pointTag.setAttribute("X", Double.toString(point.getX()));
                pointTag.setAttribute("Y", Double.toString(point.getY()));
                pointTag.setAttribute("T", Double.toString(point.getTime()));
                pointTag.appendChild(lineBreak);
                gestureTag.appendChild(pointTag);
                //pointTag.appendChild(lineBreak);
                gestureTag.appendChild(lineBreak);
                
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
            //System.out.println("Saved file to "+filePath);
        }
        catch (Exception e){
            System.out.println("ERROR saving gesture file:");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
  }
