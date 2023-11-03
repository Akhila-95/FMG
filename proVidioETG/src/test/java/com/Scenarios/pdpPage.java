package com.Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.navigationProcess;
import com.PageObjects.productListingPage;
import com.commonfunctionality.allAttributesinOneFile;
import com.testcases.baseClass;

public class pdpPage extends baseClass{

	public static void addtoCartPDP() throws InterruptedException {

		List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
	       if (pdpPagecheck.size() > 0) {
	    	   logger.info("next time me");
	    	   List<WebElement> pdpPageaddToCart = driver.findElements(By.xpath("//a[contains(@class, 'add-to-cart')]"));
	    	   int displayedAddToCartCount = 0;
	   	    for (WebElement item : pdpPageaddToCart) {
	   	        if (item.isDisplayed()) {
	   	        	displayedAddToCartCount++;
	   	        }
	   	    }
	    	   logger.info(displayedAddToCartCount);
	    	   if(displayedAddToCartCount>0) {
	    		   allAttributesinOneFile.selectTheAttributesInPdp(driver);
	    	   }else {
	    		   logger.info("notify me");
	    		   // Initialize navigationProcess to perform navigation tasks
		           navigationProcess navProcess = new navigationProcess(driver);
		           // Select a random menu item
		           navProcess.selectRandomMenu(driver);
		           productListingPage.selectRandomProduct();
		   		   //adding produuct to cart
		           allAttributesinOneFile.selectTheAttributesInPdp(driver);
	    	   }
//	   		   List<WebElement> pdpPagecheckNotfy = driver.findElements(By.xpath("//button[contains(@class,'notify-product-button')]"));
//	   	       if (pdpPagecheckNotfy.size() > 0) {
//	      	   
//	   	       }
	       }else {
	    	// Initialize navigationProcess to perform navigation tasks
	           navigationProcess navProcess = new navigationProcess(driver);
	           // Select a random menu item
	           navProcess.selectRandomMenu(driver);
	           productListingPage.selectRandomProduct();
	   		   //adding produuct to cart
	           allAttributesinOneFile.selectTheAttributesInPdp(driver);
	       }
	}
}
