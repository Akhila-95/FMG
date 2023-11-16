package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Scenarios.PdpPage;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CreditCardPaymentProcess;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;
import com.utilities.giftCard;

public class tc__simpleProductAndGc_InCC extends baseClass {
	
	  
	@Test
	public void simpleProduct_Gc() throws InterruptedException {
		
		
		//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
		
		 //adding GC into cart
		    giftCard gc = new giftCard();
		   // gc.giftCards(); 
	    
		    
		    driver.get("https://utsf.firemountain.org/1980wr/1980WR.html");
		 //selecting random menu and product and adding to cart
		    PdpPage.addtoCartPDP();
		 
		 //checkoutProcess				        
		     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
		     cp.checkoutprocess();
	     
		     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
		     cc.paymentByCreditCard();
	}
}
