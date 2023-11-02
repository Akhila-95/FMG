package com.providio.paymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.Validations.Checkout_Validation;
import com.providio.Validations.miniCartAndCartValidation;
import com.providio.commonfunctionality.CommonProccessFromMiniCartForViewCartAndCheckout;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.testcases.baseClass;

public class tc__CheckOutProcessByPayPal extends baseClass{
		
	 Checkout_Validation checkout= new Checkout_Validation();
	 

	 
	 //checkout from viewcart paypal button
	    
	 		public void checkoutprocessFromViewCart() throws InterruptedException {
	 			List <WebElement> minicartcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
	 		     
	 	     
	 	       
	 	       // minicart and check out validation
	 			miniCartAndCartValidation validation= new miniCartAndCartValidation();
	 		       if(minicartcount.size()>0) {
	 		    	   WebElement miniCartDisplay = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
	 		    	   if(miniCartDisplay.isDisplayed()) {
	 			    	   WebElement minicartcount1 = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
	 			    	   String countOfMinicart = minicartcount1.getText();
	 			    	   int minicartCountValue = Integer.parseInt(countOfMinicart);
	 			
	 			        if (minicartCountValue > 0) {		
	 			            miniCartPage mc = new miniCartPage(driver);		            
	 			            
	 			            mc.hoverOnCartButton(driver);
	 			       
	 			            
	 			            List <WebElement> minicartPopUp = driver.findElements(By.xpath("(//h1)[1]"));
	 			            if(minicartPopUp.size()>0) {
	 			            	
	 				            //validate the button click 			          
	 				            validation.validateMiniCartClick();
	 		         
	 				          
	 				            //clicks on view cart button 
	 				            mc.clickviewCartButton(driver);
	 							logger.info("clicked the view cart button in the minicart");
	 							
	 							//validate the view cart button click
	 							validation.validateViewCartClick();
	 		
	 			            }					            
					            viewCartPage vcp = new viewCartPage(driver);
			            
					            Thread.sleep(2000);
				            List<WebElement> brainPayPalButton = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
				          			            
					            if(brainPayPalButton.size()>0) {
					            	test.info("Braintree payment integration is activated");
					            	 vcp.braintreePayPalButton(driver);
					            }
						        	paymentpPage pp =new paymentpPage(driver);
						        	Thread.sleep(2000);
						        	
						        	//paypal pop up
									pp.paypalPopup(driver);
										
									
									//place order 
									reviewOrderPage rop = new reviewOrderPage(driver);
						    		Thread.sleep(4000);					    	
						    		rop.clickonplaceorderwithJsExuter(driver);
						    		
						    		Thread.sleep(5000);
															
									 Checkout_Validation checkout= new Checkout_Validation();
									 //validate the final place the order page
									 checkout.validatePlacetheOrderPage();							
									 //ordernumberandOrderdate
									 checkout.ordernumberandOrderdate();
									 Thread.sleep(3000);
									
	 			        }
	 		    	 }
	 			   }
		    	  	           
	 		}
	        
	    public void checkoutprocessFromCheckout() throws InterruptedException {

	    	List<WebElement> paymnetPage= driver.findElements(By.xpath("//h2[contains(text(),'Payment Method')]"));
	    	
		    	  if(paymnetPage.size()>0) {					

			    	 	List<WebElement> brainPaypalAcc = driver.findElements(By.xpath("//li[@data-method-id='PayPal']"));			    
				    	
				    	JavascriptExecutor js = (JavascriptExecutor) driver;	    		  
			    		//js.executeScript("window.scrollBy(0,300)", "");
		
			    	 if(brainPaypalAcc.size()>0) {	
			    		 
				    		test.info("Brain tree payment integration is activated");		    	
				    		paymentpPage pp =new paymentpPage(driver);	   
				    		
				    		pp.braintreePaypal(driver);
				    	

			    		if (driver.findElement(By.xpath("//button[contains(@class,'submit-payment')]")).isDisplayed()) {
			    			
				    			reviewOrderPage rop = new reviewOrderPage(driver);
				    			//Thread.sleep(2000);
				    			
				    	    //review order page 
					    		rop.clickonReviewOrder(driver);				    			    		
					    		Thread.sleep(4000);
					    		
					    	//place order 
					    		 rop.clickonplaceorderwithJsExuter(driver);
	
						}else  {
							pp.brainTreeAfterClick(driver);
										
					    	pp.paypalPopup(driver);
					    	
					    	
					    	reviewOrderPage rop = new reviewOrderPage(driver);
		
					    	//place order
				    		Thread.sleep(3000);
				    		 rop.clickonplaceorderwithJsExuter(driver);
				    		
    		
						}
			    	}
   	  
		    		Thread.sleep(10000);
		    	
		    			 Checkout_Validation checkout= new Checkout_Validation();
		    		 //validate the final place the order page
		    			 checkout.validatePlacetheOrderPage();
		    		
		    	     //ordernumberandOrderdate
		    			 checkout.ordernumberandOrderdate();
		    			 Thread.sleep(5000);
		    	  }	
	    }
	    
	    public void paypalCheckoutFromPDP() throws InterruptedException {
 
	    	
	 			    Thread.sleep(4000);
	 				paymentpPage pp =new paymentpPage(driver);
	 				pp.paypalPopup(driver);
	 				
	 				reviewOrderPage rop = new reviewOrderPage(driver);
					Thread.sleep(2000);
					

		    		 rop.clickonplaceorderwithJsExuter(driver);
		    		 logger.info("successfully click on the place order button by normal click");
		    		
		    		
					if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
						
						 Checkout_Validation checkout= new Checkout_Validation();
					 //validate the final place the order page
						 checkout.validatePlacetheOrderPage();
					
				     //ordernumberandOrderdate
						 checkout.ordernumberandOrderdate();
						} 
	 		  
	    }
	    
	    public void paypalFromLoginPage() throws InterruptedException {
	    	
		    	List<WebElement> paypalList= driver.findElements(By.xpath("(//div[contains(@class,'paypal-buttons-layout-horizontal')])[1]"));
		    	if(paypalList.size()>0) {	
		    		test.info("Paypal in login page");
		    		WebElement paypal= driver.findElement(By.xpath("(//div[contains(@class,'paypal-buttons-layout-horizontal')])[1]"));
		    		paypal.click();
		    		Thread.sleep(4000);
	 				paymentpPage pp =new paymentpPage(driver);
	 				pp.paypalPopup(driver);
	 				// checkOutPage cp = new checkOutPage(driver);
			          //selecting shipping address
			            
		            //tc__MinicartViewCartProcess cop = new tc__MinicartViewCartProcess();
		            //cop.selectShippingAddress(cp);
		           // cop.selectPaymentMethod(cp);
		            
	 				 reviewOrderPage rop = new reviewOrderPage(driver);
		    		 rop.clickonplaceorderwithJsExuter(driver);
		    		 logger.info("successfully click on the place order button by normal click");
		    		 
		    		 
					if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
						
						 Checkout_Validation checkout= new Checkout_Validation();
					 //validate the final place the order page
						 checkout.validatePlacetheOrderPage();
					
				     //ordernumberandOrderdate
						 checkout.ordernumberandOrderdate();
						}
		    	}else {
		    		test.info("No paypal button in login page in brain tree it is only for salesforce");
		    		
		    	}
	 			  
	    }

		
}
