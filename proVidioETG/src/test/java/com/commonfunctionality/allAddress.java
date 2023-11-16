package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.PageObjects.checkOutPage;
import com.testcases.baseClass;

public class allAddress extends baseClass{
	
public void ShippingAddressAndShippingMethod() throws InterruptedException {
	
	List<WebElement> shippingAddressList = driver.findElements(By.xpath("(//h2[contains(text(),'Shipping Address')])[1]"));
    
    
    
    if(shippingAddressList.size()>0)  {
    	test.info("Validate the shipping Page");
        WebElement existingAddress = driver.findElement(By.xpath("//select[@name='shipmentSelector' and @id='shipmentSelector-default']"));
        List<WebElement> options1 = existingAddress.findElements(By.xpath("./option"));
        System.out.println(options1.size());

        if (options1.size() > 1) {
            logger.info("Address already exists");
        } else {
        	checkOutPage cp = new checkOutPage(driver);
            cp.setFisrtName(fname);
            logger.info("Entered fname");
            test.pass("Entered fname");
            cp.setLastname(lname);
            logger.info("Entered lname");
            test.pass("Entered lname");
            WebElement Address1 = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));
            //Random random = new Random();
            int randomNumber = 123; // Generates a random number between 100 and 999
            address = String.valueOf(randomNumber);
            Address1.sendKeys(address);
            WebElement Address11 = driver.switchTo().activeElement();
            //Actions actions = new Actions(driver);
            Thread.sleep(1000);
            Address11.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
//            Address11.sendKeys(Keys.ARROW_DOWN);
            Address11.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            test.pass("Enterd the Address form the auto Suggestions");
            cp.setPhone(phonenumber);
            logger.info("Entered phone number");
            test.pass("Entered phone number");
            Thread.sleep(10000L);
        }
    }else {
    	//if Only Gc added to cart then this snippet executes 
		 List<WebElement> billingAddress= driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));		            	
   	 checkOutPage cp = new checkOutPage(driver);
   	 
       	 if(billingAddress.size()>0) {
       	// Enters the billing address in checkout3 page ,enters billing user first name,last name and billingg addres with phone number
	    	 WebElement billingAddress1 = driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));
	    	 
	    	 if(billingAddress1.isDisplayed()) {    		  
	    		 WebElement billingName = driver.findElement(By.id("billingFirstName"));
	    		 if(billingName.isDisplayed()) {
	    			 
				    	Thread.sleep(1000);		    	
				        cp.setBillingFName();		
				        logger.info("Entered fname");
				        
				        Thread.sleep(1000);		
				        cp.setBillingLName();		
				        logger.info("Entered lname");	
				        
				        // enters billing address 
				      //to get the random address -by sending the 3 numbers to address element for billing address
					  	WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));		
					  
				        Random random = new Random();
				        
				        int randomNumber =567; // Generates a random number between 100 and 999		
				        //random.nextInt(900) + 100
				        address = String.valueOf(randomNumber);		
				        		
				        Address1.sendKeys(address);	
				        
				        //to perform the keyboard activities
				        WebElement Address11 = driver.switchTo().activeElement();
				        Thread.sleep(1000);
				        
				        Address11.sendKeys(Keys.ARROW_DOWN);		
				        Thread.sleep(1000);	
				        
				        Address11.sendKeys(Keys.ARROW_DOWN);		
				        Address11.sendKeys(Keys.ENTER);		
				        Thread.sleep(2000);		
				        
				        cp.setBillingPhoneNum();		
				        logger.info("Entered phone number");		        
				        Thread.sleep(2000);
	    		 }
	    	 }	  
       	 }
      }
    
    //shipping method
    		List<WebElement> shippingMethodList= driver.findElements(By.cssSelector("div.single-shipping-method"));	
    		int shippingMethodCount = shippingMethodList.size();
    		
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		js.executeScript("window.scrollBy(0,700)", "");
    		System.out.println(shippingMethodCount);
			// Create a random number generator.
		    Random random = new Random();
	        // Generate a random index to insert the qunatity
		    int randomShippingMtd = random.nextInt(shippingMethodCount) + 1;
		   
		 	WebElement shippingMtd = driver.findElement(By.xpath("(//input[contains(@class,'form-check-input')])[" + randomShippingMtd  + "]"));	
		 
		 	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingMtd);
			String textOfShippingMethod = shippingMtd.getText();
			Thread.sleep(3000);
		 	//shippingMtd.click();
		 
			//js.executeScript("arguments[0].click();",shippingMtd);
			js.executeScript("window.scrollBy(0,700)", "");
			js.executeScript("arguments[0].click();",shippingMtd);
			
			//shippingMtd.click();
			//shippingMtd.click();
		 	Thread.sleep(3000);
		 	
		 	logger.info("Selected shipping method is " + textOfShippingMethod);
    	
    }

}
