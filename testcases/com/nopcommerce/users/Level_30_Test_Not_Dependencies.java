package com.nopcommerce.users;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserSearchPO;

public class Level_30_Test_Not_Dependencies extends BaseTest {	
	
	private WebDriver driver;
	
	private UserSearchPO searchPage;
	private UserHomePO homePage;;

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod (String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGenerator.getHomePage(driver);
		searchPage = homePage.clickToSearchLink();



	}
	
	@Test
	public void Search_01_WithEmptyData(Method method) {
		searchPage.enterToSearchTextbox("");
		searchPage.clickToSearchButton();
		
	}
	
	@Test
	public void Search_02_ByProductNameNotExist(Method method) {
		searchPage.enterToSearchTextbox("Macbook Pro 2050");
		searchPage.clickToSearchButton();
		
	}
	
	@Test
	public void Search_03_ByContainsProductName(Method method) {
		searchPage.enterToSearchTextbox("Lenovo");
		searchPage.clickToSearchButton();
		
	}
	
	@Test
	public void Search_04_ByProductName(Method method) {
		searchPage.enterToSearchTextbox("ThinkPad X1 Carbon");
		searchPage.clickToSearchButton();
		
	}
	
			
	@AfterMethod
	public void afterMethod() {
		closeBrowserDriver();
	}	
}
