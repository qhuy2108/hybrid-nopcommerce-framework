package com.saucelab.sort;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGenerator;
import pageObjects.saucelab.InventoryPageObject;

public class Level_31_Sort_ACS_DECS extends BaseTest {
	
	private LoginPageObject loginPage;
	private InventoryPageObject inventoryPage;
	
	private WebDriver driver;
	
	@Parameters({"browser", "url"})
	@BeforeMethod
	public void beforeMethod (String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		loginPage = PageGenerator.getLoginPage(driver);
		loginPage.enterToUserName("standard_user");
		loginPage.enterToPassword("secret_sauce");
		inventoryPage = loginPage.clickToLoginButton();
		
	}
	
	
	@Test
	public void Sort_01_Name() {
		
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		Assert.assertTrue(inventoryPage.isProductNameSortByAscending());
		
		inventoryPage.selectItemInSortDropdown("Name (Z to A)");
		Assert.assertTrue(inventoryPage.isProductNameSortByDescending());
	}
	
	@Test
	public void Sort_02_Price() {
		inventoryPage.selectItemInSortDropdown("Price (low to high)");
		Assert.assertTrue(inventoryPage.isProductPriceSortByAscending());
		
		inventoryPage.selectItemInSortDropdown("Price (high to low)");
		Assert.assertTrue(inventoryPage.isProductPriceSortByDescending());
	}
	
			
	@AfterMethod
	public void afterMethod() {
		// closeBrowserDriver();
	}	
}
