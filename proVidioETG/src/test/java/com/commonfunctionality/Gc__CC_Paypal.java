package com.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.PageObjects.reviewOrderPage;
import com.Validations.Checkout_Validation;
import com.paymentProccess.CreditCardPaymentProcess;
import com.paymentProccess.tc__CheckOutProcessByPayPal;
import com.paymentProccess.tc__PaymentProccessByGC;
import com.paymentProccess.tc__PaymentProccessByGC_CC_Paypal;
import com.testcases.baseClass;

public class Gc__CC_Paypal extends baseClass{

	public void paymentProccessByGCandCC(WebDriver driver) throws InterruptedException {
		List<WebElement> paymentPage= driver.findElements(By.xpath("//h2[contains(text(),'Payment Method')]"));	
		
		if(paymentPage.size()>0 ) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0, 200);");        
		
		//click the radio button
			 WebElement clickRadioButton= driver.findElement(By.id("gift-promo"));
			 clickRadioButton.click();	
			 System.out.println("Clicked on radio button");
		
			// checking availability of brain tree 
			//List<WebElement> creditcardsBraintree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
			//System.out.println("Brain tree " + creditcardsBraintree.size());
			List<WebElement> gcRedeemText= driver.findElements(By.xpath("//div[@class='success giftcert-pi']")); 
		    //if brain tree available if condition executes
			 //if(creditcardsBraintree.size()>0) {				 
					 //checking whether the gift card input box available
					 List<WebElement> giftCertificateInput= driver.findElements(By.id("giftCert"));
					 if(giftCertificateInput.size()>0) {
						 //fetching paymentBysemiGc class by creating the instance
						 test.info("Gc input is displayed ");
						 tc__PaymentProccessByGC_CC_Paypal code= new  tc__PaymentProccessByGC_CC_Paypal();				
						 code.paymentBySemiGC();					
						 logger.info("applied gift card code ");						 
						
					 } else {
						 test.info("As gift card is in cart ,so gift certificate div is not displaying , so choosing credit card payment");
						 Thread.sleep(2000);
						 //fetching credit card class by creating   tc__CreditCardPaymentProcess instance
						 //Payment process		     
					     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
					     cc.paymentByCreditCard();				
					 }
				
					 //If Gc totally redeemed the cart value then no need of another payment like credit card directly pay with Gift certificate 
					Thread.sleep(1000);
					 List<WebElement> gcTotalRedemption= driver.findElements(By.xpath("//div[contains(text(),'Your order will be paid using gift certificate')]")); 
					 if(gcTotalRedemption.size()>0) {
						 					 
						 test.info("As total price is redeemed with Gc ,We are placing order with Gift certificate in the place the combination of Gc and CC payment");
						 
						 //Review order page
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
					 }else if((gcRedeemText.size()>0)) {		 					 
						 //test.info("Gc code redeemed placing order with combination of GC and Credit card");						
						//fetching credit card class by creating   tc__CreditCardPaymentProcess instance								     
					     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
					     cc.paymentByCreditCard();
					 }/*else{
						 test.info("No GC code is redemeed");
						 test.pass("No GC code is redemeed because of insufficient balnce or Gc beloAngs to different customer So Using credit card ");	
						
						 //Payment process		     
					     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
					     cc.paymentByCreditCard();
					 }*/
		}
	}
	
	
	public void paymentProccessByGCandPaypal() throws InterruptedException {		
		List<WebElement> paymentPage= driver.findElements(By.xpath("//h2[contains(text(),'Payment Method')]"));	
		
		if(paymentPage.size()>0 ) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0, 200);");        
		
		//click the radio button
			 WebElement clickRadioButton= driver.findElement(By.id("gift-promo"));
			 //clickRadioButton.click();
			 js.executeScript("arguments[0].click();", clickRadioButton);
			 System.out.println("Clicked on radio button");
		
			
			List<WebElement> gcRedeemText= driver.findElements(By.xpath("//div[@class='success giftcert-pi']")); 
		    
					 //checking whether the gift card input box available
					 List<WebElement> giftCertificateInput= driver.findElements(By.id("giftCert"));
					 if(giftCertificateInput.size()>0) {
						 //fetching paymentBysemiGc class by creating the instance
						 test.info("Gc input is displayed ");
						 tc__PaymentProccessByGC_CC_Paypal code= new  tc__PaymentProccessByGC_CC_Paypal();				
						 code.paymentBySemiGC();					
						 Thread.sleep(3000);	
						 
						
					 } else {
						 test.info("As gift card is in cart ,so gift certificate div is not displaying , so choosing Paypal");
						 Thread.sleep(2000);
						 //paypal process
						 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
						 cpp.checkoutprocessFromCheckout();					
					 }
				
					 //If Gc totally redeemed the cart value then no need of another payment like credit card directly pay with Gift certificate 
					Thread.sleep(1000);
					 List<WebElement> gcTotalRedemption= driver.findElements(By.xpath("//div[contains(text(),'Your order will be paid using gift certificate')]")); 
					 if(gcTotalRedemption.size()>0) {
						 					 
						 test.info("As total price is redeemed with Gc ,We are placing order with Gift certificate in the place the combination of Gc and CC payment");
						 
						 //Review order page
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
			    					    							
					 }/*else if(gcRedeemText.size()>0) {		 					 
						 test.info("No GC code is redemeed");
						 test.pass("No GC code is redemeed because of insufficient balnce or Gc beloAngs to different customer So Using paypal");				
						 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
						 cpp.checkoutprocessFromCheckout();
					 
					 }*/else  {
							
						 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
						 cpp.checkoutprocessFromCheckout();
					 }
		}
	  }

	
	public void paymentByGiftCard() throws InterruptedException {
		List<WebElement> billingPage = driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));		
		
		if(billingPage.size()>0 ) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			// checking availability of brain tree
			List<WebElement> creditcardsBraintree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));				
			System.out.println("Braintree is "+ creditcardsBraintree.size());
			//click the radio button
			 WebElement clickRadioButton= driver.findElement(By.id("gift-promo"));
			 //clickRadioButton.click();
			 js.executeScript("arguments[0].click();", clickRadioButton);
			 System.out.println("Clicked on radio button");
	
			 //checking whether the gift card input box available
			 List<WebElement> giftCertificateInput= driver.findElements(By.id("giftCert"));
			 if(giftCertificateInput.size()>0) { 	
				 		test.info("Gift certificate div is displaying in payment page");									 	
						tc__PaymentProccessByGC code= new tc__PaymentProccessByGC();
						code.performSequentialOperations(driver);						
						 logger.info("applied gift card code");
								 
		      }else {	
				test.info("As gift card is in cart ,so gift certificate div is not displaying , so choosing credit card payment ");
				//if Braintree or SalesForce or stripePayment or cyberSource available then if condition will execute and payment will done with credit card
				if(creditcardsBraintree.size()>0 ) {	
					 //Payment process		     
				     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
				     cc.paymentByCreditCard();			 
				}else {
					//if Braintree or SalesForce or stripePayment or cyberSource available then if condition will execute and payment will done with paypal 
					if(creditcardsBraintree.size()>0){		 	
						tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
						cpp.checkoutprocessFromCheckout();				
						}
				}
			}
	        
		}
	}
}
