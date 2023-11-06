package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.GiftCertificate;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__OnlyGiftCards_GuestUser_VC_Paypal extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		
		
		if(isLoggedIn) {   
				 		
		 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards();
		
		    //paypal checkout form view cart page
	          CheckOutProcessByPayPal paypal= new CheckOutProcessByPayPal();	         
	          paypal.checkoutprocessFromViewCart();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
