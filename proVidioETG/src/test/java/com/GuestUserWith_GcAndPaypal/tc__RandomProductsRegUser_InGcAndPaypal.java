package com.GuestUserWith_GcAndPaypal;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.commonfunctionality.Gc__CC_Paypal;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;


public class tc__RandomProductsRegUser_InGcAndPaypal extends baseClass{
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
            
	        //gc and paypal
				 Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
				 gcAndPaypal.paymentProccessByGCandPaypal();	        
   	  
	}
}

