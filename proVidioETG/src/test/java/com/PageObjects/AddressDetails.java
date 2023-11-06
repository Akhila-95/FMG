package com.PageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.testcases.baseClass;

public class AddressDetails extends baseClass{

	 public void addressDetails() throws InterruptedException{
		  
		  //to get the random address -by sending the 3 numbers to address element for shipping address
		  
		  WebElement streetaddress =driver.findElement(By.id("street"));
    	
    	  Random random = new Random();
    	  
        String randomNumber = "123 William Street" ; // Generates a random number between 100 and 999      random.nextInt(900) + 100
        address = String.valueOf(randomNumber);
        Thread.sleep(1000);
        streetaddress.sendKeys(address);
        
        //to perform the keyboard activities
        WebElement shipping = driver.switchTo().activeElement(); 
        
        Thread.sleep(1000);
        shipping.sendKeys(Keys.ARROW_DOWN);
        
       // Thread.sleep(1000);
        //shipping.sendKeys(Keys.ARROW_DOWN);
        //shipping.sendKeys(Keys.ENTER);
        
        System.out.println("The address entered is " +shipping.getText());
        logger.info("Entered address");
        test.info("Entered address");
	  
	  }
}
