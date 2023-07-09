package com.sroy.Main;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SnapDeal {

	public static WebDriver driver;
	public void createDriver(){
		driver = DriverSetup.getWebDriver();
	}


	public void search_HeadPhones() throws InterruptedException{
		WebElement search = driver.findElement(By.id("inputValEnter"));
		search.sendKeys("Bluetooth headphone");
		WebElement search_btn = driver.findElement(By.className("searchTextSpan"));
		search_btn.click();
		Thread.sleep(1000);
	}

	public void sort_HeadPhones() throws InterruptedException{

		WebElement sort_list = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		sort_list.click();
		sort_list.findElement(By.xpath("//li[@data-sorttype='plrty']")).click();
		driver.findElement(By.name("fromVal")).clear();
		WebElement price_from = driver.findElement(By.name("fromVal"));
		price_from.sendKeys("700");
		driver.findElement(By.name("toVal")).clear();
		WebElement price_upto = driver.findElement(By.name("toVal"));
		price_upto.sendKeys("1400");
		WebElement Go = driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"));
		Go.click();
		Thread.sleep(1000);
		}

	public void print_NameAndPrice() throws InterruptedException{
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0;i<5;i++) {
			System.out.println(i);
			String name_xpath = "//div[@data-js-pos='"+i+"']/descendant::p[@class='product-title']";
			WebElement el1 = driver.findElement(By.xpath(name_xpath));
			String product_name = el1.getText();
			//div[@data-js-pos='0']/descendant::p[@class='product-title']

			String price_xpath = "//div[@data-js-pos='" + i + "']/descendant::span[contains(@id, 'display-price')]";
			WebElement el2 = driver.findElement(By.xpath(price_xpath));
			String product_price = el2.getText();
			//div[@data-js-pos='0']/descendant::span[contains(@id, 'display-price')]

			map.put(product_name,product_price);
			}
		int i = 1;
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Details of Product "+(i++)+": ");
			System.out.println("Product name : "+ entry.getKey());
			System.out.println("Product price : "+entry.getValue());
		}

		Thread.sleep(3000);
	}

	public void closeDriver() {
		driver.quit();
	}

	public static void main(String[] args) throws Exception{
		SnapDeal sp = new SnapDeal();
		sp.createDriver();
		sp.search_HeadPhones();
		sp.sort_HeadPhones();
		sp.print_NameAndPrice();
		sp.closeDriver();
	}
}

