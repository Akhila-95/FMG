package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class checkOutPage {
    WebDriver lDriver;
	
    //pageFactory constructor for this page
	public checkOutPage(WebDriver rDriver ){
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//Check out page xpaths, actionMethods and passing data values
	
	//shippingMethods
	@FindBy(xpath = "(//span[contains(text(),'Ground')])[1]")
	WebElement GroundElement;
	public void clickOnGround() throws InterruptedException{
		Thread.sleep(1000);
		GroundElement.click();
	}
	
	//shipping method for express
	@FindBy(xpath = "(//span[contains(text(),'Express')])[1]")
	WebElement ExpressElement;
	public void clickOnExpress() throws InterruptedException{
		Thread.sleep(1000);
		ExpressElement.click();
	}
	
	//usps
	@FindBy(xpath = "(//span[contains(text(),'Ground')])[1]")
	WebElement USPS_Element;
	public void clickOnUSPS() throws InterruptedException{
		Thread.sleep(1000);
		USPS_Element.click();
	}
	

	
	//ShippingDetails
	//FirstName
	@FindBy(xpath="//input[@id='shippingFirstNamedefault']")
	WebElement FirstName;
	public void setFisrtName(String fname ){	
		FirstName.clear();
		FirstName.sendKeys(fname);
        
	}

	//LastName
	@FindBy(xpath="//input[@id='shippingLastNamedefault']")
	WebElement LastName;
	public void setLastname(String lname ){
		LastName.clear();
		LastName.sendKeys(lname);
	}
	
	//Address is we are entering the google when we need the each column that time need each element
	
	//Address1 
	@FindBy(css="#shippingAddressOnedefault")
	WebElement Address1;
	public void setAddress1(String address ){
		Address1.clear();
		Address1.sendKeys(address);
	}
	
	//city
	@FindBy(xpath="//input[@id ='shippingAddressCitydefault']")
	WebElement city;
	public void setcity(String cityname ){
		city.clear();
		city.sendKeys(cityname);
	}	
	//Country
	@FindBy(xpath="//select[@id='shippingCountrydefault']")
	WebElement Country;
	public void setCountry() throws InterruptedException{
		 Select countrySelect = new Select(Country);
	        countrySelect.selectByIndex(1);
	        Thread.sleep(1000);
	}
	
	//Province
	@FindBy(xpath="//select[@id='shippingStatedefault']")
	WebElement Province;
	public void setProvince(){
		Select ProvinceSelect = new Select(Province);
        ProvinceSelect.selectByIndex(3);
	}
	
	//zipCode
	@FindBy(xpath="//input[@id='shippingZipCodedefault']")
	WebElement zipCode;
	public void setzipCode(String zipcode){	
		zipCode.clear();
		zipCode.sendKeys(zipcode);
	}
	
	//Phone
	@FindBy(css="#shippingPhoneNumberdefault")
	WebElement Phone;
	public void setPhone(String phonenumber ) throws InterruptedException{		
		 Thread.sleep(1000);
		 Phone.sendKeys("9876543212");
	}
	
	
	//For generating the fake data for the input fields
	Faker faker =new Faker();
	//billing address when we add GC to cart
	//Billing address firstName
	@FindBy(id="billingFirstName")
	WebElement billingFName;
	public void setBillingFName() {
	   String yoursFakeName = faker.name().firstName();
	   billingFName.sendKeys(yoursFakeName);
	}
	//Billing address lastName
	@FindBy(id="billingLastName")
	WebElement billingLName;
	public void setBillingLName() {
		   String yoursFakeName = faker.name().lastName();
		   billingLName.sendKeys(yoursFakeName);
	}
		
	//billing address address column
	@FindBy(id="billingAddressOne")
	WebElement billingAddress;
	
	//Billing Phone Number
	@FindBy(id="phoneNumber")
	WebElement phoneNumber;
	public void setBillingPhoneNum() {
		   String phoneNum = "9876543212";
		   phoneNumber.sendKeys(phoneNum);
	}
	
	//buttonforthepaymentpage
	@FindBy(className ="submit-shipping")
	WebElement continueButton;
    public void clickpaymentbutton(WebDriver driver) throws InterruptedException {
    	if(continueButton.isDisplayed()) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueButton);
	        js.executeScript("arguments[0].click();", continueButton);
	        Thread.sleep(5000);
    	}/*if(paymentbutton.isDisplayed()) {
    		paymentbutton.click();
    	}*/
    }
    
    //add to my address when register user is check out
    @FindBy(xpath = "(//input[@id='addShippingAddressToMyAccount'])[1]")
	WebElement addToMyAddress;
    public void clickaddToMyAddress(WebDriver driver) throws InterruptedException {
    	addToMyAddress.click();
        Thread.sleep(5000);
    }

}
