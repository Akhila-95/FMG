package com.providio.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.providio.Validations.Checkout_Validation;
import com.providio.testcases.baseClass;

public class paymentpPage extends baseClass {
	
WebDriver lDriver;
	
	public paymentpPage(WebDriver rDriver ){

		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	//BrainTree credit card  of xpaths, actionMethods and passing card details
	//braintree newcarddropdown 
	@FindBy(xpath ="//select[@id='braintreeCreditCardList']")
    WebElement newcard;
	public void selectnewcardindropdown() throws InterruptedException {
    Select newcardselect = new Select(newcard);
    newcardselect.selectByIndex(0);
    Thread.sleep(3000);
    
	}
	//Braintree cardname
	@FindBy(xpath ="//input[@id = 'cardholder-name']")
	WebElement entercname;
    public void setcardholdername(WebDriver driver) throws InterruptedException {
    	Thread.sleep(1000);
    //	if(entercname.isDisplayed()) {
	    	driver.switchTo().frame("braintree-hosted-field-cardholderName");
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercname);
	    	entercname.sendKeys("Test123");
	    	driver.switchTo().defaultContent();
    	///}
    }
    //Braintree cardnumber 
	@FindBy(xpath ="//input[@id = 'credit-card-number']")
	WebElement entercnumber;
    public void setcardnumber(WebDriver driver) throws InterruptedException {
    	//if(entercnumber.isDisplayed()) {
	    	driver.switchTo().frame("braintree-hosted-field-number");
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercnumber);
	    	String[] cardNumbers = {
	    			
	               "378282246310005",
	                "371449635398431",
	     	      // "36259600000004",
	     	       //"6011000991300009",
	     	       //"3530111333300000",
	     	      // "6304000000000000",
	     	       "5555555555554444",	        
	     	      "2223000048400011",
	     	     /*
	     	       "4005519200000004",
	     	       "4009348888881881",
	     	       "4012000033330026",
	     	       "4012000077777777",
	     	       "4012888888881881",	        
	     	       "4217651111111119",
	     	       "4500600000000061",*/
	     	       //"6243030000000001",     	     
	     	       //"6223164991230014"
	                // Add more card numbers here
	    			  "4111111111111111"
	            };

    	// Generate a random index to select a card number
		        Random rand = new Random();
		        int randomIndex = rand.nextInt(cardNumbers.length);
		        // Send the randomly selected card number
		        entercnumber.sendKeys(cardNumbers[randomIndex]);
		    	
		    	driver.switchTo().defaultContent();
    	//}
    }
    //Braintree cvv
	@FindBy(xpath ="//input[@id = 'cvv']")
	WebElement entercvv;
    public void setcardcvv(WebDriver driver) throws InterruptedException {
    	//if(entercvv.isDisplayed()) {
	    	driver.switchTo().frame("braintree-hosted-field-cvv");
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  entercvv);
	    	entercvv.sendKeys("7839");
	    	driver.switchTo().defaultContent();
    	//}
    }
    //Braintree exp
	@FindBy(xpath ="//input[@id = 'expiration']")
	WebElement enterexp;
    public void setcardexp(WebDriver driver) throws InterruptedException {	
    	//if(enterexp.isDisplayed()) {
	    	driver.switchTo().frame("braintree-hosted-field-expirationDate");
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",enterexp);
	    	enterexp.sendKeys("1230");
	    	driver.switchTo().defaultContent();
    	//}
    }
    
    //Braintree savecardbutton
	@FindBy(xpath ="//input[@id='braintreeSaveCreditCard']")
	WebElement savebutton;
    public void unchecksavecard(WebDriver driver) throws InterruptedException {	    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", savebutton);	
    }
    
    
    //Cybersource credit card Xpaths, actionMethods and passing the card details
    
    //CyberSource cardNumber
    @FindBy(xpath ="//input[@id ='cardNumber']")
    WebElement newCreditcard;
    public void latestcardnumber(WebDriver driver) throws InterruptedException {	    	
    	String[] cardNumbers = {
   			 	 "4111 1111 1111 1111",
		         "4242 4242 4242 4242",
		        // "5555 5555 5555 4444",
		       //  "5200 8282 8282 8210",
		       //  "3714 4963 539 8431"
               // Add more card numbers here
           };

   	// Generate a random index to select a card number
       Random rand = new Random();
       int randomIndex = rand.nextInt(cardNumbers.length);
       // Send the randomly selected card number
       newCreditcard.sendKeys(cardNumbers[randomIndex]);
        Thread.sleep(2000);
    }
    //CyberSource exp month
    @FindBy(xpath ="//select[@id ='expirationMonth']")
    WebElement newExpmonth;
    public void latestExpDate(WebDriver driver) throws InterruptedException {
    	Select newcardselect = new Select(newExpmonth);
        newcardselect.selectByIndex(9);
        Thread.sleep(3000);

    }
    //CyberSource exp year
    @FindBy(xpath ="//select[@id ='expirationYear']")
    WebElement newExpYear;
    public void latestExpYear(WebDriver driver) throws InterruptedException {	
    	Select newcardselect = new Select(newExpYear);
        newcardselect.selectByIndex(7);
        Thread.sleep(3000);
    }
    //CyberSource cvv
    @FindBy(xpath ="//input[@id ='securityCode']")
    WebElement newSceuritycode;
    public void latestSceuritycode(WebDriver driver) throws InterruptedException {	  
        // Locate the security code element and send the generated code     
        newSceuritycode.sendKeys("4567");
        Thread.sleep(2000);
    }
    
    //cybersource 
  //CyberSource cvv
    @FindBy(xpath ="//button[contains(@class,'add-payment')]")
    WebElement AddpaymentBtn;
    public void cyberAddpaymentBtn(WebDriver driver) throws InterruptedException {	  
    	AddpaymentBtn.click();
        Thread.sleep(2000);
    }
	
    
   //salesForce CreditCard xpaths, actionMethods and passing the details of the card
    
    //SalesForce credit cardName
    @FindBy(xpath ="//input[@autocomplete='cc-number' and @inputmode='numeric']")
    WebElement cardNumber;
    public void cardNumber(WebDriver driver) throws InterruptedException {	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']")));
        Thread.sleep(2000);
        String[] cardNumbers = {

        		"4111 1111 1111 1111",
 		        "4242 4242 4242 4242",
 		        "2223 0031 2200 3222",
 		        "4000 0566 5566 5556",
 		        "5555 5555 5555 4444",
 		        "5200 8282 8282 8210",
 		        "3714 4963 539 8431"

                // Add more card numbers here
            };

    	// Generate a random index to select a card number
        Random rand = new Random();
        int randomIndex = rand.nextInt(cardNumbers.length);

        // Send the randomly selected card number
        cardNumber.sendKeys(cardNumbers[randomIndex]);
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
    
    //SalesForce Exp Date
    @FindBy(xpath ="//input[@autocomplete='cc-exp' and @inputmode='numeric']")
    WebElement expiryDate;
    public void expiryDate(WebDriver driver) throws InterruptedException {		    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
    	expiryDate.sendKeys("1225");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
    //SalesFroce cvv
    @FindBy(xpath ="//input[@autocomplete='cc-csc' and @inputmode='numeric']")
    WebElement cvc;
    public void cvc(WebDriver driver) throws InterruptedException {	  
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure CVC input frame']")));
    	 cvc.sendKeys("123");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
    
    //Salesforce reg credit card button
    @FindBy(xpath="//div[text()='Credit Card']")
    WebElement creditCardBtn;
    public void creditCard(WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", creditCardBtn);
    	//creditCardBtn.click();
    }
    
    
    //Stripe credit card of xpaths, actionMethods and passing the card details
    
    //stripe  CardNumber
    @FindBy(xpath="//input[@autocomplete='cc-number' and @inputmode='numeric']")
    WebElement newCardNumber;
    public void cardNum(WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
        String[] cardNumbers = {

        		"4111 1111 1111 1111",
 		        "4242 4242 4242 4242",
 		        "2223 0031 2200 3222",
 		        "4000 0566 5566 5556",
 		        "5555 5555 5555 4444",
 		        "5200 8282 8282 8210",
 		        "3714 4963 539 8431"

                // Add more card numbers here
            };

    	// Generate a random index to select a card number
        Random rand = new Random();
        int randomIndex = rand.nextInt(cardNumbers.length);

        // Send the randomly selected card number
        newCardNumber.sendKeys(cardNumbers[randomIndex]);
    	 driver.switchTo().defaultContent();
    }
    //stripe exp date
    @FindBy(xpath="//input[@autocomplete='cc-exp' and @inputmode='numeric']")
    WebElement expDate;
    public void expDate(WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
    	newCardNumber.sendKeys("11 33");
    }
    //stripe cvv
    @FindBy(xpath="//input[@autocomplete='cc-csc' and @inputmode='numeric']")
    WebElement cvv;
    public void cvv(WebDriver driver) {
    	newCardNumber.sendKeys("987");
    }
    //stripe postal code
    @FindBy(name="postal")
    WebElement postalCode;
    public void postalCode() {
    	newCardNumber.sendKeys("98777890044");
    	driver.switchTo().defaultContent();
    }
    
    
    //edit the customer details in the payament page
	@FindBy(xpath = "//div[@class='card customer-summary']//button[contains(@class,'edit-button')]")
	WebElement editCustomerElement;
	@FindBy(xpath = "//input[@id='email-guest']")
	WebElement guestEmailElement;
	@FindBy(xpath = "//button[contains(text(),'Continue as guest')]")
	WebElement continueAsGuest;
	@FindBy(xpath = "//button[contains(@class ,'submit-shipping')]")
	WebElement nextPaymentButton;

	//Excuting method of the edit customer details in the payment page
	public void editCustomer(String guestEmail,WebDriver driver) throws InterruptedException {
		editCustomerElement.click();
		guestEmailElement.clear();
		guestEmailElement.sendKeys(guestEmail);
		continueAsGuest.click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nextPaymentButton);
		
	}
	
	//editShipping Method
	public void editShippingMethod(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		editShippingElement.click();
		List <WebElement> editShippingMethod=driver.findElements(By.xpath("(//div[@class='row leading-lines shipping-method-list'])[1]//input[@class='form-check-input']"));
		int  countShippingMethod = editShippingMethod.size();
		

		Random random = new Random();
		int randomRadioButton = random.nextInt(countShippingMethod) + 1;
		WebElement selectShippingMethod =driver.findElement(By.xpath("((//div[@class='row leading-lines shipping-method-list'])[1]//input[@class='form-check-input'])["+randomRadioButton+"]"));
		selectShippingMethod.click();
	}
    
    
    //editing the shipping details form the payment page
	@FindBy(xpath = "//div[@class='card shipping-summary']//button[contains(@class,'edit-button')]")
	WebElement editShippingElement;
	
	//Change the shipping address
	public void shippingDetailsChange() throws InterruptedException {
		//click on the edit button of shipping details in the payment page
		editShippingElement.click();
		
		//change the address of the customer
 	
        WebElement Address1 = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));	
        //Random random = new Random();	
        int randomNumber = 4334; // Generates a random number between 100 and 999	
        address = String.valueOf(randomNumber);	
        Address1.clear();	
        Address1.sendKeys(address);	
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Address11.sendKeys(Keys.ENTER);	
        Thread.sleep(2000);

	}
	
	
	//updating the billing address
	//to upadate the billing address
    @FindBy(xpath="//button[@class='text-center btn-show-details btn mr-2']")
    WebElement updateAddress;
    
    //change the billing address
    public void billingAddressChnge() throws InterruptedException {
   	 //click on the update address
   	 updateAddress.click();
   	 
   	 //change the billing adddress 
        WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));	
        //Random random = new Random();	
        int randomNumber = 4334; // Generates a random number between 100 and 999	
        address = String.valueOf(randomNumber);	
        Address1.clear();	
        Address1.sendKeys(address);	
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Address11.sendKeys(Keys.ENTER);	
        Thread.sleep(2000);
   	 
    }
    
    //addNew address in the payment page
    //add new address
    @FindBy(xpath = "//div[@class='d-flex mt-2']//button[contains(@class,'add-new')]")
    WebElement newAddress;
    //billing first name
    @FindBy(xpath = "//input[@id='billingFirstName']")
    WebElement billingFirstName;
    //billing last name
    @FindBy(xpath = "//input[@id='billingLastName']")
    WebElement billingLastName;
    //adding the new address
    public void newAddress(WebDriver driver,String fName,String lName) throws InterruptedException {
   	 //click on new address in billing
   	 newAddress.click();
   	 billingFirstName.sendKeys(fName);
   	 billingLastName.sendKeys(lName);
   	 WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));	
        //Random random = new Random();	
        int randomNumber = 658; // Generates a random number between 100 and 999	
        address = String.valueOf(randomNumber);	
        Address1.clear();	
        Address1.sendKeys(address);	
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Address11.sendKeys(Keys.ENTER);	
        Thread.sleep(2000);

   	 JavascriptExecutor js = (JavascriptExecutor) driver;
   	 js.executeScript("window.scrollBy(0, 500)");
	}
    
    
  //gift card 
 	@FindBy(xpath="//input[@id='giftCert']")
 	WebElement giftcertificate;
 	//to apply gift card
 	@FindBy(xpath = "//button[@value='submit-gifrcert']")
 	WebElement applyGiftCard;
 	//check gift card bal 
 	@FindBy(xpath = "//button[@value='gift-cert-balance']")
 	WebElement checkGiftcardbal;
 	//applying the gift cart
 	public void applyGiftCertifiate(String giftcard) {
		giftcertificate.sendKeys(giftcard);
		applyGiftCard.click();
	}
 	
 	
 	//paypal Braintree payment process
    public void braintreePaypal(WebDriver driver) throws InterruptedException {
        // Create an instance of Actions class
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", paypal);
        System.out.println("Clicked on paypal icon");
    }
    
    //After the paypal button click
    public void brainTreeAfterClick(WebDriver driver) throws InterruptedException {
        WebElement paypalButton= driver.findElement(By.xpath("//li[@data-method-id='PayPal']"));               
       
       // if(paypalButton.isDisplayed()) {  
        	// click on paypal radio button
        	//paypalButton.click();  
            JavascriptExecutor js = (JavascriptExecutor) driver;  
            WebElement paypalCheckout=driver.findElement(By.xpath("//div[@class='js_braintree_paypal_billing_button']")); 
            if(paypalCheckout.isDisplayed()) {
            	//click on paypal checkout button 
           	   //js.executeScript("arguments[0].click();", paypalCheckout);    
            	paypalCheckout.click();
            	logger.info("A click to Enter into paypal");	
          //  }	                 
         }                 
   }
    

    
    //addpaymentbutton
    @FindBy(xpath ="//button[@class ='btn btn-block add-payment btn-outline-primary']")
    WebElement addPayment;
    public void addPaymentButton(WebDriver driver) throws InterruptedException {	  
    JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].click();", addPayment);
    	//addPayment.click
        Thread.sleep(2000);
    }
    
  //click on review order
    @FindBy(xpath ="//button[@class='btn btn-primary btn-block submit-payment'  and @value='submit-payment']")
	WebElement revieworder;
    @FindBy(xpath ="//button[@class='btn btn-primary btn-block submit-payment'  and @value='submit-payment']")
	List<WebElement> revieworderList;
    public void clickonrevieworder(WebDriver driver) throws InterruptedException {	
    	if(revieworderList.size()>0) {
	    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", revieworder);			    	
	    	Thread.sleep(5000);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click();", revieworder);
	    	Thread.sleep(3000);
	    	if(revieworder.isDisplayed()) {
	    		 Thread.sleep(3000);
		    	revieworder.click();	
		       
	        }
    	}
    }
    
    
    //Place the order for salesforce payment process
    @FindBy(xpath ="//button[@class='btn btn-primary btn-block place-order' and @name='submit' and contains(text(), 'Place Order')]")
    WebElement placetheOrder;
    public void placetheOrder(WebDriver driver) throws InterruptedException {	  
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", placetheOrder);
    	//placetheOrder.click();
        Thread.sleep(2000);
    }
    
    //paypal payment details
    
    @FindBy(xpath = "//li[@data-method-id='PayPal']")
    WebElement paypal;

    @FindBy(xpath = "//div[@aria-label='PayPal Checkout']")
    WebElement  paypalCheckout;

    @FindBy(xpath = "//input[@name='login_email']")
    List<WebElement> emailLogin;

    @FindBy(css = "#btnNext")
    List<WebElement> nextButton;

    @FindBy(xpath = "//input[@id='password']")
    List<WebElement> password;

    @FindBy(xpath = "//button[contains(text(), 'Log In')]")
    List<WebElement> loginbutton;

    @FindBy(xpath = "(//div[@class='FundingInstrument_item_3lQ2z'])[3]")
    WebElement cardParentDiv;
    
    @FindBy(xpath = "changeShippingAddress")
    List<WebElement> changeTheAddressList;

    @FindBy(id = "payment-submit-btn")
    List<WebElement> reviewOrderButton;
    
    @FindBy(xpath = "//button[contains(text(), 'Save and Continue')]")
    List<WebElement> saveAndContinue;
    
    public void paypalPopup(WebDriver driver) throws InterruptedException {
    	
        String mainWindowHandle = driver.getWindowHandle();
        // Switch to the new window by iterating over all available window handles
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
       
         Thread.sleep(4000);
         if(emailLogin.size()>0) {
        	 WebElement  emailLogin1=driver.findElement(By.xpath("//input[@name='login_email']")); 
        	 if(emailLogin1.isDisplayed()) {
	        	 emailLogin1.clear();
	        	 emailLogin1.sendKeys("rahulnaik@etisbew.com");
	        	 test.info("Entered username");
        	 }
         }
         Thread.sleep(3000);
         if(nextButton.size()>0) {
        	 WebElement nextButton1=driver.findElement(By.cssSelector("#btnNext"));
        	 if(nextButton1.isDisplayed()) {
	             nextButton1.click();
	             Thread.sleep(1000);
        	 }
         }
         if(password.size()>0) {
        	 WebElement password1=driver.findElement(By.xpath("//input[@id='password']"));
        	if(password1.isDisplayed()) {
	             password1.sendKeys("Etgsfcc245@");
	             test.info("Entered password");
	             Thread.sleep(1000);
        	}
         }
         if(loginbutton.size()>0) {
        	 WebElement loginbutton1=driver.findElement(By.xpath("//button[contains(text(), 'Log In')]"));
        	 if(loginbutton1.isDisplayed()) {
	             loginbutton1.click();
	             test.info("Clicked on login button");
	             Thread.sleep(1000);
        	 }
         }
         Thread.sleep(2000);
    	 if(saveAndContinue.size()>0) {
    		 WebElement saveAndContinue1=driver.findElement(By.xpath("//button[contains(text(), 'Save and Continue')]"));
    		 if(saveAndContinue1.isDisplayed()) {
    			 JavascriptExecutor js = (JavascriptExecutor) driver;
    			 Thread.sleep(1000);
    		     js.executeScript("arguments[0].click();", saveAndContinue1);
    			 test.info("Clicked on save and  continue");
    		 }
    	 }      
    	 
         driver.switchTo().window(mainWindowHandle);
         Thread.sleep(1000);
         logger.info("Clicked on paypal button");
         
      }          
		    
}
