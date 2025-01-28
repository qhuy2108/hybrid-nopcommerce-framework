package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import jsonData.nopCommerce.UserInfoJson;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPO;
import pageObjects.nopCommerce.users.UserRegisterPO;
import reportConfig.ExtentManager;

import java.lang.reflect.Method;

public class Level_28_Data_JSON extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserInfoJson userInfoJson;


    String browserName;

    String emailAddress, firstName, lastName, password, companyName, day, month, year;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        this.browserName = browserName.toUpperCase();
        driver = getBrowserDriver(browserName);

        userInfoJson = UserInfoJson.getUserInfo("userData.json");

        emailAddress = getEmailRandom(userInfoJson.getEmailAddress());
        userInfoJson.setEmailAddress(emailAddress);

        firstName = userInfoJson.getFirstName();
        lastName = userInfoJson.getLastName();
        password = userInfoJson.getPassword();

        day = "18";
        month = "September";
        year = "2022";
        companyName = "Milan";

        homePage = PageGenerator.getUserHomePage(driver);

    }


    @Test
    public void User_01_Register(Method method) {
        ExtentManager.startTest(method.getName() + " - " + browserName, "User_01_Register");
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 01: Open Register page");
        registerPage =  homePage.clickToRegisterLink();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 02: Click to Male radio button");
        registerPage.clickToMaleRadio();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 03: Enter to Register Form");
        registerPage.setToRegisterFormJson(userInfoJson);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 05: Select Day dropdown with value " + day);
        registerPage.selectDayDropdown(day);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 05: Select Month dropdown with value " + month);
        registerPage.selectMonthDropdown(month);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 06: Select Year dropdown with value " + year);
        registerPage.selectYearDropdown(year);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 07: Select Company textbox with value " + companyName);
        registerPage.enterToCompanyTextbox(companyName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 08: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 09: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisteredSuccessMessage() , "Your registration completed");

    }

    @Test
    public void User_02_Login(Method method) {
        ExtentManager.startTest(method.getName() + " - " + browserName, "User_02_Login");
        registerPage.clickToLogoutButton(); // quay ra homePage

        // đang ở trang homePage gọi ra loginPage
        loginPage = homePage.clickToLoginLink();

        loginPage.loginToUserFormJson(userInfoJson);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount(Method method) {
        ExtentManager.startTest(method.getName() + " - " + browserName, "User_03_MyAccount");

        customerInfoPage = homePage.clickToMyAccountLink();

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), userInfoJson.getFirstName());
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), userInfoJson.getLastName());

        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(), day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(), month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(),companyName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), userInfoJson.getEmailAddress());
    }

    @AfterClass
    public void afterClass() {
        // driver.quit();
    }
}
