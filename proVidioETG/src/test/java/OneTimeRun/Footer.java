package OneTimeRun;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.commonfunctionality.addtoCartValidation;
import com.github.javafaker.Faker;
import com.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class Footer extends baseClass{

	@Test
	public void footer() throws InterruptedException {
		
		//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
			
		//submit the subscription		
			//Faker faker = new Faker();
	        String fakeEmail ="akhila.m";
	        String email = fakeEmail+ "@etg.digital";
	        
	      
	        WebElement subscriptionField = driver.findElement(By.id("dwfrm_mcsubscribe_email"));
	        subscriptionField.sendKeys(email );
	        test.info("Entered email in subscription");
	        
	        WebElement clickSubscription = driver.findElement(By.xpath("//button[contains(@class,'subscribe-email')]"));
	        JavascriptExecutor js = (JavascriptExecutor) driver; 
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickSubscription);
	    	js.executeScript("arguments[0].click();",clickSubscription);
	        test.info("Submitted the email in subscription");
	        
	       // Thread.sleep(6000);
	        addtoCartValidation.validatingSubscription(driver);
	}
	
	
	
}
