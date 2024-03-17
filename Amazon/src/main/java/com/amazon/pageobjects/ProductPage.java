package com.amazon.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	WebDriver webdriver;

	public ProductPage(WebDriver driver) {

		this.webdriver = driver;
	}
	
	By navCartIcon=By.id("nav-cart-count");
	By addToCartBtn=By.xpath("//input[@type='submit' and @value='Add to Cart']");
	By addToCartBtn2=By.xpath("//input[@type='button' and @value='Add to Cart']");
	//By aCartBtn=By.id("attach-sidesheet-view-cart-button-announce");
	By aCartBtn=By.xpath("(//*[normalize-space(text()) = 'Cart']/preceding-sibling::*)[2]");
	By cartItemsCount=By.xpath("//*[@class='a-truncate-cut']");
	By frameId=By.id("attach-view-cart-button-form");
	By braviaProducts=By.xpath("//span[contains(@class,'a-offscreen') and contains(text(),'Sony Bravia')]");
	By homeTheaterProducts=By.xpath("//span[contains(@class,'a-offscreen') and contains(text(),'Sony HT')]");
	
	public WebElement getViewCart() {
		
		return webdriver.findElement(navCartIcon);
	}
	
	public WebElement getAddCartButton() {
		
		return webdriver.findElement(addToCartBtn2);
	}
	
	public WebElement getAddCartButton2() {
		
		return webdriver.findElement(addToCartBtn);
	}

	public WebElement getACartButton() {
		
		return webdriver.findElement(aCartBtn);
	}
	
	public List<WebElement> getCartItem() {
		
		return webdriver.findElements(cartItemsCount);
	}
	
	public List<WebElement> getBraviaProductText() {
		
		return webdriver.findElements(braviaProducts);
	}
	
	public List<WebElement> getHomeTheaterProductText() {
		
		return webdriver.findElements(homeTheaterProducts);
	}

	public void switchToFrame() {
			
		webdriver.switchTo().frame(webdriver.findElement(frameId));
	}
}
