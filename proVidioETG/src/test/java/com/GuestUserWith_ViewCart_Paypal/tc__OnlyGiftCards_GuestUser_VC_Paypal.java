package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;

import com.PageObjects.GiftCertificate;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__OnlyGiftCards_GuestUser_VC_Paypal extends baseClass{
	int minicartCountValue ;
	@Test
	public void OnlyGiftCards() throws InterruptedException {
		
		
		//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
				 		
		 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards();
		
		    //paypal checkout form view cart page
	          CheckOutProcessByPayPal paypal= new CheckOutProcessByPayPal();	         
	          paypal.checkoutprocessFromViewCart();
	}
}
