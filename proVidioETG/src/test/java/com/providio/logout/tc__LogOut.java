package com.providio.logout;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PageObjects.homePage;
import com.PageObjects.logOut;
import com.PageObjects.loginPage;
import com.PageObjects.profilePage;
import com.testcases.baseClass;

 

public class tc__LogOut extends baseClass {

    SoftAssert softAssert = new SoftAssert();

    @Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void Logout() throws InterruptedException {
        if (isLoggedIn) {
        	//clicking on logo to get back to home page
	       	 homePage homePage = new  homePage(driver);
	       	 homePage.clickOnLogo();
	        	
	      // Create an instance of the "loginPage" class
	         loginPage lp = new loginPage(driver);        
	         
	         lp.hoverOnCreateloginAcc(driver);
	         logger.info("Hover on create and login account");
            logOut lo = new logOut(driver);
            logger.info("Hovered the myaccout");
            Thread.sleep(10000L);
            lo.clicklogout(driver);
            logger.info("clicked the logout button and successfully logged out");
            String expectedTitlelogout = "Sites-fireMountainGems-Site";
            String actualTitlelogout = driver.getTitle();
            if (actualTitlelogout.equals(expectedTitlelogout)) {
                test.pass("Successfully clicked on the Logout button");
                logger.info("User logged out successfully");
            } else {
                test.fail("The page Title does not match expected " + expectedTitlelogout + " but found " + actualTitlelogout);
                logger.info("Click failed");
            }

 

            // Assert all the soft assertions
            softAssert.assertAll();
        } else {
            Assert.fail("User not logged in");
        }
    }
}

 