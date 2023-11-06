package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonfunctionality.SelectionFromNavToPdp;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__simpleProductAndGc_Reg_InVC_Paypal extends baseClass {
	
	  
	@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
	public void simpleProduct_Gc() throws InterruptedException {
		if(isLoggedIn) {


			 //adding GC into cart
			    giftCard gc = new giftCard();
			    gc.giftCards(); 
		    	
		  //selecting random menu and product and adding to cart
		 	SelectionFromNavToPdp.selectingFromPdp();
			
		  //paypal checkout form view cart page
	          CheckOutProcessByPayPal paypal= new CheckOutProcessByPayPal();	         
	          paypal.checkoutprocessFromViewCart();   
	} else {
        Assert.fail("User not logged in");
    }
 }
	
}
