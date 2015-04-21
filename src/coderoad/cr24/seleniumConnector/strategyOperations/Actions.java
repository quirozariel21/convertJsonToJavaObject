package coderoad.cr24.seleniumConnector.strategyOperations;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;

import coderoad.cr24.model.Inspector;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.image.Image;

public interface Actions {
	
	/**
	 * This method set up the object Image
	 * @param recorder
	 * @return Image
	 */
	Image action(WebDriver driver,Recorder recorder,List<Inspector> listInspector);
	
	/**
	 * This function create a file. 
	 * @param fileName
	 * @return File
	 */
	File createFile(String fileName);

}
