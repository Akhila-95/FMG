package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.PageObjects.GiftCertificate;
import com.paymentProccess.tc__CheckOutProcessByPayPal;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.Scenarios.giftCard;
import com.providio.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class tc__OnlyGiftCards_CheckoutPaypal_GuestUser extends baseClass{
	int minicartCountValue ;
	@Test
	public void OnlyGiftCards() throws InterruptedException {
		
		
		//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
				 		
		 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards();
		
		 //checkoutProcess
			 tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
		     cp.checkoutprocess();
			     
	    //paypal process from checkout page
			 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
			 cpp.checkoutprocessFromCheckout();
	}
}
