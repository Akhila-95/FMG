

package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.paymentProccess.tc__CheckOutProcessByPayPal;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.Scenarios.SearchingProduct;
import com.testcases.baseClass;

public class tc__BySearchingProduct_RegUser_InCheckoutPaypal extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {

		if(isLoggedIn) {      

			//searching a product 		
			SearchingProduct sp = new SearchingProduct();
			sp.searchingProduct();
    
	      //checkoutProcess	        
	        tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	        
	        cp.checkoutprocess();		   

    	  //paypal process from checkout page
			 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
			 cpp.checkoutprocessFromCheckout();
				 
		 }else {
		   	 Assert.fail("User not logged in");
		   }
    }
}