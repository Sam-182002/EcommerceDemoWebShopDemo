package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="Email")
	private WebElement emailtx;
	@FindBy(id="Password")
	private WebElement Pwdtx;
	@FindBy(className="login-button")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void setloginButton(String email,String pwd) {
		emailtx.sendKeys(email);
		Pwdtx.sendKeys(pwd);
		loginBtn.click();
	}
}
