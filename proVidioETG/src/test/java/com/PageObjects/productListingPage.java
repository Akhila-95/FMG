package com.PageObjects;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Validations.navigationProcessWithValidation;
import com.Validations.validationpopupMessages;
import com.testcases.baseClass;

public class productListingPage extends baseClass{
WebDriver lDriver;


	public productListingPage(WebDriver rDriver ){
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	// Method to add a product to the cart from the Product Listing Page (PLP)
	public void addToCartFromPlp() throws InterruptedException {
	    // Find all color buttons that are enabled
	    List<WebElement> addtoCartBtns = driver.findElements(By.xpath("//a[contains(@class, 'add-to-cart')]"));
	    
	    int displayedAddToCartCount = 0;
	    for (WebElement item : addtoCartBtns) {
	        if (item.isDisplayed()) {
	        	displayedAddToCartCount++;
	        }
	    }

	    // Define the maximum number of products to add
	    int numberofProducts = 4;

	    // Get the count of matched elements and log it.
	    int count = displayedAddToCartCount;
	    logger.info("Total add to cart buttons: " + count);

	    // Create a random number generator.
	    Random random = new Random();

	    // Generate a random number to determine how many products to add (up to the defined maximum)
	    int howmanyProducts = random.nextInt(numberofProducts) + 1;

	    // Loop to add a random number of products to the cart
	    //for (int i = 1; i <= howmanyProducts; i++) {
	        // Generate a random index to select an "Add to Cart" button.
	        int randomNumberAddtoCartBtn = random.nextInt(count) + 1;
	        logger.info("Randomly selected Add to Cart button index: " + randomNumberAddtoCartBtn);

	        // Check if a valid random number was generated.
	        if (randomNumberAddtoCartBtn > 0) {
	            // Find the WebElement based on the random index and click it.
	            WebElement clickAddtoCartBtn = driver.findElement(By.xpath("(//a[contains(@class, 'add-to-cart')])[" + randomNumberAddtoCartBtn + "]"));

//	            // Find the quantity input field associated with the clicked button and set the quantity.
//	            WebElement inctheQuantity = driver.findElement(By.xpath("(//input[@name='quantity'])[" + randomNumberAddtoCartBtn + "]"));
//	            Thread.sleep(2000);
//	            inctheQuantity.clear();
//	            Thread.sleep(2000);
//	            inctheQuantity.sendKeys("5");
	            // Scroll to the "Add to Cart" button and click it.
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	         // Use JavaScript to scroll the element into the middle of the page view
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clickAddtoCartBtn);
	            Thread.sleep(1000);
	            js.executeScript("arguments[0].click();", clickAddtoCartBtn);
	            
	            //clickAddtoCartBtn.click();

	            // Validate that the product is added to the cart
	            validationpopupMessages.validatingProductisAddtoCart(driver);
	        }
	   // }
	}
	
	
	//getting a banner and slecect one
			public void selectHeroBanner() throws InterruptedException {
				List<WebElement> herobanners = driver.findElements(By.xpath("//div[@class='hero-banner']"));
				int count = herobanners.size();
			    logger.info(count);
			    if(count==7) {
			    	count = count-1;
			    	// Create a random number generator.
				    Random random = new Random();
				    // Generate a random index to select a top-level menu item. random.nextInt(count) + 1
				    int herobannerRandNumber =random.nextInt(count) + 1;
				    logger.info(herobannerRandNumber);
				    if(herobannerRandNumber>0){
				    	WebElement clickHeroBanner = driver.findElement(By.xpath("(//div[@class='hero-banner'])[" + herobannerRandNumber + "]"));
				        //clickClp.click();
				        JavascriptExecutor js = (JavascriptExecutor) driver;
				        logger.info("coming here");
				        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickHeroBanner);
				        Thread.sleep(2000);
				        clickHeroBanner.click();
				        //js.executeScript("arguments[0].click();", clickHeroBanner);
				    }
			    }
			}
	
	//qunatity
	
	 // Method to click on increasing quantity
    public void clickInIncreaseQuantity() throws InterruptedException {
    	//input[@name='quantity']
    }
	
	//input[@name='quantity']
	
	//Filters
	//display and hide features of filters
	


    public Pair<String, String> selectCategoryFilter(WebDriver driver) throws InterruptedException {
        String text = null;
        String digits = null;
        
        List<WebElement> categoryFilter = driver.findElements(By.xpath("(//h6[contains(text(),'Category')])[1]"));
        if (categoryFilter.size() > 0) {
            Thread.sleep(2000);
            //element to select the filter
            WebElement parentRefinementCategory = driver.findElement(By.xpath("//div[contains(@class,'refinement-category')]"));
            List<WebElement> refinementCategory = parentRefinementCategory.findElements(By.xpath("//span[@class='refinement-value ']"));
            int refinementCategoryCount = refinementCategory.size();
            System.out.println("Total enabled categories: " + refinementCategoryCount);
            
            if (refinementCategoryCount > 0) {
            	//randomising the filter
	                Random random = new Random();
	                int randomIndex = random.nextInt(refinementCategoryCount);
	                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
	                JavascriptExecutor js = (JavascriptExecutor) driver;
                //click on selected filter
	                js.executeScript("arguments[0].click();", selectedRefinementCategory);
               
                //text of selected filter
	               // Thread.sleep(1000);
	                text = selectedRefinementCategory.getText();            
	              //  logger.info("Selected category filter: " + text);        
                
                //text of digits in  selected filter
	                digits = text.replaceAll("\\D+", "");
	               // logger.info("The count of products during selection of filters: " + digits);
	                
	            //text extracted from the selected filter
	             // Remove the digits from the text
	                text = text.replaceAll("\\(\\d+\\)", "");
	               // System.out.println("Selected category filter without digits: " + text);
	               // System.out.println("Selected category filter name : " + text);
            } else {
                System.out.println("No sub Category Filter found.");
            }
        }
        return Pair.of(text, digits);
    }
	
	//select a color randomly from avaliable colors
	public void selectSubCategoryFilter() {
		
		List<WebElement> subCategoryFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Sub-Category')]"));
		if(subCategoryFilter.size()>0) {
			// Find all color buttons that are enabled
	        WebElement parentRefinementCategory = driver.findElement(By.xpath("//div[contains(@class,'refinement-sub-category')]"));
	        // Count how many are enabled
	        List<WebElement> refinementCategory =parentRefinementCategory.findElements(By.xpath("//span[@class='refinement-value ']"));
	        
	        WebElement filterName =parentRefinementCategory.findElement(By.xpath("//span[@class='refinement-value ']"));
	        String getFilterName = filterName.getText();
	        System.out.println("Selected filter is" +getFilterName);
	        int refinementCategoryCount = refinementCategory.size();
	        logger.info("Total enabled colors: " + refinementCategoryCount);
	        if (refinementCategoryCount>0) {
	            // Generate a random index to select a color
	            Random random = new Random();
	            int randomIndex = random.nextInt(refinementCategoryCount);
	            // Click on a randomly selected color button
	            WebElement selectedrefinementCategory = refinementCategory.get(randomIndex);
	            JavascriptExecutor js = (JavascriptExecutor) driver; 
	            js.executeScript("arguments[0].click();", selectedrefinementCategory);
	            System.out.println("2md "+selectedrefinementCategory.getText());
	            //selectedColorButton.click();
	            // You have now selected a random enabled color
	        } else {
	            logger.info("No sub Category Filter found.");
	        }
		}

	}
	//select a radom price range form the page
	public void selectColorFilter() throws InterruptedException {
		  List<WebElement> colorFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Color')]"));
			if(colorFilter.size()>0) {
				Thread.sleep(2000);
				// Find all color buttons that are enabled
		        WebElement parentRefinementCategory = driver.findElement(By.xpath("//div[contains(@class,'refinement-color')]"));
		        // Count how many are enabled
		        List<WebElement> refinementCategory =parentRefinementCategory.findElements(By.xpath("//span[@class='refinement-value ']"));
		        int refinementCategoryCount = refinementCategory.size();
		        logger.info("Total enabled colors: " + refinementCategoryCount);
		        if (refinementCategoryCount>0) {
		            // Generate a random index to select a color
		            Random random = new Random();
		            int randomIndex = random.nextInt(refinementCategoryCount);
		            // Click on a randomly selected color button
		            WebElement selectedrefinementCategory = refinementCategory.get(randomIndex);
		            JavascriptExecutor js = (JavascriptExecutor) driver; 
		         
		            js.executeScript("arguments[0].click();", selectedrefinementCategory);
		           
		        } else {
		            logger.info("No sub Category Filter found.");
		        }
		}
	}
	
	//select a random brand from the page
	public void selectbrandfromAvaliableBrand() {
		// Find all brand buttons
        List<WebElement> brandButtons = driver.findElements(By.xpath("//div[@id='refinement-brand']//button"));
        // Count how many brands are available
        int brandCount = brandButtons.size();
        logger.info("Total available brands: " + brandCount);
        if (brandCount > 0) {
            // Generate a random index to select a brand
            Random random = new Random();
            int randomIndex = random.nextInt(brandCount);
            // Click on the randomly selected brand button
            WebElement selectedBrandButton = brandButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedBrandButton);
            //selectedBrandButton.click();
            // You have now selected a random brand
        } else {
            logger.info("No available brands found.");
        }
	}
	
	//select a random  type formt the page
	public void selectTypeformAvaliableType() {
		// Find all type buttons
        List<WebElement> typeButtons = driver.findElements(By.xpath("//div[@id='refinement-type']//button"));
        // Count how many types are available
        int typeCount = typeButtons.size();
        logger.info("Total available types: " + typeCount);
        if (typeCount > 0) {
            // Generate a random index to select a type
            Random random = new Random();
            int randomIndex = random.nextInt(typeCount);
            // Click on the randomly selected type button
            WebElement selectedTypeButton = typeButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedTypeButton);
           // selectedTypeButton.click();
            // You have now selected a random type
        } else {
            logger.info("No available types found.");
        }
		
	}
	
	//select a random  type formt the page
	public void selectGpsTypeformAvaliableType() {
		// Find all GPS type buttons
        List<WebElement> gpsTypeButtons = driver.findElements(By.xpath("//div[@id='refinement-gps-type']//button"));
        // Count how many GPS types are available
        int gpsTypeCount = gpsTypeButtons.size();
        logger.info("Total available GPS types: " + gpsTypeCount);
        if (gpsTypeCount > 0) {
            // Generate a random index to select a GPS type
            Random random = new Random();
            int randomIndex = random.nextInt(gpsTypeCount);
            // Click on the randomly selected GPS type button
            WebElement selectedGPSTypeButton = gpsTypeButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedGPSTypeButton);
            //selectedGPSTypeButton.click();
            // You have now selected a random GPS type
        } else {
            logger.info("No available GPS types found.");
        }
		
	}
	
	//select a random features form the page
	public void selectFeaturesformAvaliableFeatures() {
		// Find all GPS feature buttons
        List<WebElement> gpsFeatureButtons = driver.findElements(By.xpath("//div[@id='refinement-features']//button"));
        // Count how many GPS features are available
        int gpsFeatureCount = gpsFeatureButtons.size();
        logger.info("Total available GPS features: " + gpsFeatureCount);
        if (gpsFeatureCount > 0) {
            // Generate a random index to select a GPS feature
            Random random = new Random();
            int randomIndex = random.nextInt(gpsFeatureCount);
            // Click on the randomly selected GPS feature button
            WebElement selectedGPSFeatureButton = gpsFeatureButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedGPSFeatureButton);
            //selectedGPSFeatureButton.click();
            // You have now selected a random GPS feature
        } else {
            logger.info("No available GPS features found.");
        }
	}
	
	//select a random resolution form the page
	public void selectResolutionformAvaliableResolution() {
		// Find all resolution buttons
        List<WebElement> resolutionButtons = driver.findElements(By.xpath("//div[@id='refinement-resolution']//li/button"));
        // Count how many resolutions are available
        int resolutionCount = resolutionButtons.size();
        logger.info("Total available resolutions: " + resolutionCount);
        if (resolutionCount > 0) {
            // Generate a random index to select a resolution
            Random random = new Random();
            int randomIndex = random.nextInt(resolutionCount);
            // Click on the randomly selected resolution button
            WebElement selectedResolutionButton = resolutionButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedResolutionButton);
            //selectedResolutionButton.click();
            // You have now selected a random resolution
        } else {
            logger.info("No available resolutions found.");
        }
	}
	
	//select a random display size from the page
	public void selectDisplaySizeformAvaliableDisplaySizes() {
		// Find all display size buttons
        List<WebElement> displaySizeButtons = driver.findElements(By.xpath("//div[@id='refinement-resolution']//button"));
        // Count how many display sizes are available
        int displaySizeCount = displaySizeButtons.size();
        logger.info("Total available display sizes: " + displaySizeCount);
        if (displaySizeCount > 0) {
            // Generate a random index to select a display size
            Random random = new Random();
            int randomIndex = random.nextInt(displaySizeCount);
            // Click on the randomly selected display size button
            WebElement selectedDisplaySizeButton = displaySizeButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedDisplaySizeButton);
            //selectedDisplaySizeButton.click();
            // You have now selected a random display size
        } else {
            logger.info("No available display sizes found.");
        }
		
	}
	
	//select a random display size from the page
	public void selectPixelsformAvaliablePixels() {
		// Find all pixel resolution buttons
        List<WebElement> pixelResolutionButtons = driver.findElements(By.xpath("//div[@id='refinement-pixels']//button"));
        // Count how many pixel resolutions are available
        int pixelResolutionCount = pixelResolutionButtons.size();
        logger.info("Total available pixel resolutions: " + pixelResolutionCount);
        if (pixelResolutionCount > 0) {
            // Generate a random index to select a pixel resolution
            Random random = new Random();
            int randomIndex = random.nextInt(pixelResolutionCount);
            // Click on the randomly selected pixel resolution button
            WebElement selectedPixelResolutionButton = pixelResolutionButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedPixelResolutionButton);
           // selectedPixelResolutionButton.click();
            // You have now selected a random pixel resolution
        } else {
            logger.info("No available pixel resolutions found.");
        }
		
	}
	
	//select a random newArrival from the page
	public void selectNewArrivalsformAvaliableNewArrivals() {
		// Find all pixel newArrival buttons
        List<WebElement> newArrival = driver.findElements(By.xpath("//div[@id='refinement-new-arrival']//button"));
        // Count how many pixel resolutions are available
        int newArrivalCount = newArrival.size();
        logger.info("Total available pixel resolutions: " + newArrivalCount);
        if (newArrivalCount > 0) {
            // Generate a random index to select a newArrival
            Random random = new Random();
            int randomIndex = random.nextInt(newArrivalCount);
            // Click on the randomly selected newArrival button
            WebElement selectedPixelResolutionButton = newArrival.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedPixelResolutionButton);
            //selectedPixelResolutionButton.click();
            // You have now selected a random pixel resolution
        } else {
            logger.info("No available newArrival found.");
        }
		
	}
	
	//select a random display size from the page
	public void selectTypeUseformAvaliableTypeUse() {
		// Find all pixel newArrival buttons
        List<WebElement> newArrival = driver.findElements(By.xpath("//div[@id='refinement-type-|-use']//button"));
        // Count how many pixel resolutions are available
        int newArrivalCount = newArrival.size();
        logger.info("Total available pixel resolutions: " + newArrivalCount);
        if (newArrivalCount > 0) {
            // Generate a random index to select a newArrival
            Random random = new Random();
            int randomIndex = random.nextInt(newArrivalCount);
            // Click on the randomly selected newArrival button
            WebElement selectedPixelResolutionButton = newArrival.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedPixelResolutionButton);
            //selectedPixelResolutionButton.click();
            // You have now selected a random pixel resolution
        } else {
            logger.info("No available newArrival found.");
        }
	}


		//filters
		@FindBy(xpath ="(//select[@name = 'sort-order'])[1]")
		WebElement Filters;
		public void selecttheFilters(int i, WebDriver driver) throws InterruptedException{		
			
			// Get all the available options within the dropdown
			List<WebElement> options = Filters.findElements(By.tagName("option"));

			// Get the total number of options
			int numberOfOptions = options.size();

			// Generate a random index within the range of available options
			Random random = new Random();
			int randomIndex = random.nextInt(numberOfOptions);

			// Select the random option by its index
			options.get(randomIndex).click();
			
//			Select countrySelect = new Select(Filters);
//	        countrySelect.selectByIndex(i);
//	        Thread.sleep(1000);
//	        JavascriptExecutor js = (JavascriptExecutor) driver; 
//			js.executeScript("arguments[0].click();", Filters);
	        
			//Filters.click();
	    	Thread.sleep(3000);
		}
		
	
		//FilterResetButton
		@FindBy(xpath ="//button[@class = 'reset btn p-0']")
		WebElement ResetButton;
		public void selecttheResetButton() throws InterruptedException{
			ResetButton.click();
	    	Thread.sleep(3000);
		}
		
		//WishList
		public void selecttheWishlist() throws InterruptedException{
			for(int i =2;i<= 4;i++) {
				WebElement wishlistPlp = driver.findElement(By.xpath("(//a[@title= 'Favorites'])["+i+"]"));
				Thread.sleep(4000);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", wishlistPlp);
				executor.executeScript("arguments[0].click();", wishlistPlp);
				
				//wishlistPlp.click();
			}
		}
		
		
		public static void selectRandomProduct() {
			 // Create a new Random object
	        Random random = new Random();
	        
	        // Find all the product elements on the current page (after navigating)
	        List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
	        
	        // Get the total count of products found on the page
	        int totalProductcount = products.size();
	        
	        // Check if there are any products found on the page
	        if (totalProductcount > 0) {
	            // Generate a random number within the range of the total product count
	            int randomSelectProduct = random.nextInt(totalProductcount) + 1;

	            // Find the randomly selected product element based on the generated random number
	            WebElement randomSelectProductFromPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomSelectProduct + "]"));
	            
	            // Use JavaScript Executor to click on the randomly selected product element
	            JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("arguments[0].click();", randomSelectProductFromPLP);
	        }
	        
		}
		

		//select a random product
		public void selectProductRandom(WebDriver driver) throws InterruptedException {
		    // Create a Random object to generate random numbers
		    Random random1 = new Random();
		    
		    // Find all the product elements on the current page
		    List<WebElement> products1 = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
		    
		    // Get the total count of products found on the page
		    int totalProductcount1 = products1.size();
		    
		    // Check if there are any products found on the page
		    if (totalProductcount1 > 0) {
		        // Generate a random number within the range of the total product count
		        int randomSelectProduct = random1.nextInt(totalProductcount1) + 1;

		        // Find the randomly selected product element based on the generated random number
		        WebElement randomSelectProductFromPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomSelectProduct + "]"));
		        
		        // Use JavaScript Executor to click on the randomly selected product element
		        JavascriptExecutor js = (JavascriptExecutor)driver;
		        js.executeScript("arguments[0].click();", randomSelectProductFromPLP);
		    }
		    
		    // Pause the execution for 2 seconds (simulating a wait for the page to load)
		    Thread.sleep(2000);
		    
		    // Check if there's an element indicating that the PDP (Product Detail Page) is loading
		    List<WebElement> validatingPdpIsLoading = driver.findElements(By.xpath("//a[contains(@class, 'continue-shopping')]"));
		    
		    // Log the count of elements found for validation
		    logger.info(validatingPdpIsLoading.size());
		    
		    // Check if the PDP validation element is found
		    if (validatingPdpIsLoading.size() > 0) {
		        logger.info("PDP is not validating");
		        
		        // Find and click the "Continue Shopping" button
		        WebElement continueShoppingBtn = driver.findElement(By.xpath("//a[contains(@class, 'continue-shopping')]"));
		        continueShoppingBtn.click();
		        
		        // Pause the execution for 3 seconds (simulating some wait time)
		        Thread.sleep(3000);
  
		        // Call the selectRandomMenu method from the navigationPage object to select a random menu item
		        navigationProcessWithValidation  navPage =new navigationProcessWithValidation (driver);
		    	 navPage.selectRandomMenu(driver);
		        
		        // Create a new Random object
		        Random random = new Random();
		        
		        // Find all the product elements on the current page (after navigating)
		        List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
		        
		        // Get the total count of products found on the page
		        int totalProductcount = products.size();
		        
		        // Check if there are any products found on the page
		        if (totalProductcount > 0) {
		            // Generate a random number within the range of the total product count
		            int randomSelectProduct = random.nextInt(totalProductcount) + 1;

		            // Find the randomly selected product element based on the generated random number
		            WebElement randomSelectProductFromPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomSelectProduct + "]"));
		            
		            // Use JavaScript Executor to click on the randomly selected product element
		            JavascriptExecutor js = (JavascriptExecutor)driver;
		            js.executeScript("arguments[0].click();", randomSelectProductFromPLP);
		        }
		    }
		}

		//validations 
		//Name
		 public  void name(WebDriver driver) throws InterruptedException {
			 WebElement Name = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
			    if (Name.isEnabled()) {
			    	logger.info("catagory name is displayed on the page");
			    } else {
			    	logger.info("catagory name is not displayed on the page");
			    }
			    Thread.sleep(2000);
		 }
		 
		 //BreadCramps
		 public  void BreadCramps(WebDriver driver) throws InterruptedException {
			 WebElement breadCramps = driver.findElement(By.xpath("//ol[@class='breadcrumb mb-0']"));
			    if (breadCramps.isEnabled()) {
			    	logger.info("BreadCramps are displayed on the page");
			    } else {
			    	logger.info("BreadCramps are not displayed on the page");
			    }
			    Thread.sleep(2000);
		 }
		 
		 //Filters
		 public  void Filters(WebDriver driver) throws InterruptedException {
			 WebElement filters = driver.findElement(By.xpath("//span[@class='hide-title']"));
			    if (filters.isEnabled()) {
			    	logger.info("Filters are displayed on the page");
			    } else {
			    	logger.info("Filters are not displayed on the page");
			    }
			    Thread.sleep(2000);
		 }
		 
		 //products
			public void Products(WebDriver driver) throws InterruptedException {
				List<WebElement> products = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
			    int count = products.size();
			    if(count>0) {
			    	 logger.info("products are displayed on the page");
			    } else {
			    	logger.info("products are not displayed on the page");
			    }
			    Thread.sleep(2000);
			}

				
}
