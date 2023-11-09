package OneTimeRun;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.commonfunctionality.selectingFilterFromPlp;
import com.testcases.baseClass;

public class Filters extends baseClass{
@Test
	public void filters() throws InterruptedException {
		
		///launching the browser and passing the url into it
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
	       driver.get("https://sfccstage.firemountain.org/jewelry-supplies/findings/clasps/lobster-claw-clasps/");
	       
	   
	       selectingFilterFromPlp.selectingFilterisFormplp();
	       
	       
	}
}
