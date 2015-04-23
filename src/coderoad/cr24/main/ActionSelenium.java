package coderoad.cr24.main;

import java.io.File;
import java.io.IOException;
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

import coderoad.cr24.model.Inspector;
import coderoad.cr24.model.JsonSelenium;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.Target;
import coderoad.cr24.model.image.Image;
import coderoad.cr24.selenium.ConvertJsonToJavaObject;
import coderoad.cr24.seleniumConnector.OverrideClass;

import static coderoad.cr24.utils.UtilsMethods.*;

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
	

	
	public List<Image> run() throws InterruptedException, IOException{
		
		/**
		 * Usando Selenium Grid
		 */
		/*
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setBrowserName("firefox");
		//cap.setVersion("3.6");
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		cap.setCapability("maxInstances", 3);
		
		cap.setBrowserName("chrome");
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		cap.setCapability("maxInstances", 3);
		*/
		
		
		
		int cont=0;
		
		ConvertJsonToJavaObject var=new ConvertJsonToJavaObject();
		writeFileJson(jsonString);
		JsonSelenium jsonSelenium=var.convertJsonToJavaObject(jsonString);			
		
		
		   FirefoxProfile profile = new FirefoxProfile(); 		
		   WebDriver driver= new FirefoxDriver(profile);
		   
		   // add listener
		   EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
			OverrideClass eventListener = new OverrideClass();
			eDriver.register(eventListener);
		   
		  // WebDriver driver=new RemoteWebDriver(new URL("http://10.100.0.137:4444/wd/hub"),cap);

		/*
		    File fileIE = new File("C:\\Users\\aquiroz\\Pictures\\IEDriverServer.exe");
		    System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());		   
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("nativeEvents", false);
			WebDriver driver = new InternetExplorerDriver(caps);
		*/
				   
		   //Thread.sleep(10000); 
		   
			eDriver.get(jsonSelenium.getBaseUrl());
		   		  
			File fileIni= createFile("screenshot"+String.valueOf(new Date().getTime()));
	        System.out.println("FILE PATH:"+fileIni.getAbsolutePath());
			File scrFileIni = ((TakesScreenshot)eDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFileIni, fileIni);
	        
		
		int nroCases=jsonSelenium.getCases().size();
		System.out.println("nroCases:"+nroCases);
		
		List<Image>listImage=new ArrayList<Image>();
		
		
		for(int i=0;i<nroCases;i++){
			List<Recorder>listRecorder=jsonSelenium.getCases().get(i).getListRecorder();
			List<Inspector>listInspector=jsonSelenium.getCases().get(i).getListInspector();
						
			System.out.println("CASE "+i+":Recorder:"+listRecorder.size()+" ,Inspector:"+listInspector.size());					
			
			try{
								
				//Primero evaluar reproducir la inspeccion.
				for(Inspector inspector:listInspector){
					String xpathInspector=inspector.getXpath();
					JavascriptExecutor js = (JavascriptExecutor) eDriver;
					WebElement elementInspector=eDriver.findElement(By.xpath(xpathInspector));
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);",elementInspector, "color: green; outline: 10px solid green;background-color:red;");
				}
				
				// Evaluar recorder
				for(Recorder recorder:listRecorder){
					Image image=new Image();
					
					System.out.println("************* ");
					String command=recorder.getCommand();			
					Target target=recorder.getTarget();
					
					image.setCommand(command);
					image.setValue(recorder.getValue());
					image.setTarget(target.getXpath_position());
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

						File scrFile = ((TakesScreenshot)eDriver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(scrFile, file);														
					}
									
					if(command.equalsIgnoreCase("click")){					
						System.out.println("click");
						System.out.println("xpath:"+xpath);
						File file= createFile("screenshot"+String.valueOf(new Date().getTime()));
				        System.out.println("FILE PATH:"+file.getAbsolutePath());	
				        image.setImageUrl(file.getAbsolutePath().replace("C:\\xampp\\htdocs\\cr24_images\\", "http://10.100.0.137:78/cr24_images/"));

						File scrFile = ((TakesScreenshot)eDriver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(scrFile, file);	
						
				        WebElement elem=eDriver.findElement(By.xpath(xpath));
				        Thread.sleep(5000);
				        elem.click();

						File fileUlt= createFile("screenshot"+String.valueOf(new Date().getTime()));
				        System.out.println("FILE PATH:"+file.getAbsolutePath());	
				        image.setImageUrl(fileUlt.getAbsolutePath().replace("C:\\xampp\\htdocs\\cr24_images\\", "http://10.100.0.137:78/cr24_images/"));				        				        	
					}
					
					if(command.equalsIgnoreCase("select")){

						
					}
					
					
					listImage.add(image);
				} //endfor	
				
			}catch(Exception ex){
				ex.printStackTrace();									
			}							
		} // end for				 
		
		System.out.println("listImage.size "+listImage.size());
		eDriver.close();
		return listImage;
	}		   
	
}
