package com.GuestUserWith_GcAndCC;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.commonfunctionality.Gc__CC_Paypal;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;


public class tc__RandomProductsGuestUser_InGcAndCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test
	public void simpleProduct() throws InterruptedException {
		 
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
		
			
			// selecting random menu and product and adding to cart
			SelectionFromNavToPdp.selectingFromPdp();
			
	        //checkoutProcess	        
	        MinicartViewCartProcess cp = new MinicartViewCartProcess();	        
	        cp.checkoutprocess();
            
	      //semi gc and cc 
			Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
			gCandCC.paymentProccessByGCandCC(driver);

	        
	        }
	        
	  
}

