package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.Scenarios.homePagePlp;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;

public class tc__HomePageBannerPLPInCheckoutPaypal extends baseClass{
	
	//@Test//(invocationCount=5)
    public void HomePageBannerPLPInCheckoutPaypal() throws InterruptedException {
        // Launch the browser and navigate to the URL
        launchBrowsering lb = new launchBrowsering();
        lb.chromeBrowser();

        // Execute the scenario to navigate to the PLP page from the home page banner
        homePagePlp.homePagePLP();

        // Initialize MinicartViewCartProcess to perform the checkout process
        MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
        // Perform the checkout process
        cartProcess.checkoutprocess();

     // Initialize CheckOutProcessByPayPal to perform the PayPal checkout process
        CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
        // Perform the PayPal checkout process
        cpp.checkoutprocessFromCheckout();
    }

}
