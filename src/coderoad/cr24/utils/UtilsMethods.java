package coderoad.cr24.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class UtilsMethods {

	public static final String PATH_JSON="C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json";
	public static final String DIR_CR24_IMAGES = "/cr24_images/";
	public static final String PATH_APACHE="C:\\xampp\\htdocs";
	
	
	public  static void writeFileJson(String jsonString){
		try {
			 
			File fileDir = new File(PATH_JSON);
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileDir), "UTF8"));
			
			out.append(jsonString);
			out.flush();
			out.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
    public static File createFile(String fileName){
        
        try {
            String currentDir= getTmpDir();
            File tmpDir = new File(PATH_APACHE+ DIR_CR24_IMAGES  );
            if(!tmpDir.exists()) {
                tmpDir.mkdir();
            }
            System.out.println("tmpDir "+tmpDir);
            return new File(tmpDir+"/"+fileName +".jpg");
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
            //throw new CustomSearchException("File Not Found or can not create file", e);
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
    public static String getTmpDir() throws IOException {
        File temp = File.createTempFile("i-am-tmp-file-delete-me", ".tmp" );
        String absolutePath = temp.getAbsolutePath();
        String currentDir = absolutePath.
                substring(0,absolutePath.lastIndexOf(File.separator));

        File tmpDir = new File(currentDir+DIR_CR24_IMAGES );
        if(!tmpDir.exists()) {
            tmpDir.mkdir();
        }

        return currentDir;
    }	
	
}
