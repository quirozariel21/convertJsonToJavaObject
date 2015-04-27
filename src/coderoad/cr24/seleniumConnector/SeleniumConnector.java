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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coderoad.cr24.model.JsonSelenium;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.image.Image;
import coderoad.cr24.selenium.ConvertJsonToJavaObject;
import coderoad.cr24.seleniumConnector.strategyOperations.Command;

import static coderoad.cr24.utils.UtilsMethods.*;

public class SeleniumConnector {

	private ConvertJsonToJavaObject convertJsonToJavaObject;
	private String jsonString;
	
	
	
	public SeleniumConnector(String jsonString){
		this.jsonString=jsonString;
		init();
	}
	
	private void init(){
		convertJsonToJavaObject=new ConvertJsonToJavaObject(jsonString);
	}

	private void writeFileJson(String jsonString){
		try {
			 
			File fileDir = new File(PATH_FILE_JSON);
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
		   EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
			OverrideClass eventListener = new OverrideClass();
			eDriver.register(eventListener);		
		   
		   
			eDriver.get(jsonSelenium.getBaseUrl());
		  
		   
			File fileIni= createFile("screenshot"+String.valueOf(new Date().getTime()));
	        //System.out.println("FILE PATH:"+fileIni.getAbsolutePath());
			File scrFileIni = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFileIni, fileIni);
	        
		
		int nroCases=jsonSelenium.getCases().size();
		System.out.println("nroCases:"+nroCases);
		List<Image>listImage=new ArrayList<Image>();
		
		WebDriverWait myWaitVar=new WebDriverWait(driver, 15);
		
		
		
		
		eDriver.get("http://outlook.com");
		eDriver.navigate().back();
		
		eventListener.afterChangeValueOf(null, null);
		
		for(int i=0;i<nroCases;i++){
			List<Recorder>listRecorder=jsonSelenium.getCases().get(i).getListRecorder();			  			
			System.out.println("size"+listRecorder.size());											
			for(Recorder recorder:listRecorder){
				Image image=null;				
				String command=recorder.getCommand();							
				if(command.equalsIgnoreCase("type")){					
					image=Command.TYPE.action(driver, recorder,jsonSelenium.getCases().get(i).getListInspector());
					
					
/*					
			        for(Inspector inspector:jsonSelenium.getCases().get(i).getListInspector()){
			        	JavascriptExecutor js = (JavascriptExecutor) driver;
						String xpathInspector=inspector.getXpath();
						//String xpathInspector="//html/body/div[4]/div[3]/div/div/div[3]/div/div[2]/div/div/div/a/img";
						System.out.println("xpathInspector:"+xpathInspector);				
						WebElement elementInspector=driver.findElement(By.xpath(xpathInspector));
						js.executeScript("arguments[0].setAttribute('style', arguments[1]);",elementInspector, "color: Red; outline: 10px solid red;");												

					}					
	*/				
				}
				
				if(command.equalsIgnoreCase("select")){
					try{
						
					}catch(Exception ex){
						ex.printStackTrace();
					}	
				}
				
				if(command.equalsIgnoreCase("click")){
					image=Command.CLICK.action(eDriver, recorder,jsonSelenium.getCases().get(i).getListInspector());

				}			
				
				listImage.add(image);
			} //endfor						
		} // end for				 
		
		System.out.println("listImage.size "+listImage.size());
		eDriver.close();
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
