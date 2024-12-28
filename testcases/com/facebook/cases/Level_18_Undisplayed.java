package com.facebook.cases;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPO;
import pageObjects.facebook.PageGenerator;
import pageObjects.nopCommerce.users.*;

import java.lang.reflect.Method;

public class Level_18_Undisplayed extends BaseTest {

    private WebDriver driver;
    String browserName;

    private LoginPO loginPO;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        loginPO = PageGenerator.getLoginPage(driver);
        loginPO.clickToNewAccountButton();
    }


    @Test
    public void TC_01_Element_Undisplayed() {
        loginPO.enterToEmailTextbox("daodam@gmail.com.vnn");

        // Case 1 : verify confirm email textbox is displayed
        Assert.assertTrue(loginPO.isConfirmEmailTextboxDisplayed());

        loginPO.enterToEmailTextbox("");

        // Case 2 : verify confirm email textbox is displayed
        Assert.assertFalse(loginPO.isConfirmEmailTextboxDisplayed());

        loginPO.clickToCloseIcon();
        Assert.assertTrue(loginPO.isConfirmEmailTextboxUndisplayed());

        // out date FB xem video + tai lieu excel
    }


    @AfterClass
    public void afterClass() {
        // driver.quit();
    }
}
