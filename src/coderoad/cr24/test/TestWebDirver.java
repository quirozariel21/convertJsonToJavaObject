package coderoad.cr24.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestWebDirver {

	public static void main(String[] args) {
		String baseUrl = "http://www.facebook.com/";
        WebDriver driver = new FirefoxDriver();
        
        driver.get(baseUrl);
        WebElement txtUsername=driver.findElement(By.id("email"));
        
        Actions builder=new Actions(driver);
        
        Action seriesOfActions=builder
        		.moveToElement(txtUsername)
        		.click()
        		.keyDown(txtUsername,Keys.SHIFT)
        		.sendKeys(txtUsername,"Hello")
        		.keyUp(txtUsername,Keys.SHIFT)
        		.doubleClick(txtUsername)
        		.build();
 
        seriesOfActions.perform();
  
    }
}
