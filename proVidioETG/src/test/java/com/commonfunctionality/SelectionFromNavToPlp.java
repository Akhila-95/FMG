package com.commonfunctionality;

import com.PageObjects.productListingPage;
import com.Scenarios.MenuSelection;
import com.Scenarios.plpPage;

public class SelectionFromNavToPlp {

	public static void selectionFromNavToPlp() throws InterruptedException {
		
		//random menu selection
		  MenuSelection.menues();
		  
		//clicking on breadcrumbs
	//	productListingPage.ClickOnbreadCrumbs();
		
		//filters 
		//  SelectingFilterFromPlp.selectingTheFilters();			 	  
		  
		 //selecting random prodcut to add to cart
		  plpPage.addtocartplp();
		  
		  
	}
}
