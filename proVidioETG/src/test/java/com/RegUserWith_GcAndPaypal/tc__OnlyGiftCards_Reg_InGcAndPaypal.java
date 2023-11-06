package com.RegUserWith_GcAndPaypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctionality.Gc__CC_Paypal;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__OnlyGiftCards_Reg_InGcAndPaypal extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {   
			
				 //adding GC into cart
			    giftCard gc = new giftCard();
			    gc.giftCards();
			 
				 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
			     cp.checkoutprocess();
			     
			   //semi gc and cc 
				 Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
				 gCandCC.paymentProccessByGCandCC(driver);
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
