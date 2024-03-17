package com.amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver webDriver;

	public LoginPage(WebDriver webDriver) {

		this.webDriver = webDriver;
	}

	By signInLink = By.xpath("(//span[@class='nav-action-inner' and contains(text(),'Sign in')])[2]");
	By emailOrPhone = By.id("ap_email");
	By continueBtn = By.id("continue");
	By password = By.id("ap_password");
	By signInBtn = By.id("signInSubmit");
	By optBox = By.id("input-box-otp");
	By submitOptBox = By.id("cvf-submit-otp-button");
	
	public WebElement getSignInLink() {

		return webDriver.findElement(signInLink);
	}

	public WebElement getEmailOrPhoneTextBox() {

		return webDriver.findElement(emailOrPhone);
	}

	public WebElement getCotinueBtn() {

		return webDriver.findElement(continueBtn);
	}

	public WebElement getPasswordTextBox() {

		return webDriver.findElement(password);
	}

	public WebElement getOtpTextBox() {

		return webDriver.findElement(optBox);
	}

	public WebElement getSignInBtn() {

		return webDriver.findElement(signInBtn);
	}

	public WebElement getOtpSubmitBtn() {

		return webDriver.findElement(submitOptBox);
	}

}
