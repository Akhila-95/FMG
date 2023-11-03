

package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.commonfunctionality.SelectionFromNavToPdp;
import com.paymentProccess.CreditCardPaymentProcess;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class tc__RandomProduct_GuestUser_InCc extends baseClass {

    @Test(invocationCount = 1)
    public void guestlogin() throws InterruptedException {
    	
    	//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
    	
		// selecting random menu and product and adding to cart
		SelectionFromNavToPdp.selectingFromPdp();
        
    	
        //check out process
	     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();			     
	     cp.checkoutprocess();
	     
	     //Payment process		     
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
	     cc.paymentByCreditCard();
    }
}