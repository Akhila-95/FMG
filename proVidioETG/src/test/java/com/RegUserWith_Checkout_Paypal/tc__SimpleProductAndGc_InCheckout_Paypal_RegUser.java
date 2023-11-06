package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctionality.SelectionFromNavToPdp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__SimpleProductAndGc_InCheckout_Paypal_RegUser extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
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
			     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
			     cp.checkoutprocess();
			     
			  //paypal process from checkout page
				 CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
				 cpp.checkoutprocessFromCheckout();
			 
		 }else {
		   	 Assert.fail("User not logged in");
		   }
	}
	
}
