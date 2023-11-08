package com.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Validations.validationpopupMessages;
import com.testcases.baseClass;

public class viewCartPage extends baseClass {
	
WebDriver lDriver;
	
	public viewCartPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	/*
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
			
		}*/
	
	//Checkout :- 
		@FindBy(xpath="//a[contains(text(),'Checkout')]")
		WebElement Checkout;	
		public void clickCheckout(WebDriver driver) throws InterruptedException{
			test.info("Validate check out Btn ViewCart page");
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", Checkout);	
			test.pass("Successfully Checkout Btn is Clicked");
	        Thread.sleep(5000);
		}
		
		//Removeitem	
		@FindBy(xpath="(//button[@class ='remove-btn-lg cart-delete-confirmation-btn btn btn-light'])[1]")
		WebElement CancelItem;
		public void clickCancelItem(WebDriver driver) throws InterruptedException{	
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", CancelItem);
	        Thread.sleep(5000);
		}
			
		
		   //move to wishlist link on the view cart page save-for-later
			public void saveForLater() throws InterruptedException {
				test.info("Validate the save later button click");
				List<WebElement> saveForLaterLink = driver.findElements(By.xpath("//div[@class='total-cart-content']//div[contains(@class,'save-for-later')]"));
				 // Get the total count of top-level menu elements.
		        int count = saveForLaterLink.size();
		        // Create a random number generator.
		        Random random = new Random();
		        // Generate a random index to select a top-level menu item.
		        int randomeditlink = random.nextInt(count) + 1;
		        logger.info(randomeditlink);
		        WebElement movetoWishListLink = driver.findElement(By.xpath("(//div[@class='total-cart-content']//div[contains(@class,'save-for-later')])[" + randomeditlink + "]"));
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver; 
				js.executeScript("arguments[0].click();", movetoWishListLink);		
				//movetoWishListLink.click();
				test.pass("Successfully the product is add to the save later");
				
				//validationpopupMessages.validatingProductisAddtoWishList(driver);
				
		        
			}
			
			//move to wishlist link on the view cart page
			public void removeBtn() throws InterruptedException {
				test.info("Validate the remove button click");
				Thread.sleep(3000);
				List<WebElement> removeBtns = driver.findElements(By.xpath("//div[contains(@class,'cart-delete')]"));
				 // Get the total count of top-level menu elements.
		        int count = removeBtns.size();
		        // Create a random number generator.
		        Random random = new Random();
		        // Generate a random index to select a top-level menu item.
		        int randomRemoveBtn = random.nextInt(count) + 1;
		        logger.info(randomRemoveBtn);
		        WebElement removeformviewcart = driver.findElement(By.xpath("(//div[contains(@class,'cart-delete')])[" + randomRemoveBtn + "]"));
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver; 
				js.executeScript("arguments[0].click();", removeformviewcart);		
				
				Thread.sleep(5000);
				
				String[] xpathsofViewcart = {
					    "//a[contains(@class,'undolink')]",
					    "//a[contains(@class,'save-for-later')]",
					    "//button[contains(@class,'removecart')]"
					};
				
				// Generate a random index to select an XPath expression
				int randomIndex = random.nextInt(xpathsofViewcart.length);

				// Access the randomly selected XPath expression
				String randomXPath = xpathsofViewcart[randomIndex];
				
				//RandomElement
				WebElement randomElement = driver.findElement(By.xpath(randomXPath));
				
				js.executeScript("arguments[0].click();", randomElement);		
				//randomElement.click();
				
				if(randomIndex==0) {
					validationpopupMessages.validatingProductisAddtoCart(lDriver);
				}else if(randomIndex==1) {
					// Success message is displayed
			       	   test.pass("Product added to saveForLater");
			           logger.info("Product is added to saveForLater");
					//validationpopupMessages.validatingProductisSaveforLater(driver);
				}else {
					   test.pass("Product Removed from the cart");
			           logger.info("Product Removed from the cart");
					//validationpopupMessages.validatingProductisAddtoWishList(driver);
				}
				
			
				//removeformviewcart.click();
				//popup validations
				//validationpopupMessages.removeproductformminicartValidation();
		        
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
