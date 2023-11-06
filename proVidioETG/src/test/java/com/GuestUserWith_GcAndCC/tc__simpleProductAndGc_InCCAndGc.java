package com.GuestUserWith_GcAndCC;

import org.testng.annotations.Test;

import com.commonfunctionality.Gc__CC_Paypal;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__simpleProductAndGc_InCCAndGc extends baseClass {
	
	  
	@Test
	public void simpleProduct_Gc() throws InterruptedException {
		
		
		//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
		
		 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards(); 
	    
		 //selecting random menu and product and adding to cart
		    SelectionFromNavToPdp.selectingFromPdp();
		 
			 //checkoutProcess				        
		     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
		     cp.checkoutprocess();
		     
		   //semi gc and cc 
			Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
			gCandCC.paymentProccessByGCandCC(driver);
	}
}
