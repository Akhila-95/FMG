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
import org.w3c.dom.Text;

import com.Scenarios.MenuSelection;
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
				     
				        logger.info("coming here");
				        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickHeroBanner);
				        Thread.sleep(2000);
				        clickHeroBanner.click();
				        //js.executeScript("arguments[0].click();", clickHeroBanner);
				    }
			    }
			}
	
	//breadcrumbs
			public static void ClickOnbreadCrumbs() throws InterruptedException {
				//div[contains(@class,'category-overview')]
				
				  List<WebElement> categoryOverviewList  = driver.findElements(By.xpath("//div[contains(@class,'category-overview')]"));
				  if(categoryOverviewList.size()>0) {
					  test.info("Veriying the breadcrumbs navigation");
					 // WebElement categoryOverview  = driver.findElement(By.xpath("//div[contains(@class,'category-overview')]"));
					  List<WebElement> breadcrumbLinks  = driver.findElements(By.xpath("//div[contains(@class,'category-overview')]//li[contains(@class,'breadcrumb-item')]//a"));
					  int breadcrumbLinksCount = breadcrumbLinks.size();
					  System.out.println("Total breadcrumb links: " + breadcrumbLinksCount);

				        if (breadcrumbLinksCount>0) {
				        	
				            // Randomly click on one of the anchor tags
				            Random random = new Random();
				            int randomIndex = random.nextInt(breadcrumbLinksCount);
				            WebElement selectedBreadcrumbLink = breadcrumbLinks.get(randomIndex);

				            Thread.sleep(3000);
				            // Get the text of the randomly selected breadcrumb link
				            String text = selectedBreadcrumbLink.getText();
				            System.out.println("Selected breadcrumb link text: " + text);

				            // Click on the selected breadcrumb link 
				            Thread.sleep(1000);
				            JavascriptExecutor js = (JavascriptExecutor) driver;
				            js.executeScript("arguments[0].click();", selectedBreadcrumbLink);
				           // selectedBreadcrumbLink.click();
				            String home = "Home";
				            
				           List<WebElement>  plpPageName = driver.findElements(By.cssSelector("h1.category-name"));
				            //validating the filter - if user clicks on home then it should  randomly select the menu
				          if(text.equals(home)) {
				        	  
				        	  test.info("Randomly clicked on Home ,so randomizing the menus");
				        	//random menu selection
				    		  MenuSelection.menues();
				          }else //if(plpPageName.size()>0) {
				        	  if(driver.findElement(By.cssSelector("h1.category-name")).getText().equals(text));
				        	  test.pass("Succesfully clicked on  " +text+ " and navigated to " +driver.findElement(By.cssSelector("h1.category-name")).getText() + " category");
				        	  logger.info("Succesfully clicked on  " +text+ " and navigated to " + driver.findElement(By.cssSelector("h1.category-name")).getText()+ " category");
				      //  }
				            
					      }else {
					        	test.fail("Breadcrumbs are not navigated to clicked one");
					        }
				  }
			}
			
			
			
			// nextpage link
			public static void clickOnNextPage() throws InterruptedException {
				 List<WebElement> nextPageLink  = driver.findElements(By.xpath("//a[contains(text(),'Next Page')]"));
				 int nextPageCount=nextPageLink.size();
				 test.info("Verifying the next page link");
				  if (nextPageCount>0) {
			        	
					  
					  WebElement  categoryName = driver.findElement(By.cssSelector("h1.category-name"));
					  String categoryText = categoryName.getText();
			            // Randomly click on one of the anchor tags
			            Random random = new Random();
			            int randomIndex = random.nextInt(nextPageCount);
			            WebElement nextPage= nextPageLink.get(randomIndex);

			            // Click on the selected breadcrumb link 
			            Thread.sleep(1000);
			            JavascriptExecutor js = (JavascriptExecutor) driver;
			            js.executeScript("arguments[0].click();", nextPage);
			            
			            
			            WebElement  newCategoryName = driver.findElement(By.cssSelector("h1.category-name"));
						  String newCategoryText = newCategoryName.getText();
			            if(categoryText.equals(newCategoryText)) {
			            	test.pass("Succesfully clicked on next page i.e, shown " + categoryText+  " before clicking on next page and also showed " +newCategoryText);
			            	logger.info("Succesfully clicked on next page i.e, shown " + categoryText+  " before clicking on next page and also showed " +newCategoryText);
			            }else {
			            	test.fail(" clicked failed on next page i.e, shown " + categoryText+  " before clicking on next page but showed " +newCategoryText);
			            	logger.info(" clicked failed on next page i.e, shown " + categoryText+  " before clicking on next page but showed " +newCategoryText);
			            }    
				  }else {
					  test.info("No next page button");
				  }
			}
			
			
			public static void jumpToNextPage() throws InterruptedException {
				 List<WebElement> jumpToPageList  = driver.findElements(By.id("page-number"));
				 if(jumpToPageList.size()>0) {
					 test.info("Verifying Jump to page");
					 List<WebElement> jumpToPage  = driver.findElements(By.xpath("(//span[contains(@class,'count-bold')])[4]"));
					 int jumpToPageCount =jumpToPage.size();
					 Thread.sleep(1000);
					 Random random = new Random();
			         int randomIndex = random.nextInt(jumpToPageCount );
			         WebElement nextPage=jumpToPageList.get(randomIndex);
			         String pageValue = nextPage.getText();
			         System.out.println(pageValue);
					
			         WebElement jumpToPageInput  = driver.findElement(By.id("page-number"));
			         jumpToPageInput.sendKeys(pageValue);
			         
			         WebElement clickOnGo  = driver.findElement(By.xpath("(//button[contains(@class,'paginationButton')])[1]"));
			         JavascriptExecutor js = (JavascriptExecutor) driver;
			         js.executeScript("arguments[0].click();", clickOnGo);
			         
				 }else {
					 test.info("No jump to page");
				 }				
			}
			
			//all filters
    public Pair<String, String> selectCategoryFilter(WebDriver driver) throws InterruptedException {
        String text = null;
        String digits = null;
        
        List<WebElement> categoryFilter = driver.findElements(By.xpath("(//h6[contains(text(),'Category')])[1]"));
        if (categoryFilter.size() > 0) {
        	
            Thread.sleep(2000);
            //element to select the filter
            List<WebElement> refinementCategory  = driver.findElements(By.xpath("//div[contains(@class,'refinement-category')]//span[@class='refinement-value ']"));
         
            int refinementCategoryCount = refinementCategory.size();
            System.out.println("Total enabled categories: " + refinementCategoryCount);
            
            if (refinementCategoryCount > 0) {
            	//randomising the filter
	                Random random = new Random();
	                int randomIndex = random.nextInt(refinementCategoryCount);
	                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	                
	                Thread.sleep(2000);
	              //text of filter 
	                text = selectedRefinementCategory.getText();
  		            System.out.println("the filter is " +text);
	                
                //click on selected filter
	                js.executeScript("arguments[0].click();", selectedRefinementCategory);
              		            
                
	                Thread.sleep(2000);
                //text of digits in  selected filter
	                digits = text.replaceAll("\\D+", "");
	           
	             
	                
	            //text extracted from the selected filter	             
	                text = text.replaceAll("\\(\\d+\\)", "");
	         
	              
            }
        }
        return Pair.of(text, digits);
    }
	
	//select a SubCategory  randomly from avaliable colors
    public Pair<String, String> selectSubCategoryFilter(WebDriver driver) throws InterruptedException {
    	   String text = null;
           String digits = null;
		
		List<WebElement> subCategoryFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Sub-Category')]"));
		if(subCategoryFilter.size()>0) {
			
			// Find all color buttons that are enabled
			List<WebElement> refinementCategory = driver.findElements(By.xpath("//div[contains(@class,'refinement-sub-category')]//span[@class='refinement-value ']"));
	        // Count how many are enabled
	       
	        int refinementCategoryCount = refinementCategory.size();
	        
	        logger.info("Total enabled colors: " + refinementCategoryCount);
	        if (refinementCategoryCount > 0) {
	        	
            	//randomising the filter
	                Random random = new Random();
	                int randomIndex = random.nextInt(refinementCategoryCount);
	                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	                
	                Thread.sleep(2000);
	              //text of filter 
	                text = selectedRefinementCategory.getText();
  		            System.out.println("the filter is " +text);
  		            
                //click on selected filter
	                js.executeScript("arguments[0].click();", selectedRefinementCategory);

                  Thread.sleep(2000);
                //text of digits in  selected filter
	                digits = text.replaceAll("\\D+", "");
	             
	                
	            //text extracted from the selected filter	            
	                text = text.replaceAll("\\(\\d+\\)", "");
	               
            }
        }
        return Pair.of(text, digits);

	}
	//select a color
    public Pair<String, String>  selectColorFilter(WebDriver driver) throws InterruptedException {
    	 String text = null;
         String digits = null;
         
		  List<WebElement> colorFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Color')]"));
			if(colorFilter.size()>0) {
				Thread.sleep(2000);
				// Find all color buttons that are enabled
				 List<WebElement> refinementCategory = driver.findElements(By.xpath("//div[contains(@class,'refinement-color')]//span[@class='refinement-value ']"));
		     
		        int refinementCategoryCount = refinementCategory.size();
		        logger.info("Total enabled colors: " + refinementCategoryCount);
		        if (refinementCategoryCount > 0) {
		        	
	            	//randomising the filter
		                Random random = new Random();
		                int randomIndex = random.nextInt(refinementCategoryCount);
		                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
		                JavascriptExecutor js = (JavascriptExecutor) driver;
		                
		                Thread.sleep(2000);
		              //text of filter 
		                text = selectedRefinementCategory.getText();
	  		            System.out.println("the filter is " +text); 
		                
	                //click on selected filter
		                js.executeScript("arguments[0].click();", selectedRefinementCategory);
	               
		               Thread.sleep(2000);
	                //text of digits in  selected filter
		                digits = text.replaceAll("\\D+", "");
		             
		                
		            //text extracted from the selected filter	            
		                text = text.replaceAll("\\(\\d+\\)", "");
		               
	            }
	        }
	        return Pair.of(text, digits);
	}

    
  //select a color
    public Pair<String, String>  selectshapeFilter(WebDriver driver) throws InterruptedException {
    	 String text = null;
         String digits = null;
         
		  List<WebElement> colorFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Shape')]"));
			if(colorFilter.size()>0) {
				Thread.sleep(2000);
				// Find all color buttons that are enabled
				 List<WebElement> refinementCategory = driver.findElements(By.xpath("//div[contains(@class,'refinement-shape')]//span[@class='refinement-value ']"));
		        // Count how many are enabled
		     
		        int refinementCategoryCount = refinementCategory.size();
		        logger.info("Total enabled colors: " + refinementCategoryCount);
		        if (refinementCategoryCount > 0) {
		        	
	            	//randomising the filter
		                Random random = new Random();
		                int randomIndex = random.nextInt(refinementCategoryCount);
		                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
		                JavascriptExecutor js = (JavascriptExecutor) driver;
		               
		                Thread.sleep(2000);
		                
		              //text of filter 
		                text = selectedRefinementCategory.getText();
	  		            System.out.println("the filter is " +text);
	  		            
	                //click on selected filter
		                js.executeScript("arguments[0].click();", selectedRefinementCategory);

  		           
		                Thread.sleep(2000);
	                //text of digits in  selected filter
		                digits = text.replaceAll("\\D+", "");
		             
		                
		            //text extracted from the selected filter	            
		                text = text.replaceAll("\\(\\d+\\)", "");		               
	            }
	        }
	        return Pair.of(text, digits);
	}
	
	
    //select a color
      public Pair<String, String>  selectbrandFilter(WebDriver driver) throws InterruptedException {
      	 String text = null;
           String digits = null;
           
  		  List<WebElement> colorFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Brand')]"));
  			if(colorFilter.size()>0) {
  				Thread.sleep(2000);
  				// Find all color buttons that are enabled
  				 List<WebElement> refinementCategory = driver.findElements(By.xpath("//div[contains(@class,'refinement-brand')]//span[@class='refinement-value ']"));
  		        // Count how many are enabled
  		       
  		        int refinementCategoryCount = refinementCategory.size();
  		        logger.info("Total enabled colors: " + refinementCategoryCount);
  		        if (refinementCategoryCount > 0) {
  		        	
  	            	//randomising the filter
  		                Random random = new Random();
  		                int randomIndex = random.nextInt(refinementCategoryCount);
  		                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
  		                JavascriptExecutor js = (JavascriptExecutor) driver;
  		                
  		              Thread.sleep(2000);
  		           // Get the text of the selected element before clicking it
  		               text = selectedRefinementCategory.getText();
  		               System.out.println("the filter is " +text);
  		               
  	                //click on selected filter 
  		                js.executeScript("arguments[0].click();", selectedRefinementCategory);
  
  		            Thread.sleep(2000);
  	                //text of digits in  selected filter
  		                digits = text.replaceAll("\\D+", "");
  		             
  		                
  		            //text extracted from the selected filter	            
  		                text = text.replaceAll("\\(\\d+\\)", "");
  		               
  	            }
  	        }
  	        return Pair.of(text, digits);
  	}
      
  	
      //select a color
        public Pair<String, String>  selectbaseMetalFilter(WebDriver driver) throws InterruptedException {
        	 String text = null;
             String digits = null;
             
    		  List<WebElement> colorFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Base Metal')]"));
    			if(colorFilter.size()>0) {
    				Thread.sleep(2000);
    				// Find all color buttons that are enabled
    				 List<WebElement> refinementCategory = driver.findElements(By.xpath("//div[contains(@class,'refinement-base-metal')]//span[@class='refinement-value ']"));
    		        // Count how many are enabled
    		      
    		        int refinementCategoryCount = refinementCategory.size();
    		        logger.info("Total enabled colors: " + refinementCategoryCount);
    		        if (refinementCategoryCount > 0) {
    		        	
    	            	//randomising the filter
    		                Random random = new Random();
    		                int randomIndex = random.nextInt(refinementCategoryCount);
    		                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
    		                JavascriptExecutor js = (JavascriptExecutor) driver;
    		              
    		                //text of filter 
    		                Thread.sleep(2000);
    		                text = selectedRefinementCategory.getText();
    	  		            System.out.println("the filter is " +text);
    	  		            
    	                //click on selected filter
    		                js.executeScript("arguments[0].click();", selectedRefinementCategory);

    		              Thread.sleep(2000);
    	                //text of digits in  selected filter
    		                digits = text.replaceAll("\\D+", "");
    		             
    		                
    		            //text extracted from the selected filter	            
    		                text = text.replaceAll("\\(\\d+\\)", "");
    		               
    	            }
    	        }
    	        return Pair.of(text, digits);
    	}
  	

        //select a color
          public Pair<String, String>  selectwireHardnessFilter(WebDriver driver) throws InterruptedException {
          	  String text = null;
               String digits = null;
               
      		  List<WebElement> colorFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Wire Hardness')]"));
      			if(colorFilter.size()>0) {
      				Thread.sleep(2000);
      				// Find all color buttons that are enabled
      				List<WebElement> refinementCategory = driver.findElements(By.xpath("//div[contains(@class,'refinement-wire-hardness')]//span[@class='refinement-value ']"));
      		        // Count how many are enabled
      		      
      		        int refinementCategoryCount = refinementCategory.size();
      		        logger.info("Total enabled colors: " + refinementCategoryCount);
      		        if (refinementCategoryCount > 0) {
      		        	
      	            	//randomising the filter
      		                Random random = new Random();
      		                int randomIndex = random.nextInt(refinementCategoryCount);
      		                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
      		                JavascriptExecutor js = (JavascriptExecutor) driver;
      		                
      		              Thread.sleep(2000); 
      		            //text of filter 
    		                text = selectedRefinementCategory.getText();
    	  		            System.out.println("the filter is " +text);
    	  		            
      		           
      	                //click on selected filter
      		                js.executeScript("arguments[0].click();", selectedRefinementCategory);
     
      		               Thread.sleep(2000);
      	                //text of digits in  selected filter
      		                digits = text.replaceAll("\\D+", "");
      		             
      		                
      		            //text extracted from the selected filter	            
      		                text = text.replaceAll("\\(\\d+\\)", "");
      		               
      	            }
      	        }
      	        return Pair.of(text, digits);
      	}
    	
          //select a color
          public Pair<String, String>  selectgaugeFilter(WebDriver driver) throws InterruptedException {
          	   String text = null;
               String digits = null;
               
      		  List<WebElement> colorFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Gauge')]"));
      			if(colorFilter.size()>0) {
      				Thread.sleep(2000);
      				// Find all color buttons that are enabled
      				List<WebElement> refinementCategory  = driver.findElements(By.xpath("//div[contains(@class,'refinement-gauge')]//span[@class='refinement-value ']"));
      		        // Count how many are enabled
      		     
      		        int refinementCategoryCount = refinementCategory.size();
      		        logger.info("Total enabled colors: " + refinementCategoryCount);
      		        if (refinementCategoryCount > 0) {
      		        	
      	            	//randomising the filter
      		                Random random = new Random();
      		                int randomIndex = random.nextInt(refinementCategoryCount);
      		                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
      		                JavascriptExecutor js = (JavascriptExecutor) driver;
      		                
      		              Thread.sleep(2000);
      		            //text of filter 
    		                text = selectedRefinementCategory.getText();
    	  		            System.out.println("the filter is " +text);
    	  		               		          
      	                //click on selected filter
      		                js.executeScript("arguments[0].click();", selectedRefinementCategory);
      	         
      		                Thread.sleep(2000);
      	                //text of digits in  selected filter
      		                digits = text.replaceAll("\\D+", "");
      		             
      		                
      		            //text extracted from the selected filter	            
      		                text = text.replaceAll("\\(\\d+\\)", "");
      		               
      	            }
      	        }
      	        return Pair.of(text, digits);
      	}
          //select a color
          public Pair<String, String>  selectpriceFilter(WebDriver driver) throws InterruptedException {
          	   String text = null;
               String digits = null;
               
      		  List<WebElement> colorFilter =  driver.findElements(By.xpath("(//h6[contains(text(),'Price')])[1]"));
      			if(colorFilter.size()>0) {
      				Thread.sleep(2000);
      				// Find all color buttons that are enabled
      			  List<WebElement> refinementCategory = driver.findElements(By.xpath("//div[contains(@class,'refinement-price')]//span[@class='refinement-value ']"));
      		        // Count how many are enabled
      		      
      		        int refinementCategoryCount = refinementCategory.size();
      		        logger.info("Total enabled colors: " + refinementCategoryCount);
      		        if (refinementCategoryCount > 0) {
      		        	
      	            	//randomising the filter
      		                Random random = new Random();
      		                int randomIndex = random.nextInt(refinementCategoryCount);
      		                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
      		                JavascriptExecutor js = (JavascriptExecutor) driver;
      		                
      		              Thread.sleep(4000);
      		            //text of filter 
    		                text = selectedRefinementCategory.getText();
    	  		            System.out.println("the filter is " +text);
    	  		            
      		             
      	                //click on selected filter
      		                js.executeScript("arguments[0].click();", selectedRefinementCategory);
  
      		                Thread.sleep(2000);
      	                //text of digits in  selected filter
      		                digits = text.replaceAll("\\D+", "");
      		             
      		                
      		            //text extracted from the selected filter	            
      		                text = text.replaceAll("\\(\\d+\\)", "");
      		               
      	            }
      	        }
      	        return Pair.of(text, digits);
      	}
          
          //select a color
          public Pair<String, String>  selectholesLoopsFilter(WebDriver driver) throws InterruptedException {
          	   String text = null;
               String digits = null;
               
      		  List<WebElement> colorFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Number of Holes/Loops')]"));
      			if(colorFilter.size()>0) {
      				Thread.sleep(2000);
      				// Find all color buttons that are enabled
      				List<WebElement> refinementCategory = driver.findElements(By.xpath("//div[contains(@class,'refinement-number-of-holes/loops')]//span[@class='refinement-value ']"));
      		        // Count how many are enabled
      		        
      		        int refinementCategoryCount = refinementCategory.size();
      		        logger.info("Total enabled colors: " + refinementCategoryCount);
      		        if (refinementCategoryCount > 0) {
      		        	
      	            	//randomising the filter
      		                Random random = new Random();
      		                int randomIndex = random.nextInt(refinementCategoryCount);
      		                WebElement selectedRefinementCategory = refinementCategory.get(randomIndex);
      		                JavascriptExecutor js = (JavascriptExecutor) driver;
      		                
      		              Thread.sleep(2000);
      		            //text of filter 
    		                text = selectedRefinementCategory.getText();
    	  		            System.out.println("the filter is " +text);	 		            
      		         
      	                //click on selected filter
      		                js.executeScript("arguments[0].click();", selectedRefinementCategory);

      		           Thread.sleep(2000);
      	                //text of digits in  selected filter
      		                digits = text.replaceAll("\\D+", "");
      		             
      		                
      		            //text extracted from the selected filter	            
      		                text = text.replaceAll("\\(\\d+\\)", "");
      		               
      	            }
      	        }
      	        return Pair.of(text, digits);
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
			for(int i =2;i<= 3;i++) {
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
