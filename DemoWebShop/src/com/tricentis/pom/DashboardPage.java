package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	@FindBy(linkText="Log in")
	private WebElement LoginLink;
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void SetLoginLink() {
		LoginLink.click();
	}
	

}
