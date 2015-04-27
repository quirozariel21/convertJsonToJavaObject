package coderoad.cr24.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.tierconnect.tcprojects.services.filesystem.services.TCFileSystemService;

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
	private String baseURL;
	
	private EventFiringWebDriver eDriver=null;
	List<Image>listImage=new ArrayList<Image>();
	
	
	
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
		
		
		
									
		  // WebDriver driver=new RemoteWebDriver(new URL("http://10.100.0.137:4444/wd/hub"),cap);

		
		    File fileIE = new File("C:\\Users\\quirozariel21\\Pictures\\IEDriverServer.exe");
		    System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());		   
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("nativeEvents", false);
			WebDriver driver = new InternetExplorerDriver(caps);
		
			
			   //FirefoxProfile profile = new FirefoxProfile(); 		
			   //WebDriver driver= new FirefoxDriver(profile);		   		   		   
			   // add listener
			   eDriver=new EventFiringWebDriver(driver);
				OverrideClass eventListener = new OverrideClass();
				eDriver.register(eventListener);
			
				   
		   //Thread.sleep(10000); 
		   
			baseURL=jsonSelenium.getBaseUrl();
			eDriver.get(baseURL);
	

			
			eDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			File fileIni= createFile("screenshot"+String.valueOf(new Date().getTime()));
			File scrFileIni = ((TakesScreenshot)eDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFileIni, fileIni);
			
			System.out.println("FILE PATH:"+fileIni.getAbsolutePath());
			Image image=new Image();
			image.setBaseUrl(baseURL);		
			image.setImageUrl(fileIni.getAbsolutePath().replace(PATH_APACHE+DIR_CR24_IMAGES, IP_APACHE+"/cr24_images/"));	
	        listImage.add(image);
	        
	        /*
	    	TCFileSystemService fileService=TCFileSystemService.getInstance();
	    	fileService.createFile(fileIni.getAbsolutePath(), "Comentario");
	        */
	        	        		
		int nroCases=jsonSelenium.getCases().size();
		System.out.println("nroCases:"+nroCases);
							
		for(int i=0;i<nroCases;i++){
			List<Recorder>listRecorder=jsonSelenium.getCases().get(i).getListRecorder();
			List<Inspector>listInspector=jsonSelenium.getCases().get(i).getListInspector();
					
			int nroRecorder=listRecorder.size();
			int nroInspector=listInspector.size();
			System.out.println("************************************");
			System.out.println("NRO. "+i+":Recorder:"+nroRecorder+" ,Inspector:"+nroInspector);					
			
			try{								
				baseURL=eDriver.getCurrentUrl();	
				System.out.println("baseURL:"+baseURL);

				if(nroInspector>0 && nroRecorder==0){
					System.out.println("CASE A");
					inspector(listInspector);					
				}else{
					if(nroInspector==0 && nroRecorder>0){
						System.out.println("CASE B");
						recorder(listRecorder);		
					}else{
						String baseUrlRecorder=getBaseUrlRecorder(listRecorder);
						String baseUrlInspector=getBaseUrlInspector(listInspector);
						System.out.println("baseUrlRecorder:"+baseUrlRecorder);
						System.out.println("baseUrlInspector:"+baseUrlInspector);
						if(nroInspector>0 && nroRecorder>0){
							if(baseUrlRecorder.equals(baseURL) && !baseUrlInspector.equals(baseURL)){
								System.out.println("CASE C");
								recorder(listRecorder);
								inspector(listInspector);
							}else{
								if(!baseUrlRecorder.equals(baseURL) && baseUrlInspector.equals(baseURL)){
									System.out.println("CASE D");
									inspector(listInspector);
									recorder(listRecorder);
								}else{
									if(baseUrlRecorder.equals(baseURL) && baseUrlInspector.equals(baseURL)){
										System.out.println("CASE E");
										recorder(listRecorder);
										inspector(listInspector);
									}									
								}								
							}
						}else{
						System.out.println("Case not found");		
						}						
					}					
				}				
			}catch(NoSuchElementException e){
			//	e.printStackTrace();
				System.out.println("Exception Elemento no encontrado:"+e.getMessage());
				//eDriver.quit();
				eDriver.close();
				break;
			}catch (NoSuchWindowException e) {
				// TODO: handle exception
				System.out.println("Exeption al cerrar la ventana:"+e.getMessage());
				break;
			}catch (Exception ex) {
				System.out.println("Exeption no identificada:"+ex.getMessage());
				// TODO: handle exception
				//eDriver.quit();
				eDriver.close();
				break;
			}							
		} // end for				 
		
		System.out.println("listImage.size "+listImage.size());
		eDriver.close();
		return listImage;
	}
	
	
	
	public void recorder(List<Recorder>listRecorder) throws IOException, InterruptedException{
		
		for(Recorder recorder:listRecorder){
			
			Image image=new Image();
		
			String command=recorder.getCommand();			
			Target target=recorder.getTarget();
			
			image.setCommand(command);
			image.setValue(recorder.getValue());
			image.setTarget(target.getXpath_position());
			image.setBaseUrl(recorder.getBaseUrl());
							
			String xpath=target.getXpath_attributes()==null?target.getXpath_position():target.getXpath_attributes();				

			if(command.equalsIgnoreCase("type")){
				
				File file= createFile("screenshot"+String.valueOf(new Date().getTime()));
				image.setImageUrl(file.getAbsolutePath().replace(PATH_APACHE+DIR_CR24_IMAGES, IP_APACHE+"/cr24_images/"));
				
				String value=recorder.getValue();
				WebElement element=eDriver.findElement(By.xpath(xpath));
				element.sendKeys(value);							

				File scrFile = ((TakesScreenshot)eDriver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, file);														
			}
							
			if(command.equalsIgnoreCase("click")){					
				File file= createFile("screenshot"+String.valueOf(new Date().getTime()));		       

				File scrFile = ((TakesScreenshot)eDriver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, file);					
				image.setImageUrl(file.getAbsolutePath().replace(PATH_APACHE+DIR_CR24_IMAGES, IP_APACHE+"/cr24_images/"));
				
		        WebElement elem=eDriver.findElement(By.xpath(xpath));
		        elem.click();				        				        	
			}
			
			if(command.equalsIgnoreCase("select")){

				
			}
			
			
			listImage.add(image);
		} //endfor				
		
	}
	
	
  public void inspector(List<Inspector>listInspector) throws IOException{
	  
	  // inspection element by element
		for(Inspector inspector:listInspector){
			Image image=new Image();
			String xpathInspector=inspector.getXpath();						
			JavascriptExecutor js = (JavascriptExecutor) eDriver;
			WebElement elementInspector=eDriver.findElement(By.xpath(xpathInspector));
			if(inspector.getType().equalsIgnoreCase("watch")){
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",elementInspector, "outline: 5px solid green;");	
			}else
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",elementInspector, "outline: 5px solid red;");
			
														
			image.setBaseUrl(baseURL);
			image.setTarget(xpathInspector);
			File file= takeScreenshot();	
	        image.setImageUrl(file.getAbsolutePath().replace(PATH_APACHE+DIR_CR24_IMAGES, IP_APACHE+"/cr24_images/"));
	
	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",elementInspector, "outline: none;");				
			baseURL=inspector.getBaseUrl();
			listImage.add(image);
		} // end for
		
		// inspection all elements
		Image image=new Image();
		for(Inspector inspector:listInspector){				
			String xpathInspector=inspector.getXpath();						
			JavascriptExecutor js = (JavascriptExecutor) eDriver;
			WebElement elementInspector=eDriver.findElement(By.xpath(xpathInspector));
			if(inspector.getType().equalsIgnoreCase("watch")){
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",elementInspector, "outline: 5px solid green;");	
			}else
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",elementInspector, "outline: 5px solid red;");													
			image.setBaseUrl(baseURL);
		} // end for
		File file= takeScreenshot();	
        image.setImageUrl(file.getAbsolutePath().replace(PATH_APACHE+DIR_CR24_IMAGES, IP_APACHE+"/cr24_images/"));
		listImage.add(image);				
  }	// end function inspector
	
  
  private File takeScreenshot() throws IOException{
		File file= createFile("screenshot"+String.valueOf(new Date().getTime()));
      //  System.out.println("FILE PATH:"+file.getAbsolutePath());	
        
		File scrFile = ((TakesScreenshot)eDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, file);
		
		return file;
  }
	
	private String getBaseUrlRecorder(List<Recorder>listRecorder){
		return listRecorder.get(0).getBaseUrl();
	}
	
	private String getBaseUrlInspector(List<Inspector>listInspector){
		return listInspector.get(0).getBaseUrl();
	}
	
}
