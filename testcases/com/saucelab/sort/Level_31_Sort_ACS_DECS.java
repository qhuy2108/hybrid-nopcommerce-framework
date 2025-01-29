package com.saucelab.sort;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGenerator;
import pageObjects.saucelab.ProductPageObject;

public class Level_31_Sort_ACS_DECS extends BaseTest {
	
	private LoginPageObject loginPage;
	private ProductPageObject productPage;
	
	private WebDriver driver;
	
	@Parameters({"browser", "url"})
	@BeforeMethod
	public void beforeMethod (String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		loginPage = PageGenerator.getLoginPage(driver);
		loginPage.enterToUserName("standard_user");
		loginPage.enterToPassword("secret_sauce");
		productPage = loginPage.clickToLoginButton();
		
	}
	
	
	@Test
	public void Sort_01_Name() {
		
		productPage.selectItemInSortDropdown("Name (A to Z)");
		Assert.assertTrue(productPage.isProductNameSortByAscending());
		
		productPage.selectItemInSortDropdown("Name (Z to A)");
		Assert.assertTrue(productPage.isProductNameSortByDescending());
	}
	
	@Test
	public void Sort_02_Price() {
		productPage.selectItemInSortDropdown("Price (low to high)");
		Assert.assertTrue(productPage.isProductPriceSortByAscending());
		
		productPage.selectItemInSortDropdown("Price (high to low)");
		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}
	
			
	@AfterMethod
	public void afterMethod() {
		// closeBrowserDriver();
	}	
}
