package com.GuestUserWith_GcAndCC;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Scenarios.PlpPage;
import com.commonfunctionality.Gc__CC_Paypal;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;


public class tc__RandomProductsGuestUser_InGcAndCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(invocationCount = 5)
	public void simpleProduct() throws InterruptedException {
		 
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
		
			
			// selecting random menu and product and adding to cart
			PlpPage.plp();
			
	        //checkoutProcess	        
	        MinicartViewCartProcess cp = new MinicartViewCartProcess();	        
	      //  cp.checkoutprocess();
            
	      //semi gc and cc 
			Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
		//	gCandCC.paymentProccessByGCandCC(driver);

	        
	        }
	        
	  
}

