package com.GuestUserWith_GcAndCC;

import org.testng.annotations.Test;

import com.commonfunctionality.Gc__CC_Paypal;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class tc__simpleProductAndGc_GuestUser_InCcAndGc extends baseClass {
	
	  
	@Test
	public void simpleProduct_Gc() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		// selecting random menu and product and adding to cart
		SelectionFromNavToPdp.selectingFromPdp();
		 
		 //checkoutProcess				        
	     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	   //semi gc and cc 
		Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
		gCandCC.paymentProccessByGCandCC(driver);
	}
	
}
