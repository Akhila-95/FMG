package com.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.productListingPage;
import com.testcases.baseClass;

public class selectingFilterFromPlp extends baseClass{

	public static void selectingFilterisFormplp() throws InterruptedException {
		
		test.info("Select filters form the product listing page");
		productListingPage plp = new productListingPage(driver);
		
		    List<WebElement> enabledColorButtons =  driver.findElements(By.xpath("//li[@class='color-attribute ']//button"));
	        // Collect a list of size buttons
	        List<WebElement> availableSizeButtons =  driver.findElements(By.xpath("//span[@class='size-btn']"));
	        // Collect a list of price range buttons
	        List<WebElement> availablePriceRangeButtons =  driver.findElements(By.xpath("//div[@id='refinement-price']//button"));
	        // Collect a list of brand buttons
	        List<WebElement> availableBrandButtons =  driver.findElements(By.xpath("//div[@id='refinement-brand']//button"));
	        // Collect a list of type buttons
	        List<WebElement> availableTypeButtons =  driver.findElements(By.xpath("//div[@id='refinement-type']//button"));
	        // Collect a list of GPS type buttons
	        List<WebElement> availableGPSTypeButtons =  driver.findElements(By.xpath("//div[@id='refinement-gps-type']//button"));
	        // Collect a list of GPS feature buttons
	        List<WebElement> availableGPSFeatureButtons =  driver.findElements(By.xpath("//div[@id='refinement-features']//button"));
	        // Collect a list of resolution buttons
	        List<WebElement> availableResolutionButtons =  driver.findElements(By.xpath("//div[@id='refinement-resolution']//li/button"));
	        // Collect a list of display size buttons
	        List<WebElement> availableDisplaySizeButtons =  driver.findElements(By.xpath("//div[@id='refinement-resolution']//button"));
	        // Collect a list of pixel resolution buttons
	        List<WebElement> availablePixelResolutionButtons =  driver.findElements(By.xpath("//div[@id='refinement-pixels']//button"));
	        // Collect a list of new arrival buttons
	        List<WebElement> availableNewArrivalButtons =  driver.findElements(By.xpath("//div[@id='refinement-new-arrival']//button"));
	        // Collect a list of type/use buttons
	        List<WebElement> availableTypeUseButtons =  driver.findElements(By.xpath("//div[@id='refinement-type-|-use']//button"));
		
		// color buttons
		if (!enabledColorButtons.isEmpty()) {
            //select the color
			plp.selectColorFormAvaliableColors();
			test.pass("Succesfully selected the color form the prodcut listting page");
			logger.info("Succesfully selected the color form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No enabled color buttons found.");
		}

		// size buttons
		if (!availableSizeButtons.isEmpty()) {
		    // select size
			plp.selectSizeformAvaliableSize();
			test.pass("Succesfully selected the size form the prodcut listting page");
			logger.info("Succesfully selected the size form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available size buttons found.");
		}

		//  price range buttons
		if (!availablePriceRangeButtons.isEmpty()) {
		    // select price
			plp.selectPriceformAvlaiablePriceRange();
			test.pass("Succesfully selected the price form the prodcut listting page");
			logger.info("Succesfully selected the price form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available price range buttons found.");
		}

		//  brand buttons
		if (!availableBrandButtons.isEmpty()) {
		    // select brand
			plp.selectbrandfromAvaliableBrand();
			test.pass("Succesfully selected the brand form the prodcut listting page");
			logger.info("Succesfully selected the brand form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available brand buttons found.");
		}

		//  type buttons
		if (!availableTypeButtons.isEmpty()) {
		    // select type
			plp.selectTypeformAvaliableType();
			test.pass("Succesfully selected the type form the prodcut listting page");
			logger.info("Succesfully selected the type form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available type buttons found.");
		}

		//  GPS type buttons
		if (!availableGPSTypeButtons.isEmpty()) {
		    // select gps type
			plp.selectGpsTypeformAvaliableType();
			test.pass("Succesfully selected the GPS type form the prodcut listting page");
			logger.info("Succesfully selected the GPS type form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available GPS type buttons found.");
		}

		// GPS feature buttons
		if (!availableGPSFeatureButtons.isEmpty()) {
		    // select features
			plp.selectFeaturesformAvaliableFeatures();
			test.pass("Succesfully selected the feature form the prodcut listting page");
			logger.info("Succesfully selected the feature form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available GPS feature buttons found.");
		}

		// resolution buttons
		if (!availableResolutionButtons.isEmpty()) {
		    // select resolution
			plp.selectResolutionformAvaliableResolution();
			test.pass("Succesfully selected the resolution form the prodcut listting page");
			logger.info("Succesfully selected the resolution form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available resolution buttons found.");
		}

		// display size buttons
		
		if (!availableDisplaySizeButtons.isEmpty()) {
		    // select display size
			plp.selectDisplaySizeformAvaliableDisplaySizes();
			test.pass("Succesfully selected the display size form the prodcut listting page");
			logger.info("Succesfully selected the display size form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available display size buttons found.");
		}

		// pixel resolution buttons
		if (!availablePixelResolutionButtons.isEmpty()) {
		    // select pixels
			plp.selectPixelsformAvaliablePixels();
			test.pass("Succesfully selected the pixel form the prodcut listting page");
			logger.info("Succesfully selected the pixel form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available pixel resolution buttons found.");
		}

		// new arrival buttons
		if (!availableNewArrivalButtons.isEmpty()) {
		    // select new arrival
			plp.selectNewArrivalsformAvaliableNewArrivals();
			test.pass("Succesfully selected the new arrival form the prodcut listting page");
			logger.info("Succesfully selected the new arrival form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available new arrival buttons found.");
		}

		// type/use buttons
		if (!availableTypeUseButtons.isEmpty()) {
		    // select type use button
			plp.selectTypeUseformAvaliableTypeUse();
			test.pass("Succesfully selected the type/use form the prodcut listting page");
			logger.info("Succesfully selected the type/use form the prodcut listting page");
			Thread.sleep(3000);
		} else {
		    logger.info("No available type/use buttons found.");
		}

		
		//After selecting filters click on reset button

		//plp.selecttheResetButton();
	}

}
