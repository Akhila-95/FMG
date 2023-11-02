package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class Favourites extends baseClass {

    WebDriver lDriver;

    public Favourites(WebDriver rDriver) {

        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    public void addToFavouritesFromPdp(WebDriver driver) {
    	//checks the availability of favourites and display of it in pdp page 
    	List<WebElement> favouritesInPdPList = driver.findElements(By.className("a.wishlistTile "));
    	if(favouritesInPdPList.size()>0) {
    		WebElement favouritesInPdP = driver.findElement(By.className("wishlistTile "));
    		if(favouritesInPdP.isDisplayed()) {
    			favouritesInPdP.click();
    		}
    	}
    }
}
