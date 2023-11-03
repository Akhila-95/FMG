package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctionality.SelectionFromNavToPdp;
import com.paymentProccess.tc__CheckOutProcessByPayPal;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class tc__RandomProducts_CheckoutPaypal_RegUser extends baseClass {
	int  minicartCountValue=0;
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void randomProducts() throws InterruptedException {
		
		if(isLoggedIn) { 
			
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
			 
		  // selecting random menu and product and adding to cart
			SelectionFromNavToPdp.selectingFromPdp();
	        
		  // common checkoutProcess	         
			 tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();         
			 cp.checkoutprocess();
	         
		 //paypal process from checkout page
			 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
			 cpp.checkoutprocessFromCheckout();
			 
		 }else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
