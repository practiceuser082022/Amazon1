package com.amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {

	WebDriver webDriver;

	public LogOutPage(WebDriver webDriver) {

		this.webDriver = webDriver;
	}

	By accountsListsLink = By.xpath("//*[contains(text(),'Account & Lists')]");
	By signOutLink = By.xpath("//span[contains(text(),'Sign Out')]");

	public WebElement getAccountsAndListLink() {

		return webDriver.findElement(accountsListsLink);
	}
	
	public WebElement getSignOutLink() {

		return webDriver.findElement(signOutLink);
	}

	
}
