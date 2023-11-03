package com.proviodi.eachPagetest;

import org.testng.annotations.Test;

import com.PageObjects.productListingPage;
import com.commonfunctionality.allAttributesinOneFile;
import com.commonfunctionality.selectingFilterFromPlp;
import com.testcases.baseClass;

public class pdppage extends baseClass{
	@Test
	public void testing() throws InterruptedException {
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/electronics/ipod%20%26%20mp3%20players/?lang=en_US");

	   Thread.sleep(5000);
	   selectingFilterFromPlp.selectingFilterisFormplp();
	   
	   
	   Thread.sleep(13000);
	
	}
	

}
