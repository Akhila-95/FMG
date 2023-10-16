package com.GuestUserWith_Checkout_Paypal;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.BundleProduct;
import com.providio.commonfunctionality.findAStore;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__MiniCartCheckoutButton;
import com.providio.testcases.baseClass;

public class tc__BundleProductForGuestUser_InCheckoutPaypal  extends baseClass{
	
		SoftAssert softAssert = new SoftAssert();

		 @Test
		public void bundleProduct() throws InterruptedException {
			 
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
			
			// to pick the store
	   	     findAStore  store = new findAStore();
	   	     store.findStore();
		 
			 //searching the bundle product from excel sheet
		    BundleProduct bp = new BundleProduct();
		    bp.bundleproduct();

	         //checkoutProcess		        
			  tc__MiniCartCheckoutButton cp = new tc__MiniCartCheckoutButton();	         
              cp.checkoutprocess();
              
              
      		//paypal process from checkout page
  		   tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
  		   cpp.checkoutprocessFromCheckout();
      		   
		}	 
}
