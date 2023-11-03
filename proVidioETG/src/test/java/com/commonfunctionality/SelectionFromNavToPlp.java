package com.commonfunctionality;

import com.Scenarios.MenuSelection;
import com.Scenarios.plpPage;

public class SelectionFromNavToPlp {

	public void selectionFromNavToPlp() throws InterruptedException {
		
		//random menu selection
		  MenuSelection.menues();
		  
		 //selecting random prodcut to add to cart
		  plpPage.addtocartplp();
		  
		  
	}
}
