package OneTimeRun;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.PageObjects.AddressDetails;
import com.github.javafaker.Faker;
import com.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class WholesaleProgram extends baseClass{

	//@Test
	public void wholesaleProgram() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		//clicks on wholeprogram
		WebElement wholesaleProgram= driver.findElement(By.xpath("//a[contains(text(),'Wholesale Program')]"));
		wholesaleProgram.click();
		
		//fill the form with faker data
		Faker faker = new Faker();
		
		
		// Fill in the First Name field
		String firstName = faker.name().firstName();
        WebElement firstNameField = driver.findElement(By.id("first_name"));
        firstNameField.sendKeys(firstName);

        // Fill in the Last Name field
        String lastName = faker.name().lastName();
        WebElement lastNameField = driver.findElement(By.id("last_name"));
        lastNameField.sendKeys(lastName);

        // Fill in the Company Name field
        String companyName = faker.company().name();
        WebElement companyNameField = driver.findElement(By.name("00NDK00000EcUxW"));
        companyNameField.sendKeys(companyName );

        // Select "Vendor at Shows and Craft Fairs" in the Type of Company dropdown
        WebElement companyTypeDropdown = driver.findElement(By.name("00NDK00000EBOqo"));
        companyTypeDropdown.sendKeys("Vendor at Shows and Craft Fairs");

        // Fill in the Street field calling the address
        AddressDetails address = new  AddressDetails();
        address.addressDetails();

        
        // Fill in the Phone field
        WebElement phoneField = driver.findElement(By.id("phone"));
        phoneField.sendKeys("5623-456-7890");

        // Fill in the Email field
        String fakeEmail ="akhila.m";
        String email = fakeEmail+ "@etg.digital";
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
        
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("window.scrollBy(0,400)", "");
        
        
        // Find all radio buttons by the same name attribute randomly selects the radio button
        List<WebElement> radioButtons = driver.findElements(By.name("00NDK00000EBOqy"));

        // Generate a random index to select a radio button
        int randomIndex = new Random().nextInt(radioButtons.size());

        // Click the randomly selected radio button
        Thread.sleep(1000);
      //  radioButtons.get(randomIndex).click();

        // Fill in the Annual Spend on Jewelry Supplies field
        WebElement annualSpendField = driver.findElement(By.name("00NDK00000EBOr3"));
        annualSpendField.sendKeys("$10,000");
       


        // Fill in the What kind of jewelry supplies field
        WebElement suppliesInquiryField = driver.findElement(By.name("00NDK00000EBlqM"));
        suppliesInquiryField.sendKeys("I'm interested in beads and gemstones.");

        // Fill in the Website Address field
        WebElement websiteField = driver.findElement(By.name("url"));
        websiteField.sendKeys("https://example.com");

        // Fill in the Additional Notes field
        WebElement additionalNotesField = driver.findElement(By.name("00NDK00000EBOrD"));
        additionalNotesField.sendKeys("Please send a catalog as well.");
/*
        // Check "Signup for Email Specials and Industry Expert News" checkbox
        WebElement newsletterCheckbox = driver.findElement(By.name("00NDK00000EBOqj"));
        newsletterCheckbox.click();

        // Check "Receive a FREE Catalog" checkbox
        WebElement catalogCheckbox = driver.findElement(By.name("00NDK00000EBPrr"));
        catalogCheckbox.click();*/

        // Perform any necessary actions for the reCAPTCHA (if used)
        js.executeScript("window.scrollBy(0,800)", "");
        
        WebElement recaptcha = driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));
        recaptcha.click();
        
        // Submit the form
       
    	
        WebElement submitButton = driver.findElement(By.cssSelector(".btn-form-submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
	}
	
	
}
