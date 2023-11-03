package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.GiftCertificate;
import com.paymentProccess.tc__CheckOutProcessByPayPal;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.Scenarios.giftCard;
import com.providio.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class tc__OnlyGiftCards_GuestUser_VC_Paypal extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		
		
		if(isLoggedIn) {   
				 		
		 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards();
		
		    //paypal checkout form view cart page
	          tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();	         
	          paypal.checkoutprocessFromViewCart();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
