package com.RegUserWith_GiftCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.GiftCertificate;
import com.commonfunctionality.Gc__CC_Paypal;
import com.paymentProccess.tc__CheckOutProcessByPayPal;
import com.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.Scenarios.giftCard;
import com.testcases.baseClass;

public class tc__OnlyGiftCards_Reg_InGc extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
		 
			 //adding GC into cart
			     giftCard gcs = new giftCard();
			     gcs.giftCards();
					 
				 tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
			     cp.checkoutprocess();
			     
			   //gc payment 
			     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
			     gc.paymentByGiftCard();
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
