package com.PageObjects;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Validations.validationpopupMessages;
import com.testcases.baseClass;

public class viewCartPage extends baseClass {
	
WebDriver lDriver;
	
	public viewCartPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	   Float  unitPrice = (float) 0 ;
       Float quantity = (float) 0 ;
       Float productValue = (float) 0 ;
       Float giftCardValue = (float) 0 ;   
       Float totalEachProduct = (float) 0 ;
       Float totalProduct = (float) 0 ;
       Float shippingValue = (float) 0 ;
       Float expectedPreTotalTax = (float) 0 ;
       Float actualPreTotalTax = (float) 0 ;
       Float assortablePrice = (float) 0 ;
	
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
	
			
			//items count in cart page
			public void itemsNameInCart() {
				
				 WebElement childDiv = driver.findElement(By.xpath("(//span[@class='plis-count'])[1]"));
				 String countOfProducts= childDiv.getText();
				 test.info("The total number of products in cart are " +countOfProducts);
			}
			
			//product calcualtion
			public void productCal() {
				
				//unit price
				 List<WebElement> totalProducts = driver.findElements(By.xpath("//div[contains(@class, 'card product-info product-detail  uuid-')]"));
				 List<WebElement> giftCerificateList = driver.findElements(By.xpath("//div[contains(@class, 'card product-info gift-certificate uuid-')]"));
				 if(totalProducts.size()>0 ) {
					 test.info("Products are in cart wihout GC");
					 for (int i = 1; i <=  totalProducts.size(); i++) {
						    WebElement unitPriceText = driver.findElement(By.xpath("(//span[@class='sales']//span[@class='value'])[" + i + "]"));
						    String unitPriceString = unitPriceText.getText();
						    System.out.println(unitPriceString);
						    String unitPriceValue = unitPriceString.replaceAll("[^\\d.]+", "");
						    unitPrice = Float.parseFloat(unitPriceValue);
						    logger.info("The unit price of each prodcut is "+unitPrice);
		
						
						    WebElement quantityListText = driver.findElement(By.xpath("(//input[@name='quantity'])[" + i + "]"));
						    String quantityValue = quantityListText.getAttribute("value");
						  
						    quantity = Float.parseFloat(quantityValue);
						    logger.info("The quantity  is "+quantity);
					
					 
					
						    WebElement eachProductValue = driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])[" + i + "]"));
						    String eachProductValueText= eachProductValue.getText();
						    String productValue1 = eachProductValueText.replaceAll("[^\\d.]+", "");
						    productValue = Float.parseFloat(productValue1);
						    logger.info("Extended value is " +productValue);
	
						 
						 
						    float totalProduct = unitPrice * quantity;
						    totalEachProduct += totalProduct;				    
						    System.out.println("The total price of each product is " + totalProduct +"[" + i + "]" );
						    totalEachProduct += totalProduct;	
							 
							 if(giftCerificateList.size()>0) {
								 WebElement lineItemName = driver.findElement(By.xpath("//div[@class='line-item-name']//a"));
								 String lineItemNametext = lineItemName.getText();
								 System.out.println(lineItemNametext);
								 String gc= "Gift Certificate";
								 	
								 if(lineItemNametext.equals(gc)) {
									 int countOfGc= giftCerificateList.size();
									 for(int j=1;j<=countOfGc;j++) {
										 WebElement eachProductValue1 = driver.findElement(By.xpath("(//div[contains(@class, 'card product-info gift-certificate uuid-')]//div[contains(@class, 'pricing line-item-total-price-amount item-total')])[" + j + "]"));
									     String eachProductValueText1= eachProductValue1.getText();
									     String productValue2 = eachProductValueText1.replaceAll("[^\\d.]+", "");
									     giftCardValue = Float.parseFloat(productValue2);
									     logger.info("Extended value is " + giftCardValue );
									     giftCardValue+=giftCardValue;
									     
									 }
							 }
						}
					 }
					 
					 totalEachProduct= productValue+giftCardValue;
					 
					 logger.info("Total price of all prodcuts in cart "+totalEachProduct);
				 }else {
					 test.info("Gc is cart ");
					 
				 }
			}
			
			
			public void quantityInsertionInCartPage() throws InterruptedException {
						
				List<WebElement> quantityInput = driver.findElements(By.xpath("//input[@name='quantity']"));
		
				if(quantityInput.size()>0) {
				
					int productQuantityCount = quantityInput.size();
					int productCount = 150;
					// Create a random number generator.
				    Random random = new Random();
			        // Generate a random index to insert the qunatity
				    int randomquantityInput = random.nextInt(productQuantityCount) + 1;
				    int inputQuantiy = random.nextInt(productCount)+1;
				    logger.info("Product input quantity "+inputQuantiy);
				    // Find the quantity input field associated with the clicked button and set the quantity.
			        WebElement inctheQuantity = driver.findElement(By.xpath("(//input[@name='quantity'])[" + randomquantityInput + "]"));
			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", inctheQuantity);
			        Thread.sleep(2000);
			        inctheQuantity.clear(); // Clear the existing value
			        Thread.sleep(2000);
			        inctheQuantity.sendKeys(String.valueOf(inputQuantiy));
			        Thread.sleep(1000);
			    
			       //update the qunatity
			        List<WebElement> updateQuantityList = driver.findElements(By.xpath("//div[contains(text(),' Update')]"));
			     
			        if(updateQuantityList.size()>0) {
				       WebElement updateQuantity = driver.findElement(By.xpath("(//div[contains(text(),' Update')])[" + randomquantityInput + "]"));
				       if(updateQuantity.isDisplayed()) {
				    	   updateQuantity.click();
				    	   Thread.sleep(3000);
				       }
			       }else {
			    	   logger.info("Updating the quantity in Pdp page ");
			       }
		       
				}else {
					logger.info("Gc in cart");
				}
			}
			//shipping calculation			
			public void estimatedshippingCalculations() throws InterruptedException {	 
				
				 List<WebElement> giftCerificate = driver.findElements(By.xpath("//div[contains(@class, 'card product-info gift-certificate uuid-')]"));
				 List<WebElement> totalProducts = driver.findElements(By.xpath("//div[contains(@class, 'card product-info product-detail  uuid-')]"));
				 
				 if((giftCerificate.size()>0 && totalProducts.size()>0) || (totalProducts.size()>0) ) {
					 //country
					 	countryDropDown();
					 	logger.info("Entered shipping address");

					 	WebElement assortablePriceElement = driver.findElement(By.xpath("//p[contains(@class,'assortable-price')]"));
					    String assortablePriceText= assortablePriceElement.getText();
						String assortablePriceText1 = assortablePriceText.replaceAll("[^\\d.]+", "");
						assortablePrice = Float.parseFloat(assortablePriceText1);
						logger.info("Assortable price is " +assortablePrice);
					 	
					 	test.info("Calculating the pre-total tax with the estimated shipping cost");
					    WebElement shippingValueElement = driver.findElement(By.xpath("//p[@class='text-right shipping-cost accessibility-element']"));
					    
					    String eachShippingValueText= shippingValueElement.getText();
					    System.out.println("Shipping cost "+eachShippingValueText);
					 // Remove all non-numeric characters using regular expression
					    String shippingValueText = eachShippingValueText.replaceAll("[^\\d.]+", "");

					 // If you need a float value, you can convert it
					    float shippingValue = Float.parseFloat(shippingValueText);
					 
					    float formattedPreTotalTax =(shippingValue +totalEachProduct);
					    logger.info("Estimated and expected Pre total price tax " +formattedPreTotalTax);					    
					    test.info("The total pre-tax calculation is " +formattedPreTotalTax);
					    
					    
					    // Round up the number
				        double roundedNumber = Math.ceil(formattedPreTotalTax * 100) / 100; // Round up to two decimal places

				        // Format the number to have only two digits after the decimal point
				        DecimalFormat df = new DecimalFormat("#.##");
				        String pretotalString = df.format(roundedNumber);
				        //convert string to float
				        expectedPreTotalTax = Float.parseFloat(pretotalString);

				        // Print the result
				        System.out.println("Original Number: " + expectedPreTotalTax);
				        System.out.println("Rounded and Formatted Number: " + formattedPreTotalTax);	
				        
					  //actual pre total tax
					    WebElement preTotalTaxGrandTotal = driver.findElement(By.xpath("//p[contains(@class,'grand-total')]"));
					    String preTotalTaxGrandTotalText= preTotalTaxGrandTotal.getText();
						String preTotalTaxGrandTotalTextText1 = preTotalTaxGrandTotalText.replaceAll("[^\\d.]+", "");
						actualPreTotalTax = Float.parseFloat( preTotalTaxGrandTotalTextText1);
						logger.info("Actual pre total-price is " +actualPreTotalTax);
						
						
						
						if( expectedPreTotalTax.equals(actualPreTotalTax)) {
							test.pass("The caluated pre-total tax is " + expectedPreTotalTax + " is equal to " + actualPreTotalTax);
							logger.info("The caluated pre-total tax is " + expectedPreTotalTax + " is equal to " + actualPreTotalTax);
						}else {
							test.fail("The caluated pre-total tax is " + expectedPreTotalTax + " is not equal to " + actualPreTotalTax);
							logger.info("The caluated pre-total tax is " + expectedPreTotalTax + " is not equal to " + actualPreTotalTax);
						}
				 } else {
					 test.info("Cart contain only Gc products");
				 }
			}
			
			public static void countryDropDown() throws InterruptedException {
				 // Locate the dropdown element by its ID
		        WebElement countryDropdown = driver.findElement(By.id("shippingCountrydefault"));

		        // Create a Select object
		        Select select = new Select(countryDropdown);

		        // Get all the options within the dropdown
		        List<WebElement> countryOptions = select.getOptions();

		        // Get the total number of options
		        int numberOfOptions = countryOptions.size();

		        // Generate a random index within the range of available options
		        Random random = new Random();
		        int randomIndex = random.nextInt(numberOfOptions);

		        // Select the random option by its index
		        select.selectByIndex(randomIndex);
		        Thread.sleep(5000);
			}		
}
