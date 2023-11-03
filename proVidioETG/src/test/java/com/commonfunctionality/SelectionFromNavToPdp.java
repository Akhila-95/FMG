package com.commonfunctionality;

import org.testng.annotations.Test;

import com.PageObjects.productListingPage;
import com.Scenarios.MenuSelection;
import com.testcases.baseClass;

public class SelectionFromNavToPdp extends baseClass {

	@Test
	public static void selectingFromPdp() throws InterruptedException {
	
		//random menu selection
		  MenuSelection.menues();
		  
		// selecting random product from plp
		  productListingPage.selectRandomProduct();
		  
		//adding produuct to cart
		  allAttributesinOneFile.selectTheAttributesInPdp(driver);
		  
		  
	}
}
