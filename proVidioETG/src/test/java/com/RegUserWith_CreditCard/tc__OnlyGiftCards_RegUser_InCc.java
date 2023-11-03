package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paymentProccess.CreditCardPaymentProcess;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.Scenarios.giftCard;
import com.providio.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class tc__OnlyGiftCards_RegUser_InCc extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		
		if(isLoggedIn) {
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
			 
			 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards();
			
			 //checkoutProcess
			 tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
		     cp.checkoutprocess();
				     
		     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
		     cc.paymentByCreditCard();
		     
		     Thread.sleep(2000);
		} else {
	        Assert.fail("User not logged in");
	    }
	}
}
