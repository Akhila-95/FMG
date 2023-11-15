package com.commonfunctionality;

import java.util.Random;

import com.PageObjects.productListingPage;
import com.testcases.baseClass;

public class RandomAttributesSelectionInPlpPage extends baseClass {

	  public static void allAttributes()throws InterruptedException {
		  Random random = new Random();
		  int randomNumber = random.nextInt(4) + 1;
			productListingPage plp = new productListingPage(driver);
	    	test.info("Verifying the filters");
	        switch (6) {
	            case 1:
	             //next page link
	      		     productListingPage.clickOnNextPage();
	      		  
	                break;
	            case 2:
	             //hump to page
	      		     productListingPage.jumpToNextPage();
	                break;
	             case 3:
	            //clicking on breadcrumbs
	         		 productListingPage.ClickOnbreadCrumbs();
	                 break;                    
	             case 4:
	            //filters 
	       		     SelectingFilterFromPlp.selectingTheFilters();			
	                 break;	        
	             
	            case 5:
	 	            //filters 
	            
	            	plp.selectTheSortBy(driver);			
	 	                 break;	
	            case 6:
	 	            //filters 
	            	
	            	plp.selectTheGridView();			
	 	                 break;	
	             default:
	                 System.out.println("Invalid random number.");
	         }
	 }
}
