package com.paymentProccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.testcases.baseClass;

public class PaymentProccessByGC_CC_Paypal extends baseClass{

	public List<String> readDataFromExcel(String filePath, String sheetName) throws IOException {

		List<String> data = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		boolean isFirstRow = true; // Flag to skip the first row

	    for (Row row : sheet) {
	        // Skip the first row
	        if (isFirstRow) {
	            isFirstRow = false;
	            continue;
	        }

	        for (Cell cell : row) {
	            String stringValue = cell.toString();
	            data.add(stringValue);
	        }
	    }

		workbook.close();
		return data;
	}
	public void paymentBySemiGC () throws InterruptedException {
		
	
		String filePath = GiftCertificatesforPaypal;
	    String sheetName = "GC_Codes";

	    try {
	        List<String> dataList = readDataFromExcel(filePath, sheetName);
	        int totalProducts = dataList.size();
	        
	     // Remove spaces from each element in the dataList
		    for (int i = 0; i < dataList.size(); i++) {
		        String element = dataList.get(i);
		        element = element.replace(" ", "");
		        dataList.set(i, element);
		    }

		    // Remove the empty strings from the list
	        dataList.removeIf(String::isEmpty);

	        // Concatenate the elements of the list without the comma
	      
			logger.info(dataList);
	        int operations = 0;
	      	 Iterator<String> iterator = dataList.iterator();
	      	 
	        while (iterator.hasNext()) {  
	            String value = iterator.next();
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            List<WebElement> giftCertificateList = driver.findElements(By.id("giftCert"));
	            if(giftCertificateList.size()>0) {
		            WebElement giftCertificate = driver.findElement(By.id("giftCert"));
		            if(giftCertificate.isDisplayed()){
			            js.executeScript("arguments[0].click();", giftCertificate);
			            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",giftCertificate);
			            giftCertificate.sendKeys(value);
			            Thread.sleep(2000);
		
			            
			            //check balance validation and checking the bal of GC
			             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
			             test.info("Verifying check balance button");
			            
			                // Scroll down by 500 pixels
			             	//js.executeScript("window.scrollBy(0, 500);");         
			                js.executeScript("arguments[0].click();",checkBalButton);
			                //checkBalButton.click();
			                Thread.sleep(2000);
			                List<WebElement> checkBalList= driver.findElements(By.xpath("//div[@class='balance success']"));
			                if(checkBalList.size()>0) {
					                WebElement checkBal= driver.findElement(By.xpath("//div[@class='balance success']"));
					                logger.info(checkBal.getText()); 
					                if(checkBalButton.isDisplayed()) {
					                	
				                	test.pass("Check button is enabled and selected");
					                	logger.info("Check button is enabled and selected");
					                }else {
					                	test.fail("Check button is not enabled and not selected");
					                	logger.info("Check button is  not enabled and selected");
					                }
			                }
			            // Click the apply button by passing GC
			            try {
			            	Thread.sleep(2000);
			            	js.executeScript("arguments[0].click();", giftCertificate);
				            giftCertificate.sendKeys(value);
				            Thread.sleep(2000);
				            
			                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
			                Thread.sleep(3000);	              
			                // Scroll down by 500 pixels
			               // js.executeScript("window.scrollBy(0, 200);");
			             
			                // apply button validation
			                test.info("Verifying apply button is selected");
			                if(applyGiftCard.isDisplayed()) {
			                	    js.executeScript("arguments[0].click();", applyGiftCard);
			                	    test.pass("Apply button is selected");
			                	    logger.info("Apply button is selected");
			              
					               // Thread.sleep(2000);
			                	    List<WebElement> invalidCode= driver.findElements(By.xpath("//div[contains(text(),'Invalid gift certificate code.')]"));
					                if (invalidCode.size()>0) {
					                	logger.info("This Gc " + value + "Invalid gift certificate code.");
					                    giftCertificate.clear();
					                }if (driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size() != 0) {
					                	logger.info("Insufficient funds in this " + value + " gift card");
					                	Thread.sleep(2000);
					                    giftCertificate.clear();
					                    giftCertificate.clear();
					                } 
					                Thread.sleep(2000);
					                List<WebElement> gcText= driver.findElements(By.xpath("//div[@class='success giftcert-pi']"));
					                int sizeOfGc = gcText.size();  
					                if(sizeOfGc==1) {
					                    logger.info("Gift certificate codes are applied");
					                    test.info("Gift certificate codes are applied");
					                    Thread.sleep(1000);
					                   // giftCertificate.clear();
					                    break;
					                } else {
					                    iterator.remove(); // Safely remove the element from the list
					                    logger.info("After applying GC we have this in datalist: " + dataList);
					                    Thread.sleep(5000);
					                    operations++;
				               
					                }
			                }else {
			                	test.fail("Apply button is not  selected");
			                	logger.info("Apply button is not selected");
			                }
			             
			                
			            } catch (NoSuchElementException e) {
			                logger.info("Element not found: " + e.getMessage());
			            }
			        }
		
			        logger.info("Total data: " + totalProducts);
			        logger.info("Total operations performed: " + operations);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	   
	}
	
}
