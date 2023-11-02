package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.providio.Scenarios.giftCard;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.pageObjects.GiftCertificate;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCardsInCc extends baseClass{
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
		 tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
	     cp.checkoutprocess();
			     
	     //Payment process		     
	     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();			     
	     cc.paymentByCreditCard();
	     
	     Thread.sleep(2000);
	}
}
