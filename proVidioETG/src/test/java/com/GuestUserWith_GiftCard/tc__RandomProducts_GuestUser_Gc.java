												package com.GuestUserWith_GiftCard;

import org.testng.annotations.Test;

import com.commonfunctionality.Gc__CC_Paypal;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;

public class tc__RandomProducts_GuestUser_Gc extends baseClass {
	 
	@Test
	public void paymentByGiftCardInGuestUser() throws InterruptedException  {
		
		
		//launching the browser and passing the url into it
				launchBrowsering lb = new launchBrowsering();
				lb.chromeBrowser();
				
		// selecting random menu and product and adding to cart
				SelectionFromNavToPdp.selectingFromPdp();		
				
		 //checkoutProcess				        
			     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
			     cp.checkoutprocess();
			     
		//gc payment 
			     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
			     gc.paymentByGiftCard();			   
			     
		}
}
