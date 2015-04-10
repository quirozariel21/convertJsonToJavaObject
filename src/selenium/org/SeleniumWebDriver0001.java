package selenium.org;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


//import com.gargoylesoftware.htmlunit.WebConsole;

public class SeleniumWebDriver0001 {


	public static void main(String []args) throws InterruptedException, IOException{
		   		   		  
		   
		   FirefoxProfile profile = new FirefoxProfile(); 
		   profile.setPreference("browser.download.dir", "C:\\Users\\aquiroz\\Documents"); 
		   profile.setPreference("browser.download.folderList", 2); 
		   profile.setPreference("browser.helperApps.alwaysAsk.force", false); 
		   profile.setPreference("browser.download.manager.showWhenStarting",false); 
		   profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");

		   WebDriver driver= new FirefoxDriver(profile);
		   driver.get("https://www.bankofamerica.com/");
		   
		   WebElement element=driver.findElement(By.xpath("//div/input"));
		   element.sendKeys("HOLA MUNDO");
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   
		   driver.quit();
		   /*
		   try{
			   // Create file 
			   FileWriter fstream = new FileWriter("C:\\Users\\aquiroz\\Documents\\banco.html");
			   BufferedWriter out = new BufferedWriter(fstream);
			   out.write(driver.getPageSource());
			   //Close the output stream
			   out.close();
			   }catch (Exception e){//Catch exception if any
			   System.err.println("Error: " + e.getMessage());
			   }
		   
		   
		   String page=driver.getPageSource();
		   
		   File file=new File("C:\\Users\\aquiroz\\Documents\\bancoafomericaSelenium.html");
			FileWriter fw=new FileWriter(file);
			fw.write(page);
			fw.close();
		   */
			/*
	        driver.get("http://www.wikipedia.org");
	        WebElement link;
	        link=driver.findElement(By.linkText("English"));
	        link.click();
	        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        org.apache.commons.io.FileUtils.copyFile(srcFile, new File("C:\\Users\\aquiroz\\Pictures\\screenShot1.png"));
	        Thread.sleep(5000);
	        WebElement searchBox;
	        searchBox=driver.findElement(By.id("searchInput"));
	        searchBox.sendKeys("Software");
	        searchBox.submit();
	        File srcFile2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        org.apache.commons.io.FileUtils.copyFile(srcFile2, new File("C:\\Users\\aquiroz\\Pictures\\screenShot2.png"));
	        Thread.sleep(5000);
	        */
	        driver.quit();
	        
	}

}
