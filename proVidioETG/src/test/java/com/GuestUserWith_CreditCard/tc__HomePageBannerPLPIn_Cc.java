package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Scenarios.homePagePlp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.paymentProccess.CreditCardPaymentProcess;
import com.paymentProccess.MiniCartCheckoutButton;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;

public class tc__HomePageBannerPLPIn_Cc extends baseClass{
	
	//@Test//(invocationCount=5)
    public void HomePageBannerPLPInCheckoutPaypal() throws InterruptedException {
        // Launch the browser and navigate to the URL
        launchBrowsering lb = new launchBrowsering();
        lb.chromeBrowser();

        // Execute the scenario to navigate to the PLP page from the home page banner
        homePagePlp.homePagePLP();

        //checkoutProcess	        
		MiniCartCheckoutButton cp = new MiniCartCheckoutButton();            
        cp.checkoutprocess();
        
        //payment by credit card
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
	     cc.paymentByCreditCard();
    }

}
