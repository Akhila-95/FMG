

package com.GuestUserWith_GiftCard;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Scenarios.SearchingProduct;
import com.commonfunctionality.Gc__CC_Paypal;
import com.launchingbrowser.launchBrowsering;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;

public class tc__BySearchingProduct_Guest_InGc extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test
    public void bySearchingProduct() throws InterruptedException {

		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
 
		//searching a product 
		SearchingProduct sp = new SearchingProduct();
		sp.searchingProduct();

		MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	    cp.checkoutprocess();
	     
        //gc payment 
	     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
	     gc.paymentByGiftCard();
	}
		 
}