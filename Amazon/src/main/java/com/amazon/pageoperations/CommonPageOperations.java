package com.amazon.pageoperations;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPageOperations {

	WebDriver driver;
	String mainWindowHandle;
	public CommonPageOperations(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void switchToChild() {
		mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Size ***************************************************************** "+allWindowHandles.size());
		for (String handle : allWindowHandles) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        break; 
		    }
		  
		}
	}
	
	public void switchToParent() {
		driver.close();
		driver.switchTo().window(mainWindowHandle);
	}
	
	public void moveToElementAndClick() {
		
	}
	
	public void switchToFrame(String id) {
		
		driver.switchTo().frame(id);
	}
	
	
}
