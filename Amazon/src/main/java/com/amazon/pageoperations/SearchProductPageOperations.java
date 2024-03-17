package com.amazon.pageoperations;

import org.openqa.selenium.WebDriver;
import com.amazon.pageobjects.SearchProdcutPage;

public class SearchProductPageOperations {

	SearchProdcutPage searchProdcutPage;
	
	public SearchProductPageOperations(WebDriver webDriver) {
		
		searchProdcutPage=new SearchProdcutPage(webDriver);
		
	}
	
	public void enterProductNameAndSearch(String productName) {
		searchProdcutPage.getSearchBox().clear();
		searchProdcutPage.getSearchBox().sendKeys(productName);
		searchProdcutPage.getSearchButton().click();
	}
	
	public void selectBrandCheckBox(String brand) {
		searchProdcutPage.getBrandCheckBox().click();
	}
	public void selectProductByPrice(String price) {
		
		searchProdcutPage.clickOnProductByPrice(price);
		
	}
	
	public void selectProductByPriceRanage(String low,String high) {
		
		searchProdcutPage.clickOnProductByPriceRange(low,high);
		
	}
	
	
}
