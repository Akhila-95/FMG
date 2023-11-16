package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.PageObjects.GiftCertificate;
import com.Scenarios.PdpPage;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

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
		    
		    driver.get("https://utsf.firemountain.org/1980wr/1980WR.html");
		    
		    PdpPage.addtoCartPDP();
		
		 //checkoutProcess
			 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
		     cp.checkoutprocess();
			     
	    //paypal process from checkout page
			 CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
			 cpp.checkoutprocessFromCheckout();
	}
}
