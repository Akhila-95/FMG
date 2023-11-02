package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class reviewOrderPage extends baseClass{
	
WebDriver lDriver;
	
	public reviewOrderPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	
	@FindBy(xpath ="//button[contains(text(), 'Next: Review Order')]")
	WebElement reviewOrderPage;
    public void clickonReviewOrder(WebDriver driver) throws InterruptedException {	 
   
    	JavascriptExecutor js = (JavascriptExecutor) driver;     
    	// Brain Tree
	    		Thread.sleep(3000);
		    	if(reviewOrderPage.isDisplayed()) {
		    		 js.executeScript("window.scrollBy(0,100)", "");
		    		 js.executeScript("arguments[0].click();",reviewOrderPage);
		    		 Thread.sleep(1000);
		    		 //reviewOrderPage.click();
		    		 test.info("Clicked on review order button");
		    		 logger.info("Clicked on review order button");	
		    	}	 
    }
  
    
    //In checkout page if the it will check the button of revieworder and place order buttons
	@FindBy(xpath ="(//button[contains(@class,' place-order')])[1]")
	WebElement placetheorderwithJsExuter;
	
	@FindBy(xpath ="(//button[contains(@class,' place-order')])[1]")
	List<WebElement> placetheorderList;
	
    public void clickonplaceorderwithJsExuter(WebDriver driver) throws InterruptedException {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;    	
    	if(placetheorderList.size()>0) {
	    	 		 Thread.sleep(2000);	    	 
	    			 js.executeScript("window.scrollBy(0,100)", "");
		    		// placetheorderwithJsExuter.click();
		    		 js.executeScript("arguments[0].click();", placetheorderwithJsExuter);
		    		 test.info("Clicked on place order button");
		    		 logger.info("successfully click on the place order button by normal click");
		    		 Thread.sleep(4000);	    			    		
	    	    	 
    	}
    } 
	
}
