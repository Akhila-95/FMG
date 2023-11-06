package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;

import com.PageObjects.productListingPage;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.testcases.baseClass;

public class tc__RandomProduct_GuestUser_VC_Paypal extends baseClass {
	 
	@Test
	public void paypalFromViewCartPage() throws InterruptedException {
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
		
			// selecting random menu and product and adding to cart
			SelectionFromNavToPdp.selectingFromPdp();	
	          
	     
    	 //paypal checkout form view cart page
 	          CheckOutProcessByPayPal paypal= new CheckOutProcessByPayPal();	         
 	          paypal.checkoutprocessFromViewCart();
   
		   }

}
