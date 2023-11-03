package com.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.navigationPage;
import com.PageObjects.productDescriptionPage;
import com.PageObjects.productListingPage;


public class tc__WriteaReview extends baseClass{
	//tc__Login.loginTest tc__LoginSc.verifySuccessfulLogin
	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void writeReview() throws InterruptedException {
		
		if (isLoggedIn) {
            test.info("Test case for the Navigationmenu of Newarrival Page");

       	 //navigates to pdp page randomly
		     //navigationProccess nav = new navigationProccess();
		   //  nav.commonNavigationProccess();
            
            //selecting a random product form the plp 
            selectProductFromListingPage();
            
            List<WebElement> reviewOrder = driver.findElements(By.xpath("//button[contains(@class,'write-review-button')]"));
            
            if(reviewOrder.size()>0) {
            	//reviewYepto();
            }else {
                //write a review
                writeReviewForProduct();
            }
            
            
            

            
		} else {
        Assert.fail("User not logged in");
    }
		
	}
	
	// Step 2: Select a Product from the Listing Page
	private void selectProductFromListingPage() throws InterruptedException {
	    productListingPage plp = new productListingPage(driver);
	    plp.selectProductRandom(driver);
	    logger.info("Clicked on a product from the listing page");
	    
	    //validate the product selected
	    validateproductselect();
	}

	private void validateproductselect() {
			
			//validate the product is selected
			test.info("verify that product is selected");
			
	        WebElement pdpHeader = driver.findElement(By.xpath("//h1[@class ='product-name hidden-sm-down']"));
	        boolean pdpHeaderDisplayed = pdpHeader.isDisplayed();  
	
	        if (pdpHeaderDisplayed) {
	            test.pass("Successfully clicked on the product from the product listing page");
	            logger.info("Successfully clicked on the product from the product listing page");
	        } else {
	            test.fail("Product is not selected from the product listing page");
	            logger.info("Product is not selected from the product listing page");
	        }
			 
		}
	
	// Step 4: Write a Review for the Product
		private void writeReviewForProduct() throws InterruptedException {
		    productDescriptionPage pdp = new productDescriptionPage(driver);
		    pdp.clickOnWriteAReviewAtTop(driver);
		    logger.info("Clicked on Write a Review at the top");
		    pdp.clickOnRating(driver);
		    logger.info("Clicked on Rating");
		    pdp.clickOnReviewHeadline(driver, headline);
		    logger.info("Entered Review Headline");
		    pdp.clickOnComments(comment);
		    logger.info("Entered Comments");
		    pdp.clickOnYes();
		    logger.info("Clicked on Yes");
		    pdp.clicknickName(nickName);
		    logger.info("Entered Nickname");
		    pdp.clickOnLoc(location);
		    logger.info("Entered Location");
		    pdp.clickOnSubmitReview(driver);
		    logger.info("Clicked on Submit Review");
		    Thread.sleep(2000);
		    // Add any additional steps for writing a review
		    validateReviewProduct();
		    
		    pdp.clickOncontinueShoping(driver);
		    logger.info("clicked on the clickOncontinueShoping button");
		}
		
		private void validateReviewProduct() {
			
			test.info("validate the Review of the product");
			// Find the element using XPath
			WebElement thankYouText = driver.findElement(By.xpath("//h1[contains(text(), 'Thank you!')]"));
			// Get the text value of the element
			String actualText = thankYouText.getText();
			// Define the expected text
			String expectedText = "Thank you!";
			// Validate if the text is displayed using a basic if condition
			if (actualText.equals(expectedText)) {
			    logger.info("The 'Thank you!' text is displayed on the page.");
			    test.pass("successfully writen the review");
			} else {
			    logger.info("The 'Thank you!' text is not displayed on the page.");
			    test.fail("Review is not done");
			}	
		}
		
		/*private void reviewYepto() throws InterruptedException {
			
			productDescriptionPage pdp = new productDescriptionPage(driver);
			
			pdp.clickOnReviewButton(driver);
			
			pdp.clickOnReviewStar(driver);
			
			pdp.sendReviewtitle(driver);
			
			pdp.sendReviewdescription(driver);
			
			pdp.sendReviewUserName(driver);
			
			pdp.sendReviewEmail(driver);
			
			pdp.clickOnReviewpost(driver);
			
		}*/

}
