package com.RegUserWith_GcAndPaypal;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.commonfunctionality.Gc__CC_Paypal;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;


public class tc__RandomProductsGuestUser_InGcAndPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
	public void simpleProduct() throws InterruptedException {
		 
		if(isLoggedIn) {  
			
		
			// selecting random menu and product and adding to cart
			SelectionFromNavToPdp.selectingFromPdp();
		    
	        //checkoutProcess	        
	        MinicartViewCartProcess cp = new MinicartViewCartProcess();	        
	        cp.checkoutprocess();
            
	      //gc and paypal
			  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
			  gcAndPaypal.paymentProccessByGCandPaypal();	        
	        
	}else {
	   	 Assert.fail("User not logged in");
	   } 	  
   }
}

