package com.tricentis.pom;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class HomePage {
		@FindBy(linkText  = "Contact us")
		private WebElement contactUsLink;
		@FindBy(className  = "ico-logout")
		private WebElement logoutLink;
		@FindBy(id="small-searchterms")
		private WebElement searchTxtBx;
		@FindBy(xpath="//input[@value='Add to cart']")
		private WebElement addToCart;
		@FindBy(xpath="(//a[contains(text(), 'Apparel & Shoes')])[3]")
		private WebElement apperalAndShoes;
		
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void setContactUsLink() {
			contactUsLink.click();
		}
		public void setLogout() {
			logoutLink.click();
		}
		
		public void setSearch(String searchName) {
			searchTxtBx.sendKeys(searchName+Keys.ENTER);
			
		}
		public void setAddToCart() {
			addToCart.click();
		}
		public void setApparelAndShoes() {
			apperalAndShoes.click();
		}

}
