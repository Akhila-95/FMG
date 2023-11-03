package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testcases.baseClass;

public class viewCartPage extends baseClass {
	
WebDriver lDriver;
	
	public viewCartPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//Checkout :- 
	@FindBy(xpath="//a[contains(@class,'checkout-btn')]")
	WebElement Checkout;	
	public void clickCheckout(WebDriver driver) throws InterruptedException{		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", Checkout);		
       
	}
	
	//Removeitem	
	@FindBy(xpath="(//button[@class ='remove-btn-lg cart-delete-confirmation-btn btn btn-light'])[1]")
	WebElement CancelItem;
	public void clickCancelItem(WebDriver driver) throws InterruptedException{	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", CancelItem);
        Thread.sleep(5000);
	}
		
	
   //brain tree paypal button

		public void braintreePayPalButton(WebDriver driver) {
			
		    // Find the element using its xpath
		    WebElement payPalButton = driver.findElement(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
	
		    // Perform the click action
		    payPalButton.click();
		}
		//salesforce paypalbutton
		public void salesforcePayPalButton(WebDriver driver) {
				
			    // Find the element using its xpath
			    WebElement payPalButton = driver.findElement(By.xpath("(//div[contains(@class,'salesforce-paymentrequest-element')])[1]"));
		
			    // Perform the click action
			    payPalButton.click();
			}
	
		//IF only GC in cart, it should not show the shipping method.
		public void noShippingMethodForOnlyGiftCertificate(WebDriver driver) {
			
			  List<WebElement> giftcertificate = driver.findElements(By.xpath("//div[contains(@class,'card product-info gift-certificate uuid-')]"));
			  List<WebElement> normalProducts = driver.findElements(By.xpath("//div[contains(@class,'card product-info  uuid-')]"));
			  
			  //if GC and normal products in cart  
			  if((giftcertificate.size()> 0)&& (normalProducts.size()>0)) {			  
				  List<WebElement> shippingMethodLabelList = driver.findElements(By.xpath("//label[contains(text(),'Shipping')]"));
				  
				  //if shipping method label is find
				  if(shippingMethodLabelList.size()>0) {
					  WebElement shippingMethodLabel = driver.findElement(By.xpath("//label[contains(text(),'Shipping')]"));
					  test.info("Verifying -  So, shipping method should display");	
					  //if shipping method is displayed 
					  if(shippingMethodLabel.isDisplayed()) {					  						  
						  test.pass("Verified shipping method is displayed when Gift certificate and normal products is in cart ");
						  logger.info("Gift certificate and normal products  is in cart So, shipping method should display");
					  }else {
						  test.fail(" Shipping method is not  displayed when Gift certificate and normal products is in cart ");
					  }
				  }
				  //if only normal products in cart
			  }else if(normalProducts.size()>0) {
				  WebElement shippingMethodLabel = driver.findElement(By.xpath("//label[contains(text(),'Shipping')]"));
				  //if shipping method is displayed 
				  test.info( "Verifying Normal products  is in cart So, shipping method should display");	
				  if(shippingMethodLabel.isDisplayed()) {					  					 
					  test.pass("Verified shipping method is displayed when Gift certificate and normal products is in cart ");
					  logger.info("Normal products  is in cart So, shipping method should display");	
				  }else {
					  test.fail(" Shipping method is not  displayed when Gift certificate and normal products is in cart ");
				  }
				  
			  }else if(giftcertificate.size()>0) {
				  test.info( "Verifying -Only Gift certificate is in cart So, shipping method should not display");
				  if(!(driver.findElements(By.xpath("//label[contains(text(),'Shipping')]")).size()>0)) {					  
					  logger.info("Only Gift certificate  is in cart So, shipping method should not display");	
					  test.pass("Verified -Only Gift certificate is in cart So, shipping method should not displayed");
				  }else {
					  test.fail("Verified -Only Gift certificate is in cart So, shipping method is displaying");
				  }
			  }
			
		}
}
