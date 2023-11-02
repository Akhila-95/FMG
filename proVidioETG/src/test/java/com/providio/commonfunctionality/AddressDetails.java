package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.checkOutPage;
import com.providio.testcases.baseClass;

public class AddressDetails extends baseClass {

	public void address() throws InterruptedException {
		
		
		
		   //CommonProccessFromMiniCartForViewCartAndCheckout 
        CommonProccessFromMiniCartForViewCartAndCheckout  commonProccess= new CommonProccessFromMiniCartForViewCartAndCheckout ();
        
		  //verifying the availability of shipping or pick store size
        
        List<WebElement> shippingAddressList = driver.findElements(By.xpath("(//h2[contains(text(),'Shipping Address')])[1]"));
        
      
        
        if(shippingAddressList.size()>0)  {
        	
        	 WebElement shippingAddressLabel = driver.findElement(By.xpath("(//h2[contains(text(),'Shipping Address')])[1]"));
            	
            	if(shippingAddressLabel.isDisplayed()) {
	            		
		            	checkOutPage cp = new checkOutPage(driver);
		            	
		            	//selecting shipping address
		            	commonProccess.selectShippingAddress(cp);
	
			            commonProccess.clickOnContinueBilling(cp);
		            
            	}	   
  
    	}else {
        	//if Only Gc added to cart then this snippet executes 
    		 List<WebElement> billingAddress= driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));		            	
        	 checkOutPage cp = new checkOutPage(driver);
        	 
            	 if(billingAddress.size()>0) {
            		WebElement billingAddressDisplay= driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));
            		if(billingAddressDisplay.isDisplayed()) {
	            		 //test.info("As only Gift cart is in cart ");
	            		 commonProccess.selectBillingAddress(cp);
	            		 	
	            		 commonProccess.clickOnContinueBilling(cp);
            		}
        	 }		          
    } 
	}
}
