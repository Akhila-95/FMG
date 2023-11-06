package com.paymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.miniCartPage;
import com.PageObjects.viewCartPage;
import com.Validations.miniCartAndCartValidation;
import com.commonfunctionality.FullAddressDetails;
import com.commonfunctionality.CommonProccessFromMiniCartForViewCartAndCheckout;
import com.testcases.baseClass;

public class MinicartViewCartProcess extends baseClass {
	
	
	
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
	  }
    } 
   
	  

