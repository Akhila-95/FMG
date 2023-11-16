
/*// Import necessary packages and classes
package com.providio.paymentProccess;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.PageObjects.paymentpPage;
import com.PageObjects.reviewOrderPage;
import com.commonfunctionality.AddressDetails;
import com.commonfunctionality.paymentMethods;
import com.providio.Validations.Checkout_Validation;
import com.providio.Validations.preValidationCheck;
import com.providio.creditCardPaymentMethods.allPaymentMethods;
import com.testcases.baseClass;

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
						//address.address();
					
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
	*/

// Import necessary packages and classes
package com.paymentProccess;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.CreditCardPaymentMethods.allPaymentMethods;
import com.PageObjects.paymentpPage;
import com.PageObjects.reviewOrderPage;
import com.Validations.Checkout_Validation;
import com.Validations.preValidationCheck;
import com.commonfunctionality.paymentMethods;
import com.testcases.baseClass;

// Define a test class named "tc__CreditCardPaymentProcess"
public class CreditCardPaymentProcess extends baseClass{
	
	// Define a method named "paymentByCreditCard"
	public void paymentByCreditCard() throws InterruptedException {
		
		List<WebElement> billingPage = driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));		
	
		if(billingPage.size()>0 ) {
			
			WebElement billingAddressDisplay = driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));	
			
				if(billingAddressDisplay.isDisplayed()) {
					
					// Validate the payment page
					preValidationCheck.validatePaymentButtonClk();
			       
					// Detect payment methods
					// Brain Tree
					List<WebElement> brainTree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
				   
				    // Create an instance of the "allPaymentMethods" class
					allPaymentMethods payments = new allPaymentMethods();
				    
				    JavascriptExecutor js = (JavascriptExecutor) driver;	    		  
		    		js.executeScript("window.scrollBy(0,800)", "");
				    
				    // Determine the payment method and proceed accordingly
				    if(brainTree.size()>0) {
				    	
				    	payments.brainTreeMethod();
				    	
				    } 
				    
				 // Review order page
	    		reviewOrderPage rop = new reviewOrderPage(driver);
	    		Thread.sleep(4000);			    		
	    		
	    		rop.clickonReviewOrder(driver);
	    		
	    		Thread.sleep(4000);		    		
/*
		    		
	    		 rop.clickonplaceorderwithJsExuter(driver);	    		
                 Thread.sleep(2000);
                 logger.info(driver.getTitle());
				    
				    Thread.sleep(7000);
					 // Checkout validation
		    		if(driver.getTitle().endsWith("Fire Mountain Gems and Beads")) {
		    			
		    			 Checkout_Validation checkout= new Checkout_Validation();
		    			 
		    		 // Validate the final place the order page
		    			 checkout.validatePlacetheOrderPage();
		    		
		    	     // Order number and order date
		    			 checkout.ordernumberandOrderdate();
		    			 Thread.sleep(5000);
		    		}*/
				}
		  }else {
			  test.fail("Next payment button is not enabled and clicked ");
		  }
	}
 }//method
//class
	

