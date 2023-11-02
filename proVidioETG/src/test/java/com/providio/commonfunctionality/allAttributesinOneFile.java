package com.providio.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.providio.Validations.navigationProcessWithValidation;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class allAttributesinOneFile extends baseClass{
	
	
	public static  void selectTheAttributesInPdp(WebDriver driver) throws InterruptedException {
		
		//selecting attributes from the  pdp page by checking the condition 
		allAttributes();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
     
	
	//checking the  add to cart enabled and  in stock
    		List<WebElement> Stocksize = driver.findElements(By.xpath("//span[contains(text(),'Sold Out')]"));
     		test.info("Verify that the product is avaliable");
     	    // Check if the element is present
     	    if (Stocksize.size() <= 0) {
     	    	test.pass("The product is avaliable");
     	    	
     	    	List<WebElement> addtoCartButton = driver.findElements(By.xpath("//span[contains(text(),'Add to Cart')]"));
     	    
     	    	//addtocartbutton is enabled
     	    	test.info("Verify that the product is avaliable");
     	    	if(addtoCartButton.size()>0) {
     	    		test.info("Verify that the add to cart button");
     	    		logger.info("add to cart  button enabled");
     	    		WebElement addtoCartButtonClick = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));     	    		
     	            js.executeScript("arguments[0].click();", addtoCartButtonClick);
     	            test.pass("Successfully clicked on the add to cart button");
     	    		//addtoCartButtonClick.click();
     	    	}
      
     	    }else {
    	 
    	 	//if the prodcut is outof stock then it will search for new prodcut by selecting random menu and random product
     	    	System.out.println("Product is out of stock so searching for new product");	    	
    	 	
	    	 	navigationProccess  navProccess  = new navigationProccess ();	
	    	 	navProccess.commonNavigationProccess();
     }	    
	     
	}

	public static void allAttributes() throws InterruptedException {
		
		//fetching the package size 
		List <WebElement> packageSize= driver.findElements(By.id("package-qty-feet-1"));
		System.out.println("The package size  " +packageSize.size());

			if(packageSize.size()>0) {
				attributesSelection.packageSizeSelection();
				System.out.println("selected package Size ");
				Thread.sleep(1000);
			}

	}
	
	
}
