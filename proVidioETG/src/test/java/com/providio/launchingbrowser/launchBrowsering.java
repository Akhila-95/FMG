package com.providio.launchingbrowser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class launchBrowsering extends baseClass{
	
	public void chromeBrowser() throws InterruptedException {
		
		//launching the browser and passing the url into it
		 driver.get(baseURL);
		 logger.info("Entered into url");
		 logger.info("Placing the order as guest user");
		 
		 //consenet tracking
	       List<WebElement> consentTrackingList = driver.findElements(By.xpath("//div[@id='consent-tracking']"));
	       if(consentTrackingList.size()>0) {
	    	   WebElement yesButton = driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
	    	   yesButton.click();
	    	   Thread.sleep(1000);
	       }
	}

}
