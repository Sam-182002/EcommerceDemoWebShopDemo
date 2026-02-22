package com.tricentis.pom;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ContactUsPage {
		@FindBy(id = "Enquiry")
		private WebElement enquiryTbx;
		@FindBy(className = "contact-us-button")
		private WebElement contactUsButton;
		@FindBy(xpath = "//div[@class='result']")
		private WebElement resultMsg;
		
		public ContactUsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void enquiryMsg(String msg) {
			enquiryTbx.sendKeys(msg);
			contactUsButton.click();
		}
		
		public String getResultmsg() {
			String result = resultMsg.getText();
			return result;
		}

}
