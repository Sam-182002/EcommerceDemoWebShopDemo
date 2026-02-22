package com.tricentis.generic;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.tricentis.pom.DashboardPage;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.LoginPage;
public class BaseClass {
	
	public WebDriver driver;
	public FileLib f= new FileLib();
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browser) throws IOException {
		if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--incognito");
			driver = new EdgeDriver(options);
		}else if(browser.equalsIgnoreCase("forefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			driver = new FirefoxDriver(options);
		}else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.readPropertyData("url");
		driver.get(url);
	}
	@BeforeMethod
	public void login() throws IOException {
//		driver.findElement(By.className("ico-login")).click();
		DashboardPage d= new DashboardPage(driver);
		d.SetLoginLink();
//		driver.findElement(By.id("Email")).sendKeys("admin123@email.com");
//		driver.findElement(By.id("Password")).sendKeys("12345678");
//		driver.findElement(By.className("login-button")).click();
		LoginPage l= new LoginPage(driver);
		String email = f.readPropertyData("email");
		String pwd = f.readPropertyData("password");
		
		l.setloginButton(email, pwd);
	}
	@AfterMethod
	public void logout() {
//		driver.findElement(By.linkText("Log out")).click();
		HomePage h= new HomePage(driver);
		h.setLogout();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}


}



