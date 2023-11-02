package com.GuestUserWith_Checkout_Paypal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.providio.pageObjects.Favourites;
import com.providio.testcases.baseClass;

public class FavouritesFromPdp extends baseClass {
	@Test
	public void  orderbyFavouritesFromPdp() {
		
		driver.get("https://sfccstage.firemountain.org/1000wr/1000WR.html");
		Favourites fav = new Favourites (driver);
		fav.addToFavouritesFromPdp(driver);
	}
}
