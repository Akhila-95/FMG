

package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Scenarios.SearchingProduct;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.CreditCardPaymentProcess;

import com.paymentProccess.MiniCartCheckoutButton;
import com.testcases.baseClass;

public class tc__BySearchingProduct_GuestUser_InCC extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test//(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
			
	
        //searching a product 		
		SearchingProduct sp1 = new SearchingProduct();
		sp1.searchingProduct();

	        
       //checkoutProcess	        
		MiniCartCheckoutButton cp = new MiniCartCheckoutButton();            
        cp.checkoutprocess();
        
        //payment by credit card
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
	     cc.paymentByCreditCard();
	        
    }
}