package coderoad.cr24.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;













import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wordnik.swagger.annotations.Api;

import coderoad.cr24.model.JsonSelenium;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.Target;
import coderoad.cr24.selenium.ConvertJsonToJavaObject;


public class MainCR24 {

                                                                                          
	
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String filePath="C:\\Users\\aquiroz\\Pictures\\jsonCr24001.json";
		//convertJsonToJavaObject(filePath);		
		
		ConvertJsonToJavaObject var=new ConvertJsonToJavaObject();
		JsonSelenium jsonSelenium=var.convertJsonToJavaObject(filePath);

		
		HtmlUnitDriver unitDriver = new HtmlUnitDriver();
		
		   FirefoxProfile profile = new FirefoxProfile(); 
		   profile.setPreference("browser.download.dir", "C:\\Users\\aquiroz\\Documents"); 
		   profile.setPreference("browser.download.folderList", 2); 
		   profile.setPreference("browser.helperApps.alwaysAsk.force", false); 
		   profile.setPreference("browser.download.manager.showWhenStarting",false); 
		   profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");

		   WebDriver driver= new FirefoxDriver(profile);		
		   driver.get("https://www.bankofamerica.com/");
		   
		List<Recorder>listRecorder=jsonSelenium.getCases().get(0).getListRecorder();
		  
		
		for(Recorder recorder:listRecorder){
			System.out.println("************* ");
			String command=recorder.getCommand();			
			Target target=recorder.getTarget();
			String xpath=target.getXpath_attributes();						
			if(command.equalsIgnoreCase("type")){
				String value=recorder.getValue();
				WebElement element=driver.findElement(By.xpath(xpath));
				element.sendKeys(value);							
				// Now you can do whatever you need to do with it, for example copy somewhere
				Thread.sleep(4000);
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot0.jpg"));
				
			}
			
			if(command.equalsIgnoreCase("select")){
				
			}
			
			if(command.equalsIgnoreCase("click")){
				/*
				WebElement element=driver.findElement(By.xpath(xpath));
				element.click();
				
*/
				WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
				myDynamicElement.click();
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot1.jpg"));
			}
		}
	}
	
	
	

}
