package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testcases.baseClass;

public class reviewOrderPage extends baseClass{
	
WebDriver lDriver;
	
	public reviewOrderPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	
	@FindBy(xpath ="//button[contains(text(), 'Next: Review Order')]")
	WebElement reviewOrderPage;
	
	@FindBy(xpath ="//button[contains(text(), 'Next: Review Order')]")
	List<WebElement> reviewOrderPageList;
	
    public void clickonReviewOrder(WebDriver driver) throws InterruptedException {	 
    	JavascriptExecutor js = (JavascriptExecutor) driver; 
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewOrderPage);
    	js.executeScript("arguments[0].click();",reviewOrderPage);
    	Thread.sleep(2000);
    	if((reviewOrderPage.isDisplayed() && reviewOrderPageList.size()>0 )) {
    		
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewOrderPage);
    		
    		reviewOrderPage.click();
    	}
    	test.info("Clicked on review order button");
    }
  
    
    //In checkout page if the it will check the button of revieworder and place order buttons
	@FindBy(xpath ="(//button[contains(@class,' place-order')])[2]")
	WebElement placetheorderwithJsExuter;
	
	@FindBy(xpath ="(//button[contains(@class,' place-order')])[2]")
	List<WebElement> placetheorderList;
	
    public void clickonplaceorderwithJsExuter(WebDriver driver) throws InterruptedException {
    	Thread.sleep(3000);
    	JavascriptExecutor js = (JavascriptExecutor) driver; 
    	List<WebElement> creditcardscheck = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
    	if(placetheorderList.size()>0) {
	    	 Thread.sleep(2000);
	    	 if(creditcardscheck.size()>0 ) {  
	    			js.executeScript("window.scrollBy(0,100)", "");
	    		 //placetheorderwithJsExuter.click();
	    		 js.executeScript("arguments[0].click();", placetheorderwithJsExuter);
	    		 test.info("Clicked on place order button");
		    		Thread.sleep(4000);	    			    		
	    	 }else if(!(creditcardscheck.size()>0)) {  
	    			js.executeScript("window.scrollBy(0,100)", "");
	    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placetheorderwithJsExuter);
		    		 js.executeScript("arguments[0].click();", placetheorderwithJsExuter);
		    		 test.info("Clicked on place order button");
		    		Thread.sleep(4000);	    			    		
	    	 }
	    	 
    	}
    } 
	
}
