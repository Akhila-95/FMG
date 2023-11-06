

package com.RegUserWith_ViewCart_Paypal;

import com.Scenarios.SearchingProduct;
import com.paymentProccess.CheckOutProcessByPayPal;
import com.testcases.baseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_Reg_InVC_Paypal extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.login.tc__Login.loginTest"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		if(isLoggedIn) {			

		
			 //searching a product 
				SearchingProduct sp = new SearchingProduct();
				sp.searchingProduct();
			
		    	//paypal checkout form view cart page
		          CheckOutProcessByPayPal paypal= new CheckOutProcessByPayPal();	         
		          paypal.checkoutprocessFromViewCart(); 
		          
	}  else {
        Assert.fail("User not logged in");
    }
 }
}