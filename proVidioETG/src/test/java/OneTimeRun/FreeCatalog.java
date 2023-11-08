package OneTimeRun;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.PageObjects.AddressDetails;
import com.commonfunctionality.addtoCartValidation;
import com.github.javafaker.Faker;
import com.launchingbrowser.launchBrowsering;
import com.testcases.baseClass;

public class FreeCatalog extends baseClass{
@Test
	public void freeCatalog() throws InterruptedException {
		
	
	//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
			
	//free catalog		
			WebElement clickOnFreeCatalog= driver.findElement(By.xpath("//span[@class='font-semibold']"));
			clickOnFreeCatalog.click();
			
	// free catalog
			freeCatalogPage();
	
	        
	}

	public void freeCatalogPage() throws InterruptedException {
		test.info("Verifying the pagination of free Catalog"); 
		//pagination of freecatalog
		WebElement catalogPage= driver.findElement(By.xpath("//div[@class='editorialRichText-component-container custom-h1  ']"));
		String expectedCatalogName= catalogPage.getText();
		System.out.println(expectedCatalogName);
		String actualCatalogName = "Free Jewelry Maker's Catalog";
		
		if(expectedCatalogName.equals(actualCatalogName)) {
			test.pass("Succesfully navigated to catalog page");
		}else {
			test.pass("Pagination failed to catalog page");
		}
		
		
		Faker faker = new Faker();
		// Fill in the First Name field
		String firstName = faker.name().firstName();
        WebElement firstNameField = driver.findElement(By.id("first_name"));
        firstNameField.sendKeys(firstName);
        test.info("Entered first name");

        // Fill in the Last Name field
        String lastName = faker.name().lastName();
        WebElement lastNameField = driver.findElement(By.id("last_name"));
        lastNameField.sendKeys(lastName);
        test.info("Entered last name");

        // Fill in the Company Name field
        String companyName = faker.company().name();
        WebElement companyNameField = driver.findElement(By.name("00NDK00000EcUxW"));
        companyNameField.sendKeys(companyName );
        test.info("Entered comapany name");

      
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("window.scrollBy(0,400)", "");
     
     // Fill in the Street field calling the address
        AddressDetails address = new  AddressDetails();
        address.addressDetails();
        test.info("Entered address");
        
    
        // Fill in the Email field
        String fakeEmail ="akhila.v1";
        String email = fakeEmail+ "@etg.digital";
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);	
        test.info("Entered email id");
        
        //requestCatalog
        WebElement requestCatalog = driver.findElement(By.xpath("//button[contains(text(),'Request Catalog')]"));
        requestCatalog.click();
        test.info("Submitted the request");
        
        
        addtoCartValidation.validatingFreeCatalog(driver);
	}
}
