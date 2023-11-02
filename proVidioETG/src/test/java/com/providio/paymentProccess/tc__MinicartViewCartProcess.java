package com.providio.paymentProccess;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.providio.Validations.CartPageValidation;
import com.providio.Validations.QuantityValidation;
import com.providio.Validations.miniCartAndCartValidation;
import com.providio.commonfunctionality.AddressDetails;
import com.providio.commonfunctionality.CommonProccessFromMiniCartForViewCartAndCheckout;
import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.guestUserLoginPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.testcases.baseClass;
import com.providio.testcases.tc__TaxCalculationCheckoutPage;

public class tc__MinicartViewCartProcess extends baseClass {
	
	
	
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
			            AddressDetails address = new AddressDetails();
						address.address();
			            }
		            }
		        }
	       }
	     } 
	  }
    } 
   
	  

