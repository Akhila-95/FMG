package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CreditCardPaymentProcess;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__OnlyGiftCards_GuestUser_InCc extends baseClass{
	int minicartCountValue ;
	 @Test(invocationCount = 1)
	public void OnlyGiftCards() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		 
		 //adding GC into cart
	    giftCard gc = new giftCard();
	    gc.giftCards();
		
		 //checkoutProcess
		 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
			     
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
	     cc.paymentByCreditCard();
	     
	     Thread.sleep(2000);
	}
}
