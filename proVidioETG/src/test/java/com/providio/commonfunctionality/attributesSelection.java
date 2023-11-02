package com.providio.commonfunctionality;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.providio.testcases.baseClass;

public class attributesSelection extends baseClass{
	
	
    //SizeSelection
	//@FindBy(xpath ="//select[contains(@class,'select-size')]" )
	
	//WebElement Size;
	public static void sizeSelction() throws InterruptedException {
		
		//sizes in boxess
		List<WebElement> sizeBox= driver.findElements(By.xpath("//div[contains(@class, 'select-size')]"));
		List<WebElement> sizeDropDown= driver.findElements(By.xpath("//select[contains(@class,'select-size')]"));
		
		if(sizeBox.size()>0) {
			// Find the parent div containing size options
            WebElement parentDiv = driver.findElement(By.id("size-null"));
            // Find all size option elements
            List<WebElement> sizeElements = parentDiv.findElements(By.cssSelector(".text-center"));
            // Filter enabled size options
            List<WebElement> enabledSizeOptions = new ArrayList<>();
            for (WebElement sizeElement : sizeElements) {
                if (!sizeElement.getAttribute("class").contains("disabled")) {
                    enabledSizeOptions.add(sizeElement);
                }
            }
            // Select a random enabled size
            if (!enabledSizeOptions.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(enabledSizeOptions.size());
                // Get the randomly selected size element
                WebElement selectedSizeElement = enabledSizeOptions.get(randomIndex);
                // Click the selected size element
                selectedSizeElement.click();
            }
		}else if(sizeDropDown.size()>0) {
			
		List<WebElement> sizedropdown= driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
		logger.info(sizedropdown.size());
		for(int i=1; i<=sizedropdown.size();i++) {
		WebElement Size = driver.findElement(By.xpath("(//select[contains(@class, 'select-size')])[" + i + "]"));

		// sizes from drop down Create a Select object and select the first enabled size
	    Select colorElement = new Select(Size);
	    List<WebElement> options = colorElement.getOptions();
	    List<String> enabledSizes = new ArrayList<>();
	    int optionIndex = 0;
	    for (WebElement option : options) {
	    	if (optionIndex > 0 && option.isEnabled()) {
	    		String text = option.getText();
	    		  //System.out.println(text);
	            if (!text.isEmpty()) {      	
	            	String value = option.getAttribute("data-attr-value");
	                enabledSizes.add(value);
	                //System.out.println(value);
	                option.click();
	                break; 
	                // Select the first enabled size and exit the loop
	            }
	        }

	    	 optionIndex++;
	    }

	}
 }
}
	
	
	//memorySizeSelection
//	@FindBy(id ="memorySize-null" )
//	WebElement memorySize;
	public static void memorySelection() throws InterruptedException {
		List<WebElement> memoryBox = driver.findElements(By.xpath(" //div[contains(@class, 'select-memorySize')]"));
		if(memoryBox.size()>0) {
			// Find all memory size elements
	        List<WebElement> memorySizeElements = driver.findElements(By.cssSelector(".select-memorySize .text-center"));
	        // Filter enabled memory size options
	        List<WebElement> enabledMemorySizeOptions = new ArrayList<>();
	        for (WebElement memorySizeElement : memorySizeElements) {
	            if (!memorySizeElement.getAttribute("class").contains("disabled")) {
	                enabledMemorySizeOptions.add(memorySizeElement);
	            }
	        }
	        // Select a random enabled memory size
	        if (!enabledMemorySizeOptions.isEmpty()) {
	            Random random = new Random();
	            int randomIndex = random.nextInt(enabledMemorySizeOptions.size());
	            enabledMemorySizeOptions.get(randomIndex).click();
	        }
		}else {
		// Create a Select object and select the first enabled size
		WebElement memorySize= driver.findElement(By.xpath("//select[contains(@class,'select-memorySize')]"));
	    Select MemoryElement = new Select(memorySize);
	    List<WebElement> options = MemoryElement.getOptions();
	    
	    List<String> enabledSizes = new ArrayList<>();				    
	    int optionIndex = 0;				    
	    System.out.println(options.size());
	    for (WebElement option : options) {
	    	if (optionIndex > 0 && option.isEnabled()) {				    		
	    		String text = option.getText();
	    		  //System.out.println(text);
	            if (!text.isEmpty()) {      	
	            	String value = option.getAttribute("data-attr-value");
	                enabledSizes.add(value);
	                //System.out.println(value);
	                option.click();
	                break; 
	                // Select the first enabled size and exit the loop
	            }
	        }
	    	else {
	    		System.out.println("This memory size is not avaliable");
	    	}				    	
	    	 optionIndex++;
	       }
		}
	}
	
	
	//color Selection
	public static void packageSizeSelection() throws InterruptedException {
 		
		List <WebElement> packageSizeList= driver.findElements(By.id("package-qty-feet-1"));
 		logger.info(packageSizeList.size());
 		
 		
 		if(packageSizeList.size()>0) {
 			
 			if (!packageSizeList.isEmpty()) {
 			    // Find all the packAGE buttons that are selectable
 			//	WebElement ParentPackageSize= driver.findElement(By.id("package-qty-feet-1"));
 			  //  List<WebElement> slickList = ParentPackageSize.findElements(By.xpath("//div[@class='slick-track']"));
 			 //  System.out.println("The packages sizees count " + slickList.size());
 				
 				List<WebElement> elementList = driver.findElements(By.cssSelector(".slick-slide.slick-active .single-custom-attribute"));
 				Random random = new Random();
 				int randomIndex = random.nextInt(elementList.size());
 				WebElement randomElement = elementList.get(randomIndex);
 				randomElement.click();
 			      
 			}
 		
	
   
    }
}			
	
	
	
	//width Selection
 	public static void widthSelection() throws InterruptedException {
 		 List<WebElement> widthBox =  driver.findElements(By.xpath("//div[contains(@class, 'select-width')]"));
 		
 		if(widthBox.size()>0) {
 			List<WebElement> options = driver.findElements(By.cssSelector("#width-null span.text-center:not([disabled='disabled'])"));
 	        if (!options.isEmpty()) {
 	            WebElement enabledOption = options.get(0);  // You can change the index to select a different option
 	            enabledOption.click();
 	            System.out.println("Clicked on: " + enabledOption.getText());
 	        } else {
 	            System.out.println("No enabled options found.");
 	        }
 			
 		}else {
 			
 		// Create a Select object and select the first enabled size
			List<WebElement> widthdropdown= driver.findElements(By.xpath("//select[contains(@class,'select-width')]"));
			logger.info(widthdropdown.size());
			for(int i=1; i<=widthdropdown.size();i++) {
			WebElement width = driver.findElement(By.xpath("(//select[contains(@class,'select-width')])[" + i + "]"));

		    Select colorElement = new Select(width);
		    List<WebElement> options = colorElement.getOptions();
		    List<String> enabledSizes = new ArrayList<>();
		    int optionIndex = 0;
		    System.out.println(options.size());
		    for (WebElement option : options) {
		    	if (optionIndex > 0 && option.isEnabled()) {					    		
		    		String text = option.getText();
		    		  //System.out.println(text);
		            if (!text.isEmpty()) {      	
		            	String value = option.getAttribute("data-attr-value");
		                enabledSizes.add(value);
		                //System.out.println(value);
		                option.click();
		                Thread.sleep(5000);
		                break; 				                
		            }
		        }

		    	 optionIndex++;
		    }

	     }
	
// 		List<WebElement> widthElementsDropDown = driver.findElements(By.xpath("//select[contains(@class,'select-width')]"));
//	    System.out.println(widthElementsDropDown.size());
// 		  //width 
//		  WebElement widthElement = widthElementsDropDown.get(0);
//		  System.out.println("width element is present on the page.");
//		  Select widthSelect = new Select(widthElement);
//	      // Get the list of available options
//		  List<WebElement> availableOptionsofwidth = widthSelect.getOptions();
//		  // Create a list to store the indices of enabled options
//		  List<Integer> enabledIndixes = new ArrayList<>();
//		  // Iterate through the available options and store the indices of enabled options
//		  for (int a = 0; a < availableOptionsofwidth.size(); a++) {
//		      if (availableOptionsofwidth.get(a).isEnabled()) {
//		      	enabledIndixes.add(a);
//		      }
//		  }
//		  Integer randomIndexofwidth = enabledIndixes.set(1, 1);
//		  //logger.info(enabledIndixes);
//		  System.out.println("total numbers of"+enabledIndixes);
//		  System.out.println("only width"+enabledIndixes);
//		  // Select the option at the random index
//		  widthSelect.selectByIndex(randomIndexofwidth); 
//		  Thread.sleep(5000);
 		}
 	
 }
 	
 	
 	//select showname
 	public static void selectShowName() throws InterruptedException {
 		List<WebElement> showNameBox= driver.findElements(By.cssSelector(".select-memorySize"));
 		if(showNameBox.size()>0) {
 		List<WebElement> showNameElements = driver.findElements(By.xpath("//select[contains(@class,'select-showName')]"));
	    System.out.println(showNameElements.size());
 		  //show name
		  WebElement widthElement = showNameElements.get(0);
		  System.out.println("width element is present on the page.");
		  Select showNameSelect = new Select(widthElement);
		  // Get the list of available options
		  List<WebElement> availableOptionsofwidth =  showNameSelect.getOptions();
		  // Create a list to store the indices of enabled options
		  List<Integer> enabledIndixes = new ArrayList<>();
		  // Iterate through the available options and store the indices of enabled options
		  for (int a = 0; a < availableOptionsofwidth.size(); a++) {
		      if (availableOptionsofwidth.get(a).isEnabled()) {
		      	enabledIndixes.add(a);
		      }
		  }
		  Integer randomIndexofwidth = enabledIndixes.set(1, 1);
		  //logger.info(enabledIndixes);
		  System.out.println("total numbers of"+enabledIndixes);
		  System.out.println("only width"+enabledIndixes);
		  // Select the option at the random index
		  showNameSelect.selectByIndex(randomIndexofwidth); 
		  Thread.sleep(5000);
 		}else {
 			 // Find all show name elements
 	        List<WebElement> showNameElements = driver.findElements(By.cssSelector(".select-showName .text-center"));
 	        // Filter enabled show name options
 	        List<WebElement> enabledShowNameOptions = new ArrayList<>();
 	        for (WebElement showNameElement : showNameElements) {
 	            if (!showNameElement.getAttribute("class").contains("disabled")) {
 	                enabledShowNameOptions.add(showNameElement);
 	            }
 	        }
 	        // Select a random enabled show name
 	        if (!enabledShowNameOptions.isEmpty()) {
 	            Random random = new Random();
 	            int randomIndex = random.nextInt(enabledShowNameOptions.size());
 	            enabledShowNameOptions.get(randomIndex).click();
 	        }
 		}
 	}
 	
 	//selectionExtended warrenty
   public static void selectExtendedWarranty	() {
	 
	 // Locate the dropdown element.
       List<WebElement> dropdownElement = driver.findElements(By.className("options-select"));
       if(!dropdownElement.isEmpty()) {
	        WebElement dropdownElements = driver.findElement(By.className("options-select"));
	        // Create a Select object from the dropdown element.
	        Select select = new Select(dropdownElements);
	        // Get all available options in the dropdown.
	        List<WebElement> options = select.getOptions();
	        // Generate a random index within the range of available options.
	        int randomIndex = new Random().nextInt(options.size());
	        // Select the option at the random index.
	        select.selectByIndex(randomIndex);
       }
 }
   
   
   //AcceriessizeSelection
   public static void AccsizeSelction() {
		
		WebElement sizeElement = driver.findElement(By.xpath("//select[contains(@class, 'select-accessorySize')]"));
		test.info("Verify that size select");
			    Select sizeSelect = new Select(sizeElement);
			    List<WebElement> options = sizeSelect.getOptions();
			    List<String> enabledSizes = new ArrayList<>();
			    int optionIndex = 0;
			    for (WebElement option : options) {
			    	if (optionIndex > 0 && option.isEnabled()) {
			    		String text = option.getText();
			    		  //System.out.println(text);
			            if (!text.isEmpty()) {      	
			            	String value = option.getAttribute("data-attr-value");
			                enabledSizes.add(value);
			                System.out.println(value);
			                option.click();
			                logger.info("Selected the size");
			                test.pass("Successfully selected the size");
			                break; 
			                // Select the first enabled size and exit the loop
			            }
			        }
			    	else {
			    		System.out.println("This size is not avaliable");
			    	}
			    	
			    	 optionIndex++;
			    }

	 }
	

	
/*	public static void sizeSelction() {
		
		WebElement sizeElement = driver.findElement(By.xpath("//select[contains(@class, 'select-size')]"));
		test.info("Verify that size select");
			    Select sizeSelect = new Select(sizeElement);
			    List<WebElement> options = sizeSelect.getOptions();
			    List<String> enabledSizes = new ArrayList<>();
			    int optionIndex = 0;
			    for (WebElement option : options) {
			    	if (optionIndex > 0 && option.isEnabled()) {
			    		String text = option.getText();
			    		  //System.out.println(text);
			            if (!text.isEmpty()) {      	
			            	String value = option.getAttribute("data-attr-value");
			                enabledSizes.add(value);
			                System.out.println(value);
			                option.click();
			                logger.info("Selected the size");
			                test.pass("Successfully selected the size");
			                break; 
			                // Select the first enabled size and exit the loop
			            }
			        }
			    	else {
			    		System.out.println("This size is not avaliable");
			    	}
			    	
			    	 optionIndex++;
			    }

	 }
	
	//color selection
	
	public static void colorSelection() {

		WebElement widthElement = driver.findElement(By.xpath("//select[contains(@class, 'select-color')]"));
		test.info("Verify that color select");
	    Select colorSelect = new Select(widthElement);
	    List<WebElement> options1 = colorSelect.getOptions();
	    List<String> enabledSizes1 = new ArrayList<>();
	    int optionIndex1 = 0;
	    for (WebElement option : options1) {
	    	if (optionIndex1 > 0 && option.isEnabled()) {
	    		String text = option.getText();
	    		  //System.out.println(text);
	            if (!text.isEmpty()) {      	
	            	String value = option.getAttribute("data-attr-value");
	                enabledSizes1.add(value);
	                //System.out.println(value);
	                option.click();
	                logger.info("Selected the color");
	                test.pass("Successfully selected the color");
	                break; 
	                // Select the first enabled size and exit the loop
	            }
	        }

	    	
	    	 optionIndex1++;
	    }
	}
	
	//selecting the width elements
	public static void widthSelection() throws InterruptedException {
		test.info("Verify that width select");
		
		WebElement widthElement = driver.findElement(By.xpath("//select[contains(@class, 'select-width')]"));
		
		
		Select widthSelect = new Select(widthElement);
		
		// Get the list of available options
	  List<WebElement> availableOptionsofwidth = widthSelect.getOptions();
	
	  // Create a list to store the indices of enabled options
	  List<Integer> enabledIndixes = new ArrayList<>();
	
	  // Iterate through the available options and store the indices of enabled options
	  for (int a = 0; a < availableOptionsofwidth.size(); a++) {
	  	
	      if (availableOptionsofwidth.get(a).isEnabled()) {
	      	enabledIndixes.add(a);
	      }
	  }
	  Integer randomIndexofwidth = enabledIndixes.set(1, 1);
	  //logger.info(enabledIndixes);
	  System.out.println("total numbers of"+enabledIndixes);

	  System.out.println("only width"+enabledIndixes);
	  // Select the option at the random index
	  widthSelect.selectByIndex(randomIndexofwidth);
	  logger.info("Selected the width");
	  
	  test.pass("Successfully selected the width");
	
	  Thread.sleep(3000);

	}
	
	public static void memorySelection() {
		test.info("Verify that memory size select");
		WebElement memoryElement = driver.findElement(By.xpath("//select[contains(@class, 'select-memorySize')]"));
      
	    Select colorSelect = new Select(memoryElement);
	    List<WebElement> options1 = colorSelect.getOptions();
	    List<String> enabledSizes1 = new ArrayList<>();
	    int optionIndex1 = 0;
	    for (WebElement option : options1) {
	    	if (optionIndex1 > 0 && option.isEnabled()) {
	    		String text = option.getText();
	    		  //System.out.println(text);
	            if (!text.isEmpty()) {      	
	            	String value = option.getAttribute("data-attr-value");
	                enabledSizes1.add(value);
	                //System.out.println(value);
	                option.click();
	                logger.info("Selected the memory size");
	                test.pass("Successfully selected the memeory size");
	                break; 
	                // Select the first enabled size and exit the loop
	            }
	        }	    	
	    	 optionIndex1++;
	    }
	}
	
   public static void AccsizeSelction() {
		
		WebElement sizeElement = driver.findElement(By.xpath("//select[contains(@class, 'select-accessorySize')]"));
		test.info("Verify that size select");
			    Select sizeSelect = new Select(sizeElement);
			    List<WebElement> options = sizeSelect.getOptions();
			    List<String> enabledSizes = new ArrayList<>();
			    int optionIndex = 0;
			    for (WebElement option : options) {
			    	if (optionIndex > 0 && option.isEnabled()) {
			    		String text = option.getText();
			    		  //System.out.println(text);
			            if (!text.isEmpty()) {      	
			            	String value = option.getAttribute("data-attr-value");
			                enabledSizes.add(value);
			                System.out.println(value);
			                option.click();
			                logger.info("Selected the size");
			                test.pass("Successfully selected the size");
			                break; 
			                // Select the first enabled size and exit the loop
			            }
			        }
			    	else {
			    		System.out.println("This size is not avaliable");
			    	}
			    	
			    	 optionIndex++;
			    }

	 }*/
	

}
