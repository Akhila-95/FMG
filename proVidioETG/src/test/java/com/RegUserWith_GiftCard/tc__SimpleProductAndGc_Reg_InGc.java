package com.RegUserWith_GiftCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctionality.Gc__CC_Paypal;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.Scenarios.giftCard;
import com.testcases.baseClass;

public class tc__SimpleProductAndGc_Reg_InGc extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void simpleProduct_Gc() throws InterruptedException {
		if(isLoggedIn) {      
			
			//adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards(); 
	    
		 //selecting random menu and product and adding to cart
		    SelectionFromNavToPdp.selectingFromPdp();
			 
			 //checkoutProcess				        
		     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
		     cp.checkoutprocess();
		     
			 //gc payment 
		     Gc__CC_Paypal gc1 = new Gc__CC_Paypal ();
		     gc1.paymentByGiftCard();
		 
		 }else {
		   	 Assert.fail("User not logged in");
		   }
	}
	
}
