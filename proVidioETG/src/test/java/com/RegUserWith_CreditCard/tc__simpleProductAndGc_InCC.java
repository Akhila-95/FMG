package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctionality.SelectionFromNavToPdp;
import com.paymentProccess.CreditCardPaymentProcess;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__simpleProductAndGc_InCC extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
	public void simpleProduct_Gc() throws InterruptedException {
		
		if(isLoggedIn) {			
		
		 //adding GC into cart
		    giftCard gc = new giftCard();
		    gc.giftCards(); 
	    
		 //selecting random menu and product and adding to cart
		    SelectionFromNavToPdp.selectingFromPdp();
		 
		 //checkoutProcess				        
		     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
		     cp.checkoutprocess();
	     
		     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
		     cc.paymentByCreditCard();
	 } else {
        Assert.fail("User not logged in");
    }
 }
	
}
