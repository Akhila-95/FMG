package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Scenarios.giftCard;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards_Checkout_Paypal extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true,invocationCount = 1)  
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
		 
			//adding GC into cart
			    giftCard gc = new giftCard();
			    gc.giftCards();
			 
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
