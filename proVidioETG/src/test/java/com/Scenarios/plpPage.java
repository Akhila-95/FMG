package com.Scenarios;

import com.PageObjects.productListingPage;
import com.commonfunctionality.SelectingFilterFromPlp;
import com.testcases.baseClass;

public class plpPage extends baseClass{

	public static void addtocartplp() throws InterruptedException {
	
        
        // Initialize productListingPage to interact with product listing page
        productListingPage plp = new productListingPage(driver);
        
        //selecting the filters
        SelectingFilterFromPlp.selectingTheFilters();
        
        //sort the filters     
    	plp.selectTheSortBy(driver);
      
        //product add to the favorates
        plp.selecttheWishlist();
        
        // Add a product to the cart from PLP (Product Listing Page)
        plp.addToCartFromPlp();
	}
}
