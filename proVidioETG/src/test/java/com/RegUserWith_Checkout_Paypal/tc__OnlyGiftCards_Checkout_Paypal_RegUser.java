package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paymentProccess.CheckOutProcessByPayPal;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__OnlyGiftCards_Checkout_Paypal_RegUser extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
		 
			//adding GC into cart
			    giftCard gc = new giftCard();
			    gc.giftCards();
			 
				MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
			    cp.checkoutprocess();
			     
			   //paypal process from checkout page
				 CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
				 cpp.checkoutprocessFromCheckout();
				 
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
