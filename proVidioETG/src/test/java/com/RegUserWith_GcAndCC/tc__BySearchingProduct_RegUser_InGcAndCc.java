

package com.RegUserWith_GcAndCC;

import com.commonfunctionality.Gc__CC_Paypal;
import com.commonfunctionality.SelectionFromNavToPdp;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.testcases.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_RegUser_InGcAndCc extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		 
		if(isLoggedIn) {
			
			// selecting random menu and product and adding to cart
					SelectionFromNavToPdp.selectingFromPdp();
					
			        //checkoutProcess	        
			        tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	        
			        cp.checkoutprocess();
		            
			      //semi gc and cc 
					Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
					gCandCC.paymentProccessByGCandCC(driver);
			
		 } else {
		        Assert.fail("User not logged in");
		    }
    }
}