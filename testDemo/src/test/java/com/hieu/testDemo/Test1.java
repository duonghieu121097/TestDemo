package com.hieu.testDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import junit.framework.Assert;

public class Test1 {

	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
		// setup driver
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();

		// open browser
		driver.get("https://kcpm-07.herokuapp.com/login");
		// maximize window
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
		// refresh website
		//driver.navigate().refresh();

	}

	@Test
	public void fristMethod() {
		System.out.println("fristMethod");
		
		WebElement txtUserName = driver.findElement(By.name("username"));
		WebElement txtPassWord = driver.findElement(By.name("password"));
		
		txtUserName.sendKeys("dvmhieu");
		txtPassWord.sendKeys("matkhau1");
		
		WebElement btnLogin = driver.findElement(By.className("btn-default"));
		btnLogin.click();
			
		
		/*WebElement errorBox = driver.findElement(By.id("error_box"));
		
		Assert.assertEquals(errorBox.getText(), "Vui lòng thử lại sau\r\n" + 
				"Bạn đã thử quá nhiều. Vui lòng thử lại sau.");
		*/
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");

	}

}
