package com.commonfunctionality;

import java.util.Random;

import com.PageObjects.ProductListingPage;

import com.testcases.baseClass;

public class RandomAttributesSelectionInPlpPage extends baseClass {

	  public static void allAttributes()throws InterruptedException {
		  Random random = new Random();
		  int randomNumber = random.nextInt(4) + 1;
			ProductListingPage plp = new ProductListingPage(driver);
	    	test.info("Verifying the filters");
	        switch (6) {
	            case 1:
	             //next page link
	      		     ProductListingPage.clickOnNextPage();
	      		  
	                break;
	            case 2:
	             //Jump to page
	      		     ProductListingPage.jumpToNextPage();
	                break;
	             case 3:
	            //clicking on breadcrumbs
	         		 ProductListingPage.ClickOnbreadCrumbs();
	                 break;                    
	             case 4:
	            //filters 
	       		     SelectingFilterFromPlp.selectFilterFromPLP();			
	                 break;	        
	             
	            case 5:
	 	            //filters - SORT BY	            
	            	ProductListingPage.selectTheSortBy(driver);			
	 	                 break;	
	            case 6:
	 	            //filters 
	            	
	            	plp.selectTheGridView();			
	 	                 break;	
	            case 7:
	 	            //filters 
	            	
	            	ProductListingPage.selecttheWishlist();			
	 	                 break;	
	             default:
	                 System.out.println("Invalid random number.");
	         }
	 }
}
