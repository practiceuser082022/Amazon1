package com.amazon.pageoperations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.pageobjects.*;
import com.amazon.utils.Utilities;

public class ProductPageOperations {

	public ProductPage productPage;
	public Utilities utilities;

	public ProductPageOperations(WebDriver webDriver) {
		productPage = new ProductPage(webDriver);
		utilities = new Utilities(webDriver);
	}

	public void addProductToCart() {
		utilities.clickUsingJS(productPage.getAddCartButton());
	}

	public void addProductToCart2() {
		utilities.clickUsingJS(productPage.getAddCartButton2());
	}

	public void viewCart() {
		utilities.clickUsingJS(productPage.getViewCart());
	}

	public void clickACart() {
		utilities.clickUsingJS(productPage.getACartButton());
	}

	public int itemsCountInCart() {

		return productPage.getCartItem().size();
	}

	public void switchToFrame() {

		productPage.switchToFrame();
	}

	public List<String> getAddedProducts(String prodcutType) {

		List<String> productNames = new ArrayList<String>();
		List<WebElement> list = null;

		if (prodcutType.equalsIgnoreCase("Sony Bravia")) {
			list = productPage.getBraviaProductText();
		} else if (prodcutType.equalsIgnoreCase("Sony HT")) {
			list = productPage.getHomeTheaterProductText();
		}
		for (WebElement e : list) {

			productNames.add(e.getAttribute("innerHTML"));

		}
		return productNames;
	}
}
