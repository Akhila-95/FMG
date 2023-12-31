package com.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.miniCartPage;
import com.testcases.baseClass;

public class miniCartAndCartValidation extends baseClass {

	
		public void validateMiniCartClick() throws InterruptedException {
	    	
	    	test.info("Verify the  hover on cart button");
	    	
	        WebElement minicart = driver.findElement(By.xpath("(//h1)[1]"));
	        String actualTitleofminicart = minicart.getText();
	        String expectedTitleminicart = "Your shopping cart";
	        Thread.sleep(2000);
	        logger.info(minicart.getText());
	        if (actualTitleofminicart.equals(expectedTitleminicart)) {
	            test.pass("Hovered on minicart");
	            logger.info("Hovered on minicart");

	        } 
	        
	        test.info("Verify the display of viewcart, checkout are displayed");
	        List<WebElement> productsinthecart = driver.findElements(By.cssSelector("div.total-products"));

	        List<WebElement> viewcarButtonList = driver.findElements(By.xpath("(//a[contains(text(),'View Cart')])[1]"));
	        List<WebElement> checkOutNowList= driver.findElements(By.xpath("//a[contains(text(),'Check Out Now')]"));
	        if(viewcarButtonList.size()>0) {
		        WebElement viewcarButton = driver.findElement(By.xpath("(//a[contains(text(),'View Cart')])[1]"));
		        boolean displayViewcart = viewcarButton.isDisplayed();
		        logger.info(displayViewcart);
		        
		        if(checkOutNowList.size()>0) {
			        WebElement checkOutNow= driver.findElement(By.xpath("//a[contains(text(),'Check Out Now')]"));
			        boolean displaycheckOut = checkOutNow.isDisplayed();
			        logger.info(displaycheckOut);
			        
			        if(displayViewcart && displaycheckOut ) {        	
					        	test.pass("Successfully displayed the viewcart, checkout, and products, The number of products are: "+ productsinthecart.size());
					            logger.info("Successfully displayed the viewcart, checkout,  and products");
					        	
					        }else {
					            test.fail(" Not displayed the viewcart, checkout, paypal buttons and products");
					            logger.info("Not displayed the viewcart, checkout, paypal buttons and products");
					        }
					
			        //price in cart 
			        WebElement priceInCart = driver.findElement(By.xpath("//div[@class='price']//b"));
			        test.info("The price in cart is " + priceInCart.getText());
		        }
	        }
	    }

	    public void validateViewCartClick() throws InterruptedException {
	    	   Thread.sleep(1000);
	        List<WebElement> viewcartList = driver.findElements(By.xpath("//h1[contains(text(),'Your Shopping Cart')]"));
	        if(viewcartList.size()>0) {
	        	test.info("Verify the view-cart button is clicked");
		        WebElement viewcart = driver.findElement(By.xpath("//h1[contains(text(),'Your Shopping Cart')]"));
		        String actualTitleofviewcart = viewcart.getText();
		        String expectedTitleviewcart = "Your Shopping Cart";
		        logger.info(viewcart.getText());
		     
		        if (actualTitleofviewcart.equals(expectedTitleviewcart)) {
		            test.pass("Successfully clicked on the view cart button and the messgae displayed is " +viewcart.getText());
		            logger.info("Successfully clicked on the view cart button");
		        } else {
		           // test.fail("Clicked failed on the view cart button");
		            logger.info("Clicked failed on the view cart button");
		        }	   
	        }
	    }

	    
	    public void validateCheckoutafterClick() {
	    	
	        List<WebElement> checkoutPaginationList = driver.findElements(By.xpath("//h2[contains(text(),'Returning and New Customers')]"));
	        if(checkoutPaginationList.size()>0) {
	        	test.info("Verify the check out button is clicked");
		        WebElement checkoutPagination = driver.findElement(By.xpath("//h2[contains(text(),'Returning and New Customers')]"));
		        String actualTitleofviewcart = checkoutPagination.getText();
		        String expectedTitleviewcart = "Shipping";
		        logger.info(checkoutPagination.getText());
		        if (actualTitleofviewcart.equals(expectedTitleviewcart)) {
		            test.pass("Successfully clicked on the checkout button button");
		            logger.info("Successfully clicked on the checkout button button");
		        } else {
		            test.fail("Clicked failed on the checkout button button");
		            logger.info("Clicked failed on the checkout button button");
		        }
	        }
	        
	    }
	}

