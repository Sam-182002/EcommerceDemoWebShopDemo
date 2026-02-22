package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
@FindBy(className = "wishlist-content")
private WebElement wishListMsg;

public WishListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public String getWishListMsg() {
	String text = wishListMsg.getText();
	return text;
	
}
}
