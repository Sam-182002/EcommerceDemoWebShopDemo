package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPage {
	@FindBy(className="success")//declaration
	private WebElement successMsg;
	
	public AddCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);//initialization
		
	}
	
	public String getSuccessMsg() { //utilization
		String text = successMsg.getText();
		return text;
	}

}