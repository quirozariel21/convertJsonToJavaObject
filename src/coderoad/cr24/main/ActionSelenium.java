package coderoad.cr24.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import java.io.FileNotFoundException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coderoad.cr24.model.JsonSelenium;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.Target;
import coderoad.cr24.model.image.Image;
import coderoad.cr24.selenium.ConvertJsonToJavaObject;

public class ActionSelenium {

	private ConvertJsonToJavaObject convertJsonToJavaObject;
	private String jsonString;
	
	public ActionSelenium(String jsonString){
		this.jsonString=jsonString;
		init();
	}
	
	private void init(){
		convertJsonToJavaObject=new ConvertJsonToJavaObject(jsonString);
	}
	
	private void writeFileJson(String jsonString){
		try {
			 
			File fileDir = new File("C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json");
			//FileWriter file = new FileWriter("C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json");
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileDir), "UTF8"));
			
			out.append(jsonString);
			out.flush();
			out.close();
			/*
			file.write(jsonString);
			file.flush();
			file.close();*/
	 
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
		   
		   /*
		   File fileIE = new File("C:\\Users\\aquiroz\\Pictures\\IEDriverServer.exe");
		    System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());		   
		   WebDriver driver = new InternetExplorerDriver();
		   Thread.sleep(10000); 
		    */
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
				Image image=new Image();
				
				System.out.println("************* ");
				String command=recorder.getCommand();			
				Target target=recorder.getTarget();
				
				image.setCommand(command);
				image.setValue(recorder.getValue());
				image.setTarget(target.getName());
				image.setBaseUrl(recorder.getBaseUrl());
				
				
				//String xpath=target.getXpath_attributes();						
				String xpath=target.getXpath_position();
				if(command.equalsIgnoreCase("type")){
					
					File file= createFile("screenshot"+String.valueOf(new Date().getTime()));
			        System.out.println("FILE PATH:"+file.getAbsolutePath());
					image.setImageUrl(file.getAbsolutePath());
					
					String value=recorder.getValue();
					WebElement element=driver.findElement(By.xpath(xpath));
					element.sendKeys(value);							

					//Thread.sleep(400);
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, file);
					
					try{
						
					}catch(Exception ex){
						ex.printStackTrace();
					}	
					
				}
				
				if(command.equalsIgnoreCase("select")){

					try{
						
					}catch(Exception ex){
						ex.printStackTrace();
					}	
				}
				
				if(command.equalsIgnoreCase("click")){
					try{
						System.out.println("click");
						File file= createFile("screenshot"+String.valueOf(new Date().getTime()));
				        System.out.println("FILE PATH:"+file.getAbsolutePath());	
				        image.setImageUrl(file.getAbsolutePath().replace("C:\\xampp\\htdocs\\cr24_images\\", "http://10.100.0.137:78/cr24_images/"));
				        
				        WebElement elem=driver.findElement(By.xpath(xpath));
				        elem.click();

						File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(scrFile, file);						
					}catch(Exception ex){
						ex.printStackTrace();
					}

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
