package com.commonfunctionality;

import java.util.Random;

import com.PageObjects.productListingPage;

public class RandomAttributesSelectionInPlpPage {

	  public static void allAttibutes()throws InterruptedException {
		  Random random = new Random();
		  int randomNumber = random.nextInt(4) + 1;

	    	
	        switch (randomNumber) {
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
	             
	             default:
	                 System.out.println("Invalid random number.");
	         }
	 }
}
