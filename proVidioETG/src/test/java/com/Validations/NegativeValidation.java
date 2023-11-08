package com.Validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.checkOutPage;
import com.PageObjects.guestUserLoginPage;
import com.PageObjects.reviewOrderPage;
import com.testcases.baseClass;

public class NegativeValidation extends baseClass {
    public static void guestEmail() throws InterruptedException {
        guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
        
        // Click on the 'Continue as guest' button
        guestLoginPage.clickOnContinueAsGuest();
        Thread.sleep(2000);
        // Find and check the error message for the required email field
        WebElement errorMessageReqField = driver.findElement(By.xpath("//div[text()='This field is required.']"));
        boolean isDisplayedReqField = errorMessageReqField.isDisplayed();
        logger.info(isDisplayedReqField);
        
        // Check if the error message is displayed and log the result
        if (isDisplayedReqField) {
            test.pass("The user did not enter the email and clicked the guest checkout, and the error is displayed");
            logger.info("The user did not enter the email and clicked the guest checkout, and the error is displayed");
        } else {
            test.fail("The user did not enter the email and clicked the guest checkout, and the error is not displayed");
            logger.info("The user did not enter the email and clicked the guest checkout, and the error is not displayed");
        }
    }

    public static void shippingDetails() throws InterruptedException {
        // Refresh the page
        driver.navigate().refresh();

        checkOutPage cp = new checkOutPage(driver);
        cp.clickContinueBillingbutton(driver);
        
        // Find error messages for various shipping details
        WebElement firstNameError = driver.findElement(By.xpath("//div[contains(text(),'Please enter a First name')]"));
        WebElement lastNameError = driver.findElement(By.xpath("//div[contains(text(),'Please enter a Last name')]"));
        WebElement addressError = driver.findElement(By.xpath("//div[contains(text(),'Please enter Address information')]"));
        WebElement stateError = driver.findElement(By.xpath("//div[contains(text(),'Please select a State')]"));
        WebElement cityError = driver.findElement(By.xpath("//div[contains(text(),'Please enter a City')]"));
        WebElement zipcodeError = driver.findElement(By.xpath("(//div[contains(text(),'Please enter a valid ZIP / Postal')])[1]"));
        WebElement phoneNumError = driver.findElement(By.xpath("//div[contains(text(),'Please enter a Phone Number.')]"));
        
        // Check if all error messages are displayed and log the result
        if (firstNameError.isDisplayed() && lastNameError.isDisplayed() && addressError.isDisplayed() && stateError.isDisplayed() && cityError.isDisplayed() && zipcodeError.isDisplayed() && phoneNumError.isDisplayed()) {
            test.pass("Successfully error message is displayed when empty text is given");
        } else {
            test.fail("No error message is displayed when empty text is given");
        }
    }

    public static void creditCardDetails() throws InterruptedException {
        // Review order page
        reviewOrderPage rop = new reviewOrderPage(driver);
        Thread.sleep(4000);
        rop.clickonReviewOrder(driver);
        
        // Find and check the error message for the required credit card details
        WebElement errorMessageCreditCartReqField = driver.findElement(By.xpath("//div[@id='braintreeCreditCardFieldsContainer']//p[text()='Please enter valid credit card details.']"));
        boolean isDisplayedCreditCardReqField = errorMessageCreditCartReqField.isDisplayed();
        logger.info(isDisplayedCreditCardReqField);
        
        // Check if the error message is displayed and log the result
        if (isDisplayedCreditCardReqField) {
            test.pass("The user did not enter the Credit card details, clicked the guest Next review button, and the error is displayed");
            logger.info("The user did not enter the Credit card details, clicked the guest Next review button, and the error is displayed");
        } else {
            test.fail("The user did not enter the Credit card details, clicked the guest Next review button, and the error is not displayed");
            logger.info("The user did not enter the Credit card details, clicked the guest Next review button, and the error is not displayed");
        }
    }
}
