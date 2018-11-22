package com.hieu.testDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import junit.framework.Assert;


public class Test1 {

	WebDriver driver = null;
	public String URL_LOGIN = "https://www.saucedemo.com/";
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
		// setup driver
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void login(String userName, String passWord) {
		driver.get(URL_LOGIN);
		// maximize window
		driver.manage().window().maximize();
		
		WebElement txtUserName = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[1]"));
		WebElement txtPassWord = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[2]"));
		
		txtUserName.sendKeys(userName);
		txtPassWord.sendKeys(passWord);
		
		WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]"));
		btnLogin.click();
		
	}

	


	@Test
	public void fristMethod() {
		System.out.println("fristMethod");
		
		//Login correct user and password
		login("standard_user", "secret_sauce");
	}
	
	
	@Test
	public void secondMethod() {
		System.out.println("secondMethod");
		
		//login with empty user and password
		login("", "");
	
		WebElement errorBox1 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"));
		Assert.assertEquals(errorBox1.getText(), "Epic sadface: " + "Username is required");	
	}
	
	@Test
	public void thirdMethod() {
		System.out.println("thirdMethod");
		
		//login with correct user but empty password
		login("standard_user", "");
	
		WebElement errorBox1 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"));
		Assert.assertEquals(errorBox1.getText(),"Epic sadface: " +  "Password is required");	
	}
	
	@Test
	public void fourthMethod() {
		System.out.println("fourthMethod");
		
		//login with incorrect user and password
		login("standard", "123456");
	
		WebElement errorBox1 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"));
		Assert.assertEquals(errorBox1.getText(), "Epic sadface: " +  "Username and password do not match any user in this service");	
	}
	
	@Test
	public void fifthMethod() {
		System.out.println("fifthMethod");
		
		//login with correct user but incorrect password
		login("standard_user", "123456");
	
		WebElement errorBox1 = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"));
		Assert.assertEquals(errorBox1.getText(),"Epic sadface: " +  "Username and password do not match any user in this service");	
	}
	
	@Test
	public void sixthMethod() {
		System.out.println("sixthMethod");
		
		//Login correct with another user and password
		login("locked_out_user", "secret_sauce");
	}
	
	@Test
	public void seventhMethod() {
		System.out.println("seventhMethod");
		
		//Login correct with another user and password
		login("problem_user", "secret_sauce");
	}
	


	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
		//close browser
		driver.quit();
	}

}
