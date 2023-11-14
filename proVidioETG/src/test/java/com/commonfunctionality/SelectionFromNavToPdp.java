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
		//driver.get("https://utsf.firemountain.org/jewelry/jewelry-and-gifts/gifts/?prefn1=color&prefv1=Browns%20%2F%20Tans");
		
		  //random attribute selection from plp
		  RandomAttributesSelectionInPlpPage.allAttibutes();
		  
		// selecting random product from plp
		  productListingPage.selectRandomProduct();
		  
		//adding produuct to cart
		  allAttributesinOneFile.selectTheAttributesInPdp(driver);
		  
		  
	}
}
