

package com.RegUserWith_GiftCard;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Scenarios.SearchingProduct;
import com.commonfunctionality.Gc__CC_Paypal;
import com.paymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;

public class tc__BySearchingProduct_Reg_InGc extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {

		if(isLoggedIn) {      
 
			//searching a product 
			SearchingProduct sp = new SearchingProduct();
			sp.searchingProduct();

			MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
		    cp.checkoutprocess();
		     
	        //gc payment 
		     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
		     gc.paymentByGiftCard();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
    }
}