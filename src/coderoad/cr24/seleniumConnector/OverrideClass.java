package coderoad.cr24.seleniumConnector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class OverrideClass implements WebDriverEventListener{

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE HACER CLICK 8"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK 8");
		System.out.println("LISTENER DESPUES DE HACER CLICK 8");
		System.out.println("LISTENER DESPUES DE HACER CLICK 8");
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE HACER CLICK 7"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK 7");
		System.out.println("LISTENER DESPUES DE HACER CLICK 7");
		System.out.println("LISTENER DESPUES DE HACER CLICK 7");
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE HACER CLICK 6"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK 6");
		System.out.println("LISTENER DESPUES DE HACER CLICK 6");
		System.out.println("LISTENER DESPUES DE HACER CLICK 6");
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE HACER CLICK 5"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK 5");
		System.out.println("LISTENER DESPUES DE HACER CLICK 5");
		System.out.println("LISTENER DESPUES DE HACER CLICK 5");
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE HACER CLICK 4"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK 4");
		System.out.println("LISTENER DESPUES DE HACER CLICK 4");
		System.out.println("LISTENER DESPUES DE HACER CLICK 4");
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE HACER CLICK 3"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK 3");
		System.out.println("LISTENER DESPUES DE HACER CLICK 3");
		System.out.println("LISTENER DESPUES DE HACER CLICK 3");
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE HACER CLICK 2"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK 2");
		System.out.println("LISTENER DESPUES DE HACER CLICK 2");
		System.out.println("LISTENER DESPUES DE HACER CLICK 2");
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
		System.out.println("LISTENER DESPUES DE HACER CLICK 1"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK 1");
		System.out.println("LISTENER DESPUES DE HACER CLICK 1");
		System.out.println("LISTENER DESPUES DE HACER CLICK 1");
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE HACER CLICK"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK");
		System.out.println("LISTENER DESPUES DE HACER CLICK");
		System.out.println("LISTENER DESPUES DE HACER CLICK");
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE HACER CLICK 0"); 
		System.out.println("LISTENER DESPUES DE HACER CLICK 0");
		System.out.println("LISTENER DESPUES DE HACER CLICK 0");
		System.out.println("LISTENER DESPUES DE HACER CLICK 0");		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
