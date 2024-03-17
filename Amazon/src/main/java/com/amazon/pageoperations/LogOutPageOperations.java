package com.amazon.pageoperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.amazon.pageobjects.LogOutPage;
import com.amazon.pageobjects.LoginPage;
import com.amazon.utils.Utilities;

public class LogOutPageOperations {

	WebDriver webDriver;
	LogOutPage logOutPage;
	Actions actions;
	Utilities utilities;
	
	public LogOutPageOperations(WebDriver webDriver) {

		this.webDriver = webDriver;
		logOutPage = new LogOutPage(webDriver);
		actions = new Actions(webDriver);
		utilities=new Utilities(webDriver);
		
	}

	public void clickOnAccountsAndListLink() {

		actions.moveToElement(logOutPage.getAccountsAndListLink()).click().perform();

	}

	public void clickOnSignOutLink() {
		actions.moveToElement(logOutPage.getSignOutLink()).click().perform();
	}
	
	public void clickOnSignOut() {
		actions.moveToElement(logOutPage.getAccountsAndListLink()).moveToElement(logOutPage.getSignOutLink()).click().perform();

	}

}
