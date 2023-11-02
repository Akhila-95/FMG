

package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.findAStore;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__GuestUser_InCc extends baseClass {

    @Test(invocationCount = 5)
    public void guestlogin() throws InterruptedException {
    	
    	//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
    	
	    //selects a random catgory and product add to cart
        navigationProccess navProccess = new navigationProccess();
        navProccess.commonNavigationProccess();
        
    	
        //check out process
	     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();			     
	     cp.checkoutprocess();
	     
	     //Payment process		     
	     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();			     
	     cc.paymentByCreditCard();
    }
}