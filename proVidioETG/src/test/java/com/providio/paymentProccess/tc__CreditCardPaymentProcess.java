// Import necessary packages and classes
package com.providio.paymentProccess;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.Validations.Checkout_Validation;
import com.providio.Validations.preValidationCheck;
import com.providio.commonfunctionality.AddressDetails;
import com.providio.commonfunctionality.paymentMethods;
import com.providio.creditCardPaymentMethods.allPaymentMethods;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.testcases.baseClass;

// Define a test class named "tc__CreditCardPaymentProcess"
public class tc__CreditCardPaymentProcess extends baseClass{
	
	// Define a method named "paymentByCreditCard"
	public void paymentByCreditCard() throws InterruptedException {
		
		List<WebElement> paymnetPage= driver.findElements(By.xpath("//h2[contains(text(),'Payment Method')]"));	
	
		if(paymnetPage.size()>0 ) {
			
			WebElement paymentPageDisplay = driver.findElement(By.xpath("//h2[contains(text(),'Payment Method')]"));	
			
				if(paymentPageDisplay.isDisplayed()) {
					
								
					// Detect payment methods
					// Brain Tree
					List<WebElement> brainTree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
				   
				    // Create an instance of the "allPaymentMethods" class
				    allPaymentMethods bpm = new allPaymentMethods();
				  
				    
				    // Determine the payment method and proceed accordingly
				    if(brainTree.size()>0) {
				    	
				    	bpm.BrainTreeMethod();
				    	
				    	//adding new card to account				    	
				    		//bpm.addNewCardThoughExistingCards();
				    	
				    } 
				    
				    // address details
			            AddressDetails address = new AddressDetails();
						address.address();
					
			    	// Review order page
			    		reviewOrderPage rop = new reviewOrderPage(driver);			    				    		
			    		rop.clickonReviewOrder(driver);			   	    		
			    		Thread.sleep(4000);		    		
	
				 //placeorder   		
			    		 rop.clickonplaceorderwithJsExuter(driver);			    		  
			    		 Thread.sleep(9000);
			    		 
					//order page validation		    	
	    			 Checkout_Validation checkout= new Checkout_Validation();
		    			 
		    		 // Validate the final place the order page
		    			 checkout.validatePlacetheOrderPage();
		    		
		    	     // Order number and order date
		    			 checkout.ordernumberandOrderdate();
		    			 Thread.sleep(2000);
				}
		  }else {
			  test.fail("Next payment button is not enabled and clicked ");
		  }
	}
 }//method
//class
	
