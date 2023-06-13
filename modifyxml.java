import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class modifyxml {
    public static void main(String[] args) throws TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        String dirPath = "xml_logs";
        for(int i=1;i<=6;i++){
            String path= dirPath+"/s0"+i;
             // create a File object for the directory
            File dir = new File(path);

            // get a list of all the files in the directory
            File[] files = dir.listFiles();
            //System.out.println(files[0]);

            // loop through each file and rename it
            for (File file : files) {
                Document document = null;
                try {
                    // parse the xml to read contents
                    //System.out.println(file);
                    document = builder.parse(file);
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                document.getDocumentElement().normalize();

                 Element root = document.getDocumentElement();
                 String fileName = root.getAttribute("Name");

                // modify the file name as desired (e.g., add a prefix or suffix)
                String newFileName = fileName.toLowerCase();
                String ss=newFileName.replaceAll("square", "sq");
                //System.out.println(ss);
                if((ss.equals("right_sq_bracket10")||ss.equals("left_sq_bracket10") || ss.equals("arrow10")||ss.equals("caret10")|| ss.equals("check10")||ss.equals("circle10")||ss.equals("rectangle10")||
                ss.equals("star10")||ss.equals("left_curly_brace10")||ss.equals("right_curly_brace10")||ss.equals("x10")||ss.equals("v10")||ss.equals("delete10")||ss.equals("pigtail10")||ss.equals("zigzag10")||ss.equals("triangle10"))){
                    root.setAttribute("Name", ss);
                }
                else{
                    String sb= ss.substring(0, ss.length()-1);
                    String nf= sb.concat("0"+ss.substring(ss.length()-1,ss.length()));
                    System.out.println(nf);
                    root.setAttribute("Name", nf);
                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domsource = new DOMSource(document);
            StreamResult Streamresult = new StreamResult(file);
            transformer.transform(domsource, Streamresult);
            }
        }

            
    }
}
