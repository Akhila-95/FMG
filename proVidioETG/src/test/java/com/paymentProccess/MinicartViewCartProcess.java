package com.paymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.PageObjects.checkOutPage;
import com.PageObjects.miniCartPage;
import com.PageObjects.viewCartPage;
import com.Validations.miniCartAndCartValidation;
import com.commonfunctionality.FullAddressDetails;
import com.commonfunctionality.GuestCheckout;
import com.commonfunctionality.allAddress;
import com.commonfunctionality.CommonProccessFromMiniCartForViewCartAndCheckout;
import com.testcases.baseClass;

public class MinicartViewCartProcess extends baseClass {
	
	
	/*
    public void checkoutprocess() throws InterruptedException {

       List <WebElement> minicartcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
     
       //CommonProccessFromMiniCartForViewCartAndCheckout 
       CommonProccessFromMiniCartForViewCartAndCheckout  commonProccess= new CommonProccessFromMiniCartForViewCartAndCheckout ();
       
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
		            //Thread.sleep(5000);		               
		            //click on the cart button
		            mc.hoverOnCartButton(driver);
		            //Thread.sleep(1000);
		            
		            List <WebElement> minicartPopUp = driver.findElements(By.xpath("(//h1)[1]"));
		            if(minicartPopUp.size()>0) {
		            	
			            //validate the button click 			          
			            validation.validateMiniCartClick();
	         
			           // Thread.sleep(1000);
			            //clicks on view cart button 
			            mc.clickviewCartButton(driver);
						logger.info("clicked the view cart button in the minicart");
						
						//validate the view cart button click
						validation.validateViewCartClick();	
		            }
		
		            viewCartPage vcp = new viewCartPage(driver);
	        
		            vcp.clickCheckout(driver);
		            Thread.sleep(1000);
		
		            //Taxcalculation
		            
		           // tc__TaxCalculationCheckoutPage tc = new tc__TaxCalculationCheckoutPage();           
		           // tc.taxCalculation();
		            
		           //if any guest user means guest checkout
		            commonProccess.clickContinueAsGuest();
		            Thread.sleep(3000);
		            
		         // address details
		            List<WebElement> shippingAddressList = driver.findElements(By.xpath("(//h2[contains(text(),'Shipping Address')])[1]"));
		            if(shippingAddressList.size()>0) {
		            WebElement shippingAddress = driver.findElement(By.xpath("(//h2[contains(text(),'Shipping Address')])[1]"));
			            if(shippingAddress.isDisplayed()) {
				            FullAddressDetails address = new FullAddressDetails();
							address.address();
			            }
		            }
		        }
	       }
	     } 
	  }*/
	 public void checkoutprocess() throws InterruptedException {
	    	Thread.sleep(3000);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll up using JavaScript
	        // Negative 'y' value scrolls up
	    	js.executeScript("window.scrollTo(0, 0);");

	        // Check if the minicart is displayed
	        List<WebElement> minicartdisplayedcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
	        if (minicartdisplayedcount.size() > 0) {

	            // Get the number of products in the cart
	            WebElement productCountInCart = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
	            String countOfMinicart = productCountInCart.getText();
	            int minicartProductCountValue = Integer.parseInt(countOfMinicart);

	            // If products are in the minicart, proceed
	            if (minicartProductCountValue > 0) {

	                miniCartPage mc = new miniCartPage(driver);
	                Thread.sleep(5000);

	                // Click on the cart button in the minicart
	                mc.hoverOnCartButton(driver);
			        Thread.sleep(1000);
	                mc.clickviewCartButton(driver);
	            
	             // Initialize the view cart page
	                viewCartPage vcp = new viewCartPage(driver);
	                
	                if(minicartProductCountValue > 2) {
	                	vcp.saveForLater();
	                    
	                    vcp.removeBtn();
	                }
	                
	              
	                // Click the "Checkout" button in the view cart page
	                
	                Thread.sleep(5000);
	                vcp.clickCheckout(driver);
	                Thread.sleep(1000);
	                
	            
	                
	                GuestCheckout gc = new GuestCheckout();
	                gc.clickContinueAsGuest();
	                
	                //validate the negative shipping address
	                //negativeValidation.shippingDetails();
	                
	                // Handle the shipping address
	                
	                allAddress sd = new allAddress();
	                sd.ShippingAddress();

	                
	                checkOutPage cp = new checkOutPage(driver);
	                cp.clickContinueBillingbutton(driver);


	            } else {
	                logger.info("The cart value is empty");
	                test.fail("The cart value is empty");
	            }
	        }
	 }
    } 
   
	  

