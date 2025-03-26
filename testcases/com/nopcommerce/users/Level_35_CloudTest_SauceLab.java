package com.nopcommerce.users;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.enviroment.EnviromentConfig;

import java.lang.reflect.Method;

public class Level_35_CloudTest_SauceLab extends BaseTest {

	private EnviromentConfig enviromentConfig;
	
	@Parameters({"server", "os", "browser", "browser_version"})
	@BeforeClass
	public void beforeClass (String serverName, String osName, String browserName, String browserVersion ) {
		ConfigFactory.setProperty("server", serverName);
		enviromentConfig = ConfigFactory.create(EnviromentConfig.class);

		driver = getBrowser_SauceLab(enviromentConfig.appUrl(), osName, browserName, browserVersion);
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
