package com.sroy.Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\Driver\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup()
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseURL = "https://www.snapdeal.com/";
		driver.get(baseURL);
		return driver;
	}
}
