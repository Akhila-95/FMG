package com.providio.Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.homePage;
import com.commonfunctionality.addtoCartValidation;
import com.commonfunctionality.allAttributesinOneFile;
import com.testcases.baseClass;

public class SearchingProduct extends baseClass{

	public  void searchingProduct() throws InterruptedException {

		
   	  //searching a product
       homePage homepage = new homePage(driver);
       homepage.clickOnSearchBar(this.searchBar);
       test.info("searched a product " + this.searchBar);
       
       //clicked on searched product
       Thread.sleep(2000);
       homepage.clickOnSearchedProduct();
       test.info("clicked on searched product");
   
		
		 List<WebElement> pdpPage = driver.findElements(By.xpath("//span[contains(text(),'Add to Cart')]"));
		 if( pdpPage.size()>0) {
			 allAttributesinOneFile.selectTheAttributesInPdp(driver);
		 }
		  
		   //validating the product is add to the cart
	   addtoCartValidation.validatingProductisAddtoCart(driver);

	}

}
