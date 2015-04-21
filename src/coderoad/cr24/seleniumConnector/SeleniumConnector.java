package coderoad.cr24.seleniumConnector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import coderoad.cr24.model.JsonSelenium;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.image.Image;
import coderoad.cr24.selenium.ConvertJsonToJavaObject;
import coderoad.cr24.seleniumConnector.strategyOperations.Command;

public class SeleniumConnector {

	private ConvertJsonToJavaObject convertJsonToJavaObject;
	private String jsonString;
	
	private static final String pathFileJson="C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json";
	
	public SeleniumConnector(String jsonString){
		this.jsonString=jsonString;
		init();
	}
	
	private void init(){
		convertJsonToJavaObject=new ConvertJsonToJavaObject(jsonString);
	}

	private void writeFileJson(String jsonString){
		try {
			 
			File fileDir = new File(pathFileJson);
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileDir), "UTF8"));			
			out.append(jsonString);
			out.flush();
			out.close();	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public List<Image> run() throws InterruptedException, IOException{
				
		int cont=0;
		
		ConvertJsonToJavaObject var=new ConvertJsonToJavaObject();
		writeFileJson(jsonString);
		JsonSelenium jsonSelenium=var.convertJsonToJavaObject(jsonString);			
		
		
		   FirefoxProfile profile = new FirefoxProfile(); 		
		   WebDriver driver= new FirefoxDriver(profile);
		   		 
		   driver.get(jsonSelenium.getBaseUrl());
		  
		   
			File fileIni= createFile("screenshot"+String.valueOf(new Date().getTime()));
	        System.out.println("FILE PATH:"+fileIni.getAbsolutePath());
			File scrFileIni = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFileIni, fileIni);
	        
		
		int nroCases=jsonSelenium.getCases().size();
		System.out.println("nroCases:"+nroCases);
		List<Image>listImage=new ArrayList<Image>();
		
		
		for(int i=0;i<nroCases;i++){
			List<Recorder>listRecorder=jsonSelenium.getCases().get(i).getListRecorder();			  			
			System.out.println("size"+listRecorder.size());											
			for(Recorder recorder:listRecorder){
				Image image=null;				
				String command=recorder.getCommand();							
				if(command.equalsIgnoreCase("type")){					
					image=Command.TYPE.action(driver, recorder,jsonSelenium.getCases().get(i).getListInspector());					
				}
				
				if(command.equalsIgnoreCase("select")){
					try{
						
					}catch(Exception ex){
						ex.printStackTrace();
					}	
				}
				
				if(command.equalsIgnoreCase("click")){
					image=Command.CLICK.action(driver, recorder,jsonSelenium.getCases().get(i).getListInspector());

				}			
				
				listImage.add(image);
			} //endfor						
		} // end for				 
		
		System.out.println("listImage.size "+listImage.size());
		driver.close();
		return listImage;
	}
	
	
	public static final String DIR_CR24_IMAGES = "/cr24_images/";
    public File createFile(String fileName){
        
        try {
            String currentDir= getTmpDir();
            //File tmpDir = new File(currentDir+ DIR_CR24_IMAGES  );
            File tmpDir = new File("C:\\xampp\\htdocs"+ DIR_CR24_IMAGES  );
            //C:\xampp\htdocs\img_cr24
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
