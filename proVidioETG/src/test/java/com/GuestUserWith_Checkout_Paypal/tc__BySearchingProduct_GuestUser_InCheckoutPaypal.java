

package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Scenarios.SearchingProduct;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;

public class tc__BySearchingProduct_GuestUser_InCheckoutPaypal extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test//(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
	
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();

        //searching a product 		
		SearchingProduct sp = new SearchingProduct();
		sp.searchingProduct();
       
       //checkoutProcess	        
        MinicartViewCartProcess cp = new MinicartViewCartProcess();            
        cp.checkoutprocess();
                    
	  //paypal process from checkout page
		 CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
		 cpp.checkoutprocessFromCheckout();
    }
}