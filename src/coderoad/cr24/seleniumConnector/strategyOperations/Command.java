package coderoad.cr24.seleniumConnector.strategyOperations;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;

import coderoad.cr24.model.Inspector;
import coderoad.cr24.model.Recorder;
import coderoad.cr24.model.image.Image;

public enum Command implements Actions{
		
	TYPE(new Type()),
	CLICK(new Click());

	private final Actions delegate;
	
	
	private Command(Actions delegate){
		this.delegate=delegate;		
	}
	
	
	@Override
	public Image action(WebDriver driver, Recorder recorder,List<Inspector> listInspector) {
		return this.delegate.action(driver, recorder,listInspector);
		
	}

	@Override
	public File createFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
}
