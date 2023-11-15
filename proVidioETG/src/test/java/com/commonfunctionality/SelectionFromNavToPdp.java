package com.commonfunctionality;

import org.testng.annotations.Test;

import com.PageObjects.productListingPage;
import com.Scenarios.MenuSelection;
import com.testcases.baseClass;

public class SelectionFromNavToPdp extends baseClass {

	@Test
	public static void selectingFromPdp() throws InterruptedException {
	
		//random menu selection
		// MenuSelection.menues();
		driver.get("https://utsf.firemountain.org/1241wr/1241WR.html");
		
		  //random attribute selection from plp
		//  RandomAttributesSelectionInPlpPage.allAttributes();
		  
		// selecting random product from plp
		 // productListingPage.selectRandomProduct();
		  
		//adding produuct to cart
		  allAttributesinOneFile.selectTheAttributesInPdp(driver);
		  
		  driver.get("https://utsf.firemountain.org/1999wr/1999WR.html");
		  allAttributesinOneFile.selectTheAttributesInPdp(driver);
		  
	}
}
