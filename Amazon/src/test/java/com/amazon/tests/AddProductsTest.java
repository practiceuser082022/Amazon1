package com.amazon.tests;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.pageoperations.CommonPageOperations;
import com.amazon.pageoperations.CreateAccountPageOperations;
import com.amazon.pageoperations.LogOutPageOperations;
import com.amazon.pageoperations.LoginPageOperations;
import com.amazon.pageoperations.ProductPageOperations;
import com.amazon.pageoperations.SearchProductPageOperations;
import com.amazon.verifications.Verifications;

public class AddProductsTest extends BaseTest {
  public WebDriver webDriver;
  LoginPageOperations loginPageOperations;
  CreateAccountPageOperations createAccountPageOperations;
  SearchProductPageOperations searchProductPageOperations;	
  CommonPageOperations commonPageOperations;
  ProductPageOperations productPageOperations;
  LogOutPageOperations logOutPageOperations;
  
  
	@BeforeTest
	public void setup() {

		webDriver=getDriver();		
		loginPageOperations=new LoginPageOperations(webDriver);
		createAccountPageOperations=new CreateAccountPageOperations(webDriver);
		searchProductPageOperations=new SearchProductPageOperations(webDriver);
		commonPageOperations=new CommonPageOperations(webDriver);
		productPageOperations=new ProductPageOperations(webDriver);
		logOutPageOperations=new LogOutPageOperations(webDriver);
		
	}

	@Test(enabled=false)
	public void createAccout() {
		Properties userProperties=getUserInfo();
		createAccountPageOperations.enterUserName(userProperties.getProperty("username"));
		createAccountPageOperations.enterPassword(userProperties.getProperty("password"));
		createAccountPageOperations.enterPhoneNumber(userProperties.getProperty("email"));
		createAccountPageOperations.clickOnCreateBtn();
		
	}
	@Test(priority=2)
	public void addProductsToCart() {
		
		Properties userProperties=getUserInfo();
	
		webDriver.get(getEnvUrl());
		
		loginPageOperations.clickOnSignInLink();
		loginPageOperations.enterEmailOrPhoneNumber(userProperties.getProperty("username"));
		loginPageOperations.clickOnContinue();
		loginPageOperations.enterPassword(userProperties.getProperty("password"));
		loginPageOperations.clickOnSignIn();		
		
		webDriver.navigate().to(getEnvUrl());
		searchProductPageOperations.enterProductNameAndSearch("sony");
		searchProductPageOperations.selectBrandCheckBox("Sony");
		
		searchProductPageOperations.enterProductNameAndSearch("Sony Bravia 55 inch tv");
		searchProductPageOperations.selectProductByPrice("50000");
		commonPageOperations.switchToChild();
		productPageOperations.addProductToCart2();
		productPageOperations.clickACart();	
		
		assertTrue(Verifications.verifyProductInList(productPageOperations.getAddedProducts("Sony Bravia"),"Sony Bravia"));
		commonPageOperations.switchToParent();
		
		webDriver.navigate().to(getEnvUrl());
		searchProductPageOperations.enterProductNameAndSearch("Sony Bravia 189 cm (75 inches)");
		searchProductPageOperations.selectProductByPriceRanage("100000","150000");
		commonPageOperations.switchToChild();
		productPageOperations.addProductToCart2();
		productPageOperations.clickACart();
		
		assertTrue(Verifications.verifyProductInList(productPageOperations.getAddedProducts("Sony Bravia"),"Sony Bravia"));
		commonPageOperations.switchToParent();
		
		webDriver.navigate().to(getEnvUrl());
		searchProductPageOperations.enterProductNameAndSearch("sony home theater");
		searchProductPageOperations.selectBrandCheckBox("Sony");
		
		//searchProductPageOperations.enterProductNameAndSearch("Sony HT");
		searchProductPageOperations.selectProductByPriceRanage("20000","50000");
		commonPageOperations.switchToChild();
		productPageOperations.addProductToCart();
		productPageOperations.clickACart();	
		
		assertTrue(Verifications.verifyProductInList(productPageOperations.getAddedProducts("Sony HT"),"Sony HT"));
		commonPageOperations.switchToParent();
		
		logOutPageOperations.clickOnSignOut();
		
	}
}

