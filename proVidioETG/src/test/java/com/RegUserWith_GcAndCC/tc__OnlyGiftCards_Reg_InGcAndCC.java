package com.RegUserWith_GcAndCC;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctionality.Gc__CC_Paypal;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.Scenarios.giftCard;
import com.testcases.baseClass;

public class tc__OnlyGiftCards_Reg_InGcAndCC extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
		 
		//adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards();
			 
	    //checkoutProcess				        
	     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
	     cp.checkoutprocess();
		        
		    
			     
	   //semi gc and cc 
			Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
			gCandCC.paymentProccessByGCandCC(driver);
			
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
