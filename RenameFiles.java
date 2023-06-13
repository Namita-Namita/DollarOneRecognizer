import java.io.*;

public class RenameFiles {
   public static void main(String[] args) {
    
      // specify the directory path where the files are located
      String dirPath = "xml_logs";
        for(int i=1;i<=6;i++){
            String path= dirPath+"/s0"+i;
             // create a File object for the directory
            File dir = new File(path);

            // get a list of all the files in the directory
            File[] files = dir.listFiles();

            // loop through each file and rename it
            for (File file : files) {
                // get the current file name
                String fileName = file.getName();

                // modify the file name as desired (e.g., add a prefix or suffix)
                String newFileName = fileName.toLowerCase();
                String ss=newFileName.replaceAll("square", "sq");
                //System.out.println(ss);
                
                if(newFileName.equals("arrow10")||newFileName.equals("caret10")||newFileName.equals("check10")||newFileName.equals("circle10")||newFileName.equals("rectangle10")||newFileName.equals("triangle10")||newFileName.equals("x10")||newFileName.equals("v10")||newFileName.equals("left_curly_brace10")||newFileName.equals("right_curly_brace10")||newFileName.equals("pigtail10")||newFileName.equals("delete10")||newFileName.equals("zigzag10")||newFileName.equals("star10")){
                     // create a new File object with the new name
                     File newFile = new File(dir+"/" + newFileName+".xml");
                     file.renameTo(newFile);
                  }
                else if(newFileName.equals("right_square_bracket10")||newFileName.equals("left_square_bracket10")){   
                    // create a new File object with the new name
                    File newFile = new File(dir+"/" + ss+".xml");
                    file.renameTo(newFile);
                 }
                else{
                    String sb= ss.substring(ss.length()-1, ss.length());
                    String nf= ss.replace(sb, "0"+sb+".xml");
                    // System.out.println(nf);
                    
                    // create a new File object with the new name
                    File newFile = new File(dir+"/" + nf);
                    file.renameTo(newFile);
                }
            }
      }
    }
}
