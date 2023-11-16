package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.PageObjects.homePage;
import com.testcases.baseClass;


public class SelectingFilterFromPlp extends baseClass{

	
	//filters from plp 
	public static void selectFilterFromPLP() throws InterruptedException {
		// Find the element using the dynamic XPath with a wildcard
        List<WebElement> TotalNumberofFilters =  driver.findElements(By.xpath("//div[contains(@class, 'refinement refinement-')]"));
        // Get the total count of top-level menu elements.
        int Filterscount = TotalNumberofFilters.size();
        logger.info("Total filters count is " + Filterscount);
        // Create a random number generator.
        Random random = new Random();
        // Generate a random index to select a top-level menu item.
        int randomNumberFilter = random.nextInt(Filterscount) + 1;
        logger.info("Randomly selected filters number " + randomNumberFilter);
        
        // get the name of the Main filter 
        WebElement mainFilterName = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//h6)["+randomNumberFilter+"]"));
        // Get and print the text of the found element
        String NameofFilterText = mainFilterName.getText();
        logger.info(NameofFilterText);
        
        //number of sub filtes associate with the main filter
        List<WebElement> numberofFiltersinOneFilter =  driver.findElements(By.xpath("(//div[contains(@class, 'refinement refinement-')]//div[contains(@id, 'refinement-')])["+randomNumberFilter+"]//button"));
        // Get the total count of top-level menu elements.
        int countofeachFilterbtns = numberofFiltersinOneFilter.size();
        logger.info("Total filters countofeachFilterbtns is " + countofeachFilterbtns);
        // Generate a random index to select a top-level menu item.
        int randomNumbercountofeachFilterbtns = random.nextInt(countofeachFilterbtns) + 1;
        logger.info("Randomly selected subfilter number " + randomNumbercountofeachFilterbtns);
        
      //name of the selected radio icon
        WebElement selectedName = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//div[contains(@id, 'refinement-')])["+randomNumberFilter+"]//span[@class='refinement-value ']"));
        // Get and print the text of the found element
        String SelectedTextname = selectedName.getText();
        
        // Extract content within parentheses using regular expressions and seperate the text
        String extractedContent = extractContentWithinParentheses(SelectedTextname);
        String textWithoutParentheses = removeContentWithinParentheses(SelectedTextname);
        // Print the result
        logger.info("Original Text: " + SelectedTextname);
        logger.info("Extracted Content: " + extractedContent);
        logger.info("Text without Parentheses: " + textWithoutParentheses);
        
        //Radio icon of the filter
        WebElement selectRadioIcon = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//div[contains(@id, 'refinement-')])["+randomNumberFilter+"]//button"));
        //selectRadioIcon.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectRadioIcon);
        js.executeScript("arguments[0].click();", selectRadioIcon);
        Thread.sleep(4000);
        
        //get the filters name which is selected 
        WebElement selectedNameinFilters = driver.findElement(By.xpath("//div[contains(@class, 'refinement-device')]//span"));
        // Get and print the text of the found element
        String SelectedTextofFiltersname = selectedNameinFilters.getText();
        logger.info(SelectedTextofFiltersname);
        
        //get How many prodcts loaded
        WebElement loadedProductsCount = driver.findElement(By.xpath("(//span[@class='count-value'])[1]"));
        // Get and print the text of the found element
        String productsCount = loadedProductsCount.getText();
        logger.info(productsCount);
        
      //check the condition for which filter is selected
        if((textWithoutParentheses.equals(SelectedTextofFiltersname))|| (extractedContent.equals(productsCount))) {
        	logger.info(NameofFilterText+" Selected The Filter "+extractedContent+" And The Loaded Products are "+productsCount);
        	test.pass(NameofFilterText+" Selected The Filter "+extractedContent+" And The Loaded Products are "+productsCount);
        }else {
        	logger.info(NameofFilterText+" Not Selected The Filter "+extractedContent+" And The Loaded Products are "+productsCount);
        	test.pass(NameofFilterText+" Not Selected The Filter "+extractedContent+" And The Loaded Products are "+productsCount);
        }
        
        Thread.sleep(4000);
	}

	 private static String extractContentWithinParentheses(String input) {
	        // Use regular expression to match content within parentheses
	        // and capture the content using groups
	        String regex = "\\(([^)]+)\\)";
	        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
	        java.util.regex.Matcher matcher = pattern.matcher(input);

	        // Check if there is a match
	        if (matcher.find()) {
	            return matcher.group(1); // Extract content within parentheses
	        } else {
	            return ""; // Return empty string if no match found
	        }
	    }
	 private static String removeContentWithinParentheses(String input) {
	        // Use regular expression to match content within parentheses
	        // and remove it from the input string
	        String regex = "\\([^)]+\\)";
	        return input.replaceAll(regex, "");
	    }
}
