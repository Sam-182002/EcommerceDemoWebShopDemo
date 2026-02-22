package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoePage {
	@FindBy(xpath="//select[contains(@id,'product_attribute')]")
	private WebElement sizeDropDown;
	@FindBy(xpath="//span[@title='Green']")
	private WebElement color;
	@FindBy(className = "add-to-wishlist-button")
	private WebElement addWishList;
	@FindBy(className = "ico-wishlist")
	private WebElement wishListBtn;
	@FindBy(xpath="//p[@class='content']")
	private WebElement sucessMsg;
	
	public ShoePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void setSelectSize() {
		Select s= new Select(sizeDropDown);
		s.selectByValue("28");
	}
	public void SetColor() {
		color.click();
	}
	public void SetAddWishList() {
		addWishList.click();
	}
	public String getWishListSuccessMsg() {
		String successMsg = sucessMsg.getText();
		return successMsg;
		
	}
	public void setClickWishList() {
		
		wishListBtn.click();
	}
}
