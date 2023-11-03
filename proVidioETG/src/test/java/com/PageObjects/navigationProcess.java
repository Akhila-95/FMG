package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Scenarios.MenuSelection;
import com.testcases.baseClass;

public class navigationProcess extends baseClass {
    WebDriver lDriver;

    public navigationProcess(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

 
    public void selectRandomMenu(WebDriver driver) throws InterruptedException {
    	
    		MenuSelection.menues();
    	
        }
        

        
    }
    
    

