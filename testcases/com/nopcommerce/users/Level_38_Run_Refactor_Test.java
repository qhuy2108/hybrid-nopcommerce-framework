package com.nopcommerce.users;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.enviroment.EnviromentConfig;

import java.lang.reflect.Method;

public class Level_38_Run_Refactor_Test extends BaseTest {

    private EnviromentConfig enviromentConfig;

    @Parameters({"evnName", "server", "browser", "ipAddress", "portNumber", "osName", "os_version", "browser_version"})
    @BeforeClass
    public void beforeClass (@Optional("local") String evnName, @Optional("dev") String serverName,
                             @Optional("chrome") String browserName,
                             @Optional("") String ipAddress, @Optional("") String portNumber,
                             @Optional("Windows") String osName, @Optional("10") String osVersion,
                             @Optional("latest") String browser_version) {

        ConfigFactory.setProperty("server", serverName);
        enviromentConfig = ConfigFactory.create(EnviromentConfig.class);

        driver = getBrowserRefactor(enviromentConfig.appUrl(), evnName, serverName, browserName, ipAddress, portNumber, osName, osVersion, browser_version);
    }


    @Test
    public void User_01_Register(Method method) {

    }

    @Test
    public void User_02_Login(Method method) {

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
    private WebDriver driver;
}