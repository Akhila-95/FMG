package com.RegUserWith_GcAndCC;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctionality.Gc__CC_Paypal;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.Scenarios.giftCard;
import com.providio.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class tc__simpleProductAndGc_InCCAndCc_InRegUser extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void simpleProduct_Gc() throws InterruptedException {
		if(isLoggedIn) {     
		
		//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
		
		 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards(); 
	    
		 //selecting random menu and product and adding to cart
		    SelectionFromNavToPdp.selectingFromPdp();
		 
			 //checkoutProcess				        
		  //checkoutProcess				        
		     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
		     cp.checkoutprocess();
	   
		   //semi gc and cc 
				Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
				gCandCC.paymentProccessByGCandCC(driver);
				
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
