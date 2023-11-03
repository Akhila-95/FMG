

package com.GuestUserWith_GiftCard;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.commonfunctionality.Gc__CC_Paypal;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.Scenarios.SearchingProduct;
import com.providio.launchingbrowser.launchBrowsering;
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

		tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
	    cp.checkoutprocess();
	     
        //gc payment 
	     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
	     gc.paymentByGiftCard();
	}
		 
}