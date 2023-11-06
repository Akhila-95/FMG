package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CreditCardPaymentProcess;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__OnlyGiftCards_RegUser_InCc extends baseClass{
	int minicartCountValue ;
@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
	
	public void OnlyGiftCards() throws InterruptedException {
		
		if(isLoggedIn) {
			
			 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards();
			
			 //checkoutProcess
			 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
		     cp.checkoutprocess();
				     
		     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
		     cc.paymentByCreditCard();
		     
		     Thread.sleep(2000);
		} else {
	        Assert.fail("User not logged in");
	    }
	}
}
