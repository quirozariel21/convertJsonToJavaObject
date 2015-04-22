package coderoad.cr24.seleniumConnector.strategyOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coderoad.cr24.model.Inspector;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.Target;
import coderoad.cr24.model.image.Image;

public class Click implements Actions{

	public static final String DIR_CR24_IMAGES = "/cr24_images/";
	
	@Override
	public Image action(WebDriver driver,Recorder recorder,List<Inspector> listInspector) {

		Image image=new Image();
		try {
			System.out.println("** STRATEGY CLICK ** ");
				
			String command=recorder.getCommand();			
			Target target=recorder.getTarget();	
			image.setCommand(command);
			image.setValue(recorder.getValue());
			image.setTarget(target.getXpath_attributes());
			image.setBaseUrl(recorder.getBaseUrl());							
			String xpath=target.getXpath_attributes();
			System.out.println("target.getXpath_position() "+target.getXpath_position());
			System.out.println("target.getXpath_attributes() "+target.getXpath_attributes());
					
			File file= createFile("screenshot"+String.valueOf(new Date().getTime()));
	        System.out.println("FILE PATH:"+file.getAbsolutePath());
	        image.setImageUrl(file.getAbsolutePath().replace("C:\\xampp\\htdocs\\cr24_images\\", "http://10.100.0.137:78/cr24_images/"));
	
	        
	        
	        
	        
			String value=recorder.getValue();
			WebElement element=driver.findElement(By.xpath(xpath));
			System.out.println(element.getTagName()+" "+element.getText());
			//js.executeScript("arguments[0].style.border='10px dotted green'", element);
			
			element.click();							
	
			
			
			
			
			
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(scrFile, file);			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
		return image;
	}

	@Override	
    public File createFile(String fileName){
        
        try {
            String currentDir= getTmpDir();
            File tmpDir = new File("C:\\xampp\\htdocs"+ DIR_CR24_IMAGES  );
            if(!tmpDir.exists()) {
                tmpDir.mkdir();
            }
            System.out.println("tmpDir "+tmpDir);
            return new File(tmpDir+"/"+fileName +".jpg");
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
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
