package coderoad.cr24.seleniumConnector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class OverrideClass implements WebDriverEventListener{

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER afterChangeValueOf"); 
		System.out.println("LISTENER afterChangeValueOf");
		System.out.println("LISTENER afterChangeValueOf");		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER afterClickOn"); 
		System.out.println("LISTENER afterClickOn");
		System.out.println("LISTENER afterClickOn");		
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER afterFindBy"); 
		System.out.println("LISTENER afterFindBy");
		System.out.println("LISTENER afterFindBy");			
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER afterNavigateBack"); 
		System.out.println("LISTENER afterNavigateBack");
		System.out.println("LISTENER afterNavigateBack");
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER afterNavigateForward"); 
		System.out.println("LISTENER afterNavigateForward");
		System.out.println("LISTENER afterNavigateForward");		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER afterNavigateTo"); 
		System.out.println("LISTENER afterNavigateTo");
		System.out.println("LISTENER afterNavigateTo");		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER DESPUES DE afterScript"); 
		System.out.println("LISTENER DESPUES DE afterScript");
		System.out.println("LISTENER DESPUES DE afterScript");
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
		System.out.println("LISTENER ANTES De beforeChangeValueOf"); 
		System.out.println("LISTENER ANTES De beforeChangeValueOf");
		System.out.println("LISTENER ANTES De beforeChangeValueOf");
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER ANTES DE beforeClickOn"); 
		System.out.println("LISTENER ANTES DE beforeClickOn");
		System.out.println("LISTENER ANTES DE beforeClickOn");
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		System.out.println("LISTENER ANTES DE beforeFindBy"); 
		System.out.println("LISTENER ANTES DE beforeFindBy");
		System.out.println("LISTENER ANTES DE beforeFindBy");
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
		System.out.println("ANTES DE beforeFindBy");
		
	}

}
