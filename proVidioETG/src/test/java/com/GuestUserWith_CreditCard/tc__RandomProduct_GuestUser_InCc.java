

package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.commonfunctionality.SelectionFromNavToPdp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CreditCardPaymentProcess;
import com.paymentProccess.MinicartViewCartProcess;
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
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();			     
	     cp.checkoutprocess();
	     
	     //Payment process		     
	  //   CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
	 //    cc.paymentByCreditCard();
    }
}