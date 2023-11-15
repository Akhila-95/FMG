package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.PageObjects.homePage;
import com.PageObjects.productListingPage;
import com.testcases.baseClass;


public class SelectingFilterFromPlp extends baseClass{

	
 	List<WebElement> categoryFilter =  driver.findElements(By.xpath("(//h6[contains(text(),'Category')])[1]"));
 
    List<WebElement> subCategoryFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Sub-Category')]"));
    // Collect a list of size buttons
   
    // Collect a list of price range buttons
    List<WebElement> colorFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Color')]"));
    // Collect a list of brand buttons
    List<WebElement> shapeFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Shape')]"));
    
    List<WebElement> brandFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Brand')]"));
    // Collect a list of type buttons
    List<WebElement> baseMetalFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Base Metal')]"));
    // Collect a list of GPS type buttons
    List<WebElement> wireHardnessFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Wire Hardness')]"));
    // Collect a list of GPS feature buttons
    List<WebElement> gaugeFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Gauge')]"));
    // Collect a list of resolution buttons
    List<WebElement> priceFilter =  driver.findElements(By.xpath("(//h6[contains(text(),'Price')])[1]"));
    // Collect a list of display size buttons

    List<WebElement> holesLoopsFilter =  driver.findElements(By.xpath("//h6[contains(text(),'Number of Holes/Loops')]"));
    
    
    public static void selectingTheFilters() throws InterruptedException {
    	
    	//reseting if any filter is applied before
    	List<WebElement> resetList = driver.findElements(By.xpath("//button[@class = 'reset btn p-0']"));
    	if(resetList.size()>0) {
    		productListingPage plp = new productListingPage(driver);
    		plp.selecttheResetButton();
   		
    	}
    	
        test.info("Selecting filters from Plp");
        List<WebElement> moreList = driver.findElements(By.xpath("//div[contains(text(),'More...')]"));
        if (moreList.size() > 0) {
            for (WebElement moreListElement : moreList) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", moreListElement);
                break;
            }
        }
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-700)", "");
        
        allFilters();
    
        
    }
    
    public static void allFilters() throws InterruptedException {
    	
	    Random random = new Random();
       
       int randomNumber = random.nextInt(9) + 1;
        System.out.println("random number is " + randomNumber);

    	 SelectingFilterFromPlp plp = new SelectingFilterFromPlp();
        switch (randomNumber) {
            case 1:
                plp.baseMetalFilter();
                break;
            case 2:
                plp.brandFilter();
                break;
             case 3:
                plp.categoryFilter();
                 break;                    
             case 4:
                 plp.colorFilter();
                 break;
             case 5:
                plp.priceFilter();
                 break;
             case 6:
                plp.gaugeFilter();
                 break;
             case 7:
                 plp.shapeFilter();
                 break;
             case 8:
                plp.holesLoopsFilter();
                 break;
             case 9:
                 plp.wireHardnessFilter();
                  break;
             
             default:
                 System.out.println("Invalid random number.");
         }
 }
    
//filters in plp

	public void categoryFilter() throws InterruptedException {

		// size buttons
		if (!categoryFilter.isEmpty()) {
			productListingPage plpPage =new productListingPage(driver);
			Pair<String, String> result = plpPage.selectCategoryFilter(driver)  ;
			  String text = result.getLeft();
			  String digits = result.getRight();
			  
			  System.out.println( text);
			  System.out.println( digits);
			
			Thread.sleep(4000);
			// text of selected product and count of it   
			 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
			 if(selectedFiltersList.size()>0) {
				 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
				 String selectedFilterText= selectedFiltersBar.getText();
				 System.out.println("Selected filter in  " +selectedFilterText);
				 
				 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
				 String count= countOfProductsSelected.getText();
				 count = count.replaceAll(",", "");
				 System.out.println("Count of prodcuts after selecting the filter " +count);
				 
					 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {					 
						test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
						logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
	
					 }else {
						 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
						 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
					
					 }
				 }else {
					 test.info("no filter is selected");
				 }
		} else {
		    test.info("No availability of Category Filter");
		    SelectingFilterFromPlp.selectingTheFilters();
			
		}
	}
	
	public void colorFilter() throws InterruptedException {
			//  price range buttons
			if (! colorFilter.isEmpty()) {
				productListingPage plpPage =new productListingPage(driver);
				Pair<String, String> result =plpPage.selectColorFilter(driver);
				  String text = result.getLeft();
				  String digits = result.getRight();
				  
				  System.out.println( text);
				  System.out.println( digits);
				
				Thread.sleep(4000);
				// text of selected product and count of it   
				 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
				 if(selectedFiltersList.size()>0) {
					 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
					 String selectedFilterText= selectedFiltersBar.getText();
					 System.out.println("Selected filter in  " +selectedFilterText);
					 
					 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
					 String count= countOfProductsSelected.getText();
					 count = count.replaceAll(",", "");
					 System.out.println("Count of prodcuts after selecting the filter " +count);
					 
						 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {
						 
							test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
							logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
		
						 }else {
							 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
							 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
						
						 }
					 }else {
						 test.info("no filter is selected");
					 }
			} else {
				test.info("No availability of color Filter");
				 SelectingFilterFromPlp.selectingTheFilters();
			}
	}
	
		public void shapeFilter() throws InterruptedException {
	//  price range buttons
			if (!shapeFilter.isEmpty()) {
				productListingPage plpPage =new productListingPage(driver);
				Pair<String, String> result =plpPage.selectshapeFilter(driver);
				  String text = result.getLeft();
				  String digits = result.getRight();
				  
				  System.out.println( text);
				  System.out.println( digits);
				
				Thread.sleep(4000);
				// text of selected product and count of it   
				 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
				 if(selectedFiltersList.size()>0) {
					 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
					 String selectedFilterText= selectedFiltersBar.getText();
					 System.out.println("Selected filter in  " +selectedFilterText);
					 
					 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
					 String count= countOfProductsSelected.getText();
					 count = count.replaceAll(",", "");
					 System.out.println("Count of prodcuts after selecting the filter " +count);
					 
						 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {						 
							test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
							logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
		
						 }else {
							 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
							 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
						
						 }
					 }else {
						 test.info("no filter is selected");
					 }
			} else {
				 test.info("No availability of shape Filter");
				 SelectingFilterFromPlp.selectingTheFilters();
				
			}
		}
		public void brandFilter() throws InterruptedException {
		//  price range buttons
			if (!brandFilter.isEmpty()) {
				productListingPage plpPage =new productListingPage(driver);
				Pair<String, String> result =plpPage.selectbrandFilter(driver);
				  String text = result.getLeft();
				  String digits = result.getRight();
				  
				  System.out.println( text);
				  System.out.println( digits);
				
				Thread.sleep(4000);
				// text of selected product and count of it   
				// text of selected product and count of it   
				 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
				 if(selectedFiltersList.size()>0) {
					 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
					 String selectedFilterText= selectedFiltersBar.getText();
					 System.out.println("Selected filter in  " +selectedFilterText);
					 
					 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
					 String count= countOfProductsSelected.getText();
					 count = count.replaceAll(",", "");
					 System.out.println("Count of prodcuts after selecting the filter " +count);
					 
						 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {						 
							test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
							logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
		
						 }else {
							 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
							 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
						
						 }
					 }else {
						 test.info("no filter is selected");
					 }
			} else {
				test.info("No availability of brand Filter");
				 SelectingFilterFromPlp.selectingTheFilters();
			}
		}	
			
			public void baseMetalFilter() throws InterruptedException {
			// sub category 
				if (!baseMetalFilter.isEmpty()) {
					// getting the selected filter text an count from another class during the selection
					productListingPage plpPage =new productListingPage(driver);
					Pair<String, String> result = plpPage.selectbaseMetalFilter(driver);
					  String text = result.getLeft();
					  String digits = result.getRight();
					  
					  System.out.println(text);
					  System.out.println(digits);
					
					Thread.sleep(3000);
					// text of selected product and count of it   
					 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
					 if(selectedFiltersList.size()>0) {
						 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
						 String selectedFilterText= selectedFiltersBar.getText();
						 System.out.println("Selected filter in  " +selectedFilterText);
						 
						 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
						 String count= countOfProductsSelected.getText();
						 count = count.replaceAll(",", "");
						 System.out.println("Count of prodcuts after selecting the filter " +count);
						 
							 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {							 
								test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
								logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
			
							 }else {
								 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
								 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
							
							 }
						 }else {
							 test.info("no filter is selected");
						 }
				}else {
					test.info("No availability of base metal Filter");
					 SelectingFilterFromPlp.allFilters();
				}
			}
			public void wireHardnessFilter() throws InterruptedException { 
				// size buttons
				if (!wireHardnessFilter.isEmpty()) {
					productListingPage plpPage =new productListingPage(driver);
					Pair<String, String> result = plpPage.selectwireHardnessFilter(driver)  ;
					  String text = result.getLeft();
					  String digits = result.getRight();
					  
					  System.out.println( text);
					  System.out.println( digits);
					
					Thread.sleep(4000);
					// text of selected product and count of it   
					 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
					 if(selectedFiltersList.size()>0) {
						 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
						 String selectedFilterText= selectedFiltersBar.getText();
						 System.out.println("Selected filter in  " +selectedFilterText);
						 
						 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
						 String count= countOfProductsSelected.getText();
						 count = count.replaceAll(",", "");
						 System.out.println("Count of prodcuts after selecting the filter " +count);
						 
							 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {						 
								test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
								logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
			
							 }else {
								 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
								 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
							
							 }
						 }else {
							 test.info("no filter is selected");
						 }
				} else {
				    test.info("No availability of wire hardness Filter");
				    SelectingFilterFromPlp.allFilters();
					
				}
			}
			public void gaugeFilter() throws InterruptedException {
				//  price range buttons
				if (!gaugeFilter.isEmpty()) {
					productListingPage plpPage =new productListingPage(driver);
					Pair<String, String> result =plpPage.selectgaugeFilter(driver);
					  String text = result.getLeft();
					  String digits = result.getRight();
					  
					  System.out.println( text);
					  System.out.println( digits);
					
					Thread.sleep(4000);
					// text of selected product and count of it   
					 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
					 if(selectedFiltersList.size()>0) {
						 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
						 String selectedFilterText= selectedFiltersBar.getText();
						 System.out.println("Selected filter in  " +selectedFilterText);
						 
						 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
						 String count= countOfProductsSelected.getText();
						 count = count.replaceAll(",", "");
						 System.out.println("Count of prodcuts after selecting the filter " +count);
						 
							 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {							 
								test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
								logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
			
							 }else {
								 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
								 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
							
							 }
						 }else {
							 test.info("no filter is selected");
						 }
				} else {
					test.info("No availability of gauge Filter");
					 SelectingFilterFromPlp.allFilters();
				}
			}
			public void priceFilter() throws InterruptedException {
				if(!priceFilter.isEmpty()) {
						productListingPage plpPage =new productListingPage(driver);
						Pair<String, String> result =plpPage.selectpriceFilter(driver);
						  String text = result.getLeft();
						  String digits = result.getRight();
						  
						  System.out.println( text);
						  System.out.println( digits);
						
						Thread.sleep(4000);
						// text of selected product and count of it   
						 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
						 if(selectedFiltersList.size()>0) {
							 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
							 String selectedFilterText= selectedFiltersBar.getText();
							 System.out.println("Selected filter in  " +selectedFilterText);
							 
							 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
							 String count= countOfProductsSelected.getText();
							 count = count.replaceAll(",", "");
							 System.out.println("Count of prodcuts after selecting the filter " +count);
							 
								 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {								 
									test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
									logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
				
								 }else {
									 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
									 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
								
								 }
							 }else {
								 test.info("no filter is selected");
							 }
					} else {
						test.info("No availability of color Filter");
						 SelectingFilterFromPlp.allFilters();
					}
			}
			public void holesLoopsFilter() throws InterruptedException {
			
				if(!holesLoopsFilter.isEmpty()) {
					productListingPage plpPage =new productListingPage(driver);
					Pair<String, String> result =plpPage.selectholesLoopsFilter(driver);
					  String text = result.getLeft();
					  String digits = result.getRight();
					  
					  System.out.println( text);
					  System.out.println( digits);
					
					Thread.sleep(4000);
					// text of selected product and count of it   
					 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
					 if(selectedFiltersList.size()>0) {
						 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
						 String selectedFilterText= selectedFiltersBar.getText();
						 System.out.println("Selected filter in  " +selectedFilterText);
						 
						 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
						 String count= countOfProductsSelected.getText();
						 count = count.replaceAll(",", "");
						 System.out.println("Count of prodcuts after selecting the filter " +count);
						 
							 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {							 
								test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
								logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
			
							 }else {
								 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
								 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
							
							 }
						 }else {
							 test.info("no filter is selected");
						 }
				} else {
					test.info("No availability of color Filter");
					 SelectingFilterFromPlp.selectingTheFilters();
				}
			
		//After selecting filters click on reset button

		//plp.selecttheResetButton();
	}
	 public void subCategoryFilter() throws InterruptedException {
			// sub category 
			if (!subCategoryFilter.isEmpty()) {
				// getting the selected filter text an count from another class during the selection
				productListingPage plpPage =new productListingPage(driver);
				Pair<String, String> result = plpPage.selectSubCategoryFilter(driver);
				  String text = result.getLeft();
				  String digits = result.getRight();
				  
				  System.out.println(text);
				  System.out.println(digits);
				
				Thread.sleep(3000);
				// text of selected product and count of it   
				 List<WebElement> selectedFiltersList =  driver.findElements(By.xpath("(//span[@class='filter-value-element'])[2]"));
				 if(selectedFiltersList.size()>0) {
					 WebElement selectedFiltersBar =  driver.findElement(By.xpath("(//span[@class='filter-value-element'])[2]"));
					 String selectedFilterText= selectedFiltersBar.getText();
					 System.out.println("Selected filter in  " +selectedFilterText);
					 
					 WebElement countOfProductsSelected =  driver.findElement(By.xpath("(//span[@class='count-value'])[1]")); 
					 String count= countOfProductsSelected.getText();
					 count = count.replaceAll(",", "");
					 System.out.println("Count of prodcuts after selecting the filter " +count);
					 
						 if (text.trim().equals(selectedFilterText.trim()) && digits.equals(count)) {					 
							test.pass("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
							logger.info("Succesfully selected the "+ selectedFilterText+ "and count of the selected products " + count);
		
						 }else {
							 test.fail("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
							 logger.info("The selected filter is "+text+ "but displayed filter is  " + selectedFilterText);
						
						 }
					 }else {
						 test.info("no filter is selected");
					 }
			}else {
				test.info("No availability of sub Category Filter");
				 SelectingFilterFromPlp.allFilters();
			}
     }
	 
	
}
