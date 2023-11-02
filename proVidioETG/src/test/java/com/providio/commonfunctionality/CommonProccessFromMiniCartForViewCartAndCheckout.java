package com.providio.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.guestUserLoginPage;
import com.providio.testcases.baseClass;

public class CommonProccessFromMiniCartForViewCartAndCheckout extends baseClass {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 public void clickContinueAsGuest() throws InterruptedException {
	        List<WebElement> continueasAGuest = driver.findElements(By.xpath("//input[@id='email-guest']"));
	        logger.info(continueasAGuest.size());

	        if (continueasAGuest.size() > 0) {
	        	 //if guest checkout label is displayed then only this if condition executes 
	        	 	if(driver.findElement(By.xpath("//input[@id='email-guest']")).isDisplayed()) {
			            guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
			           
			            guestLoginPage.clickOnEmail(driver);
			            logger.info("Guest mail again");
			            guestLoginPage.clickOnContinueAsGuest();
			            logger.info("Guest user : continue's  as guest");	           
	        	 	}	          
	        }else {
	        	test.info("User is already in login");
	        }
	  
	    }

	    public void selectShippingAddress(checkOutPage cp) throws InterruptedException {
	    	
	    	//selecting shipping address for reg and guest user
	    	 List<WebElement> shippingAddressList = driver.findElements(By.xpath("(//h2[contains(text(),'Shipping Address')])[1]"));
	        
	        	//if user is registered then if condition executes
		        if(shippingAddressList.size()>0) {
		        	
		        	  //if user is register will have RecipientLabel  and  saveShippingAddressList 
		        	  List<WebElement> recipientLabel = driver.findElements(By.xpath("//label[contains(text(),'Recipient')]"));
		        	  List<WebElement> saveShippingAddressList = driver.findElements(By.id("addShippingAddressToMyAccount-single-shipping"));
		        	  	
		        	  //if have save address label then it is registered user
			        	  if(saveShippingAddressList.size()>0) {
			        		  WebElement shippingToDisplay = driver.findElement(By.xpath("(//h2[contains(text(),'Shipping Address')])[1]"));
			        		  if(shippingToDisplay.isDisplayed()) {
				        		  test.info("User is Registered");
				        		  if(recipientLabel.size()>0 && saveShippingAddressList.size()>0) {
				        			  test.info("User is Registered and have saved address");
				        		
				        		  }else if(saveShippingAddressList.size()>0) {
				        			  test.info("User have no saved cards");
	
							          //Enters name and address			        	
								        	shippingAddressDetailsWithName(cp);	
								        	
								       //adds the addres to account
								        	saveTheShippingAddress();	
				        		  }
			        		  }
				        	}else {	
					        	//if user is guest this else part will execute 
			        			test.info("User is a Guest");
			        			
			        		//Enters name and address	
			        			shippingAddressDetailsWithName(cp);				        					
				        	}			        
		        }
	    }
	    
	    public void selectingRandomSavedShippingAddress() throws InterruptedException {
	    	
		    	  test.info("User logged in and have saved  Address ");				           
		          
		          // Locate the <select> element by its ID attribute
		          WebElement addressDropDownSelect = driver.findElement(By.xpath("//select[@id='shipmentSelector-default']"));
		          
		    if(addressDropDownSelect.isDisplayed()) {      
		          //click on address drop down
		          
		          addressDropDownSelect.click();
		          //js.executeScript("arguments[0].click();",  addressDropDownSelect);
		          System.out.println("Clicks on drop down");
		          
		          Actions action = new Actions(driver);
			    	//action.moveToElement(addressDropDownSelect).perform();
			    	Thread.sleep(5000);
		          // Create a Select object to work with the <select> element
		          Select select = new Select(addressDropDownSelect);
		
		          // Get all the options in the dropdown
		          List<WebElement> options = select.getOptions();
		          
		           logger.info(options.size());
		          // Generate a random index within the range of available options
		          Random random = new Random();
		          int randomIndex = random.nextInt(options.size());
		          Thread.sleep(1000);
		          // Select the option at the random index
		          select.selectByIndex(randomIndex);
		          Thread.sleep(1000);
		          
			        System.out.println("Selected random address is " + randomIndex);
		    	}
		    }

	    public void selectBillingAddress(checkOutPage cp) throws InterruptedException {
	    	
	    	// Enters the billing address in checkout3 page ,enters billing user first name,last name and billingg addres with phone number
	    	 WebElement billingAddress = driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));
	    	 
	    	 if(billingAddress.isDisplayed()) {    		  
	    		 WebElement billingName = driver.findElement(By.id("billingFirstName"));
	    		 if(billingName.isDisplayed()) {
	    			 
				    	Thread.sleep(1000);		    	
				        cp.setBillingFName();		
				        logger.info("Entered fname");
				        
				        Thread.sleep(1000);		
				        cp.setBillingLName();		
				        logger.info("Entered lname");	
				        
				        // enters billing address 
				        billingDetailsOnly();	
				        
				        cp.setBillingPhoneNum();		
				        logger.info("Entered phone number");		        
				        Thread.sleep(2000);
	    		 }
	    	 }	        
	    }
	    
	    public void clickOnContinueBilling(checkOutPage cp) throws InterruptedException {
	    	
	    	//if payment button is available then  then it clicks on payment button	    	
	        List<WebElement> paymentButton = driver.findElements(By.cssSelector(".submit-shipping"));
	        if(paymentButton.size()>0 ) {
	        	 Thread.sleep(2000);	        	
	        	 WebElement paymentButtonEnable = driver.findElement(By.cssSelector(".submit-shipping"));
	        	 if(paymentButtonEnable.isEnabled()) {
			        cp.clickpaymentbutton(driver);
			        logger.info("Clicked on the payment button");
	        	 }
		       
	        }

	        // As we are taking the address from google suggestions ,for some Address we don't have city to resolve the city error we are changing the the address 
	        
	        List<WebElement> errorMessageInvalidCityList = driver.findElements(By.xpath("//div[@id='defaultCity']"));
	        
	        if(errorMessageInvalidCityList.size()>0) { 
	        	
		        WebElement errorMessageInvalidCity = driver.findElement(By.xpath("//div[@id='defaultCity']"));
		        
		        if(errorMessageInvalidCity.isDisplayed()) {
		        	
		        boolean isDisplayedinvalidcity = errorMessageInvalidCity.isDisplayed();
		        test.info("The error is " + errorMessageInvalidCity.getText() );

			        if(isDisplayedinvalidcity) {
			        	test.info("User entered the wrong city and we are entering the new address");
			        	test.pass("User entered the wrong city and we are entering the new address");         
			            logger.info("User entered the wrong city and we are entering the new address");
			            
			            shippingAddressDetailsOnly();
			            
			            cp.clickpaymentbutton(driver);
			            logger.info("Clicked on the payment button 2nd time");
			        }
		       }
		        
		    } 
	     
	    }
	    
	  public void shippingAddressDetailsWithName(checkOutPage cp) throws InterruptedException {
		  
		  //this method send the shipping first name,last name and address details , phonenumber by checking the display of firstname 
			  Thread.sleep(1000);	
			  WebElement firstName = driver.findElement(By.xpath("//input[@id='shippingFirstNamedefault']"));
			  
			if(firstName.isDisplayed()) {
			//	test.info("Adding New address though having the address");
		        cp.setFisrtName(fname);	
		        logger.info("Entered shipping fname");
		        test.info("Entered shipping fname");
		        
		        Thread.sleep(1000);	
		        cp.setLastname(lname);		        
		        logger.info("Entered shipping lname");
		        test.info("Entered shipping lname");
		     
		        //enters shpping address
		        shippingAddressDetailsOnly();
		        
		        Thread.sleep(2000);	
		        cp.setPhone(phonenumber);		        
		        logger.info("Entered phone number");
		        test.info("Entered phone number");
		        Thread.sleep(2000);   
		        
			}/*else {
				
				List<WebElement> firstNameList = driver.findElements(By.xpath("(//input[@class='form-control shippingFirstName'])[2]"));
				if(firstNameList.size()>0) {
					//first name
					WebElement firstName1 = driver.findElement(By.xpath("(//input[@class='form-control shippingFirstName'])[2]"));
					if(firstName1.isDisplayed()) {
						firstName1.sendKeys("Akhila");
						
						//last name
						WebElement lastName1 = driver.findElement(By.xpath("(//input[@class='form-control shippingLastName'])[2]"));
						lastName1.sendKeys("Akhila");
						
						//address at enter adddress button
						WebElement addressAtEnterAddress = driver.findElement(By.xpath("(//input[@class='form-control shippingAddressOne pac-target-input'])[2]"));
						
					
						int randomNumber = 456; // Generates a random number between 100 and 999     random.nextInt(900) + 100
						address = String.valueOf(randomNumber);
						
						addressAtEnterAddress.sendKeys(address);
						Thread.sleep(1000);
						//to perform the keyboard activities
						WebElement shipping = driver.switchTo().activeElement(); 
			          
						Thread.sleep(1000);
						shipping.sendKeys(Keys.ARROW_DOWN);
			                  
						shipping.sendKeys(Keys.ENTER);
						
						//address at enter adddress button
						WebElement phoneNumber = driver.findElement(By.xpath("(//input[@class='form-control shippingPhoneNumber'])[2]"));
						phoneNumber.sendKeys("9876543212");
					}
				}
			}*/
	  }
	  
		  public void shippingAddressDetailsOnly() throws InterruptedException{
			  
			  //to get the random address -by sending the 3 numbers to address element for shipping address
			  
			  WebElement shippingAddress = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));
	      	
	      	  Random random = new Random();
	      	  
	          int randomNumber =  random.nextInt(900) + 100; // Generates a random number between 100 and 999     
	          address = String.valueOf(randomNumber);
	          Thread.sleep(1000);
	          shippingAddress.sendKeys(address);
	          
	          //to perform the keyboard activities
	          WebElement shipping = driver.switchTo().activeElement(); 
	          
	          Thread.sleep(1000);
	          shipping.sendKeys(Keys.ARROW_DOWN);
	          
	         // Thread.sleep(1000);
	          //shipping.sendKeys(Keys.ARROW_DOWN);
	          shipping.sendKeys(Keys.ENTER);
	          
	          System.out.println("The address entered is " +shipping.getText());
	          logger.info("Entered shipping address");
	          test.info("Entered shipping address");
		  
		  }
		  
		  public void billingDetailsOnly() throws InterruptedException {
			
			  	//to get the random address -by sending the 3 numbers to address element for billing address
			  	WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));		
			  
		        Random random = new Random();
		        
		        int randomNumber =567; // Generates a random number between 100 and 999		
		        //random.nextInt(900) + 100
		        address = String.valueOf(randomNumber);		
		        		
		        Address1.sendKeys(address);	
		        
		        //to perform the keyboard activities
		        WebElement Address11 = driver.switchTo().activeElement();
		        Thread.sleep(1000);
		        
		        Address11.sendKeys(Keys.ARROW_DOWN);		
		        Thread.sleep(1000);	
		        
		        Address11.sendKeys(Keys.ARROW_DOWN);		
		        Address11.sendKeys(Keys.ENTER);		
		        Thread.sleep(2000);	
		  }
		  
		  public void saveTheShippingAddress() {
			  
			  //if user is registered and entered new address then if user want to save the address then below condition executes
			  List<WebElement> saveShippingAddressList = driver.findElements(By.id("addShippingAddressToMyAccount-single-shipping"));
			  
			  if(saveShippingAddressList.size()>0) {
				  
					  WebElement saveShippingAddress = driver.findElement(By.id("addShippingAddressToMyAccount-single-shipping"));
					  
					  if(saveShippingAddress.isDisplayed()) {
						  
						  js.executeScript("arguments[0].click();",saveShippingAddress);
					  }
			  }

		  }	
		  
		  public void addNewAddress(checkOutPage cp) throws InterruptedException {
			  //though user have address 
			  WebElement addNewAddress = driver.findElement(By.xpath("(//button[contains(@class,'btn-add-new')])[1]"));
	      	if(addNewAddress.isDisplayed()) {
	      		JavascriptExecutor js = (JavascriptExecutor) driver;
	  	    	js.executeScript("arguments[0].click();",  addNewAddress);		
	  	    	
	  	    	//shipping address with name 
	  	    	shippingAddressDetailsWithName(cp);
	  	    	
	      	}
		  }
}
