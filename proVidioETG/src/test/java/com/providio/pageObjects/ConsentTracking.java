package com.providio.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsentTracking  {

	WebDriver lDriver;
	//pageFactory constructor for this page
	public ConsentTracking(WebDriver rDriver) {
		this.lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//consent tracking

	
	@FindBy(xpath = "//div[@id='consent-tracking']")
	List<WebElement> consentTrackingList;
	
	@FindBy(className ="affirm btn btn-primary" )
	WebElement yesButton;
	
	public void enableConsentTracking() {
		//if consent tracking is available
		if(consentTrackingList.size()>0) {
			//click on Yes button
			yesButton.click();
		}
	}
	
}
