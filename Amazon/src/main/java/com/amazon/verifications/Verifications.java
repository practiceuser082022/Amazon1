package com.amazon.verifications;

import java.util.List;

public class Verifications {

	public static boolean verifyProductInList(List<String> prodcuts,String productName) {
		
		boolean productAvailableInList=false;
		for(String product: prodcuts) {
			
			if(product.contains(productName))
				productAvailableInList=true;
			
		}
		
		return productAvailableInList;
	}
}
