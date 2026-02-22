package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApperalAndShoesPage {
	@FindBy(linkText = "Blue and green Sneaker")
	private WebElement BlueShoe;
	
	public ApperalAndShoesPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void setSelectShoe() {
		BlueShoe.click();
	}

}
